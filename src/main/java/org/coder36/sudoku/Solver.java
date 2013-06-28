package org.coder36.sudoku;

import java.util.Stack;

/**
 */
public class Solver {

    int [][] a = new int[9][9];

    public Solver(int [][] a ) {
        this.a = a;
    }

    public Solver( int [] puzzle ) {
        int i = 0;
        for ( int y=0; y<9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                a[y][x] = puzzle[i++];
            }
        }
    }

    public int[] solveMe() {
        recurse();
        int b[] = new int[81];
        int i = 0;
        for ( int y=0; y<9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                b[i++] =a[y][x];
            }
        }
        return b;

    }

    private int tries = 0;

    public boolean recurse() {
        if ( tries++ % 100000 == 0 ) {
            System.out.println( tries );
        }
        if ( isComplete() ) return true;
        for ( int y=0; y<9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                if ( a[y][x] == 0 ) {
                    for ( int i=1; i<=9; i++ ) {
                        if ( isAllowed( x, y, i ) ) {
                            a[y][x] = i;
                            if ( recurse() ) return true;
                            a[y][x] = 0;
                        }
                    }
                }
            }
        }
        return false;

    }

    private boolean isComplete() {
        for( int y=0; y< 9; y++ ) {
            for ( int x=0; x<9; x++ ) {
                if ( a[y][x] == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean isAllowed( int x, int y, int num ) {
        return !contains( getRow(x,y), num ) && !contains( getCol(x,y), num ) && ! contains( getSquare(x, y), num );
    }

    protected int [] getRow( int x, int y  ) {
        return a[y];
    }

    protected int [] getCol( int x, int y  ) {
        int [] b = new int[9];
        for ( int i=0; i < 9; i++ ) {
            b[i] = a[i][x];
        }
        return b;
    }

    protected int [] getSquare( int x, int y ) {
        int [] b = new int[9];

        int z = 0;
        int ymod = (y/3) * 3;
        int xmod = (x/3) * 3;
        for ( int i=0; i < 3; i++ ) {
            for ( int j=0; j < 3; j++ ) {
                b[z++] = a[ymod+i][xmod + j];
            }
        }
        return b;
    }


    private boolean contains( int [] list, int num ) {
        for ( int i: list ) {
            if ( i == num ) return true;
        }
        return false;
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
