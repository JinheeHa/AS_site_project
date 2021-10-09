package web.as.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.as.common.SessionUtil;
import web.as.service.AsinfoService;
import web.as.service.MemberService;
import web.as.vo.asinfoVO;
import web.as.vo.memberVO;

@Controller
public class ViewController {

	@Autowired
	MemberService service;
	
	@Autowired
	AsinfoService asservice;
	
	@RequestMapping("/")
	public String main(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception{
		
		// 사용자 세션.
		memberVO membervo = (memberVO)SessionUtil.getAttribute("member");
		
		if(membervo == null ) {	//로그인 세션 체크
			return "login";
		}else {
			return "index";
		}
	}

	@ResponseBody
	@RequestMapping("/member/login")
	public boolean memberlogin(memberVO vo, HttpServletRequest req, HttpServletResponse res, Model model) throws Exception{
		
		
		vo = service.selectMemberOne(vo);
				
		
		if(vo!=null) {
			// TODO : vo를 세션에 등록해줌.
			SessionUtil.setAttribute("member", vo);
			
			return true;	// 로그인 완료
		}else {
			return false;	//로그인 실패
		}
		
	}
	
	
	
	@RequestMapping("/index")
	public String index(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception{
		
		return "index";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception{
		
		return "register";
	}
	
	@ResponseBody 
	@RequestMapping("/member/join")
	public boolean join(@ModelAttribute("memberVO") memberVO vo ) throws Exception{
		
		int cnt = service.selectMemberCount(vo);
		
		if (cnt>0) {
			return false;
		}else {
			service.insertMember(vo);
		}
		
		return true;
	}
	
	@RequestMapping("/member/getList")
	@ResponseBody
	public List<asinfoVO> getList(@ModelAttribute("asinfoVO") asinfoVO vo) throws Exception{
		
		List<asinfoVO> list = asservice.selectAsInfoList(vo) ;
		
		return list;
		
	}
	 
	
	
	
	
}
