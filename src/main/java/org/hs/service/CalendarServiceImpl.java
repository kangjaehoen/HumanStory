package org.hs.service;

import org.hs.domain.CalendarVO;
import org.hs.mapper.CalendarMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class CalendarServiceImpl implements CalendarService {
	private CalendarMapper mapper;
	
	
	@Override
	public void register(CalendarVO board) {
		mapper.insert(board);
		
		log.info("register.........");
	}

}
