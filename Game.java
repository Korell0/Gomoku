package com.codecool.fiveinarow;

public class Game implements GameInterface {

    private int[][] board;
    private int rows;
    private int cols;
    int numberOfPlayers;
    private Player[] players;

    public Game(int nRows, int nCols) {
        board = new int[nRows][nCols];
        numberOfPlayers = 2;
        players = new Player[numberOfPlayers];

        for(int index = 0; index < numberOfPlayers; index++){
            players[index] = new Player();
        }

        rows = nRows;
        cols = nCols;

    }

    /*
    public Game(int nRows, int nCols, int numberOfPlayers) {
        board = new int[nRows][nCols];
        players = new Player[numberOfPlayers];

        rows = nRows;
        cols = nCols;

    }

    */


    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getMove(int player) {
        return null;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
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
		    if(board[indexRows][indexCols] == 0)
                {System.out.print(" x ");}

            else if(board[indexRows][indexCols] == 1)
                {System.out.print(" 1 ");}

            else if(board[indexRows][indexCols] == 2)
            {System.out.print(" 2 ");}
		}
	System.out.println();
	}
    }

    public void printResult(int player) {

        int score = this.players[player].getPlayerScore();

        System.out.println("The " + player + ". player's score: " + score);
    }

    public void enableAi(int player) {
    }

    public void play(int howMany) {

        printBoard();
        printResult(0);
    }
}
