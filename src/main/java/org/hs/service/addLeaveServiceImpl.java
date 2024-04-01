package org.hs.service;

import org.hs.domain.addLeavesDTO;
import org.hs.mapper.CalendarMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class addLeaveServiceImpl implements addLeaveService {
	private CalendarMapper mapper;
	
	
	@Override
	public void addLeaves(addLeavesDTO leaves) {
		mapper.insert(leaves);
		
		log.info("register.........");
		
		
	}
}
