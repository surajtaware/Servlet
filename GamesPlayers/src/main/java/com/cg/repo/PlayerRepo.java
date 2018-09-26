package com.cg.repo;

import java.util.List;

import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;

public interface PlayerRepo {

	public Player save(Player player) throws DuplicateElementException;
	
	//public List<Player> findByDayName(String dayName);
	
	public List<Player> findByGamesName(String gameName);

}
