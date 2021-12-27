package com.ozansaribal.springboot.mongodb.service.entityservice;

import com.ozansaribal.springboot.mongodb.entity.Member;
import com.ozansaribal.springboot.mongodb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberEntityService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(String id){

        Optional<Member> optional = memberRepository.findById(id);

        Member member = null;
        if (optional.isPresent()){
            member = optional.get();
        }

        return member;
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public void deleteById(String id){
        memberRepository.deleteById(id);
    }

}
