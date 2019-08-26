/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;


/**
 *
 * @author kevin
 */
public interface State {
    
    public void Tester(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public boolean validAction();
    
}
