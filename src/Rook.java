public class Rook extends ChessPiece {
    public boolean check = true;

    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    @Override
    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||           //Проверка что фигура не выходит за пределы доски
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {                                 //фигура не сходила на то же место
            return false;
        }

        if (line == toLine || column == toColumn) {

            if (line == toLine) {

                int startColumn = Math.min(column, toColumn) + 1;
                int endColumn = Math.max(column, toColumn);
                for (int col = startColumn; col < endColumn; col++) {
                    if (chessBoard.board[line][col] != null) {
                        return false;
                    }
                }
            }

            if (column == toColumn) {
                int startLine = Math.min(line, toLine) + 1;
                int endLine = Math.max(line, toLine);
                for (int ln = startLine; ln < endLine; ln++) {
                    if (chessBoard.board[ln][column] != null) {
                        return false;
                    }
                }
            }
            return true;
        }


        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}