/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author CMFerrer
 */
public class TextoSecretoMed extends JPasswordField implements FocusListener{
    
    public TextoSecretoMed(){
        this.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 18));
        this.setForeground(new Color(221,220,220));
        this.setPreferredSize(new Dimension(200, 40));
        this.setSize(new Dimension(200, 40));
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.setOpaque(true);
        this.setVisible(true);
        this.addFocusListener(this);
        super.setText("Tu contraseña");
        super.setEchoChar((char)0);
    }
    
    @Override
    public void focusGained(FocusEvent fe) {
              
        String place = new String(super.getPassword());
        
        if (place.equals("Tu contraseña")) {
            super.setText("");
            this.setFont(new Font("Gadugi", Font.PLAIN, 18));
            this.setForeground(Color.BLACK);
            super.setEchoChar('•');
        }
        
        super.setBorder(new MatteBorder(0, 0, 1, 0, new Color(79, 119, 254)));
    }

    @Override
    public void focusLost(FocusEvent fe) {

        String place = new String(super.getPassword());
        
        if (place.equals("")) {
            super.setText("Tu contraseña");
             this.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 18));
            this.setForeground(new Color(221,220,220));
            super.setEchoChar((char)0);
        }
        
        super.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
    }
}
