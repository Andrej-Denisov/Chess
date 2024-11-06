public class Queen extends ChessPiece{

    public Queen(String color) {
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

        if (line == toLine && column == toColumn) {                                 //фигура не сходила на то же место
            return false;
        }

        if (line == toLine || column == toColumn || Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            int stepLine = (toLine - line) != 0 ? (toLine - line) > 0 ? 1 : -1 : 0;
            int stepColumn = (toColumn - column) != 0 ? (toColumn - column) > 0 ? 1 : -1 : 0;

            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += stepLine;
                currentColumn += stepColumn;
            }
            return  true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
