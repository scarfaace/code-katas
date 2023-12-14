public class BoardEvaluator {

  public boolean isOver(Board board) {
    if (board.hasAnyEmptyCell()) {
      return true;
    }

    return false;
  }



}
