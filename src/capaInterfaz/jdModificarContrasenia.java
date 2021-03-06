/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz;

import capaInterfaz.Componentes.Mail;
import capaInterfaz.Componentes.MensajeMed;
import capaInterfaz.Componentes.RoundedPanelSinSombra;
import capaNegocio.*;
import static capaInterfaz.jdInicioSesion.recuperacion;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author user-pc
 */
public class jdModificarContrasenia extends javax.swing.JDialog {

    clsUsuario miUsuario = new clsUsuario();

    /**
     * Creates new form jdModificarContrasena
     */
    public jdModificarContrasenia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 0, 0));
        getRootPane().setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new capaInterfaz.Componentes.RoundedPanelSinSombra(40, Color.WHITE);
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonMedSecundario1 = new capaInterfaz.Componentes.BotonMedSecundario();
        botonMed1 = new capaInterfaz.Componentes.BotonMed();
        btnSalir = new javax.swing.JButton();
        txtContrasenia = new capaInterfaz.Componentes.TextoSecretoMed();
        txtConfirmar = new capaInterfaz.Componentes.TextoSecretoMed();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar contrase??a");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("Confirmar contrase??a");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblUsuario.setText("Nombre usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel4.setText("Contrase??a");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        botonMedSecundario1.setText("Cancelar");
        botonMedSecundario1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        botonMedSecundario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMedSecundario1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonMedSecundario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, -1));

        botonMed1.setText("Confirmar");
        botonMed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMed1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonMed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 130, -1));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Exit.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusable(false);
        btnSalir.setOpaque(true);
        btnSalir.setPreferredSize(new java.awt.Dimension(49, 25));
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Exit (2).png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 40, -1));
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, -1));
        jPanel1.add(txtConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, -1));

        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hidden.png"))); // NOI18N
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 30, 40));

        jCheckBox3.setContentAreaFilled(false);
        jCheckBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hidden.png"))); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 30, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 360, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblUsuario.setText(jdInicioSesion.nomUsuario);
    }//GEN-LAST:event_formWindowOpened

    private void botonMed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMed1ActionPerformed
        // TODO add your handling code here:
        if (Arrays.equals(txtContrasenia.getPassword(), txtConfirmar.getPassword())) {
            try {
                miUsuario.modificarContrasenia(lblUsuario.getText(), txtConfirmar.getPassword());

                if (recuperacion) {
                    new Mail().enviarNuevoCodigo(lblUsuario.getText());
                    new MensajeMed().mostrar(this, "<html><div style='text-align: center;'>??Contrase??a modificada!<br>Se le enviara un nuevo c??digo de recuperaci??n</div></html>", 2);

                } else {
                    new MensajeMed().mostrar(this, "Contrase??a modificada", 2);
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(this, ex.getMessage());
            }
        } else {
            new MensajeMed().mostrar(this, "Contrase??as no coinciden", 3);
        }
    }//GEN-LAST:event_botonMed1ActionPerformed

    private void botonMedSecundario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMedSecundario1ActionPerformed
        // TODO add your handling code here:
        recuperacion = false;
        dispose();
    }//GEN-LAST:event_botonMedSecundario1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hidden.png")));
            txtContrasenia.setEchoChar('???');
        } else {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/view.png")));
            txtContrasenia.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hidden.png")));
            txtConfirmar.setEchoChar('???');
        } else {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/view.png")));
            txtConfirmar.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdModificarContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdModificarContrasenia dialog = new jdModificarContrasenia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private capaInterfaz.Componentes.BotonMed botonMed1;
    private capaInterfaz.Componentes.BotonMedSecundario botonMedSecundario1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    private capaInterfaz.Componentes.TextoSecretoMed txtConfirmar;
    private capaInterfaz.Componentes.TextoSecretoMed txtContrasenia;
    // End of variables declaration//GEN-END:variables
}
