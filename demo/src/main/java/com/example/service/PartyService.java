package com.example.service;

import java.util.List;

import com.example.entity.Party;

public interface PartyService {
    
    public static final String BEAN_NAME = "partyService";
    
    public static final int PayMethod_AA = 0;
    public static final int PayMethod_free = 1;
    public static final int PayMethod_me = 2;
    
    public List<Party> getAll();
    
    public List<Party> getBySubject(String subject);
    
    public Party UpdateParty(Party party);
    
}
