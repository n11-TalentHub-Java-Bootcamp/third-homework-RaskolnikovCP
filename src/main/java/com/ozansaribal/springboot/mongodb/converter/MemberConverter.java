package com.ozansaribal.springboot.mongodb.converter;

import com.ozansaribal.springboot.mongodb.dto.MemberDto;
import com.ozansaribal.springboot.mongodb.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberConverter {

    MemberConverter INSTANCE = Mappers.getMapper(MemberConverter.class);

    @Mapping(source = "id", target = "member_id")
    @Mapping(source = "nickname", target = "member_name")
    @Mapping(source = "email", target = "member_email")
    @Mapping(source = "phone_number", target = "member_phone_number")
    MemberDto convertMemberToMemberDto(Member member);

    @Mapping(source = "id", target = "member_id")
    @Mapping(source = "nickname", target = "member_name")
    @Mapping(source = "email", target = "member_email")
    @Mapping(source = "phone_number", target = "member_phone_number")
    List<MemberDto> convertAllMemberListToMemberDtoList(List<Member> memberList);

    @Mapping(source = "member_id", target = "id")
    @Mapping(source = "member_name", target = "nickname")
    @Mapping(source = "member_email", target = "email")
    @Mapping(source = "member_phone_number", target = "phone_number")
    Member convertMemberDtoToMember(MemberDto memberDto);

}
