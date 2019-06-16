package com.aplus.DOS.memberHasItem.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberHasItemRepository extends JpaRepository<MemberHasItem, Long>{
	@Query("select m from MemberHasItem m where m.memberId =:memberId ")
	public List<MemberHasItem> findAllByMemberId(@Param("memberId")Long MemberId);
}
