
package higherorlowercardgame;

import java.awt.Toolkit;

public class HigherOrLowerCardGame {

    public static void main(String[] args) {
        
        
        
        game game = new game();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int)tk.getScreenSize().getWidth();
        int ySize = (int)tk.getScreenSize().getHeight();
        game.setSize(xSize,ySize);
        game.setVisible(true); 
        
        
    }
}
    
