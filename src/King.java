public class King extends ChessPiece{
    public boolean check = true;

    public King(String color) {
        super(color);
    }
    public String getColor(){
        return color;
    }
    @Override
    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||           //Проверка что фигура не выходит за пределы доски
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {                                 //Фигура не сходила на то же место
            return false;
        }

        return (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece.canMoveToPosition(board,i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


