package com.bot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bot.vo.LeadResponseVO;
import com.bot.vo.LeadVO;

@Controller("botController")
public class BotController {
	
	
	public static final String EXT_JSP=".jsp";
	
	private int RANGE = 125000;
	private int MIN = 4000;
	
	
	@RequestMapping({"/bot/{screen}", "/auth/{screen}"})
	public ModelAndView adminScreens(final HttpServletRequest request,
			@PathVariable("screen") String screen) {
		return  new ModelAndView(screen + EXT_JSP);
	}

	
	@RequestMapping(value = "/v1/process-lead", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody LeadResponseVO createNewContext(
			@RequestBody LeadVO lead,
			final HttpServletRequest request, final HttpServletResponse response) {

		try {
			this.saveInSession(lead, request.getSession());
			System.out.println(lead.getDebug());
			if(this.isBot(lead, request.getSession())){
				return new LeadResponseVO("NA","potential_bot",null);
			}else{
				return new LeadResponseVO("ID"+ Math.random() *10000,"success",null);
			}
			

		}catch (Exception exception) {
			exception.printStackTrace();
			return new LeadResponseVO(null, "error", exception.getMessage());
		}

	}
	
	private void saveInSession(LeadVO leadVO, HttpSession session){
		
		if(leadVO.getDebug() ==0)
				return;
		
		if(session.getAttribute("xc") == null){
			session.setAttribute("xc", leadVO.getDebug());
			session.setAttribute("first", "y");
		}else{
			session.setAttribute("first", "n");
		}
	}
	
	private boolean isBot(LeadVO leadVO, HttpSession session){
		
		if(leadVO.getDebug() < MIN)
				return true;
		
		if("y".equals(session.getAttribute("first"))){
			return false;
		}else{
			long original = (Long)session.getAttribute("xc");
			if(leadVO.getDebug() > original - RANGE && leadVO.getDebug() < original + RANGE ){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
}
