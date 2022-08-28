public class Main {
  public static void main(String[] args) {
    Board board = new Board(height, width);
    Player player1 = new Player('X', "Alfons");
    Player player2 = new Player('O', "Alf");

    Game game = new Game(board, player1, player2, scoreEvaluator);
  }
}
