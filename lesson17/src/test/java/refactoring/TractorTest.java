package refactoring;

import junit.framework.TestCase;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

    public void testShouldMoveForward(){
        Tractor tractor = new Tractor();
        tractor.move("F");
        assertEquals(0, tractor.position.getPositionX());
        assertEquals(1, tractor.position.getPositionY());
    }

    public void testShouldTurn(){
        Tractor tractor = new Tractor();
        tractor.move("T");
        assertEquals(Orientation.EAST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.WEST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection(){
        Tractor tractor = new Tractor();
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.position.getPositionX());
        assertEquals(0, tractor.position.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(1, tractor.position.getPositionX());
        assertEquals(-1, tractor.position.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(0, tractor.position.getPositionX());
        assertEquals(-1, tractor.position.getPositionY());
        tractor.move("T");
        tractor.move("F");
        assertEquals(0, tractor.position.getPositionX());
        assertEquals(0, tractor.position.getPositionY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau(){
        Tractor tractor = new Tractor();
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
        try{
            tractor.move("F");
            fail("Tractor was expected to fall off the plateau");
        }catch(TractorInDitchException expected){
        }
    }
}