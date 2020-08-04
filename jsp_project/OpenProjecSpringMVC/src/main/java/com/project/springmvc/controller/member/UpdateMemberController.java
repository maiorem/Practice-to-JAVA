package com.project.springmvc.controller.member;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springmvc.model.member.EditMemberRequest;
import com.project.springmvc.service.member.EditMemberFormService;
import com.project.springmvc.service.member.EditMemberService;

@Controller
@RequestMapping("/member/editMember")
public class UpdateMemberController {
	
	@Autowired
	EditMemberService editService;
	
	@Autowired
	EditMemberFormService editFormService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String editForm(@RequestParam int idx, Model model) {
		model.addAttribute("editId", editFormService.selectIdByIdx(idx));
		return "/member/editMemberForm";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String editMember(HttpServletRequest request, EditMemberRequest editMember, Model model) throws IOException, Exception {
		
		model.addAttribute("editResult", editService.editMemberInfo(request, editMember));	
		return "/member/editMember";
	}
	
	
}
