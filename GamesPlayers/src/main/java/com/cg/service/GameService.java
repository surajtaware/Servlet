package com.cg.service;

import com.cg.beans.Game;
import com.cg.exception.DuplicateObjectException;

public interface GameService {

	public Game add(Game game) throws DuplicateObjectException;
}
