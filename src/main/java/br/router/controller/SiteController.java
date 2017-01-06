package br.router.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
	
	@GetMapping(value = {"", "index"})
	public String root() {
		return "views/index";
	}

}
