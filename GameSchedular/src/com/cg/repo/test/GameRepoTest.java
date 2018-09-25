package com.cg.repo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Game;
import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.GameRepo;
import com.cg.repo.GameRepoImpl;
import com.cg.repo.PlayerRepo;
import com.cg.repo.PlayerRepoImpl;

public class GameRepoTest {

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}
	

	private GameRepo gameRepo;
	
	@Before
	public void init(){
		
		gameRepo = new GameRepoImpl();
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Game game = new Game();
		gameRepo.save(game);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Game game = null;		
		gameRepo.save(game);
	}
	
	@Test(expected=DuplicateElementException.class)
	public void test_save2() {
		Game game = new Game();
		game.setName("hockey");
		gameRepo.save(game);
		
		Game game1 = new Game();
		game1.setName("hockey");
		gameRepo.save(game1);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_findByName() {
		String gameName =null;
		gameRepo.findByName(gameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		Game game = new Game();
		game.setName("hockey");
		
		gameRepo.save(game);
		
		String GameName ="hockey";
		Game g =gameRepo.findByName(GameName);
	
		assertTrue("hockey".equals(g.getName()));
	}
	
	@Test
	public void test_findByGamesName2() {
		Game game = new Game();
		game.setName("hockey");
		
		gameRepo.save(game);
		
		String GameName ="cricket";
		Game g =gameRepo.findByName(GameName);
	
		assertNull(g);
	}

}
