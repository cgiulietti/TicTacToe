package Game;

import java.util.ArrayList;

/* class used to store and return the pre-computed masks of the winning grids 
 * cells are set to true when they must be marked by one player in order to win,
 * false when does not matter which player marked them */
public class WinningGrids {

   /* list containing the winning grids */
   final ArrayList<Boolean[][]> grids = new ArrayList<Boolean[][]>();
	
   private static final Boolean[][] grid1 =
   {
    { true,    true,   true  },
    { false,   false,  false },
    { false,   false,  false }
   };
   
   private static final  Boolean[][] grid2 =
   {
    { false,   false,  false  },
    { true,    true,   true },
    { false,   false,  false }
   };
   
   private static final  Boolean[][] grid3 =
   {
    { false,   false,  false  },
    { false,   false,  false },
    { true,    true,   true }
   };
   
   private static final  Boolean[][] grid4 =
   {
    { true,   false,  false  },
    { true,   false,  false },
    { true,   false,  false }
   };
   
   private static final  Boolean[][] grid5 =
   {
    { false,   true,  false  },
    { false,   true,  false },
    { false,   true,  false }
   };
   
   private static final  Boolean[][] grid6 =
   {
    { false,   false,   true  },
    { false,   false,  true },
    { false,   false,  true }
   };
   
   private static final  Boolean[][] grid7 =
   {
    { true,    false,   false },
    { false,   true,    false },
    { false,   false,   true  }
   };
   
   private static final  Boolean[][] grid8 =
   {
    { false,   false,   true  },
    { false,   true,    false },
    { true,    false,   false }
   };
   
   
   public WinningGrids() {
      super();
      grids.add(grid1);
      grids.add(grid2);
      grids.add(grid3);
      grids.add(grid4);
      grids.add(grid5);
      grids.add(grid6);
      grids.add(grid7);
      grids.add(grid8);
   }

   public ArrayList<Boolean[][]> getGrids(){
      return grids;
   }
  
   public static boolean isWinningCell ( Boolean b ){
      return b;
   }
   
}
