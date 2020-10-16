/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Front.Claves;
import Front.Qr_img;
import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class funciones {

    conexcion con = new conexcion();
    Entes en = new Entes();

    public String clave(String nit_ente) {
        Statement st;
        String clave = "";

        try {
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

    public String nit_ente(String nit_ente) {
        Statement st;
        String cod_certifica = "";

        try {
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

    public void cambio_estado(String nit_ente) {
        Connection cnc = con.getConnection();
        try {
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
        String[] encrip = new String[2];
        encrip = encripta(cod_certifica, nombre_ente, nit_ente, date);
        JTextField txt = new JTextField();
        txt.setText(encrip[1]);
        txt.setEditable(false);

        //JOptionPane.showConfirmDialog(null, "CONTRASEÑA DEL CERTIFICADO:\n" +encrip[1], "CONTRASEÑA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, txt);
        try {
            PreparedStatement str = con.getConnection().prepareStatement(en.inserta());

            str.setString(1, cod_certifica);
            str.setInt(2, cod_ente);
            str.setString(3, nombre_ente);
            str.setLong(4, nit_ente);
            str.setDate(5, date);
            str.setString(6, "A");
            str.setString(7, encrip[1]);
            str.setString(8, encrip[0]);
            str.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    private String[] encripta(String cod_certifica, String nombre_ente, long nit_ente, java.sql.Date date) throws Exception {
        Claves cla = new Claves();
        String datos[] = new String[2];
        String Key = cla.key();
        String cadena = "CERTIFICADO: " + cod_certifica + "\nNOMBRE DEL ENTE: " + nombre_ente + "\nNIT DEL ENTE: " + nit_ente + "\nFECHA CREACION ENTE: " + date;
        datos[0] = Key;
        datos[1] = cla.encripta(cadena, Key);
        return datos;
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
    public void pdf_certi(String nit, String cod_certifica, String ruta) throws WriterException, IOException {
        Qr_img generaQR = new Qr_img();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String fecha = date.toString();
        String qr = "CORRELATIVO: " + cod_certifica + "\nNIT DEL ENTE: " + nit + "\n" + "FECHA INSCRIPCION: " + fecha;
        BufferedImage imagen = generaQR.crearQR(qr, 300, 300);
        //BufferedImage imagen = ImageIO.read(new FileInputStream("diseño/logo.png"));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nit_ente", new String(nit));
        parametros.put("cod_certificado", new String(cod_certifica));
        parametros.put("img_qr", imagen);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    "C:\\Diseño Reporte\\rem.jasper", parametros,
                    con.getConnection());
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jasperPrint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("C:\\Reportes\\" + cod_certifica + ".pdf"));
            JOptionPane.showMessageDialog(null, "EL REPORTE FUE GUARDADO EN: " + ruta);
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();

            // se muestra en una ventana aparte para su descarga
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
                    "C:\\Diseño Reporte\\rem.jasper", parametros,
                    con.getConnection());
            JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);
            jasperViewer.setVisible(true);

        } catch (JRException ex) {
            System.out.print(ex);
        }
    }
}
