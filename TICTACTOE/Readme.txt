
1)How to Execute Program?

Type  "javac TicTacToe.java" in Terminal 
Now TicTacToe.class is created means Program is successfully Compiled
Type "java TicTacToe" To Run a Program

2)How to Play This Game?

First You are asked Which version you are willing to play.
Press 1 to play Player vs Player Match.
Press 2 to play Player vs Computer Match.

Then Game Board Will be shown to you, For making move each player have to choose a number from 1 to 9.
Corresponding Spots          1 2 3           
                             4 5 6
                             7 8 9
Game will End If Either any player wins or Game ends in Tie.

3)Rule Of The Game.

The player who succeeds in placing three respective marks in a horizontal, vertical, or diagonal row wins the
game.
If There is no empty spot left on board Then Game ends in tie.

4)Total Methods You create.

a)public static void playerTurn(char[][] board, Scanner scanner, int p1_p2)
b)public static void computerTurn(char[][] board, Scanner scanner, int p1_p2)
c)public static int CanCpuWin(char[][] board)
d)public static int canPlayerWin(char[][] board)
e)public static boolean hasContestantWon(char[][] board, char move)
f)public static void printBoard(char[][] board)
g)public static boolean isValidMove(char[][] board, String position)
h)public static void placeMove(char[][] board, String position, char makeMove)
i)public static boolean isGameFinished(char[][] board)
j)public static void main(String args[])

5)How CPU make its Move in Player vs Computer Match?

CPU make its move after checking 2 conditions
a)Is there any spot Where if CPU moves and it wins after making that move.
To implement This I check all the empty spots If there is any spot where cpu can win. CPU will play accordingly And wins
To check I Place Computer's Symbol  In board's each emptyspot one by one and Call The funtion hasContestantWon? I 
Make dummy board in which i place move and check it this spot is not winning spot then Make that spot empty as it was earlier.
b)Is there any spot Where Player can win in next move.
To implement this I use similar approach as used above. Just Place Player's symbol one by one to each spot and checks.
If both the above conditions turns False Then CPU will Choose Random Empty Spot.
