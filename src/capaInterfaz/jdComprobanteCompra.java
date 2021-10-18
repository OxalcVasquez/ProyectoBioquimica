/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz;

import capaInterfaz.Componentes.ColorTabla;
import capaInterfaz.Componentes.RoundedPanel;
import capaInterfaz.Componentes.ComboMed;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;

/**
 *
 * @author CMFerrer
 */
public class jdComprobanteCompra extends javax.swing.JDialog {

    private int posX = 0, posY = 0;
    /**
     * Creates new form jdPaciente
     */
    public jdComprobanteCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        getRootPane().setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        
        cboComp.setUI(ComboMed.createUI(cboComp));
        tblDatos.getTableHeader().setDefaultRenderer(new ColorTabla());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new RoundedPanel();
        gradientButton2 = new capaInterfaz.Componentes.BotonMedGradiente();
        botonMedGradiente1 = new capaInterfaz.Componentes.BotonMedGradiente();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        txtCorreo = new capaInterfaz.Componentes.TextoMed();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new capaInterfaz.Componentes.BotonMedGradiente();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo2 = new capaInterfaz.Componentes.TextoMed();
        jLabel14 = new javax.swing.JLabel();
        txtCorreo3 = new capaInterfaz.Componentes.TextoMed();
        btnBuscar1 = new capaInterfaz.Componentes.BotonMedGradiente();
        jLabel16 = new javax.swing.JLabel();
        txtCorreo4 = new capaInterfaz.Componentes.TextoMed();
        jLabel17 = new javax.swing.JLabel();
        txtCorreo5 = new capaInterfaz.Componentes.TextoMed();
        btnBuscar2 = new capaInterfaz.Componentes.BotonMedGradiente();
        btnBuscar3 = new capaInterfaz.Componentes.BotonMedGradiente();
        botonMedGradiente2 = new capaInterfaz.Componentes.BotonMedGradiente();
        botonMedGradiente3 = new capaInterfaz.Componentes.BotonMedGradiente();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCorreo6 = new capaInterfaz.Componentes.TextoMed();
        jLabel20 = new javax.swing.JLabel();
        cboComp = new javax.swing.JComboBox<>();
        txtCorreo1 = new capaInterfaz.Componentes.TextoMed();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradientButton2.setText("Nuevo");
        gradientButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradientButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(gradientButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 157, -1));

        botonMedGradiente1.setText("Modificar");
        botonMedGradiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMedGradiente1ActionPerformed(evt);
            }
        });
        jPanel2.add(botonMedGradiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 450, 160, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setText("BIOQUÍMICA DEL NORTE ANDINO S.A.C.  ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 13, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gadugi", 3, 14)); // NOI18N
        jLabel8.setText("RUC: 20601834945 ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 45, -1, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDatos.setSelectionBackground(new java.awt.Color(104, 228, 176));
        jScrollPane1.setViewportView(tblDatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 790, 243));

        txtCorreo.setText("");
        txtCorreo.setPlaceholder("");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 317, -1));

        jLabel9.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel9.setText("Chota-Cajamarca-Perú, Jr. San Martín N°477");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 99, -1, -1));

        jLabel10.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel10.setText("CORREO: bioquimicadelnorte@gmail.com");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 72, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setText("COMPRA");

        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel7.setText("N°:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel15.setText("Fecha:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 35, -1, -1));

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel11.setText("Producto:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        btnBuscar.setText("B");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 57, -1));

        jLabel12.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel12.setText("N° Comp:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel13.setText("Tipo Comp:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));

        txtCorreo2.setText("");
        txtCorreo2.setPlaceholder("");
        txtCorreo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 179, -1));

        jLabel14.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        txtCorreo3.setText("");
        txtCorreo3.setPlaceholder("");
        txtCorreo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo3ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 320, -1));

        btnBuscar1.setText("B");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 162, 57, -1));

        jLabel16.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel16.setText("Cantidad:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        txtCorreo4.setText("");
        txtCorreo4.setPlaceholder("");
        txtCorreo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo4ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 179, -1));

        jLabel17.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel17.setText("---------");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 70, -1));

        txtCorreo5.setText("");
        txtCorreo5.setPlaceholder("");
        txtCorreo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo5ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 179, -1));

        btnBuscar2.setText("Nuevo");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(943, 162, -1, -1));

        btnBuscar3.setText("Nuevo");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, -1, -1));

        botonMedGradiente2.setText("Salir");
        jPanel2.add(botonMedGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 570, 160, -1));

        botonMedGradiente3.setText("Eliminar");
        jPanel2.add(botonMedGradiente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 160, -1));

        jLabel18.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel18.setText("Precio:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jLabel19.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel19.setText("Proveedor:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 166, -1, -1));

        txtCorreo6.setText("");
        txtCorreo6.setPlaceholder("");
        jPanel2.add(txtCorreo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 164, 179, -1));

        jLabel20.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel20.setText("Razón social:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 166, -1, -1));

        cboComp.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        cboComp.setForeground(new java.awt.Color(51, 51, 51));
        cboComp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Boleta Electrónica", "Factura", "Factura Electrónica" }));
        jPanel2.add(cboComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 190, -1));

        txtCorreo1.setText("");
        txtCorreo1.setPlaceholder("");
        txtCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 164, 317, -1));

        jLabel21.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel21.setText("Total:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 630, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 1070, 690));

        jPanel1.setBackground(new java.awt.Color(84, 248, 147));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTIONAR COMPRA");

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Exit.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusable(false);
        btnSalir.setPreferredSize(new java.awt.Dimension(49, 25));
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Exit (2)_1.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(344, 344, 344)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 158));
        jPanel1.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 3, Color.GRAY));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1190, 670));
        jPanel3.setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3, Color.GRAY));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        posX = evt.getX();
	posY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_formMouseDragged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void gradientButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradientButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradientButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo3ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtCorreo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo2ActionPerformed

    private void txtCorreo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo4ActionPerformed

    private void txtCorreo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo5ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    private void botonMedGradiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMedGradiente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMedGradiente1ActionPerformed

    private void txtCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo1ActionPerformed

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
            java.util.logging.Logger.getLogger(jdComprobanteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdComprobanteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdComprobanteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdComprobanteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdComprobanteCompra dialog = new jdComprobanteCompra(new javax.swing.JFrame(), true);
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
    private capaInterfaz.Componentes.BotonMedGradiente botonMedGradiente1;
    private capaInterfaz.Componentes.BotonMedGradiente botonMedGradiente2;
    private capaInterfaz.Componentes.BotonMedGradiente botonMedGradiente3;
    private capaInterfaz.Componentes.BotonMedGradiente btnBuscar;
    private capaInterfaz.Componentes.BotonMedGradiente btnBuscar1;
    private capaInterfaz.Componentes.BotonMedGradiente btnBuscar2;
    private capaInterfaz.Componentes.BotonMedGradiente btnBuscar3;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboComp;
    private capaInterfaz.Componentes.BotonMedGradiente gradientButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDatos;
    private capaInterfaz.Componentes.TextoMed txtCorreo;
    private capaInterfaz.Componentes.TextoMed txtCorreo1;
    private capaInterfaz.Componentes.TextoMed txtCorreo2;
    private capaInterfaz.Componentes.TextoMed txtCorreo3;
    private capaInterfaz.Componentes.TextoMed txtCorreo4;
    private capaInterfaz.Componentes.TextoMed txtCorreo5;
    private capaInterfaz.Componentes.TextoMed txtCorreo6;
    // End of variables declaration//GEN-END:variables
}