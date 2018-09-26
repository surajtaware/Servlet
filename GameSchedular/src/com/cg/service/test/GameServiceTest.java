package com.cg.service.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.cg.beans.Game;
import com.cg.repo.GameRepoImpl;
import com.cg.service.GameService;
import com.cg.service.GameServiceImpl;


public class GameServiceTest {

	private GameService gameService;
	
	private GameRepoImpl gameRepoImpl;

	@Before
	public void init(){
		
		MockitoAnnotations.initMocks(this);
		gameService = new GameServiceImpl(gameRepoImpl);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Game game = new Game();
		gameService.add(game);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Game game = null;		
		gameService.add(game);
	}
}
