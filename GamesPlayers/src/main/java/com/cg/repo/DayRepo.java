package com.cg.repo;

import java.util.List;

import com.cg.beans.Day;

import com.cg.exception.DuplicateObjectException;

public interface DayRepo {


	public Day save(Day day) throws DuplicateObjectException;
	
	//public Day findByPlayerName(String playerName);
	
	public List<Day> findByGamesName(String gameName);

	public Day findByName(String name);
}
