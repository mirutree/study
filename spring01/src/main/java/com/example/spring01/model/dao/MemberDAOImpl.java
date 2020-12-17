package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public boolean check_passwd(String userid, String passwd) {
		boolean result = false;
		// mybatis mapper에 전달할 값이 2개 이상인 경우
		// dto 또는 맵으로 전달
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		// 쿼리에 전달할 때 2개이상 쓸 수가 없음 selectOne 함수가 1개밖에 못 보냄. 그래서 맵으로 묶음
		int count = sqlSession.selectOne("member.check_passwd", map);
		// 레코드가 1개이면 true, 0개이면 false 리턴. count는 1 아니면 0임
		if (count == 1)
			result = true; // 1이면 (아이디,비밀번호가 일치하면) result는 true임
		return result; 
	}
	

}
