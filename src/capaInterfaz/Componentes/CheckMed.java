/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;

/**
 *
 * @author CMFerrer
 */
public class CheckMed extends JCheckBox {
 
    public CheckMed() {
        this.setSelected(true);
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/checked.png")));
        this.setOpaque(false);
        this.setFont(new Font("Gadugi", Font.PLAIN, 18));

        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (isSelected()) {
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/checked.png")));
                } else {
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/unchecked.png")));
                }
            }
        });
    }
}
