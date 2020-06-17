import java.util.*;

public class TicTacToeMain {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


    public static void main(String[] args) {

        String[] [] gameBoard = {{" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "},
                {"---", "+", "---", "+", "---"},
                {" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "},
                {"---", "+", "---", "+", "---"},
                {" ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " "}};

        printGameBoard(gameBoard);



        while (true) {
            Scanner scan = new Scanner(System.in);

//          Human player code
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position Taken! Enter a correct Position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

//          CPU player code
            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("Position Taken! Enter a correct Position");
                cpuPos = random.nextInt(9) + 1;
            }

            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            String result = checkWinner();
            System.out.println(result);
        }

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

        String symbol = " ";

        if (user.equals("player")) {
            symbol = "X";
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = "O";
            cpuPositions.add(pos);
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
            default:
                break;
        }
    }

    public static String checkWinner() {

//        Horizontal rows
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

//        Vertical columns
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

//        Diagonals
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);


//        Here we are making a list of the lists above
        List<List> winningPositions = new ArrayList<List>();
        winningPositions.add(topRow);
        winningPositions.add(midRow);
        winningPositions.add(botRow);
        winningPositions.add(leftCol);
        winningPositions.add(midCol);
        winningPositions.add(rightCol);
        winningPositions.add(cross1);
        winningPositions.add(cross2);

//        Lists are related to collections which is why we can use containsAll(collections)
        for (List l : winningPositions) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry!! :( ";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!!";
            }
        }

        return "";
    }
}

