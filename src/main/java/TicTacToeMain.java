import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {

        String[] [] gameBoard = {{" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "},
                {"---", "+", "---", "+", "---"},
                {" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "},
                {"---", "+", "---", "+", "---"},
                {" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "}};

        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int pos = scan.nextInt();

        System.out.println(pos);

        printGameBoard(gameBoard);

    }
    public static void printGameBoard(String[] [] gameBoard)  {
        for (String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePiece(String[] [] gameBoard, int pos, String user) {

        String symbol = "X";

        if (user.equals("player")) {
            symbol = "X";
        } else if (user.equals("cpu")) {
            symbol = "O";
        }


        switch(pos) {
            case 1:
                gameBoard[0] [1] = symbol;
                break;
            case 2:
                gameBoard[0] [5] = symbol;
                break;
            case 3:
                gameBoard[0] [9] = symbol;
                break;
            case 4:
                gameBoard[2] [1] = symbol;
                break;
            case 5:
                gameBoard[2] [5] = symbol;
                break;
            case 6:
                gameBoard[2] [9] = symbol;
                break;
            case 7:
                gameBoard[4] [1] = symbol;
                break;
            case 8:
                gameBoard[4] [5] = symbol;
                break;
            case 9:
                gameBoard[4] [9] = symbol;
                break;
        }
    }
}

//{' ', '|', ' ', '|', ' '},
//        {'-', '+', '-', '+', '-'},
//        {' ', '|', ' ', '|', ' '}};
