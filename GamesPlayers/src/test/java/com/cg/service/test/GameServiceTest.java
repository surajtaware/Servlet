package com.cg.service.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.beans.Game;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.GameRepoImpl;
import com.cg.service.GameService;
import com.cg.service.GameServiceImpl;


public class GameServiceTest {

	private GameService gameService;
	
	@Mock private GameRepoImpl gameRepoImpl;

	@Before
	public void init(){
		
		MockitoAnnotations.initMocks(this);
		gameService = new GameServiceImpl(gameRepoImpl);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Game game = new Game();
		try {
			gameService.add(game);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_save_success() {
		Game game = new Game();
		game.setName("hockey");
		
		try {
			when(gameRepoImpl.save(game)).thenReturn(game);
		} catch (DuplicateElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gameService.add(game);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Game game = null;		
		try {
			gameService.add(game);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
