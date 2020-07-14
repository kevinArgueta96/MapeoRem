/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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

public class funciones {

    conexcion con = new conexcion();
    Entes en = new Entes();

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

    public void inserta(String cod_certifica, int cod_ente, String nombre_ente, int nit_ente) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try {
            PreparedStatement str = con.getConnection().prepareStatement(en.inserta());

            str.setString(1, cod_certifica);
            str.setInt(2, cod_ente);
            str.setString(3, nombre_ente);
            str.setInt(4, nit_ente);
            str.setDate(5, date);
            str.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex);

        }
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
