package com.cg.service;

import com.cg.beans.Day;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.DayRepo;

public class DayServiceImpl implements DayService{

	DayRepo dayRepo;
	
	public DayServiceImpl(DayRepo dayRepo) {
	
	this.dayRepo = dayRepo;
	
	}
	
	public Day add(Day day) throws DuplicateElementException {
	if(day == null)
	{
	throw new NullPointerException();
	}
	if(day.getName() == null) {
	
	throw new NullPointerException();
	}
	
	return dayRepo.save(day);
	}

	
}
