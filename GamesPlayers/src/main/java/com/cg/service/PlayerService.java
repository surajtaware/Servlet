package com.cg.service;

import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;

public interface PlayerService {

	public Player add(Player player) throws DuplicateElementException;
}
