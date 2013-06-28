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
    public void easyTest() {
        int [][] a = new int[9][9];
        a[0] = new int[] {0,1,4,  8,0,0,  3,0,7};
        a[1] = new int[] {6,7,0,  4,0,0,  5,0,0};
        a[2] = new int[] {0,5,0,  3,6,7,  9,0,4};

        a[3] = new int[] {4,0,0,  2,8,0,  0,9,5};
        a[4] = new int[] {0,9,5,  7,0,3,  0,2,0};
        a[5] = new int[] {8,0,2,  0,1,0,  0,4,3};

        a[6] = new int[] {7,4,0,  0,5,2,  8,0,0};
        a[7] = new int[] {3,0,6,  0,0,4,  0,5,9};
        a[8] = new int[] {0,0,9,  0,3,8,  4,7,0};

        Solver solver = new Solver(a);
        assertArrayEquals( new int[] {8, 0, 0, 4, 0, 0, 3, 6, 7}, solver.getSquare( 3, 0 ));
        assertArrayEquals( new int[] {7, 4, 0, 3, 0, 6, 0, 0, 9}, solver.getSquare( 0, 7 ));
        assertArrayEquals( new int[] {0, 1, 4, 8, 0, 0, 3, 0, 7}, solver.getRow(3, 0));
        assertArrayEquals( new int[] {3, 0, 6, 0, 0, 4, 0, 5, 9}, solver.getRow(0, 7));
        assertArrayEquals( new int[] {8, 4, 3, 2, 7, 0, 0, 0, 0}, solver.getCol(3, 0));
        assertArrayEquals( new int[] {0, 6, 0, 4, 0, 8, 7, 3, 0}, solver.getCol(0, 7));

        print( solver.solveMe() );

    }

    //@Test
    public void hardTest() {
        int [][] a = new int[9][9];
        a[0] = new int[] {4,8,7,  0,5,0,  0,6,0};
        a[1] = new int[] {9,0,0,  4,0,0,  0,0,3};
        a[2] = new int[] {2,0,6,  0,8,9,  5,0,0};

        a[3] = new int[] {0,0,4,  0,1,5,  6,0,0};
        a[4] = new int[] {1,0,0,  0,0,4,  0,5,0};
        a[5] = new int[] {0,7,8,  2,0,0,  0,0,0};

        a[6] = new int[] {0,0,0,  0,0,8,  0,7,0};
        a[7] = new int[] {7,5,0,  0,0,0,  0,3,0};
        a[8] = new int[] {0,2,0,  0,3,7,  4,1,0};

        Solver solver = new Solver(a);

    }

    public void print(int [][] a) {
        for ( int y=0; y<9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                System.out.print( a[y][x] );
            }
            System.out.print( "\n" );
        }
        System.out.println( "================" );
    }


}
