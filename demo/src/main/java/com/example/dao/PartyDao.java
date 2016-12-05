package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Party;



public interface PartyDao extends JpaRepository <Party, String> {
    
    List<Party> findBySubject(String subject);

	Party save(Party party);
    
}
