package com.tpe.controller;

import com.tpe.domain.Member;
import com.tpe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable long id, @RequestBody Member member) {
        memberService.update(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable long id) {
        memberService.delete(id);
    }
}
