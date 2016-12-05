package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PartyItemDao;
import com.example.entity.Party;
import com.example.entity.PartyItem;

@Service(PartyItemService.BEAN_NAME)
public class PartyItemServiceImpl implements PartyItemService {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PartyItemDao partyItemDao;
	

	@Override
	public List<PartyItem> findAll(){
		return partyItemDao.findAll();
	}
	

	@Override
	public List<PartyItem> findByOrganizerId(String id){
		return partyItemDao.findByOrganizerId(id);
	}

	@Override
	public List<PartyItem> findByMemberId(String id){
		return partyItemDao.findByMemberId(id);
	}
}
