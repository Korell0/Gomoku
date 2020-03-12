package com.codecool.fiveinarow;
import java.util.Scanner;

public class Game implements GameInterface {

    private int[][] board;
    private int rows;
    private int cols;

    public Game(int nRows, int nCols) {
	board = new int [nRows][nCols];
	rows = nRows;
	cols = nCols;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getMove(int player) {
       int[] rightdata = new int[3];
       rightdata[0] = player;
        if ( player == 1 ){
            System.out.println("Player 1 give us the X coordinate: ");
            Scanner xmove = new Scanner(System.in);
            int Xnextmove = xmove.nextInt()-1;
            rightdata[1] = Xnextmove;
            System.out.println("Player 1 give us the Y coordinate: ");
            Scanner ymove = new Scanner(System.in);
            int Ynextmove = ymove.nextInt()-1;
            rightdata[2] = Ynextmove;
            }
        else if ( player == 2 ){
            Scanner xmove = new Scanner(System.in);
            System.out.println("Player 2 give us the X coordinate: ");
            int Xnextmove = xmove.nextInt()-1;
            rightdata[1] = Xnextmove;
            Scanner ymove = new Scanner(System.in);
            System.out.println("Player 2 give us the Y coordinate: ");
            int Ynextmove = ymove.nextInt()-1;
            rightdata[2] = Ynextmove;
        }
        return rightdata;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
        board[row][col] = player;
    }

    public boolean hasWon(int player, int howMany) {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void printBoard() {
 	for (int indexRows = 0 ; indexRows < rows ; indexRows++ ){
		for (int indexCols = 0 ; indexCols < cols ; indexCols++ ){
			if ( board[indexRows][indexCols] == 0 ) {
                System.out.print(" . ");
            } else if ( board[indexRows][indexCols] == 1){
                System.out.print(" X ");
            } else if ( board[indexRows][indexCols] == 2){
                System.out.print(" O ");
            }
		}
	System.out.println();
	}
    }

    public void printResult(int player) {
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {
        int player = 1;
        while (!hasWon(player, howMany)){
            printBoard();
            int[] move = getMove(player);
            mark(move[0],move[1],move[2]);
            if (player == 1){
                player = 2;
            }
            else if (player == 2){
                player = player -1;
            }
        }
    }
}
