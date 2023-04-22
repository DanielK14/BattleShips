import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleShipTest {
	
	private static ArrayList<BattleShip> testShipsList = new ArrayList<BattleShip>();
	private static ArrayList<String> testShipLocation = new ArrayList<String>(); 
	private static BattleShip testBattleShip = new BattleShip();
	private static GameHelper testHelper = new GameHelper();
	
	@BeforeAll
	static void setUpTests() {
		testBattleShip.setName("testBattleShip");
		testShipsList.add(testBattleShip);
		testShipLocation.add("b2");
		testShipLocation.add("b3");
		testShipLocation.add("b4");
		testBattleShip.setLocationCells(testShipLocation);
	}

	@Test
	void testMiss() {
		assertEquals("miss", testBattleShip.checkYourSelf("a2"));
	}
	
	@Test
	void testHit() {
		assertEquals("hit", testBattleShip.checkYourSelf("b2"));
	}
	
	@Test
	void testSameHit() {
		BattleShip sameHitShip = new BattleShip();
		ArrayList<String> sameHitLocationArrayList = new ArrayList<String>();
		sameHitLocationArrayList.add("c3");
		sameHitLocationArrayList.add("c4");
		sameHitLocationArrayList.add("c5");
		sameHitShip.setLocationCells(sameHitLocationArrayList);
		
		sameHitShip.checkYourSelf("c3");
		sameHitShip.checkYourSelf("c3");
		assertEquals(1, sameHitShip.numOfHits);
	}
	
	@Test
	void testKill() {
		testBattleShip.checkYourSelf("b3");
		testBattleShip.checkYourSelf("b2");
		assertEquals("kill", testBattleShip.checkYourSelf("b4"));
	}
	
	
	
	@Test
	void testSetName() {
		assertEquals("testBattleShip", testBattleShip.getName());
	}

}
