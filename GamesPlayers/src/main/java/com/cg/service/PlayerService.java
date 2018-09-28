package com.cg.service;

import com.cg.beans.Player;
import com.cg.exception.DuplicateObjectException;

public interface PlayerService {

	public Player add(Player player) throws DuplicateObjectException;
}
