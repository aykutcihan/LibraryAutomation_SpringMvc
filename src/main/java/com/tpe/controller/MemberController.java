package com.tpe.controller;

import com.tpe.domain.Member;
import com.tpe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/new")
    public String sendMemberForm(@ModelAttribute("member") Member member) {
        return "memberForm";
    }

    @PostMapping("/saveMember")
    public String createMember(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping
    public ModelAndView getMembers(){
        List<Member> list = memberService.getAllMembers();
        ModelAndView mav = new ModelAndView();
        mav.addObject("members",list);
        mav.setViewName("members");
        return mav;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Member member = memberService.findMemberById(id);
        model.addAttribute(member);
        return "memberForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}
