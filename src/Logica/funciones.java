/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

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
}
