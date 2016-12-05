package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Party;
import com.example.entity.PartyItem;

public interface PartyItemDao extends JpaRepository<PartyItem, String> {
	public List<PartyItem> findByOrganizerId(String id);
	
	public List<PartyItem> findByMemberId(String id);
	
	
}
