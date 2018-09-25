package com.cg.repo;

import java.util.List;

import com.cg.beans.Player;

public interface PlayerRepo {

	public Player save(Player player);
	
	//public List<Player> findByDayName(String dayName);
	
	public List<Player> findByGamesName(String gameName);

}
