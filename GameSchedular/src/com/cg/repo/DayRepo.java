package com.cg.repo;

import com.cg.beans.Day;

public interface DayRepo {


	public Day save(Day day);
	
	public Day findByPlayerName(String playerName);
	
	public Day findByGamesName(String gameName);
}
