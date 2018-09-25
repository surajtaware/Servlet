package com.cg.beans;

import java.util.Set;

public class Day {

	private String name;
	
	private Set<Game> games;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGame(Game game) {
		games.add(game);
	}
	
	
}
