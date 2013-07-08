Sudoku
======

Sudoku is a numbers game, consisting of a 9 x 9 grid.  Given a "starting" grid you must fill the frid with numbers between 1 and 9, observing the following rules:

* Each row (left to right) can contain the numbers 1-9 only once
* Each column (top to bottom) can contain the numbers 1-9 only once
* Each 3 x 3 square can contain the numbers 1-9 only once

Example starting grid:

    . 1 .   3 . 4   5 . .
    5 . 7   . 1 .   4 . .
    . 4 .   . 7 .   . 1 9

    4 . .   7 . 2   . . 8
    . 3 8   . . .   2 9 .
    2 . .   6 . 8   . . 7

    9 8 .   . 2 .   . 6 .
    . . 4   . 8 .   9 . 5
    . . 3   9 . 6   . 2 .

When correctly completed it should look like:

    8 1 9   3 6 4   5 7 2
    5 6 7   2 1 9   4 8 3
    3 4 2   8 7 5   6 1 9

    4 9 6   7 3 2   1 5 8
    7 3 8   5 4 1   2 9 6
    2 5 1   6 9 8   3 4 7

    9 8 5   4 2 3   7 6 1
    6 2 4   1 8 7   9 3 5
    1 7 3   9 5 6   8 2 4

This coding kata is about writing an algorithm to solve Sudoku puzzles.

Tips
----
* Use test driven development
* Get something working, then refine your solution
* If coded correctly, the algorithm will find a solution in about a second!


My solution
-----------

I used a brute force approach where I try every number in the blank cell, until one of the following occurs:
1) The row column and square are valid.  I then move onto the next blank cell.
2) I try all the numbers 1-9 and find none of them valid.  At this point I "back track", knowing that at some point, one of my earlier guesses must have been incorrect.

I iterate over the 9x9 square, until I stumble upon the correct solution.

What was difficult?
-------------------
I got the algortihm fairly quickly, but it was really slow!  The key break through was obvious:
* Once I've identified a cell which could not be filled with any number, then this is the signal to back track.


What do I like about my solution?
---------------------------------
One thing I think is particularly elegant in my solution is the use of self recursion to effect the back tracking.  I effectively build up a call stack of guesses, which makes back tracking as simple as returning false:

        public boolean recurse() {
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
                        return false;
                    }
                }
            }
            return true;
        }

I also think its quite neat the way that I've represented the sudoku grids in the unit tests.  It makes the tests fairly life like and adds to the readability.

Building
--------


    git checkout https://github.com/coder36/sudoku.git
    cd sudoku
    mvn clean install

