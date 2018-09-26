package com.cg.service;

import com.cg.beans.Game;
import com.cg.repo.GameRepoImpl;

public class GameServiceImpl implements GameService {

	GameRepoImpl gameRepoImpl;
	
	
	
	public GameServiceImpl(GameRepoImpl gameRepoImpl) {
		super();
		this.gameRepoImpl = gameRepoImpl;
	}



	public Game add(Game game) {
		if(game == null)
			throw new NullPointerException();
		if(game.getName()==null)
			throw new NullPointerException();
		
		return gameRepoImpl.save(game);
	}

	
}
