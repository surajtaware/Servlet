package com.cg.service;

import com.cg.beans.Game;
import com.cg.exception.DuplicateElementException;

public interface GameService {

	public Game add(Game game) throws DuplicateElementException;
}
