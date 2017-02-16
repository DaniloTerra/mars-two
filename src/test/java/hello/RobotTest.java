package hello;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RobotTest {
	@Test
	public void TestMoveForward() {
		Robot robot = new Robot();

		assertEquals(robot.move("M"), "(0, 1, N)");
		assertEquals(robot.move("M"), "(0, 2, N)");
	}

	@Test
	public void TestMoveLeft() {
		Robot robot = new Robot();

		assertEquals(robot.move("L"), "(0, 0, W)");
		assertEquals(robot.move("L"), "(0, 0, S)");
		assertEquals(robot.move("L"), "(0, 0, E)");
		assertEquals(robot.move("L"), "(0, 0, N)");
	}

	@Test
	public void TestMoveRight() {
		Robot robot = new Robot();

		assertEquals(robot.move("R"), "(0, 0, E)");
		assertEquals(robot.move("R"), "(0, 0, S)");
		assertEquals(robot.move("R"), "(0, 0, W)");
		assertEquals(robot.move("R"), "(0, 0, N)");
	}

	@Test
	public void TestCaseOne() {
		Robot robot = new Robot();

		assertEquals(robot.move("MMRMMRMM"), "(2, 0, S)");
	}

	@Test
	public void TestCaseTwo() {
		Robot robot = new Robot();

		assertEquals(robot.move("MML"), "(0, 2, W)");		
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestInvalidOrientation() {
		Robot robot = new Robot();
		robot.move("AAA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestMoveOutOfForwardLimit() {
		Robot robot = new Robot();
		robot.move("MMMMMM");	
	}
}