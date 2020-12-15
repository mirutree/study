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
	
	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.list");
	}

}
