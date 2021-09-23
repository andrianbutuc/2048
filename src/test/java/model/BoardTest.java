package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Case[][] gametable ;
    private Case[][] result ;
    private Case[][] initialHistory ;
    @BeforeEach
    public void setUp() {
        gametable = new Case[4][4];
        result = new Case[4][4];
        initialHistory = new Case[4][4];
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {
                gametable[line][column] = new Case(line,column);
                result[line][column] = new Case(line,column);
                initialHistory[line][column] = new Case(line,column);
            }
        }
    }
    static boolean gameTableEquals(Case[][] g1,Case[][] g2){
        for (int line = 0; line < g1.length; line++) {
            for (int column = 0; column < g1[line].length; column++) {
                if(g1[line][column].getValue() != g2[line][column].getValue()){
                    return false ;
                }
            }
        }
        return true ;
    }
    @Test
    void copyBoard() {
        Board b = new Board(gametable,initialHistory);
        Board copyB = new Board(b);
        assertTrue(BoardTest.gameTableEquals(b.getGameTable(),copyB.getGameTable()));

    }

    @Test
    void copyBoardNull() {
        Board b = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Board(b));
    }

    @Test
    void move1() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        b.move(Direction.DOWN);
        result[3][0].setValue(2);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }

    @Test
    void move2() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.DOWN);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move3() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(4);
        b.move(Direction.DOWN);
        result[2][0].setValue(4);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move4() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(8);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(4);
        result[1][0].setValue(8);
        result[2][0].setValue(4);
        result[3][0].setValue(4);
        b.move(Direction.DOWN);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move5() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.DOWN);
        result[1][0].setValue(4);
        result[2][0].setValue(4);
        result[3][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move6() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.RIGHT);
        result[0][3].setValue(2);
        result[1][3].setValue(2);
        result[2][3].setValue(4);
        result[3][3].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move7() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.TOP);
        result[0][0].setValue(4);
        result[1][0].setValue(4);
        result[2][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move8() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.RIGHT);
        result[0][3].setValue(4);
        result[1][3].setValue(2);
        result[2][3].setValue(4);
        result[3][3].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move9() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        gametable[3][1].setValue(8);
        gametable[3][2].setValue(4);
        gametable[3][3].setValue(4);
        b.move(Direction.LEFT);
        result[0][0].setValue(4);
        result[1][0].setValue(2);
        result[2][0].setValue(4);
        result[3][0].setValue(16);
        result[3][1].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move10() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.LEFT);
        result[0][0].setValue(2);
        result[1][0].setValue(2);
        result[2][0].setValue(4);
        result[3][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move11() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.TOP);
        result[0][0].setValue(4);
        result[1][0].setValue(4);
        result[2][0].setValue(2);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move12() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        b.move(Direction.TOP);
        result[0][0].setValue(4);
        result[1][0].setValue(2);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move13() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.DOWN);
        result[1][0].setValue(4);
        result[2][0].setValue(2);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move14() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.TOP);
        result[0][0].setValue(4);
        result[1][0].setValue(4);
        result[2][0].setValue(2);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move15() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(0);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.DOWN);
        result[2][0].setValue(2);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move16() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(2);
        b.move(Direction.DOWN);
        result[2][0].setValue(4);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move17() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[3][0].setValue(4);
        b.move(Direction.DOWN);
        result[2][0].setValue(2);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move18() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(2);
        gametable[2][0].setValue(2);
        gametable[3][0].setValue(4);
        b.move(Direction.DOWN);
        result[1][0].setValue(2);
        result[2][0].setValue(4);
        result[3][0].setValue(4);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move19() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(0);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.DOWN);
        result[1][0].setValue(2);
        result[2][0].setValue(4);
        result[3][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move20() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(2);
        gametable[1][0].setValue(4);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.DOWN);
        result[1][0].setValue(2);
        result[2][0].setValue(8);
        result[3][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void move21() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(4);
        gametable[1][0].setValue(4);
        gametable[2][0].setValue(4);
        gametable[3][0].setValue(8);
        b.move(Direction.DOWN);
        result[1][0].setValue(4);
        result[2][0].setValue(8);
        result[3][0].setValue(8);
        assertTrue(BoardTest.gameTableEquals(gametable,result));
    }
    @Test
    void moveDirectionNull() {
        Board b = new Board();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> b.move(null));

    }
//
    @Test
    void initializeRandomCase() {
        Board b = new Board(gametable,initialHistory);
        b.initializeRandomCase();
        assertFalse(BoardTest.gameTableEquals(gametable,result));
    }

    @Test
    void isFullFalse() {
        Board b = new Board();
        boolean result = b.isFull(b.getGameTable());
        assertFalse(result);
    }

    @Test
    void isFullTrue() {
        Board b = new Board();
        for (int i = 0; i < 15; i++) {
            b.initializeRandomCase();
        }
        boolean result = b.isFull(b.getGameTable());
        assertTrue(result);
    }

    @Test
    void getGameTable() {
        Board b = new Board(gametable,initialHistory);
        gametable[0][0].setValue(8);
        Case[][] tableb = b.getGameTable();
        assertTrue(BoardTest.gameTableEquals(tableb,gametable));
    }

    @Test
    void compareBoardTestFalse(){
        gametable[3][3].setValue(4);
        Board b = new Board(gametable,initialHistory);
        assertFalse(b.compareBoard());
    }
    @Test
    void compareBoardTestTrue(){
        Board b = new Board(gametable,initialHistory);
        assertTrue(b.compareBoard());
    }
    @Test
    void containsWinnerValueTrue(){
        gametable[3][3].setValue(2048);
        Board b = new Board(gametable,initialHistory);
        assertTrue(b.containsWinnerValue(b.getGameTable()));
    }
    @Test
    void containsWinnerValueFalse(){
        Board b = new Board(gametable,initialHistory);
        assertFalse(b.containsWinnerValue(b.getGameTable()));
    }
}