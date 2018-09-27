package com.cg.service;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.DayRepo;

public class DayServiceImpl implements DayService{

	DayRepo dayRepo;
	
	public DayServiceImpl(DayRepo dayRepo) {
	
	this.dayRepo = dayRepo;
	
	}
	
	public Day add(Day day) throws DuplicateElementException {
		if(day == null || day.getName()==null)
		{
		throw new NullPointerException();
		}
		
		Day g = dayRepo.findByName(day.getName());
		if(g!=null)
			throw new DuplicateElementException("day already present");
		return dayRepo.save(day);
	}

	
}
