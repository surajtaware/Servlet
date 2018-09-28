package com.cg.service;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;
import com.cg.repo.DayRepo;

public class DayServiceImpl implements DayService{

	DayRepo dayRepo;
	
	public DayServiceImpl(DayRepo dayRepo) {
	
	this.dayRepo = dayRepo;
	
	}
	
	public Day add(Day day) throws DuplicateObjectException {
		if(day == null || day.getName()==null)
		{
		throw new NullPointerException();
		}
		
		Day g = dayRepo.findByName(day.getName());
		if(g!=null)
			throw new DuplicateObjectException("day present");
		return dayRepo.save(day);
	}

	
}
