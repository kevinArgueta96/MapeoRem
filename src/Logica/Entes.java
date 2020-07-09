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

    private String ente = "SELECT * FROM tb_ENTE";
    private String depto = "select codigo, nombre from TB_DEPARTAMENTO";
    private String inserta = "INSERT INTO Certificado_ente (cod_certificado,cod_ente,nombre_ente,nit_ente,fecha_creacion) VALUES (?, ?, ?, ?,?)";
    private String procedimiento = "{call db_rem.SPREM_SEC_CERTIFICADO(?)}";
    private String mun,mun_c;
    private String ubica_query_cobertura;
    
    public String ente() {
        return ente;
    }

    public String depto() {
        return depto;
    }

    public String inserta() {
        return inserta;
    }

    public String procedimineto() {
        return procedimiento;
    }

    public String muni(String dato) {
         mun="Select codigo, nombre from tb_municipio where codigo_depto="+dato;
        return mun;
    }
    public String muni_c(String dato) {
         mun_c="Select count(*) from tb_municipio where codigo_depto='"+dato+"'";
        return mun_c;
    }
    public String depto_cobertura(String dato){
        String devuelve;
        devuelve=ubica_query_cobertura="select * from VW_COBERTURA_ENTES WHERE DEPARTAMENTO='"+dato+"'";
        return devuelve;
    }
    public String muni_cobertura(String dato){
        String devuelve;
        devuelve=ubica_query_cobertura="select * from VW_COBERTURA_ENTES WHERE MUNICIPIO='"+dato+"'";
        return devuelve;
    }
}
