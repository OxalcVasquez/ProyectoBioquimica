/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author CMFerrer
 */
public class spinnerMed extends JPanel {

    BorderLayout layout = new BorderLayout();

    JButton siguiente = new JButton(new javax.swing.ImageIcon(getClass().getResource("/Iconos/next.png")));
    JFormattedTextField cantidad ;

    NumberFormatter formatter;
    
    JTextField campoPrecio = new JTextField();
    Double precio = 0.0;

    public void setPrecio(JTextField campoPrecio, Double precio) {
        this.precio = precio;

        this.campoPrecio.setEnabled(true);
        this.campoPrecio = campoPrecio;
    }

    public Integer getCantidad() {
        return Integer.parseInt(cantidad.getValue().toString());
    }

    public spinnerMed() {

        setBackground(Color.WHITE);
        setLayout(layout);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        cantidad = new JFormattedTextField(formatter);
        cantidad.setPreferredSize(new Dimension(48, 24));
        cantidad.setSize(new Dimension(48, 24));
        cantidad.setFont(new Font("Gadugi", Font.PLAIN, 18));
        cantidad.setForeground(Color.BLACK);
        cantidad.setBorder(null);
        cantidad.setValue(1);
        cantidad.setOpaque(false);
        cantidad.setHorizontalAlignment(JTextField.CENTER);

        cantidad.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (cantidad.getValue().toString().length() == 1) {
                    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        cantidad.setValue(1);
                    }
                }

            }

            public void keyReleased(KeyEvent e) {

                if (campoPrecio.isEnabled()) {
                    if ((e.getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9) || (e.getKeyCode() >= KeyEvent.VK_NUMPAD0 && e.getKeyCode() <= KeyEvent.VK_NUMPAD9) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        campoPrecio.setText(String.valueOf(precio * Integer.parseInt(cantidad.getValue().toString())));
                    }
                }

            }
        });

        add(cantidad, BorderLayout.CENTER);

        JButton anterior = new JButton(new javax.swing.ImageIcon(getClass().getResource("/Iconos/previous.png")));
        anterior.setBorder(null);
        anterior.setContentAreaFilled(false);
        anterior.setBorderPainted(false);
        anterior.setFocusPainted(false);
        anterior.setOpaque(false);
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cantidad.setText(String.valueOf(Integer.parseInt(cantidad.getValue().toString()) - 1));
                if (campoPrecio.isEnabled()) {
                    campoPrecio.setText(String.valueOf(precio * Integer.parseInt(cantidad.getValue().toString())));
                }
            }
        });
        add(anterior, BorderLayout.WEST);

        siguiente.setBorder(null);
        siguiente.setContentAreaFilled(false);
        siguiente.setBorderPainted(false);
        siguiente.setFocusPainted(false);
        siguiente.setOpaque(false);
        siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cantidad.setText(String.valueOf(Integer.parseInt(cantidad.getValue().toString()) + 1));
                if (campoPrecio.isEnabled()) {
                    campoPrecio.setText(String.valueOf(precio * Integer.parseInt(cantidad.getValue().toString())));
                }
            }
        });
        add(siguiente, BorderLayout.EAST);
        //layout.setHgap(6);
        campoPrecio.setEnabled(false);
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad.setText(String.valueOf(cantidad));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
    
    public void setMaximo(Integer maximo){
        formatter.setMaximum(maximo);
    }

}
