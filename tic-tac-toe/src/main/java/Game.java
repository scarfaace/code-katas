public class Game {
  private final Board board;
  private final Player player1;
  private final Player player2;
  private Player currentPlayer;

  private final BoardEvaluator scoreEvaluator;

  public Game(Board board, Player player1, Player player2, BoardEvaluator scoreEvaluator) {
    this.board = board;
    this.player1 = player1;
    this.player2 = player2;
    this.currentPlayer = player1;
    this.scoreEvaluator = scoreEvaluator;
  }

  public void play() {
    while(true) {
      if(scoreEvaluator.isOver(board)) {
        break;
      }
      currentPlayer.writeToBoard(board);
    }
  }
}
