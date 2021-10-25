/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz.Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author CMFerrer
 */
public class MensajeMed {

    UIManager UI = new UIManager();
    JLabel mensaje = new JLabel();
    BotonMed medOk = new BotonMed();
    BotonMed medCancelar = new BotonMed();
    //JButton[] botones = new JButton[2];
    JButton[] botones = {medOk,medCancelar};
    JButton[] boton = {medOk};
    Component jdialog;
    int tipo;

    // 0 -> info  |  1 -> warning  |  2 -> presence  |  3 -> error
    public MensajeMed() {

        UI.put("OptionPane.background", new Color(255, 255, 255));//red
        UI.put("Panel.background", new Color(255, 255, 255));//blue

        this.mensaje.setFont(new Font("Gadugi", Font.PLAIN, 20));

    }

    public int mostrar(Component jdialog, String mensaje, int tipo) {
        this.mensaje.setText(mensaje);
        this.tipo = tipo;
        this.jdialog = jdialog;

        return tipo();
    }

    private int tipo() {
        int respuesta;
        medOk.setText("OK");
        medOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent) e.getSource());
                pane.setValue(medOk);
            }
        });
        medCancelar.setText("Cancelar");
        medCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent) e.getSource());
                pane.setValue(medCancelar);
            }
        });
        
        // java 8

        switch (tipo) {
            case 0 :
                respuesta = JOptionPane.showOptionDialog(jdialog, mensaje, "INFORMACIÓN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Iconos/info.png")), boton, boton[0]);
                break;
            
            case 1 :
                respuesta = JOptionPane.showOptionDialog(jdialog, mensaje, "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Iconos/warning.png")), botones, botones[0]);
                break;
            
            case 2 :
                respuesta = JOptionPane.showOptionDialog(jdialog, mensaje, "ÉXITO", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Iconos/presence.png")), boton, boton[0]);
                break;
            default :
                respuesta = JOptionPane.showOptionDialog(jdialog, mensaje, "ERROR", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Iconos/error.png")), boton, boton[0]);
                break;
        }
        return respuesta;
    }

    protected JOptionPane getOptionPane(JComponent parent) {
        JOptionPane pane = null;
        if (!(parent instanceof JOptionPane)) {
            pane = getOptionPane((JComponent) parent.getParent());
        } else {
            pane = (JOptionPane) parent;
        }
        return pane;
    }
}
