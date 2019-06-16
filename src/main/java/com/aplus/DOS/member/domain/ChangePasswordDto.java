package com.aplus.DOS.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangePasswordDto {
	public String memberId;
	public String email;
	public String password;
}
