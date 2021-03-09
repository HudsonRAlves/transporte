package br.com.hudson.transporte.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transporte")
public class TransporteController {
	
	@RequestMapping("/ola")
	public String exibirMensagem(){
		return "Hello Word!!!";
	}
	
}
