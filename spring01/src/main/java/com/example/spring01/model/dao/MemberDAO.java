package com.example.spring01.model.dao;

import java.util.List;

import com.example.spring01.model.dto.MemberDTO;

public interface MemberDAO {
	// 회원목록
	public List<MemberDTO> list();
	
	// 회원등록
	public void insert(MemberDTO dto);
	
	// 회원 상세정보
	public MemberDTO detail(String userid);
	
	// 회원삭제
	public void delete(String userid);
	
	// 회원 정보 수정
	public void update(MemberDTO dto);
	
	// 비밀번호 체크
	public boolean check_passed(String userid, String passwd);
}
