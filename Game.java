package com.codecool.fiveinarow;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        int[] playerMove = new int[3];

        playerMove[0] = player;

        char[] coordinates = {'X', 'Y'};

        for(int index = 0; index < coordinates.length; index++) {

            System.out.println("Player " + player  + ": " + "give us the " + coordinates[index]+ " coordinate:  ");

            int xCoordinate = scanner.nextInt();
            xCoordinate -= 1;

            playerMove[index + 1] = xCoordinate;
        }

        return playerMove;
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

        int score = this.players[player].getPlayerScore();

        System.out.println("The " + player + ". player's score: " + score);
    }

    public void enableAi(int player) {
    }

    public boolean spotTaken(int xCoord, int yCoord){

        return board[xCoord][yCoord] == 0;

    }

    public void play(int howMany) {

        boolean gameOver = false;


        while(!gameOver) {
            int[] playerMove = new int[3];
                for (int player = 0; player < players.length; player++) {
                printBoard();

                do{

                    playerMove  = getMove(player + 1);

                    if(!spotTaken(playerMove[1], playerMove[2])){
                        System.out.println("That spot is already taken, chose another one!");
                        System.out.println();
                    }
                }

                while(!spotTaken(playerMove[1], playerMove[2]));


                    mark(playerMove[0], playerMove[1], playerMove[2]);
                    gameOver = hasWon(player, 5);




            }
        }}

}