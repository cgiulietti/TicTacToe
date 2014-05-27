package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeUI implements ActionListener {
   
   static final int GRID_SIZE = 3;
   
   /* window and buttons */
   private JFrame window = new JFrame("Tic-Tac-Toe");
   private JButton button11 = new JButton(" ");
   private JButton button12 = new JButton(" ");
   private JButton button13 = new JButton(" ");
   private JButton button21 = new JButton(" ");
   private JButton button22 = new JButton(" ");
   private JButton button23 = new JButton(" ");
   private JButton button31 = new JButton(" ");
   private JButton button32 = new JButton(" ");
   private JButton button33 = new JButton(" ");

   private boolean freezed;
   private TicTacToeLogic gameLogic;

   public TicTacToeUI(){

      /* create window */
      window.setSize(300,300);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));

      /* add buttons */
      window.add(button11);
      window.add(button12);
      window.add(button13);
      window.add(button21);
      window.add(button22);
      window.add(button23);
      window.add(button31);
      window.add(button32);
      window.add(button33);

      /* add action listener */
      button11.addActionListener(this);
      button12.addActionListener(this);
      button13.addActionListener(this);
      button21.addActionListener(this);
      button22.addActionListener(this);
      button23.addActionListener(this);
      button31.addActionListener(this);
      button32.addActionListener(this);
      button33.addActionListener(this);

      window.setVisible(true);
      freezed = false;
      gameLogic = new TicTacToeLogic();
      
   }

   public void actionPerformed(ActionEvent a) {
      
	   /* perform operation only if the window is not freezed */
	   if ( freezed == false ){

		   JButton button = (JButton) a.getSource();
		   Coordinates coordinates = getCoordinates(button);

		   if ( gameLogic.makeMoveAndCheckIfOver( coordinates.x, coordinates.y ) ){ 
			   if ( gameLogic.getWinner() != null ){
				   System.out.println(gameLogic.getWinnerName()+ " won!");
			   }else{
				   System.out.println("Tied game!");
			   }
			   freezed = true;
		   }
		   
		   /* update the cell if necessary */
		   if ( button.getText() == " "){
			   if ( gameLogic.getLastPlayerMadeMove() == gameLogic.PLAYER1 ){
				   button.setText("O");
			   }else{
				   button.setText("X");
			   }
		   }

	   }
     
   }

   /* return the coordinates given a button */
   private Coordinates getCoordinates (Object button) {
      
      Coordinates c = null;
      
      if ( button.equals(button11) ){
         c = new Coordinates(0, 0);
      }else if ( button.equals(button12) ){
         c = new Coordinates(0, 1);
      }else if ( button.equals(button13) ){
         c = new Coordinates(0, 2);
      }else if ( button.equals(button21) ){
         c = new Coordinates(1, 0);
      }else if ( button.equals(button22) ){
         c = new Coordinates(1, 1);
      }else if ( button.equals(button23) ){
         c = new Coordinates(1, 2);
      }else if ( button.equals(button31) ){
         c = new Coordinates(2, 0);
      }else if ( button.equals(button32) ){
         c = new Coordinates(2, 1);
      }else if ( button.equals(button33) ){
         c = new Coordinates(2, 2);
      }
      
      return c;
      
   }

   public static void main(String[] args){
      new TicTacToeUI();
   }

   /* internal class used to store the coordinates of a button */
   private class Coordinates{
      private final int x;
      private final int y;
      
      public Coordinates(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
      
   }
   
}
