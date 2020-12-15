package com.example.spring01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	// 회원목록
	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.list");
	}
	
	// 회원등록
	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert", dto); 
		// 네임스페이스 member 아이디가 insert dto내용을 전달
	}
	
	// 회원 상세정보
	// selectOne() 레코드가 1개 selectList() 레코드가 1개 이상
	@Override
	public MemberDTO detail(String userid) {
		return sqlSession.selectOne("member.detail", userid);
	}

	// 회원삭제
	@Override
	public void delete(String userid) {
		sqlSession.delete("member.delete", userid);
	}

	// 회원 정보 수정
	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	// 비밀번호 체크
	@Override
	public boolean check_passed(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
