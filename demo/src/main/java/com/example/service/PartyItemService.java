package com.example.service;

import java.util.List;

import com.example.entity.Party;
import com.example.entity.PartyItem;

public interface PartyItemService {
	public static final String BEAN_NAME = "partyItemService";
	
	public static final int Accept = 1;
	public static final int Reject = 2;
	public static final int noDecision = 0;

	List<PartyItem> findAll();

	List<PartyItem> findByOrganizerId(String id);

	List<PartyItem> findByMemberId(String id);

}
