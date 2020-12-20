package com.example.spring02.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.dto.MemberDTO;

@Repository // 서버가 startup될 때 이 클래스가 메모리에 자동으로 등록됨
public class MemberDAOImpl implements MemberDAO {
	
	// 로깅 처리를 위한 객체 선언
	private static final Logger logger =
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	//SqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 연결시켜 줌
	@Inject // 의존관계 주입
	SqlSession sqlSession;	
	
	@Override
	public List<MemberDTO> memberList() {
		logger.info("memberList called...");
		// sql mapper에 작성된 sql 코드.ㄱ 실행됨 (auto commit & close)
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
