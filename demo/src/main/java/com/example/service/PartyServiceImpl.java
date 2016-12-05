package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PartyDao;
import com.example.entity.Party;


@Service(PartyService.BEAN_NAME)
public class PartyServiceImpl implements PartyService {
	
    @Autowired
    private PartyDao partyDao;
    
    public List<Party> getAll(){
    	return partyDao.findAll();
    }
    
    public List<Party> getBySubject(String subject){
    	return partyDao.findBySubject(subject);
    }
    
    //update or delete
    public Party UpdateParty(Party party){
    	return partyDao.save(party);
    }
    
	
}
