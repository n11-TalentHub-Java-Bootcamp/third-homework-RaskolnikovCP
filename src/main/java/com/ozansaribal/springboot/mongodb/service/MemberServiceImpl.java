package com.ozansaribal.springboot.mongodb.service;

import com.ozansaribal.springboot.mongodb.entity.Member;
import com.ozansaribal.springboot.mongodb.service.entityservice.MemberEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberEntityService memberEntityService;

    public List<Member> findAll() {
        return memberEntityService.findAll();
    }

    public Member findById(String id) {
        return memberEntityService.findById(id);
    }

    public Member save(Member member) {
        return memberEntityService.save(member);
    }

    public void delete(String id) {
        memberEntityService.deleteById(id);
    }

}
