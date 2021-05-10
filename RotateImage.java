public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int moveright = 0, moveUp = len - 1;

        for (int i = 0; i < len / 2; i++) {
            moveright = 0;
            for (int j = len - 1; j >= 0; j--) {
                swap(matrix, i, j, moveright, moveUp);
                moveright++;
            }
            moveUp--;
        }

        for (int i = 0; i < len; i++) {
            moveright = i;
            for (int j = i; j < len; j++) {
                swap(matrix, i, i, moveright, j);
                moveright++;
            }

        }
        moveUp = len - 1;
        for (int i = 0; i < len / 2; i++) {
            moveright = 0;
            for (int j = 0; j < len; j++) {
                if (len % 2 != 0 && j == len / 2) {
                    moveright++;
                    continue;
                }
                swap(matrix, i, j, moveright, moveUp);
                moveright++;
            }
            moveUp--;
        }
    }

    public void swap(int[][] matrix, int i, int j, int moveright, int moveDir) {
        int temp = matrix[i][moveright];
        matrix[i][moveright] = matrix[moveDir][j];
        matrix[moveDir][j] = temp;
    }

}
