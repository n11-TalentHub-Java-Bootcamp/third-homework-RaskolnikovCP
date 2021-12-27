package com.ozansaribal.springboot.mongodb.service;

import com.ozansaribal.springboot.mongodb.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(String id);

    Member save(Member member);

    void delete(String id);

}
