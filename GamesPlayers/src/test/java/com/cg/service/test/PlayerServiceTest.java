package com.cg.service.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.omg.CORBA.portable.ApplicationException;

import com.cg.beans.Game;
import com.cg.beans.Player;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.PlayerRepo;
import com.cg.service.PlayerService;
import com.cg.service.PlayerServiceImpl;

public class PlayerServiceTest {

private PlayerService playerService;
	
	@Mock private PlayerRepo playerRepo;
	
	@Before
	public void init(){
	
	MockitoAnnotations.initMocks(this);
	playerService = new PlayerServiceImpl(playerRepo);
	}
	
	// Adding Player object with null values.
	@Test(expected=NullPointerException.class)
	public void test_save_withNullValues() throws ApplicationException {
	
	Player player = new Player();
	try {
		playerService.add(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	// Player's Name Can't be empty.
	@Test(expected=NullPointerException.class)
	public void test_save_withoutPlayerName() throws ApplicationException {
	
	Player player = new Player();
	player.setName(null);
	try {
		playerService.add(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	//Valid Player should be added.
	@Test
	public void test_save_validPlayerDetails() throws ApplicationException {
	
	Player player = new Player();
	player.setName("Virat Kholi");
	Game game = new Game();
	game.setName("Cricket");
	game.setNoOfPlayers((byte) 11);
	player.setGame(game);
	try {
		when(playerRepo.save(player)).thenReturn(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		playerService.add(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} 
	
	//Player needs at least one game.
	@Test(expected = RuntimeException.class)
	public void test_save_playerRequiredAtLeastOneGame()  {
	
	Player player = new Player();
	player.setName("Virat Kholi");
	//player.setGame(null);
	try {
		when(playerRepo.save(player)).thenReturn(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		playerService.add(player);
	} catch (DuplicateElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


}
