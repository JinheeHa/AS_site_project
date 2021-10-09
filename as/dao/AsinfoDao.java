package web.as.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.as.vo.asinfoVO;

@Repository
public class AsinfoDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<asinfoVO> selectAsInfoList(asinfoVO vo) throws Exception{
		
		return sqlSession.selectList("asinfo.selectAsInfoList", vo);
		
	}
	
	
}
