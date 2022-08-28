public class Board {
  private final int rows;
  private final int columns;
  private char[][] field;

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    initializeBoard(rows, columns);
  }

  private void initializeBoard(int rows, int columns) {
    field = new char[rows][columns];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        field[row][col] = ' ';
      }
    }
  }

  public void insert(char symbol, int x, int y) throws Exception {
    if (!isCellEmpty(x, y)) {
      throw new Exception(String.format("Position [%d,%d] is not empty."));
    }
    field[x][y] = symbol;
  }

  private boolean isCellEmpty(int x, int y) {
    return field[x][y] == ' ';
  }

  public boolean hasAnyEmptyCell() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        if(field[row][col] == ' ') {
          return true;
        }
      }
    }
    return false;
  }
}
