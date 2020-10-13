/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Front.Claves;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.nio.channels.FileChannel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class funciones {

    conexcion con = new conexcion();
    Entes en = new Entes();
    
    public String clave (String nit_ente){
        Statement st;
        String clave="";
       
        try{
        st = con.getConnection().createStatement();
        ResultSet result = st.executeQuery(en.certe_ente(nit_ente));
            
         while (result.next()) {
                clave = result.getString(3);
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
        return clave;
    }
    public String nit_ente (String nit_ente){
        Statement st;
        String cod_certifica="";
       
        try{
        st = con.getConnection().createStatement();
        ResultSet result = st.executeQuery(en.certe_ente(nit_ente));
            
         while (result.next()) {
                cod_certifica = result.getString(1);
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
        return cod_certifica;
    }
    public void cambio_estado(String nit_ente){
         Connection cnc=con.getConnection();
         try{
       PreparedStatement str_update = con.getConnection().prepareStatement(en.UPDATE_CERTIFICADO(nit_ente));
        str_update.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    public String procedimiento(String cod_certifica) {
        try {
            CallableStatement cst = con.getConnection().prepareCall(en.procedimineto());
            cst.registerOutParameter(1, java.sql.Types.VARCHAR);
            cst.execute();
            cod_certifica = cst.getString(1);

        } catch (Exception ex) {
            System.out.println(ex);

        }
        return cod_certifica;
    }

    public void inserta(String cod_certifica, int cod_ente, String nombre_ente, long nit_ente) throws Exception {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String encript=encripta(cod_certifica, cod_ente, nombre_ente, nit_ente, date);
        JTextField txt = new JTextField();
        txt.setText(encript);
        txt.setEditable(false);
        
        //JOptionPane.showConfirmDialog(null, "CONTRASEÑA DEL CERTIFICADO:\n" +encript, "CONTRASEÑA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null, txt);
        try {
            PreparedStatement str = con.getConnection().prepareStatement(en.inserta());

            str.setString(1, cod_certifica);
            str.setInt(2, cod_ente);
            str.setString(3, nombre_ente);
            str.setLong(4, nit_ente);
            str.setDate(5, date);
            str.setString(6, "A");
            str.setString(7, encript);
            str.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
    private String encripta(String cod_certifica, int cod_ente, String nombre_ente, long nit_ente,java.sql.Date date) throws Exception{
        Claves cla =new Claves();
        String cadena=cod_certifica+"\n"+cod_ente+"\n"+nombre_ente+"\n"+nit_ente+"\n"+date;
        cla.encripta(cadena);
        return cla.encripta(cadena);
    } 
    public void filtro(String consulta, JTable jtableBuscar) {
        DefaultTableModel dm;
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    
    public static void copyFile(File ruta_inicio, File ruta_final)
           throws IOException {
       
       FileChannel source = null;
       FileChannel destination = null;
       source = new FileInputStream(ruta_inicio).getChannel();
       destination = new FileOutputStream(ruta_final).getChannel();
       if (destination != null && source != null) {
           destination.transferFrom(source, 0, source.size());
       }
       if (source != null) {
           source.close();
       }
       if (destination != null) {
           destination.close();
       }

}
}
