package com.ozansaribal.springboot.mongodb.controller;

import com.ozansaribal.springboot.mongodb.converter.MemberConverter;
import com.ozansaribal.springboot.mongodb.dto.MemberDto;
import com.ozansaribal.springboot.mongodb.entity.Member;
import com.ozansaribal.springboot.mongodb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public List<MemberDto> findAll() {

        List<Member> memberList = memberService.findAll();

        List<MemberDto> memberDtoList = MemberConverter.INSTANCE.convertAllMemberListToMemberDtoList(memberList);

        return memberDtoList;

        //return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable String id) {
        return memberService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody MemberDto memberDto) {

        Member member = MemberConverter.INSTANCE.convertMemberDtoToMember(memberDto);

        member = memberService.save(member);

        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

}
