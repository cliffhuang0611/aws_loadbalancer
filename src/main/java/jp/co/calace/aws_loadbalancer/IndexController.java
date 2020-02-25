package jp.co.calace.aws_loadbalancer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String dispTop(Model model){
		return "index";
	}
}
