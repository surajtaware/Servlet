package com.cg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateElementException;

public class GameRepoImpl implements GameRepo {
	
	Set<Game> games;
		
	public GameRepoImpl(Set<Game> games) {
		super();
		this.games = games;
	}

	public Game findByName(String name) {
		if(name == null)
			throw new NullPointerException();
				
		for(Game g:games) {
				
				if(g.getName()==name)
				return g;
		}
		
		return null;
	}
	
	public Game save(Game game)  {
		if(game == null)
			throw new NullPointerException();
		if(game.getName()==null)
			throw new NullPointerException();
		
				
		games.add(game);
		
		return game;
	}

	
	/*public Day findByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	
}
