package com.ozansaribal.springboot.mongodb.repository;

import com.ozansaribal.springboot.mongodb.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
}
