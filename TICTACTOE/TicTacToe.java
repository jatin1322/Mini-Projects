import java.util.*;

//Class to make player's turn, computer's turn, after playing checking has contestant won?
class Player {

    static String Name1;
    static String Name2;

    // Method To make move of user
    public static void playerTurn(char[][] board, Scanner scanner, int p1_p2) {
        String inputOfUser;
        if (p1_p2 == 1) {
            System.out.println(Player.Name1 + "'s turn ");
        } else {
            System.out.println(Player.Name2 + "'s turn ");
        }
        while (true) {

            System.out.println("Enter Your Desired Location (1-9):");
            inputOfUser = scanner.nextLine();
            if (Board.isValidMove(board, inputOfUser)) {
                break;
            } else {
                System.out.println(inputOfUser + " is not a valid move.");
            }
        }
        if (p1_p2 == 1) {
            Board.placeMove(board, inputOfUser, 'X');
        } else {
            Board.placeMove(board, inputOfUser, 'O');
        }

    }

    // Method to make move of cpu
    public static void computerTurn(char[][] board, Scanner scanner, int p1_p2) {
        System.out.println("Computer" + "'s turn ");
        int cpu = CanCpuWin(board);
        if (cpu != -1) {
            System.out.println("Computer chose " + Integer.toString(cpu));
            Board.placeMove(board, Integer.toString(cpu), 'O');
        } else {
            int player = canPlayerWin(board);
            if (player != -1) {
                System.out.println("Computer chose " + Integer.toString(player));
                Board.placeMove(board, Integer.toString(player), 'O');
            } else {
                Random rand = new Random();
                int computerMove;
                while (true) {
                    computerMove = rand.nextInt(9) + 1;
                    if (Board.isValidMove(board, Integer.toString(computerMove))) {
                        break;
                    }
                }
                System.out.println("Computer chose " + computerMove);
                Board.placeMove(board, Integer.toString(computerMove), 'O');
            }
        }

    }

    // Checking Is there any position where CPU can win
    public static int CanCpuWin(char[][] board) {
        char[][] dummy_board = board;

        for (int i = 1; i <= 9; i++) {
            if (Board.isValidMove(dummy_board, Integer.toString(i))) {
                Board.placeMove(dummy_board, Integer.toString(i), 'O');
                if (hasContestantWon(dummy_board, 'O')) {

                    return i;
                } else {
                    Board.placeMove(dummy_board, Integer.toString(i), '.');
                }
            }
        }
        return -1;
    }

    // Checking Is there any position where Player can win in her next move
    public static int canPlayerWin(char[][] board) {
        char[][] dummy_board = board;

        for (int i = 1; i <= 9; i++) {
            if (Board.isValidMove(dummy_board, Integer.toString(i))) {
                Board.placeMove(dummy_board, Integer.toString(i), 'X');
                if (hasContestantWon(dummy_board, 'X')) {

                    return i;
                } else {
                    Board.placeMove(dummy_board, Integer.toString(i), '.');
                }
            }
        }
        return -1;
    }

    // Checking Has Contestant Won?
    public static boolean hasContestantWon(char[][] board, char move) {
        if ((board[0][0] == move && board[0][1] == move && board[0][2] == move) ||
                (board[1][0] == move && board[1][1] == move && board[1][2] == move) ||
                (board[2][0] == move && board[2][1] == move && board[2][2] == move) ||

                (board[0][0] == move && board[1][0] == move && board[2][0] == move) ||
                (board[0][1] == move && board[1][1] == move && board[2][1] == move) ||
                (board[0][2] == move && board[1][2] == move && board[2][2] == move) ||

                (board[0][0] == move && board[1][1] == move && board[2][2] == move) ||
                (board[0][2] == move && board[1][1] == move && board[2][0] == move)) {
            return true;
        }
        return false;
    }

}

// class to handle all Board Activity
class Board {
    // Printing Board
    public static void printBoard(char[][] board) {
        System.out.println("");
        System.out.println("     " + board[0][0] + " " + board[0][1] + " " + board[0][2] + "                1 2 3");

        System.out.println("     " + board[1][0] + " " + board[1][1] + " " + board[1][2] + "                4 5 6");

        System.out.println("     " + board[2][0] + " " + board[2][1] + " " + board[2][2] + "                7 8 9");
        System.out.println("");
    }

    // Checking Before placing move Is the spot empty?
    public static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == '.');
            case "2":
                return (board[0][1] == '.');
            case "3":
                return (board[0][2] == '.');
            case "4":
                return (board[1][0] == '.');
            case "5":
                return (board[1][1] == '.');
            case "6":
                return (board[1][2] == '.');
            case "7":
                return (board[2][0] == '.');
            case "8":
                return (board[2][1] == '.');
            case "9":
                return (board[2][2] == '.');
            default:
                return false;
        }
    }

    // Method To place Move after Checking
    public static void placeMove(char[][] board, String position, char makeMove) {
        switch (position) {
            case "1":
                board[0][0] = makeMove;
                break;
            case "2":
                board[0][1] = makeMove;
                break;
            case "3":
                board[0][2] = makeMove;
                break;
            case "4":
                board[1][0] = makeMove;
                break;
            case "5":
                board[1][1] = makeMove;
                break;
            case "6":
                board[1][2] = makeMove;
                break;
            case "7":
                board[2][0] = makeMove;
                break;
            case "8":
                board[2][1] = makeMove;
                break;
            case "9":
                board[2][2] = makeMove;
                break;
            default:
                System.out.println(":(");
        }
    }

    // To Check Whether Game Finished, As in rules Provided Game finishes if either
    // player wins or Game Draws After filling whole Board
    public static boolean isGameFinished(char[][] board) {

        if (Player.hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.print(Player.Name1 + " wins!  ");
            System.out.println(Player.Name2 + " loses!");
            return true;
        }

        if (Player.hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.print(Player.Name1 + " loses!  ");
            System.out.println(Player.Name2 + " Wins!  ");

            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

}

class TicTacToe {
    public static void main(String args[]) {
        System.out.println("Welcome To The Game Tic-Tac-Toe");
        System.out.println("Press 1 for Player Vs Player Match");
        System.out.println("Press 2 for Player Vs Computer Match");

        Scanner sc = new Scanner(System.in);
        int Choice = sc.nextInt();
        if (Choice == 1) {
            System.out.println("Enter Name of Player 1");
            Scanner pl1 = new Scanner(System.in);
            String P1 = pl1.nextLine();

            System.out.println("Enter Name of Player 2");
            Scanner pl2 = new Scanner(System.in);
            String P2 = pl2.nextLine();

            Player.Name1 = P1;
            Player.Name2 = P2;

            char[][] board = { { '.', '.', '.' },
                    { '.', '.', '.' },
                    { '.', '.', '.' } };
            System.out.println("     Game Board           Corresponding spots ");
            Board.printBoard(board);
            System.out.println(". represents Empty space             ");

            System.out.println(Player.Name1 + ": X         " + Player.Name2 + ": O");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                Player.playerTurn(board, scanner, 1);
                if (Board.isGameFinished(board)) {
                    break;
                }
                Board.printBoard(board);

                Player.playerTurn(board, scanner, 0);
                if (Board.isGameFinished(board)) {
                    break;
                }
                Board.printBoard(board);
            }
            pl1.close();
            pl2.close();
        } else if (Choice == 2) {
            
            System.out.println("Enter Your Name");
            Scanner pl1 = new Scanner(System.in);
            String P1 = pl1.nextLine();

            Player.Name1 = P1;
            Player.Name2 = "Computer";

            char[][] board = { { '.', '.', '.' },
                    { '.', '.', '.' },
                    { '.', '.', '.' } };
            System.out.println("     Game Board           Corresponding spots ");
            Board.printBoard(board);
            System.out.println(". represents Empty space             ");

            System.out.println(Player.Name1 + ": X         " + "Computer" + ": O");
            Scanner scanner = new Scanner(System.in);
            Player.playerTurn(board, scanner, 1);
            Board.printBoard(board);

            System.out.println("Computer" + "'s turn ");
            int pos = -1;

            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    count++;
                    if (board[i][j] == 'X') {
                        pos = count;
                    }
                }
            }
            if (pos == 5) {
                System.out.println("Computer chose " + 3);
                Board.placeMove(board, "3", 'O');

            } else {
                System.out.println("Computer chose " + 5);
                Board.placeMove(board, "5", 'O');
            }
            Board.printBoard(board);
            while (true) {
                Player.playerTurn(board, scanner, 1);
                if (Board.isGameFinished(board)) {
                    break;
                }
                Board.printBoard(board);

                Player.computerTurn(board, scanner, 2);
                if (Board.isGameFinished(board)) {
                    break;
                }
                Board.printBoard(board);
            }
            pl1.close();
        }
        sc.close();
    }

}