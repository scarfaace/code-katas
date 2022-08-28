import lombok.Value;

@Value
public class Player {
  char symbol;
  String name;

  public void writeToBoard(Board board, int x, int y) {
    board.insert(symbol, x, y);
  }
}
