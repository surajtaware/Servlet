package com.cg.service;

import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;
import com.cg.repo.GameRepoImpl;

public class GameServiceImpl implements GameService {

	GameRepoImpl gameRepoImpl;
	
	
	
	public GameServiceImpl(GameRepoImpl gameRepoImpl) {
		super();
		this.gameRepoImpl = gameRepoImpl;
	}



	public Game add(Game game) throws DuplicateObjectException {
		if(game == null || game.getName()==null)
			throw new NullPointerException();
		
		Game g = gameRepoImpl.findByName(game.getName());
		if(g!=null)
			throw new DuplicateObjectException("game present");
		
		return gameRepoImpl.save(game);
	}

	
}
