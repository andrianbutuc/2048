package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Game2048Test {

    @Test
    void updateScore() {
        Game2048 g = new Game2048();
        g.updateScore(4);
        assertEquals(g.getScore(),4);
    }

    @Test
    void updateScoreNegative() {
        Game2048 g = new Game2048();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> g.updateScore(-4));
    }


    @Test
    void getScore() {
        Game g = new Game2048();
        assertEquals(0,g.getScore());
    }

    @Test
    void movePlusScore() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        gametable[3][0].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,0);
        g.move(Direction.DOWN);
        int newScore  = 4 ;
        assertEquals(newScore,g.getScore());
    }

    @Test
    void moveScoreUnchanged() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        gametable[3][0].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        g.move(Direction.LEFT);
        int newScore  = 4 ;
        assertEquals(newScore,g.getScore());

    }
    @Test
    void moveDirectionNull(){
        Game g = new Game2048();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> g.move(null));
    }

    @Test
    void haveCaseToMerge() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game2048 g = new Game2048(b,4);
        assertTrue(g.haveCaseToMerge());
    }
    @Test
    void haveCaseToMerge2() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        gametable[0][1].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game2048 g = new Game2048(b,4);
        assertTrue(g.haveCaseToMerge());
    }
    @Test
    void haveCaseToMergeFalse() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        gametable[0][2].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game2048 g = new Game2048(b,4);
        assertFalse(g.haveCaseToMerge());
    }

    @Test
    void isLostTrue() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
                gametable[line][column].setValue(line+column+1);
            }
        }
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        assertTrue(g.isLost());
    }

    @Test
    void isLostFalse() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(4);
        gametable[0][1].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        assertFalse(g.isLost());
    }
    @Test
    void isLostFalse2() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
                gametable[line][column].setValue(line+column+1);
            }
        }
        gametable[0][0].setValue(2);
        gametable[0][1].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        assertFalse(g.isLost());
    }
    @Test
    void isWin() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[0][0].setValue(2);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        assertFalse(g.isWon());
    }
    @Test
    void isWin2() {
        Case[][] gametable = new Case[4][4];
        Case[][] initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
        gametable[3][3].setValue(2048);
        Board b = new Board(gametable,initialHistory);
        Game g = new Game2048(b,4);
        assertTrue(g.isWon());
    }
}