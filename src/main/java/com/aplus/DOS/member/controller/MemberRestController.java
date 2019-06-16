package com.aplus.DOS.member.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aplus.DOS.common.model.ApiResponseMessage;
import com.aplus.DOS.common.model.AuthenticationRequest;
import com.aplus.DOS.common.model.AuthenticationToken;
import com.aplus.DOS.levels.domain.Levels;
import com.aplus.DOS.member.domain.BuyMoneyDto;
import com.aplus.DOS.member.domain.ChangePasswordDto;
import com.aplus.DOS.member.domain.Email;
import com.aplus.DOS.member.domain.EndGameDto;
import com.aplus.DOS.member.domain.MakeNewPassword;
import com.aplus.DOS.member.domain.Member;
import com.aplus.DOS.member.domain.MemberItemSelectDto;
import com.aplus.DOS.member.domain.MemberRepository;
import com.aplus.DOS.member.domain.MemberSaveRequestDto;
import com.aplus.DOS.member.domain.SettingNewPasswordDto;
import com.aplus.DOS.member.service.EmailService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {

	private MemberRepository memberRespository;
	private AuthenticationManager authenticationManager;
	private EmailService emailService;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponseMessage> saveMember(@RequestBody MemberSaveRequestDto dto) {
		if (memberRespository.findByEmail(dto.getEmail()).size() != 0) {
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Duplicate Email", "", "");
			return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		memberRespository.save(dto.toEntity());
		ApiResponseMessage message = new ApiResponseMessage("Success", "Sign Up Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
	}

	@PostMapping("/login")
	public AuthenticationToken login(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
		String email = authenticationRequest.getEmail();
		String password = authenticationRequest.getPassword();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		Member member = memberRespository.findByEmail(email).get(0);
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_BASIC"));

		return new AuthenticationToken(member.getMemberId(), email, member.getNickname(), list, session.getId(),
				member.getMoney(), member.getLevel().getLevelsId(), member.getExp(), member.getChooseNote(),
				member.getChooseEffect());
	}

	@PostMapping("/sendMail")
	public ResponseEntity<ApiResponseMessage> sendMail(@RequestBody SettingNewPasswordDto dto) {
		try {
			List<Member> li = memberRespository.findByEmailAndAnswer(dto.getEmail(), dto.getAnswer());
			if (li.size() > 0) {
				String newPassword = MakeNewPassword.getRandomString(10);
				Member member = li.get(0);
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				member.setPassword(passwordEncoder.encode(newPassword));
				Email mail = new Email(dto.getEmail(), newPassword);
				memberRespository.save(member);
				emailService.sendMail(mail);
			} else {
				ApiResponseMessage message = new ApiResponseMessage("Fail", "Wrong Email or Answer", "", "");
				return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Connect Error", "", "");
			return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		}
		ApiResponseMessage message = new ApiResponseMessage("Success", "Send Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
	}

	@PostMapping("/buyIGM")
	public ResponseEntity<ApiResponseMessage> buyIGM(@RequestBody BuyMoneyDto dto) {
		try {
			Optional<Member> li = memberRespository.findById(Long.parseLong(dto.getMemberId()));
			Member member = li.get();
			member.setMoney(Long.parseLong(dto.getMoney()));
			memberRespository.save(member);
		} catch (Exception e) {
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Error", "", "");
			return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		}
		ApiResponseMessage message = new ApiResponseMessage("Success", "Buy Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
	}

	@PostMapping("/setItem")
	public ResponseEntity<ApiResponseMessage> setItem(@RequestBody MemberItemSelectDto dto) {
		try {
			Optional<Member> li = memberRespository.findById(Long.parseLong(dto.getMemberId()));
			Member member = li.get();
			member.setChooseEffect(Integer.parseInt(dto.getChooseEffect()));
			member.setChooseNote(Integer.parseInt(dto.getChooseNote()));
			memberRespository.save(member);
		} catch (Exception e) {
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Error", "", "");
			return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		}
		ApiResponseMessage message = new ApiResponseMessage("Success", "Setting Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
	}

	@PostMapping("/endGame")
	public AuthenticationToken endGame(@RequestBody EndGameDto dto , HttpSession session) {
		Member member = memberRespository.getOne(Long.parseLong(dto.getMemberId()));
		member.setMoney(Long.parseLong(dto.getMoney()));
		member.setExp(Long.parseLong(dto.getExp()));
		member.setLevel(Levels.builder().levelsId(Long.parseLong(dto.getLevel())).build());
		memberRespository.save(member);
		List<GrantedAuthority> list = new ArrayList<>();
		return new AuthenticationToken(member.getMemberId(), member.getEmail(), member.getNickname(), list, session.getId(),
				member.getMoney(), member.getLevel().getLevelsId(), member.getExp(), member.getChooseNote(),
				member.getChooseEffect());
	}
	
	@PostMapping("changeInfo")
	public ResponseEntity<ApiResponseMessage> setItem(@RequestBody ChangePasswordDto dto) {
		try {
			Member member = memberRespository.getOne(Long.parseLong(dto.getMemberId()));
			if(!member.getEmail().equals(dto.email)) {
				ApiResponseMessage message = new ApiResponseMessage("Fail", "Email Error", "", "");
				return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
			}else {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				member.setPassword(passwordEncoder.encode(dto.getPassword()));
				memberRespository.save(member);
			}
		} catch (Exception e) {
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Error", "", "");
			return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		}
		ApiResponseMessage message = new ApiResponseMessage("Success", "Change Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
	}

}
