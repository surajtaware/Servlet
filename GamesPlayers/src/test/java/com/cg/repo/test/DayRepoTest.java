package com.cg.repo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;
import com.cg.repo.DayRepo;
import com.cg.repo.DayRepoImpl;

public class DayRepoTest {

	private DayRepo dayRepo;
		
	@Before
	public void init(){
		
		//dayRepo = new DayRepoImpl();
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		Day day = new Day();
		try {
			dayRepo.save(day);
		} catch (DuplicateObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		Day day = null;		
		try {
			dayRepo.save(day);
		} catch (DuplicateObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=DuplicateObjectException.class)
	public void test_save2() throws DuplicateObjectException {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		
		Day day = new Day();
		day.setName("kho-kho");		
		dayRepo.save(day);
		
		Day day1 = new Day();
		day1.setName("kho-kho");
		dayRepo.save(day1);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		String GameName =null;
		dayRepo.findByGamesName(GameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		Game game = new Game();
		game.setName("kho-kho");
		
		Day day = new Day();
		day.setName("first");
		day.setGame(game);
		
		try {
			dayRepo.save(day);
		} catch (DuplicateObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="kho-kho";
		List<Day> days=dayRepo.findByGamesName(GameName);
	
		assertFalse(days.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() {
		DayRepo dayRepo = new DayRepoImpl(new ArrayList<Day>());
		Game game = new Game();
		game.setName("kho-kho");
		
		Day day = new Day();
		day.setName("first");
		day.setGame(game);
		
		try {
			dayRepo.save(day);
		} catch (DuplicateObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
		System.out.println(days.size());
		assertTrue(days.isEmpty());
	}
	
	
}
