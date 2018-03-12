package demoMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/name")
	public ModelAndView name() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("obj","View_message");
		return modelAndView;
		
	}
	@RequestMapping("/sample")
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("Sample");
		modelAndView.addObject("sample_Obj", "login form");
		return modelAndView;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
	@RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LogInBean loginBean)
	{
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null)
        {
            if (loginBean.getUserName().equals("chandra") && loginBean.getPassword().equals("chandra123")) 
            {
                model.addAttribute("msg", "welcome" /*+ loginBean.getUserName()*/);
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
	
   

}
