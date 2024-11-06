public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    @Override
    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //System.out.println("Работа пешек");
//System.out.println("line = "+line+" column = "+column+" toLine = "+toLine+" toColumn ="+toColumn);
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
        !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];

        if (this.getColor().equals("White")) {

            //System.out.println("Ход белых");

            if (line == 1 && toLine == 3 && column == toColumn && targetPiece == null) {
                return true;
            }

            if (toLine == line + 1 && column == toColumn && targetPiece == null) {
                return true;
            }

            if (toLine == line + 1 && Math.abs(toColumn - column) == 1 && targetPiece != null &&
                    !targetPiece.getColor().equals(this.getColor())) {
                return true;
            }
        } else if (this.getColor().equals("Black")) {

            //System.out.println("Ход черных");

            if (line == 6 && toLine == 4 && column == toColumn && targetPiece == null) {
                return true;
            }

            if (toLine == line - 1 && column == toColumn && targetPiece == null) {
                return true;
            }

            if (toLine == line - 1 && Math.abs(toColumn - column) == 1 && targetPiece != null &&
                    !targetPiece.getColor().equals(this.getColor())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    private boolean isValidPosition(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }
}