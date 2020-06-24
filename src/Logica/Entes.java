/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author argue
 */
public class Entes {
    private String ente="SELECT * FROM tb_ENTE";
    private String depto="Select * from tb_departamento";
    private String inserta = "INSERT INTO Certificado_ente (cod_certificado,cod_ente,nombre_ente,nit_ente,fecha_creacion) VALUES (?, ?, ?, ?,?)";
    private String procedimiento="{call db_rem.SPREM_SEC_CERTIFICADO(?)}";
    public String ente(){
        return ente;
    }
    public String depto(){
        return depto;
    }
    public String inserta(){
        return inserta;
    }
    public String procedimineto(){
        return procedimiento;
    }
}
