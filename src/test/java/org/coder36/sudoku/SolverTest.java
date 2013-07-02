package org.coder36.sudoku;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mark
 * Date: 27/06/13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class SolverTest {

    @Test
    public void metroEasyTest() {

        int  p1 [] = new int[] {
                0,1,0,  3,0,4,  5,0,0,
                5,0,7,  0,1,0,  4,0,0,
                0,4,0,  0,7,0,  0,1,9,

                4,0,0,  7,0,2,  0,0,8,
                0,3,8,  0,0,0,  2,9,0,
                2,0,0,  6,0,8,  0,0,7,

                9,8,0,  0,2,0,  0,6,0,
                0,0,4,  0,8,0,  9,0,5,
                0,0,3,  9,0,6,  0,2,0
        };

        int solution [] = new int[] {
                8,1,9,  3,6,4,  5,7,2,
                5,6,7,  2,1,9,  4,8,3,
                3,4,2,  8,7,5,  6,1,9,

                4,9,6,  7,3,2,  1,5,8,
                7,3,8,  5,4,1,  2,9,6,
                2,5,1,  6,9,8,  3,4,7,

                9,8,5,  4,2,3,  7,6,1,
                6,2,4,  1,8,7,  9,3,5,
                1,7,3,  9,5,6,  8,2,4
        };

        Solver solver = new Solver(p1);
        assertArrayEquals( solution, solver.solveMe() );
    }

   @Test
    public void reallyEasyTest() {

        int solution [] = new int[] {
                5,3,4,  6,7,8,  9,1,2,
                6,7,2,  1,9,5,  3,4,8,
                1,9,8,  3,4,2,  5,6,7,

                8,5,9,  7,6,1,  4,2,3,
                4,2,6,  8,5,3,  7,9,1,
                7,1,3,  9,2,4,  8,5,6,

                9,6,1,  5,3,7,  2,8,4,
                2,8,7,  4,1,9,  6,3,5,
                3,4,5,  2,8,6,  1,7,9
        };

        int p1 [] = new int[] {
                5,3,4,  6,7,8,  9,1,2,
                6,7,2,  1,9,5,  3,4,8,
                1,9,8,  3,4,2,  5,6,7,

                0,0,0,  0,0,0,  0,0,0,
                4,2,6,  0,0,0,  0,0,0,
                7,1,3,  9,2,4,  0,0,0,

                9,6,1,  0,3,7,  2,8,4,
                2,8,7,  4,0,9,  6,3,5,
                3,4,5,  2,8,6,  1,7,9
        };

        Solver solver = new Solver(p1);
        assertArrayEquals( solution, solver.solveMe() );


    }





    public void print(int [] a) {
        int i = 0;
        for ( int y=0; y<9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                System.out.print( a[i++] );
            }
            System.out.print( "\n" );
        }
        System.out.println( "================" );
    }


}
