/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaInterfaz;

import capaNegocio.clsProveedor;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NUEVO
 */
public class jdManProveedorTemp extends javax.swing.JDialog {
    clsProveedor objProv = new clsProveedor();
    /**
     * Creates new form jdManProveedorTemp
     */
    public jdManProveedorTemp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProv = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtRAZ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCiu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboRubro = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Ruc");

        tblProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProv);

        jLabel2.setText("Razón social:");

        jLabel3.setText("Correo:");

        jLabel4.setText("Web");

        jLabel5.setText("Tel.");

        jLabel6.setText("Ciudad");

        jLabel7.setText("Rubro");

        cboRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agrícola", "Veterinario", "Químico" }));

        jLabel8.setText("Estado");

        chkEstado.setText("(Activo)");

        btnBuscar.setText("B");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Dar de baja");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCiu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(103, 103, 103))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(chkEstado)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(btnBuscar)))
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton5))
                                .addGap(0, 35, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtRAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(65, 65, 65))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(409, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(23, 23, 23)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRAZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnNuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(chkEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(jButton4)
                    .addContainerGap(373, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try {
              String rubro="";
              if(txtRuc.getText().equals("")){
                  JOptionPane.showMessageDialog(this, "Ingrese el ruc a modificar!");
            }else{
               
                    if (cboRubro.getSelectedItem().equals("Agrícola")) rubro="A";
                    if (cboRubro.getSelectedItem().equals("Veterinario")) rubro="V";
                    if (cboRubro.getSelectedItem().equals("Químico")) rubro="Q";
            objProv.modificarProv(txtRuc.getText(),txtRAZ.getText(), txtCorreo.getText(), txtWeb.getText(), txtTel.getText(), txtCiu.getText(), rubro, chkEstado.isSelected());
                JOptionPane.showMessageDialog(this, "Modificado correctamente...");
                listarProveedores();
              }
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try {
            if(txtRuc.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese ruc a eliminar...");
            }else{
                objProv.eliminarProv(txtRuc.getText());
                listarProveedores();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
         ResultSet rsPr = null;
           String rubro="";
        try {
            if(txtRuc.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese ruc a buscar...");
                txtRuc.requestFocus();
            }else{
                rsPr=objProv.buscarProv(txtRuc.getText());
                if(rsPr.next()){
                    txtRAZ.setText(rsPr.getString("razonsocial"));
                    txtCorreo.setText(rsPr.getString("correo"));
                    txtTel.setText(String.valueOf(rsPr.getString("telefono")));
                    txtWeb.setText(String.valueOf(rsPr.getString("web")));
                    txtCiu.setText(String.valueOf(rsPr.getString("ciudad")));
                    rubro=rsPr.getString("rubro");
                    if(rubro.equals("A")) cboRubro.setSelectedItem("Agrícola");
                    if(rubro.equals("V")) cboRubro.setSelectedItem("Veterinario");
                    if(rubro.equals("Q")) cboRubro.setSelectedItem("Químico");
                  
                    chkEstado.setSelected(rsPr.getBoolean("estado"));
                }else{
                    JOptionPane.showMessageDialog(this, "Ruc no registrado...");
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
         String rubro="";
    
        try {
            
              
                if (objProv.validar(txtRuc.getText())){
                    if (cboRubro.getSelectedItem().equals("Agrícola")) rubro="A";
                    if (cboRubro.getSelectedItem().equals("Veterinario")) rubro="V";
                    if (cboRubro.getSelectedItem().equals("Químico")) rubro="Q";
                    
                    objProv.registrarProv(txtRuc.getText(),txtRAZ.getText(), txtCorreo.getText(), txtWeb.getText(), txtTel.getText(), txtCiu.getText(), rubro, chkEstado.isSelected());
                  JOptionPane.showMessageDialog(this, "Registro correcto");
                  listarProveedores();
                }else{
                     JOptionPane.showMessageDialog(this, "Ruc ya está registrado!");

                }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         try {
            if(txtRuc.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese ruc a dar de baja...");
            }else{
                objProv.darBajaHab(txtRuc.getText());
                listarProveedores();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        listarProveedores();
    }//GEN-LAST:event_formWindowOpened

    private void tblProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProvMouseClicked
        // TODO add your handling code here:
        txtRuc.setText(String.valueOf(tblProv.getValueAt(tblProv.getSelectedRow(),0)));
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_tblProvMouseClicked
 private void listarProveedores(){
        ResultSet rsPr =null;
        String rubro="";
        DefaultTableModel modeloPr=new DefaultTableModel();
        modeloPr.addColumn("Ruc");
        modeloPr.addColumn("Razon Social");
        modeloPr.addColumn("Correo");
        modeloPr.addColumn("Web");
        modeloPr.addColumn("Tel.");
        modeloPr.addColumn("Ciudad");
        modeloPr.addColumn("Rubro");
        modeloPr.addColumn("Estado");
        tblProv.setModel(modeloPr);
        try {
            rsPr=objProv.listarProveedores();
            while(rsPr.next()){
                rubro=rsPr.getString("rubro");
                    if(rubro.equals("A")) rubro=("Agrícola");
                    if(rubro.equals("V")) rubro=("Veterinario");
                    if(rubro.equals("Q")) rubro=("Químico");
                modeloPr.addRow(new Object[]{
                    rsPr.getString("ruc"),
                    rsPr.getString("razonsocial"),
                    rsPr.getString("correo"),
                    rsPr.getString("web"),
                    rsPr.getString("telefono"),
                    rsPr.getString("ciudad"),
                    rubro,
                    rsPr.getBoolean("estado")? "Activo" : "Inactivo",});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    
 
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdManProveedorTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdManProveedorTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdManProveedorTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdManProveedorTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdManProveedorTemp dialog = new jdManProveedorTemp(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboRubro;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProv;
    private javax.swing.JTextField txtCiu;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtRAZ;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}