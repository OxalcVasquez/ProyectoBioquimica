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
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author CMFerrer
 */
public class TextoMed extends JTextField implements FocusListener {

    private String placeholder = "placeholder";
    private Color colorPlaceHolder = new Color(221, 220, 220);

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public TextoMed() {
        this.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 18));
        this.setForeground(new Color(221,220,220));
        this.setPreferredSize(new Dimension(200, 30));
        this.setSize(new Dimension(200, 30));
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        this.setOpaque(true);
        this.setVisible(true);
        this.addFocusListener(this);
        super.setText(placeholder);
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (super.getText().equals(placeholder)) {
            super.setText("");
            this.setFont(new Font("Gadugi", Font.PLAIN, 18));
            this.setForeground(Color.BLACK);
        }
        super.setBorder(new MatteBorder(0, 0, 1, 0, new Color(16,171,131)));
        
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (super.getText().equals("")) {
            super.setText(placeholder);
            this.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 18));
            this.setForeground(colorPlaceHolder);
        }
        super.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
    }

    @Override
    public void setText(String string){
        super.setText(string);
        this.setFont(new Font("Gadugi", Font.PLAIN, 18));
        this.setForeground(Color.BLACK);
    }

}
