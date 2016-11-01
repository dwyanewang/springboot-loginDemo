package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name="T_ROLE", schema="APP")
public class UserAuthority implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "system-assigned")
    @GenericGenerator(name= "system-assigned", strategy = "assigned")
    @Column(name="ID", columnDefinition="CHAR(6)")
    private String id;
    
    @Column(name="ROLE_NAME", length=30)
    private String authority;
    
    @Column(name="ROLE_DESC", length=50)
    private String description;
    
    @Override
    public String getAuthority() {
        return authority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
