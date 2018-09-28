package com.cg.repo.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Game;
import com.cg.beans.Player;
import com.cg.exception.DuplicateObjectException;
import com.cg.repo.GameRepo;
import com.cg.repo.GameRepoImpl;
import com.cg.repo.PlayerRepo;
import com.cg.repo.PlayerRepoImpl;

public class GameRepoTest {

	
	/*private GameRepo gameRepo;
	
	@Before
	public void init(){
		
		gameRepo = new GameRepoImpl();
	}*/
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		GameRepo gameRepo = new GameRepoImpl(new HashSet<Game>());
		
		Game game = new Game();
		gameRepo.save(game);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		GameRepo gameRepo = new GameRepoImpl(new HashSet<Game>());
		Game game = null;		
		gameRepo.save(game);
	}
	
	

	@Test(expected=NullPointerException.class)
	public void test_findByName() {
		GameRepo gameRepo = new GameRepoImpl(new HashSet<Game>());
		
		String gameName =null;
		gameRepo.findByName(gameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		GameRepo gameRepo = new GameRepoImpl(new HashSet<Game>());
		
		Game game = new Game();
		game.setName("kho-kho");
		
		gameRepo.save(game);
		
		String GameName ="kho-kho";
		Game g =gameRepo.findByName(GameName);
	
		assertTrue("kho-kho".equals(g.getName()));
	}
	
	@Test
	public void test_findByGamesName2() {
		GameRepo gameRepo = new GameRepoImpl(new HashSet<Game>());
		
		Game game = new Game();
		game.setName("kho-kho");
		
		gameRepo.save(game);
		
		String GameName ="cricket";
		Game g =gameRepo.findByName(GameName);
	
		assertNull(g);
	}

}
