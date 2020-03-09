package jp.co.calace.aws_loadbalancer;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionPageController {
	@RequestMapping(value="sessionTestPage", method=RequestMethod.GET)
	public String disp(
		HttpSession session,
		@RequestParam(value = "procMode", required = false) String procMode,
		Model model){
		if(session.getAttribute("sessionName") == null){
			return "redirect:/";
		}
		if("clearSession".equals(procMode)){
			Enumeration <String> attrList = session.getAttributeNames();
			while(attrList.hasMoreElements()){
				session.removeAttribute(attrList.nextElement());
			}
			return "redirect:/";
		}
		model.addAttribute("instanceId", session.getAttribute("instanceId"));
		model.addAttribute("sessionName", session.getAttribute("sessionName"));
		return "sessionTestPage";
	}
	
}
