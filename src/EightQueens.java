//八皇后问题
public class EightQueens {

    static final int MAX_NUM = 8;
    int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.settleQueen(0);
        eightQueens.print();
    }

    public boolean settleQueen(int m){
        if(m == MAX_NUM){
            return true;
        }else {
            for (int n = 0; n < MAX_NUM; n++) {
                //为当前行清零，避免回溯时出现脏数据
                for (int i = 0; i < MAX_NUM; i++) {
                    chessBoard[m][i] = 0;
                }

                if(check(m,n)){
                    chessBoard[m][n] = 1;
                    if(settleQueen(m + 1)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean check(int m, int n) {
        for (int i = 0; i < m; i++) {
            //检查纵向
            if (chessBoard[i][n] == 1) {
                return false;
            }
            //检查左斜向
            if (n - 1 - i >= 0 && chessBoard[m - 1 - i][n - 1 - i] == 1) {
                return false;
            }
            //检查右斜向
            if (n + 1 + i < MAX_NUM && chessBoard[m - 1 - i][n + 1 + i] == 1) {
                return false;
            }
        }
        return true;
    }

    public void print(){
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

}
