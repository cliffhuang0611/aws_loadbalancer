package jp.co.calace.aws_loadbalancer;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public String dispTop(
		HttpSession session,
		Model model){
		if(session.getAttribute("sessionName") != null){
			return "redirect:sessionTestPage";
		}
		SessionFormModel sfModel = new SessionFormModel();
		model.addAttribute("sessionInfo", sfModel);
		return "index";
	}
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.POST)
	public String processForm(
		HttpSession session,
		@ModelAttribute("sessionInfo") SessionFormModel form,
		Model model
	) {
		session.setAttribute("sessionName", form.getSessionName());
		return "redirect:sessionTestPage";
	}
}
