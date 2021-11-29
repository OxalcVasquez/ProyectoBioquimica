/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author user-pc
 */
public class ComboMed extends BasicComboBoxUI {

    private Color red = new Color(104, 228, 176);

    public static ComboBoxUI createUI(JComponent c) {
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return new ComboMed();

    }

    
    /*
    @Override
    protected JButton createArrowButton() {
        BasicArrowButton basicArrowButton = new BasicArrowButton(
                BasicArrowButton.SOUTH, //dirección de la flecha
                Color.WHITE, //Color de fondo
                new Color(130, 7, 7), //sombra
                new Color(130, 7, 7), //darkShadow
                Color.WHITE //highlight
        );
        // se quita el efecto 3D del boton, sombra y darkShadow no se aplican
        basicArrowButton.setBorder(BorderFactory.createLineBorder(red, 2));
        basicArrowButton.setContentAreaFilled(false);
        return basicArrowButton;
    }*/
    // se puede usar un JButton para usar un ícono personalizado en lugar del arrow
    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton();
        // se quita el efecto 3D del botón, sombra y darkShadow no se aplican
        button.setText("");
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setContentAreaFilled(false);
        button.setBackground(Color.WHITE);
        button.setOpaque(true);
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arrow.png")));
        

        return button;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(Color.WHITE);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    // pinta los items
    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(Color.WHITE);
                list.setSelectionForeground(Color.BLACK);
                if (isSelected) {
                    setBackground(new Color(16,171,131));
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(new Color(70, 70, 70));
                }

                return this;
            }
        };
    }

    //////////////////////////////////////////////////////////////////////////
}
