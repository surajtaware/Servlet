package com.cg.service.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;
import com.cg.repo.DayRepo;
import com.cg.service.DayService;
import com.cg.service.DayServiceImpl;

public class DayServiceTest {

private DayService dayService;
	
	@Mock private DayRepo dayRepo;
	
	@Before
	public void init(){
	
	MockitoAnnotations.initMocks(this);
	dayService = new DayServiceImpl(dayRepo);
	}
	
	// Adding Day object with null values.
	@Test(expected=NullPointerException.class)
	public void test_save_withNullValues() {
	
	Day day = new Day();
	try {
		dayService.add(day);
	} catch (DuplicateObjectException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	// Day's Name Can't be empty.
	@Test(expected=NullPointerException.class)
	public void test_save_withoutDayName() {
	
	Day day = new Day();
	day.setName(null);
	try {
		dayService.add(day);
	} catch (DuplicateObjectException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	//Valid Days should be added.
	@Test
	public void test_save_validDays() {
	
	Day day = new Day();
	day.setName("Day1");
	try {
		when(dayRepo.save(day)).thenReturn(day);
	} catch (DuplicateObjectException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		dayService.add(day);
	} catch (DuplicateObjectException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} 
	
	@Test(expected=DuplicateObjectException.class)
	public void test_save_duplicate() throws DuplicateObjectException {
		Day day = new Day();
		day.setName("1");
		
		
			when(dayRepo.findByName(day.getName())).thenReturn(day);
		
		
			dayService.add(day);
		
	}
	

}
