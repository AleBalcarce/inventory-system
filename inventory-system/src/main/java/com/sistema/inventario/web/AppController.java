package com.sistema.inventario.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("")
	public String indexPage() {
		return "index";
	}

}
