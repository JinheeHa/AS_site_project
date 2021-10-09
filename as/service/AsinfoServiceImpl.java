package web.as.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.as.dao.AsinfoDao;
import web.as.vo.asinfoVO;

@Service
public class AsinfoServiceImpl implements AsinfoService{

	@Autowired
	AsinfoDao asinfodao;

	
	@Override
	public List<asinfoVO> selectAsInfoList(asinfoVO vo) throws Exception {
		return asinfodao.selectAsInfoList(vo);
	}
	
	
}
