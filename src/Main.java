package tictactoe;
import java.util.Scanner;


public class Main {

    public static int position(char one, char two, char three) {
        if (one == two && two == three) {
            return (1);
        }
        return (0);
    }

    public static int checkWin(char[] chArray) {
        char ch = 0;

        if (chArray[0] != ' ' && position(chArray[0], chArray[1], chArray[2]) > 0) {
            ch = chArray[0];
        } else if (chArray[3] != ' ' && position(chArray[3], chArray[4], chArray[5]) > 0) {
            ch = chArray[3];
        } else if (chArray[6] != ' ' && position(chArray[6], chArray[7], chArray[8]) > 0) {
            ch = chArray[6];
        } else if (chArray[0] != ' ' && position(chArray[0], chArray[3], chArray[6]) > 0) {
            ch = chArray[0];
        } else if (chArray[1] != ' ' && position(chArray[1], chArray[4], chArray[7]) > 0) {
            ch = chArray[1];
        } else if (chArray[2] != ' ' && position(chArray[2], chArray[5], chArray[8]) > 0) {
            ch = chArray[2];
        } else if (chArray[0] != ' ' && position(chArray[0], chArray[4], chArray[8]) > 0) {
            ch = chArray[0];
        } else if (chArray[2] != ' ' && position(chArray[2], chArray[4], chArray[6]) > 0) {
            ch = chArray[2];
        }

        if (ch == 'X') {
            return (1);
        } else if (ch == 'O') {
            return (2);
        }
        return (3);
    }

    public static int analysisGame(char[] chArray) {
        int flag = checkWin(chArray);
        if (flag == 3) {
            return 0;
        } else if (flag == 1) {
            System.out.println("X wins");
            return 1;
        } else if (flag == 2) {
            System.out.println("O wins");
            return 1;
        }
        return 0;
    }

    public static void printMap(char[] chArray) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", chArray[0], chArray[1], chArray[2]);
        System.out.printf("| %c %c %c |%n", chArray[3], chArray[4], chArray[5]);
        System.out.printf("| %c %c %c |%n", chArray[6], chArray[7], chArray[8]);
        System.out.println("---------");
    }

    public static void checkSpaceForStep(int first, int second, char[] chArray, char ch) {
        System.out.println(first);
        System.out.println(second);
        if (chArray[first * 3 - 4 + second] == 'X' || chArray[first * 3 - 4 + second] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            getCoords(chArray, ch);
            return;
        } else {
            chArray[first * 3 - 4 + second] = ch;
            printMap(chArray);
        }
    }

    public static void getCoords(char[] chArray, char ch) {
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
                    getCoords(chArray, ch);
                    return;
                }
            } else {
                System.out.println("You should enter numbers!");
                getCoords(chArray, ch);
                return;
            }
        }
        if (firstCoord > 3 || secondCoord > 3 || firstCoord < 1 || secondCoord < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            getCoords(chArray, ch);
            return;
        } else {
            checkSpaceForStep(firstCoord, secondCoord, chArray, ch);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chArray = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        printMap(chArray);
        int step = 0;
        char ch = 'X';
        while (analysisGame(chArray) != 1) {
            getCoords(chArray, ch);
            if (step == 0) {
                ch = 'O';
                step = 1;
            } else {
                ch = 'X';
                step = 0;
            }
        }
    }
}