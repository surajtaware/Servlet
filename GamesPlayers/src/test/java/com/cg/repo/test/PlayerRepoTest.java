package com.cg.repo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Game;
import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.PlayerRepo;
import com.cg.repo.PlayerRepoImpl;

public class PlayerRepoTest {

	
	private PlayerRepo playerRepo;
	
	@Before
	public void init(){
		
		playerRepo = new PlayerRepoImpl(new ArrayList<Player>());
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Player player = new Player();
		try {
			playerRepo.save(player);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Player player = null;		
		try {
			playerRepo.save(player);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		

	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		String gameName =null;
		playerRepo.findByGamesName(gameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		Game game = new Game();
		game.setName("hockey");
		
		Player player = new Player();
		player.setName("vickey");
		player.setGame(game);
		
		try {
			playerRepo.save(player);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="hockey";
		List<Player> players=playerRepo.findByGamesName(GameName);
	
		assertFalse(players.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() {
		Game game = new Game();
		game.setName("hockey");
		
		Player player = new Player();
		player.setName("vickey");
		player.setGame(game);
		
		try {
			playerRepo.save(player);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="cricket";
		List<Player> players=playerRepo.findByGamesName(GameName);
	
		assertTrue(players.isEmpty());
	}
	
}
