/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Logica.Entes;
import Logica.conexcion;
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
    public frm_depto() {
        initComponents();
                tbl_depto.setEnabled(false);
        conexcion con = new conexcion();
        Entes en = new Entes();
        String[] dato = new String[8];
        
        ResultSet rs;
        Statement st;
        DefaultTableModel tbl = new DefaultTableModel();
        DefaultTableModel tbl_dept = new DefaultTableModel();
        tbl.addColumn("CODIGO");
        tbl.addColumn("NOMBRE ");
        
        tbl_dept.addColumn("CODIGO");
        tbl_dept.addColumn("NOMBRE ");
        
        tbl_muni.setModel(tbl_dept);
        tbl_depto.setModel(tbl);
        /*try {
            st = con.getConnection();
            ResultSet result = st.executeQuery(en.depto());
            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
           
                tbl.addRow(dato);
            }
            con.desconectar();
        } catch (Exception ex) {
            System.err.println(ex);
        }
*/

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_depto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_muni = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane2.setViewportView(tbl_muni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_deptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_deptoMouseClicked
        int filaseleccionada;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_depto;
    private javax.swing.JTable tbl_muni;
    // End of variables declaration//GEN-END:variables
}
