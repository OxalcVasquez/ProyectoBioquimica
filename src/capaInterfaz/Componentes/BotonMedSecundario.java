/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

/**
 *
 * @author Rojeru San
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
* @author Rojeru San
 */
public class BotonMedSecundario extends JButton implements MouseListener {
 
    
    public BotonMedSecundario() {
        this.setFont(new Font("Gadugi", Font.PLAIN, 12));
        this.setPreferredSize(new Dimension(280, 30));
        this.setSize(new Dimension(280, 30));
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBackground(new Color(255,255,255));
        this.setForeground(new Color(0,0,0));
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    public void mouseClicked(MouseEvent e) {
    }


    public void mousePressed(MouseEvent e) {
        this.setBackground(new Color(0,0,0));
        this.setForeground(new Color(255,255,255));
    }

    public void mouseReleased(MouseEvent e) {       
        this.setBackground(new Color(255,255,255));
        this.setForeground(new Color(0,0,0));
    }

    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(229, 229, 229));
    }

    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(255, 255, 255));
    }


}
