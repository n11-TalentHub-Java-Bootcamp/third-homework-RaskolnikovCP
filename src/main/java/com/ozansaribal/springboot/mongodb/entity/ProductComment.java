package com.ozansaribal.springboot.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "product_comment")
public class ProductComment {

    @Id
    private String id;

    private String comment;
    private Date comment_date;
    private String product_id;
    private String member_id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
}
