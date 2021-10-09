package web.as.service;

import java.util.List;

import web.as.vo.memberVO;
import web.as.vo.asinfoVO;

public interface AsinfoService {
	
	public List<asinfoVO> selectAsInfoList(asinfoVO vo) throws Exception;
	
	
	
	
}
