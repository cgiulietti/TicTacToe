package Game;

public class TicTacToeLogic {

   static final int EMPTY_CELL = 0;
   static final int PLAYER1_CELL = 1;
   static final int PLAYER2_CELL = 2;
   public static final boolean PLAYER1 = true;
   public static final boolean PLAYER2 = false;
   
   private boolean currentPlayer;
   private boolean isGameOver;
   private Boolean winner = null;
   private int[][] grid = new int[TicTacToeUI.GRID_SIZE][TicTacToeUI.GRID_SIZE];
   private WinningGrids winningGrids = new WinningGrids();

   public TicTacToeLogic() {
      super();
      
      /* initialize the grid */
      for (int i=0; i<TicTacToeUI.GRID_SIZE; i++){
         for (int j=0; j<TicTacToeUI.GRID_SIZE; j++){
            grid[i][j] = EMPTY_CELL;
         }
      }
      
      /* start with player 1 */
      currentPlayer = PLAYER1;
      
      isGameOver = false;
   }
   
   /* mark the requested cell for the current player and return if game over */
   public boolean makeMoveAndCheckIfOver( int x, int y ){
	   
      if ( grid[x][y] == EMPTY_CELL ){
    	  
         if ( currentPlayer == PLAYER1 ){
            grid[x][y] = PLAYER1_CELL;
         }else{
            grid[x][y] = PLAYER2_CELL;
         }
         
         /* check if game is won by player after the move,
          * or if it is tied
          */
         if ( checkIfCurrentPlayerWon() ){
        	isGameOver = true;
        	winner = new Boolean(currentPlayer);
         }else if ( checkIfTiedGame() ){
        	isGameOver = true;
         }
         
         /* finally change the player */
         changePlayer();
         
      }
      
      return isGameOver;
   }

   
   private void changePlayer( ){ 

      if ( currentPlayer == PLAYER1 ){
         currentPlayer = PLAYER2;
      }else{
         currentPlayer = PLAYER1;
      }
      
   }
   
   private boolean checkIfCurrentPlayerWon() {
      
      Integer currPlayerCell;
      int count;
      
      if ( currentPlayer == PLAYER1 ){
         currPlayerCell = PLAYER1_CELL;
      }else{
         currPlayerCell = PLAYER2_CELL;
      }
      
      /* for each pre-computed mask of a winning grid, check if it matches with
       * the current grid */
      for (Boolean[][] winningGrid : winningGrids .getGrids() ) {
         count = 0;
         for (int i = 0; i < TicTacToeUI.GRID_SIZE; i++) {
            for (int j = 0; j < TicTacToeUI.GRID_SIZE; j++) {
               if ( WinningGrids.isWinningCell(winningGrid[i][j]) && 
                     grid[i][j] == currPlayerCell ){
                  count++;
               }
               /* if count reached the GRID_SIZE, then the player won */
               if (count == TicTacToeUI.GRID_SIZE) return true;
            }
         }
      }

      return false;
      
   }

   private boolean checkIfTiedGame() {
      
      for (int i = 0; i < TicTacToeUI.GRID_SIZE; i++) {
         for (int j = 0; j < TicTacToeUI.GRID_SIZE; j++) {
            if ( grid[i][j] == EMPTY_CELL ) return false;
         }
      }
      
      return true;
   }
   
   public String getWinnerName() {
      String player;
      
      if ( winner == PLAYER1 ){
         player = "Player1";
      }else{
         player = "Player2";
      }
      
      return player;
   }
   
   public boolean getLastPlayerMadeMove() {
	   return !currentPlayer;
   }
   
   public Boolean getWinner() {
	   return winner;
   }
   
}
