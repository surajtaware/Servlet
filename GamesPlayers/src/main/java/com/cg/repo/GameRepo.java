package com.cg.repo;

import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;

public interface GameRepo {

	public Game save(Game game);
	
	public Game findByName(String name);
}
