package utils;

public class HangedManDrawer {
    public static char[][] hangedManDrawing =
            {{' ', ' ', ' ', ' ', '_', '_', '_', '_', '_'},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|'},
                    {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', '|'},
                    {' ', ' ', '/', '|', (char) 92, ' ', ' ', ' ', '|'},
                    {' ', ' ', '/', ' ', (char) 92, ' ', ' ', ' ', '|'},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'_', '_', '_', '_', '_', '_', '_', '_', '|'}};

    public static int[][] hangedManDrawingMatrix =
            {{7, 7, 7, 7, 4, 4, 4, 4, 4},
                    {7, 7, 7, 3, 7, 7, 7, 7, 5},
                    {7, 7, 7, 2, 7, 7, 7, 7, 5},
                    {7, 7, 1, 1, 1, 7, 7, 7, 5},
                    {7, 7, 0, 7, 0, 7, 7, 7, 5},
                    {7, 7, 7, 7, 7, 7, 7, 7, 5},
                    {6, 6, 6, 6, 6, 6, 6, 6, 5}};

    public static void printHangedMan(int livesLeft) {
        for (int i = 0; i < hangedManDrawing.length; i++) {
            int[] matrixRow = hangedManDrawingMatrix[i];
            for (int j = 0; j < matrixRow.length; j++) {
                if (hangedManDrawingMatrix[i][j] >= livesLeft) {
                    System.out.print(hangedManDrawing[i][j]);
                } else System.out.print(' ');
            }
            System.out.println();
        }
    }
}
