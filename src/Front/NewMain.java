/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Front;

import Logica.conexcion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.*;
import java.util.Calendar;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 *
 * @author argue
 */
public class NewMain {

    public static void main(String[] args) {
        conexcion con = new conexcion();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println(date);
       // System.out.println(fecha.getMonth());
        /*  try {
           
            CallableStatement cst = con.getConnection().prepareCall("{call db_rem.SPREM_SEC_CERTIFICADO(?)}");
            cst.registerOutParameter(1,java.sql.Types.VARCHAR);
         
            cst.execute();
            String nombre = cst.getString(1);
            System.out.println(nombre);
            //con.desconectar();
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
         */
    }
}
