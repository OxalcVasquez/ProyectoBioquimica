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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * @author CMFerrer
 */
public class BotonMed extends JButton implements MouseListener {

    Color fondo = new Color(14, 20, 40);
    Color fondoPresionado = new Color(80, 82, 81); //De preferencia oscuro
    Color fondoHover = new Color(164, 170, 164); //De preferencia claro
    Color letra = new Color(240, 247, 244);
    Color letraPresionado = new Color(240, 247, 244);
    
    public BotonMed() {
        this.setFont(new Font("Gadugi", Font.BOLD, 18));
        this.setPreferredSize(new Dimension(100, 30));
        this.setSize(new Dimension(100, 30));
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBackground(fondo);
        this.setForeground(letra);
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 24, 24);

        g.setColor(getBackground().darker().darker().darker());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 24, 24);

        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            g.setColor(getForeground());
            g.drawString(super.getText(), getWidth() / 2 - fm.stringWidth(super.getText()) / 2, getHeight() / 2 + fm.getMaxDescent());
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) { //Botón presionado
        this.setBackground(fondoPresionado);
        this.setForeground(letraPresionado);
    }

    public void mouseReleased(MouseEvent e) { //Botón después de presionar      
        this.setBackground(fondo);
        this.setForeground(letra);
    }

    public void mouseEntered(MouseEvent e) { // hover
        this.setBackground(fondoHover);
    }

    public void mouseExited(MouseEvent e) {  //Botón fuera de foco, no está debajo del ratón 
        this.setBackground(fondo);
    }

}
