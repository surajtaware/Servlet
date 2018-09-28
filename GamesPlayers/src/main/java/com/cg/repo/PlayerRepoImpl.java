package com.cg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.beans.Player;

import com.cg.exception.DuplicateObjectException;

public class PlayerRepoImpl implements PlayerRepo{
	
	List<Player> players;	
	
	
	public PlayerRepoImpl(List<Player> players) {
		super();
		this.players = players;
	}



	public Player save(Player player) throws DuplicateObjectException {
		if(player == null)
			throw new NullPointerException();
		if(player.getName()==null)
			throw new NullPointerException();
		
		
		
		players.add(player);
		
		return player;
	}

	
		
	public List<Player> findByGamesName(String gameName) {
		if(gameName == null)
			throw new NullPointerException();
		List<Player> d1 = new ArrayList<Player>();
		
		for(Player d:players) {
			
			Set<Game> games=d.getGame();
			
			for(Game g:games) {
				
				String sname=g.getName();						
				
				if(sname==gameName)
				{
					//System.out.println("first : "+sname);
					//System.out.println("second :"+gameName);
					d1.add(d);
				}
			}
		}
		
		return d1;
	}
	
	

	
}
