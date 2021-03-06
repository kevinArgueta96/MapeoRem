/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Logica.*;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argue
 */
public class frm_depto extends javax.swing.JFrame {

    /**
     * Creates new form frm_depto
     */
    conexcion con = new conexcion();
    Entes en = new Entes();
    DefaultTableModel tbl_diseño_depto = new DefaultTableModel();
    DefaultTableModel tbl_diseño_mun = new DefaultTableModel();
    DefaultTableModel tbl_cobertura = new DefaultTableModel();

    public frm_depto() {
        initComponents();
        this.setLocationRelativeTo(null);
        //tbl_depto.setEnabled(false);
        lbl_cod_depto.setVisible(false);

        String[] dato = new String[8];

        ResultSet rs;
        Statement st;

        tbl_diseño_depto.addColumn("CODIGO");
        tbl_diseño_depto.addColumn("NOMBRE ");

        tbl_diseño_mun.addColumn("CODIGO");
        tbl_diseño_mun.addColumn("NOMBRE ");

        tbl_cobertura.addColumn("NOMBRE");
        tbl_cobertura.addColumn("DEPARTAMENTO ");
        tbl_cobertura.addColumn("MUNICIPIO");
        tbl_cobertura.addColumn("HORARIO ");

        tbl_muni.setModel(tbl_diseño_mun);
        tbl_depto.setModel(tbl_diseño_depto);
        tbl_cobertura_demu.setModel(tbl_cobertura);

        try {
            st = con.getConnection().createStatement();
            ResultSet result = st.executeQuery(en.depto());
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);

                tbl_diseño_depto.addRow(dato);
            }
            //con.desconectar();
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_muni = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_depto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_depto = new javax.swing.JLabel();
        lbl_cod_depto = new javax.swing.JLabel();
        btn_depto = new javax.swing.JButton();
        lbl_municipio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cobertura_demu = new javax.swing.JTable();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_muni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_muni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_muniMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_muni);

        tbl_depto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_depto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_deptoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_depto);

        jLabel1.setText("DEPARTAMENTO SELECCIONADO:");

        lbl_depto.setFont(new java.awt.Font("Corbel Light", 3, 18)); // NOI18N

        btn_depto.setText("REVISAR POR DEPARTAMENTO");
        btn_depto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deptoActionPerformed(evt);
            }
        });

        lbl_municipio.setFont(new java.awt.Font("Corbel Light", 3, 18)); // NOI18N

        jLabel2.setText("MUNICIPIO SELECCIONADO:");

        jButton2.setText("REVISAR POR MUNICIPIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbl_cobertura_demu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_cobertura_demu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cobertura_demuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_cobertura_demu);

        btn_regresar.setText("REGRESAR");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lbl_cod_depto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(471, 471, 471)
                                    .addComponent(btn_depto)
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(142, 142, 142)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_depto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jButton2)))))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_regresar)
                .addGap(558, 558, 558))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_depto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_cod_depto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_depto)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_regresar)
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_deptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_deptoMouseClicked
        funciones fun = new funciones();
        tbl_diseño_mun.setRowCount(0);
        lbl_municipio.setText("");
        try {
            int filaseleccionada = 0;
            if (filaseleccionada == -1) {
                JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUNA FILA");
            } else {
                int seleccion = tbl_depto.rowAtPoint(evt.getPoint());
                lbl_depto.setText(String.valueOf(tbl_depto.getValueAt(seleccion, 1)));
                lbl_cod_depto.setText(String.valueOf(tbl_depto.getValueAt(seleccion, 0)));
                if (lbl_cod_depto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR ANTES UN DEPARTAMENTO");
                } else {
                    Statement st;
                    String[] mun = new String[60];
                    String query = en.muni(lbl_cod_depto.getText());

                    try {
                        st = con.getConnection().createStatement();
                        ResultSet result = st.executeQuery(query);

                        while (result.next()) {

                            mun[0] = result.getString(1);
                            mun[1] = result.getString(2);
                            tbl_diseño_mun.addRow(mun);
                        }

                    } catch (Exception ex) {
                        System.err.println(ex);

                    }
                }

            }
        } catch (HeadlessException ex) {

        }
        /* try{
            //Guardamos en un entero la fila seleccionada.
            filaseleccionada = tbl_depto.getSelectedRow();
            if (filaseleccionada == -1){
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
            } else {
                Comprar_vehiculo cv = new Comprar_vehiculo(null, rootPaneCheckingEnabled);
                cv.setVisible(true);

                //String ayuda = tabla.getValueAt(filaseleccionada, num_columna).toString()); 
                String bastidor = (String)table_comprados.getValueAt(filaseleccionada, 0);
                String color = (String)table_comprados.getValueAt(filaseleccionada, 1);
                String matricula = (String)table_comprados.getValueAt(filaseleccionada, 2);
                String marca = (String)table_comprados.getValueAt(filaseleccionada, 3);
//                textfield_bastidor.setText(bastidor);
//                textfield_color.setText(color);
//                textfield_marca.setText(email);
//                textfield_modelo.setText(matricula);
//                textfield_matricula.setText(marca);
            }
        }catch (HeadlessException ex){
            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }    */
    }//GEN-LAST:event_tbl_deptoMouseClicked

    private void btn_deptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deptoActionPerformed
        int cont = 0;
        if (lbl_depto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN DEPARTAMENTO");
        } else {
            try {
                Statement st_c;
                st_c = con.getConnection().createStatement();
                ResultSet result_c = st_c.executeQuery(en.depto_count(lbl_depto.getText()));
                while (result_c.next()) {
                    cont = result_c.getInt(1);
                }
            } catch (Exception ex) {
                System.err.println(ex);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "EN EL DEPARTAMENTO NO HAY ENTES INSCRITOS");
                tbl_cobertura.setRowCount(0);
            } else {
                tbl_cobertura.setRowCount(0);
                String[] dato = new String[8];

                Statement st;
                try {
                    st = con.getConnection().createStatement();
                    ResultSet result = st.executeQuery(en.depto_cobertura(lbl_depto.getText()));
                    while (result.next()) {
                        dato[0] = result.getString(1);
                        dato[1] = result.getString(2);
                        dato[2] = result.getString(3);
                        dato[3] = result.getString(4);

                        tbl_cobertura.addRow(dato);
                    }
                    //con.desconectar();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }//GEN-LAST:event_btn_deptoActionPerformed

    private void tbl_muniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_muniMouseClicked
        try {
            int filaseleccionada = 0;
            if (filaseleccionada == -1) {
                JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUNA FILA");
            } else {
                int seleccion = tbl_depto.rowAtPoint(evt.getPoint());
                lbl_municipio.setText(String.valueOf(tbl_diseño_mun.getValueAt(seleccion, 1)));

            }
        } catch (HeadlessException ex) {

        }
    }//GEN-LAST:event_tbl_muniMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int cont = 0;
        if (lbl_municipio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN MUNICIPIO");
        } else {
            try {
                Statement st_c;
                st_c = con.getConnection().createStatement();
                ResultSet result_c = st_c.executeQuery(en.muni_count(lbl_municipio.getText()));
                while (result_c.next()) {
                    cont = result_c.getInt(1);
                }
            } catch (Exception ex) {
                System.err.println(ex);
            }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "EN EL MUNICIPIO NO HAY ENTES INSCRITOS");
                tbl_cobertura.setRowCount(0);
            } else {
                Entes en = new Entes();
                tbl_cobertura.setRowCount(0);
                String[] dato = new String[8];
                ResultSet rs;
                Statement st;
                try {
                    st = con.getConnection().createStatement();
                    ResultSet result = st.executeQuery(en.muni_cobertura(lbl_municipio.getText()));
                    while (result.next()) {
                        dato[0] = result.getString(1);
                        dato[1] = result.getString(2);
                        dato[2] = result.getString(3);
                        dato[3] = result.getString(4);

                        tbl_cobertura.addRow(dato);
                    }
                    //con.desconectar();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_cobertura_demuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cobertura_demuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cobertura_demuMouseClicked

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        frm_principal ente = new frm_principal();
        ente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btn_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_depto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_depto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_depto;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_cod_depto;
    private javax.swing.JLabel lbl_depto;
    private javax.swing.JLabel lbl_municipio;
    private javax.swing.JTable tbl_cobertura_demu;
    private javax.swing.JTable tbl_depto;
    private javax.swing.JTable tbl_muni;
    // End of variables declaration//GEN-END:variables
}
