import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] table = new char[3][3];
        int player = 1;
        do {
            printTable(table);
            step(player, table);
            player = player == 1 ? 2 : 1;
            System.out.println(whoWin(table));
        } while (whoWin(table) == '-' && havePlace(table));
        System.out.println("asd");;
    }

    public static void printTable(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void step(int player, char[][] table) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        do {
            row = scanner.nextInt();
            column = scanner.nextInt();
        } while (!isValidPlace(row, column, table));
        table[row][column] = player == 1 ? 'o' : 'x';
    }

    private static boolean isValidPlace(int row, int column, char[][] table) {
        if(row < 0 || row > 2 || column < 0 || column > 2){
            return false;
        }
        return table[row][column] != 'o' || table[row][column] != 'x';
    }

    public static boolean havePlace(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (isValidPlace(i, j, table)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char whoWin(char[][] table) {
        for (int i = 0; i < 3; i++) {
            if (table[i][0] != 0 && table[i][0] == table[i][1] && table[i][1] == table[i][2]) {
                return table[i][1];
            }
            if (table[0][i] != 0 &&table[0][i] == table[1][i] && table[1][i] == table[2][i]) {
                return table[1][i];
            }
        }
        if (table[1][1] != 0 &&table[1][1] == table[2][2] && table[1][1] == table[0][0]) {
            return table[2][2];
        }
        if (table[1][1] != 0 &&table[0][2] == table[1][1] && table[0][2] == table[2][0]) {
            return table[1][1];
        }
        return '-';
    }
}