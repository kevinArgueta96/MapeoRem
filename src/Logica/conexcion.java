package Logica;

import java.sql.*;
import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author argue
 */
public class conexcion {

    static Connection cnc;
    static Statement st;
    private static final String user = "db_rem";
    private static final String pass = "db_rem";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    public conexcion() {
        try {
            cnc = DriverManager.getConnection(url, user, pass);
           
            st = cnc.createStatement();
            if (cnc != null) {
                //JOptionPane.showMessageDialog(null, "Conexcion exitosa");
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Conexcion fallida"+ ex);
        }
    }

    public Connection getConnection() {
        return cnc;
    }
         

    public void desconectar() {
        try {
            cnc.close();
            cnc=null;
        } catch (Exception ex) {
        }
    }
}
