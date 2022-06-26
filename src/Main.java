package tictactoe;
import java.util.Scanner;


public class Main {

    public static int checkNumberXO(char[] chArray) {
        int n_x = 0, n_o = 0;
        int i = 0;
        while (i < 9) {
            if (chArray[i] == 'X') {
                n_x++;
            } else if (chArray[i] == 'O') {
                n_o++;
            }
            i++;
        }
        if (n_x != n_o && (n_x + n_o) != 9) {
            return (1);
        }
        return (checkWin(chArray));
    }

    public static int position(char one, char two, char three) {
        if (one == two && two == three) {
            return (1);
        }
        return (0);
    }

    public static int checkWin(char[] chArray) {
        int i = 0;
        char ch = 0;

        i += position(chArray[0], chArray[1], chArray[2]);
        if (i > 0) {
            ch = chArray[0];
        }
        i += position(chArray[3], chArray[4], chArray[5]);
        if (i > 0) {
            ch = chArray[3];
        }
        i += position(chArray[6], chArray[7], chArray[8]);
        if (i > 0) {
            ch = chArray[6];
        }

        i += position(chArray[0], chArray[3], chArray[6]);
        if (i > 0) {
            ch = chArray[0];
        }
        i += position(chArray[1], chArray[4], chArray[7]);
        if (i > 0) {
            ch = chArray[1];
        }
        i += position(chArray[2], chArray[5], chArray[8]);
        if (i > 0) {
            ch = chArray[2];
        }

        i += position(chArray[0], chArray[4], chArray[8]);
        if (i > 0) {
            ch = chArray[0];
        }
        i += position(chArray[2], chArray[4], chArray[6]);
        if (i > 0) {
            ch = chArray[2];
        }

        if (i > 1) {
            return (5);
        } else if (i == 0) {
            int count = 0;
            for (int j = 0; j < 9; j++) {
                if (chArray[j] == 'X' ||  chArray[j] == 'O') {
                    count++;
                }
            }
            if (count < 9) {
                return (0);
            }
            return (2);
        } else if (ch == 'X') {
            return (3);
        }  else if (ch == 'O') {
            return (4);
        }
        return (6);
    }

    public static void analysisGame(char[] chArray) {
        int flag = checkNumberXO(chArray);
        if (flag == 0) {
            System.out.println("Game not finished");
        } else if (flag == 1) {
            System.out.println("Impossible");
        } else if (flag == 2) {
            System.out.println("Draw");
        } else if (flag == 3) {
            System.out.println("X wins");
        } else if (flag == 4) {
            System.out.println("O wins");
        } else {
            System.out.println("Impossible");
        }
    }

    public static void printMap(char[] chArray) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", chArray[0], chArray[1], chArray[2]);
        System.out.printf("| %c %c %c |%n", chArray[3], chArray[4], chArray[5]);
        System.out.printf("| %c %c %c |%n", chArray[6], chArray[7], chArray[8]);
        System.out.println("---------");
    }

    public static void checkSpaceForStep(int first, int second, char[] chArray) {
        System.out.println(first);
        System.out.println(second);
        if (chArray[first * 3 - 4 + second] == 'X' || chArray[first * 3 - 4 + second] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            getCoords(chArray);
            return;
        } else {
            chArray[first * 3 - 4 + second] = 'X';
            printMap(chArray);
        }
    }

    public static void getCoords(char[] chArray) {
        Scanner scanner = new Scanner(System.in);
        int firstCoord = 0;
        int secondCoord = 0;

        System.out.print("Enter the coordinates: ");

        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                firstCoord = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    secondCoord = scanner.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    getCoords(chArray);
                    return;
                }
            } else {
                System.out.println("You should enter numbers!");
                getCoords(chArray);
                return;
            }
        }
        if (firstCoord > 3 || secondCoord > 3 || firstCoord < 1 || secondCoord < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            getCoords(chArray);
            return;
        } else {
            checkSpaceForStep(firstCoord, secondCoord, chArray);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String str = scanner.nextLine();
        char[] chArray = str.toCharArray();
        printMap(chArray);
        getCoords(chArray);
//        analysisGame(chArray);
    }
}