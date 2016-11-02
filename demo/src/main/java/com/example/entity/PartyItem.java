package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_PARTY_ITEM", schema = "APP")
public class PartyItem {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "CHAR(36)")
    private String id;

	
	
	  @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
    @JoinColumn(name="PARTY_ID")
    private Party party;
    
    @Column(name = "MEMBERID", length = 50)
    private String memberId;
    
    @Column(name = "ORGANIZERID", length = 50)
    private String organizerId;
    
    @Column(name="ACCEPT") // 0:null 1:accept 2:reject
    private int accept;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberid) {
		this.memberId = memberid;
	}

	public String getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}

	public int getAccept() {
		return accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}   
}
