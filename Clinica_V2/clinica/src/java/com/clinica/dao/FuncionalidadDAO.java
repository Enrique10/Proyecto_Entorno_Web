package com.clinica.dao;

import com.clinica.bean.Funcionalidad;
import com.clinica.util.DBconex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GERARDO
 */
public class FuncionalidadDAO {

    private Connection cn = DBconex.getConexion();
    private PreparedStatement pt;
    private ResultSet rs;

    public List<Funcionalidad> listaFuncionalidad() {
        List<Funcionalidad> lista = null;
        try {
            lista = new ArrayList<Funcionalidad>();
            String cadena = "select * from funcionalidad";
            pt = cn.prepareStatement(cadena);
            rs = pt.executeQuery();
            Funcionalidad funcionalidad = new Funcionalidad();
            while (rs.next()) {
                funcionalidad = new Funcionalidad();
                funcionalidad.setId_fnl(Integer.valueOf(rs.getString("id_fnl")));
                funcionalidad.setNomb_fnl(rs.getString("nomb_fnl"));
                funcionalidad.setIcn_fnl(rs.getString("icn_fnl"));
                funcionalidad.setAcc_fnl(rs.getString("acc_fnl"));
                funcionalidad.setIdpd_fnl(Integer.valueOf(rs.getString("idpd_fnl")));
                lista.add(funcionalidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
