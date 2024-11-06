public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn) && checkPos(endLine) && checkPos(endColumn)) {
            ChessPiece piece = board[startLine][startColumn];
            ChessPiece targetPiece = board[endLine][endColumn];

            if (piece == null || !piece.getColor().equals(nowPlayer)) {
                return false;
            }

            if (piece.canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                if (targetPiece == null || !targetPiece.getColor().equals(nowPlayer)) {
                    board[endLine][endColumn] = piece;
                    board[startLine][startColumn] = null;
                    this.nowPlayer = this.nowPlayer.equals("White") ? "Black" : "White";
                    return true;
                }
            }
        }
        return false;
    }

    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    public boolean castling0() {
        int kingLine = nowPlayer.equals("White") ? 0 : 7;
        int kingColumn = 4;
        int rookColumn = 0;

        King king = (King) board[kingLine][kingColumn];
        Rook rook = (Rook) board[kingLine][rookColumn];

        if (king != null && rook != null && king.check && rook.check) {

            if (board[kingLine][1] == null && board[kingLine][2] == null && board[kingLine][3] == null) {

                if (!isUnderAttack(kingLine, kingColumn) && !isUnderAttack(kingLine, 2)) {

                    board[kingLine][2] = king;
                    board[kingLine][rookColumn] = null;
                    board[kingLine][3] = rook;
                    board[kingLine][kingColumn] = null;
                    king.check = false;
                    rook.check = false;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean castling7() {
        int kingLine = nowPlayer.equals("White") ? 0 : 7;
        int kingColumn = 4;
        int rookColumn = 7;
        King king = (King) board[kingLine][kingColumn];
        Rook rook = (Rook) board[kingLine][rookColumn];

        if (king != null && rook != null && king.check && rook.check) {

            if (board[kingLine][5] == null && board[kingLine][6] == null) {

                if (!isUnderAttack(kingLine, kingColumn) && !isUnderAttack(kingLine, 6)) {

                    board[kingLine][6] = king;
                    board[kingLine][rookColumn] = null;
                    board[kingLine][5] = rook;
                    board[kingLine][kingColumn] = null;
                    king.check = false;
                    rook.check = false;
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isUnderAttack(int line, int column) {


        return false; // По умолчанию возвращаем false
    }
}