package org.hs.mapper;

import java.util.List;

import org.hs.domain.CalendarVO;
import org.hs.domain.addLeavesDTO;

public interface CalendarMapper {

	public List<CalendarVO> getList();
	
	public void insert(CalendarVO board);
	
	public void insertSelectKey(CalendarVO board);
	
	public List<addLeavesDTO> getLevesList();
	
	public void insert(addLeavesDTO leaves);
	
	
}
