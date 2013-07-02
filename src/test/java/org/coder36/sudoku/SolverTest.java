package org.coder36.sudoku;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite
 * @author Mark Middleton
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
        assertArrayEquals(solution, solver.solve());
    }

    @Test
    public void metroModerateTest() {

        int  p1 [] = new int[] {
                0,6,0,  0,4,8,  0,7,0,
                1,0,0,  0,0,0,  4,0,6,
                0,0,0,  0,1,6,  0,9,0,

                0,0,0,  2,0,4,  7,0,3,
                4,0,6,  0,0,0,  9,0,8,
                7,0,5,  8,0,3,  0,0,0,

                0,4,0,  6,3,0,  0,0,0,
                2,0,7,  0,0,0,  0,0,4,
                0,5,0,  4,8,0,  0,1,0
        };

        int solution [] = new int[] {
                3,6,2,  9,4,8,  1,7,5,
                1,9,8,  7,2,5,  4,3,6,
                5,7,4,  3,1,6,  8,9,2,

                8,1,9,  2,6,4,  7,5,3,
                4,3,6,  5,7,1,  9,2,8,
                7,2,5,  8,9,3,  6,4,1,

                9,4,1,  6,3,2,  5,8,7,
                2,8,7,  1,5,9,  3,6,4,
                6,5,3,  4,8,7,  2,1,9
        };

        Solver solver = new Solver(p1);
        assertArrayEquals(solution, solver.solve());
    }

    @Test
    public void metroHardTest() {

        int  p1 [] = new int[] {
                0,3,0,  0,0,5,  9,0,0,
                8,5,0,  0,0,3,  0,0,0,
                0,0,0,  7,1,0,  0,0,3,

                0,0,8,  0,0,0,  0,2,4,
                0,0,5,  0,0,0,  6,0,0,
                3,9,0,  0,0,0,  1,0,0,

                6,0,0,  0,8,7,  0,0,0,
                0,0,0,  6,0,0,  0,4,1,
                0,0,1,  2,0,0,  0,7,0
        };

        int solution [] = new int[] {
                1,3,7,  4,2,5,  9,6,8,
                8,5,4,  9,6,3,  7,1,2,
                2,6,9,  7,1,8,  4,5,3
                ,
                7,1,8,  3,9,6,  5,2,4,
                4,2,5,  8,7,1,  6,3,9,
                3,9,6,  5,4,2,  1,8,7,

                6,4,3,  1,8,7,  2,9,5,
                5,7,2,  6,3,9,  8,4,1,
                9,8,1,  2,5,4,  3,7,6
        };

        Solver solver = new Solver(p1);
        assertArrayEquals(solution, solver.solve());
    }

   @Test
    public void emptyTest() {

        int p1 [] = new int[] {
                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0,

                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0,

                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0,
                0,0,0,  0,0,0,  0,0,0
        };

        Solver solver = new Solver(p1);
        print( solver.solve() );
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
