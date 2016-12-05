package com.example.web.controller;

import static com.example.web.model.common.ResponseCode.SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Party;
import com.example.service.PartyItemService;
import com.example.service.PartyService;
import com.example.web.model.PartyRequest;
import com.example.web.model.PartyResponse;
import com.example.web.model.UpdateUserResponse;
import com.example.web.model.common.JsonResponse;

@RestController
public class PartyController {

    private static Logger logger = LoggerFactory.getLogger(PartyController.class);
    
    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyItemService partyItemService;
    
    @RequestMapping(value = "/party", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "*")
    public @ResponseBody PartyResponse partyAction(@RequestBody PartyRequest req) {
    	
    	Party party=new Party();
    	party.setLocation(req.getAddress());
    	party.setLongitude(req.getLng());
    	
    	party.setLatitude(req.getLat());
    	party.setReMark(req.getNote());
    	party.setSubject(req.getTopic());
    	party.setStartDate(req.getDate());
    	partyService.UpdateParty(party);

    	PartyResponse res = new PartyResponse(SUCCESS, "Create Success!");
		return res;
    }
}
