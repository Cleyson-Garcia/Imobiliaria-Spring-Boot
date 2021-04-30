package com.gft.imobiliaria.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gft.imobiliaria.Service.SetupService;

@Controller
public class IndexController {

	private boolean importado;
	@Autowired
	private SetupService serv;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("indexPage.html");
		mv.addObject("import",importado);
		return mv;
		
	}
	
	@GetMapping("/import")
	public ModelAndView importar() {
		importado = true;
		serv.loadDb();
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
	@PostConstruct
	private void checkBd() {
		importado = serv.checkState();
	}
}
