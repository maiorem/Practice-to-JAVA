package com.project.springmvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springmvc.service.member.IdCheckService;

@Controller
public class IdCheckController {
	
	@Autowired
	IdCheckService idService;
	
	@RequestMapping
	@ResponseBody
	public String idCheck(@RequestParam("email") String email) {
		return idService.idcheck(email);
	}

}
