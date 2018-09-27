package com.cg.service;

import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.PlayerRepo;

public class PlayerServiceImpl implements PlayerService {

	private PlayerRepo playerRepo;
	
	public PlayerServiceImpl(PlayerRepo playerRepo) {
	
	this.playerRepo = playerRepo;
	}
	
	public Player add(Player player) throws DuplicateElementException  {
	
			if(player == null) {
			
			throw new NullPointerException();
			}
			if(player.getName() == null) {
			
			throw new NullPointerException();
			}
			if(player.getGame().size() < 1) {
			
			throw new RuntimeException("Player needs at least one game.");
			}
			
			
			
			return playerRepo.save(player);
	}


}
