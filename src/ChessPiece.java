public abstract class ChessPiece {

    protected String color;
    private Boolean check = true;

    public ChessPiece (String color){
        this.color = color;
    }

    public String getColor(){
        return color;

    }
    public abstract Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
}
