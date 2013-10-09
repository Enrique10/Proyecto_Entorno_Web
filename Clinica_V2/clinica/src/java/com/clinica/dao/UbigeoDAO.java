package com.clinica.dao;

import com.clinica.bean.Departamento;
import com.clinica.bean.Distrito;
import com.clinica.bean.Provincia;
import com.clinica.util.DBconex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UbigeoDAO {

    private Connection cn = DBconex.getConexion();
    private PreparedStatement pt;
    private ResultSet rs;

    public List<Departamento> lista_departamento() {
        List<Departamento> lista = null;
        try {
            lista = new ArrayList<Departamento>();
            pt = cn.prepareStatement("select * from departamento order by desc_depa asc");
            rs = pt.executeQuery();
            Departamento depa = new Departamento();
            while (rs.next()) {
                depa = new Departamento();
                depa.setId_depa(Integer.valueOf(rs.getString("id_depa")));
                depa.setDesc_depa(rs.getString("desc_depa"));
                lista.add(depa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<Provincia> lista_provincia(Long pid_depa) {
        List<Provincia> lista = null;
        try {
            lista = new ArrayList<Provincia>();
            pt = cn.prepareStatement("select * from provincia where id_depa=" + pid_depa + 
                    " order by desc_prov asc");
            rs = pt.executeQuery();
            Provincia provi = new Provincia();
            while (rs.next()) {
                provi = new Provincia();
                provi.setId_prov(Long.valueOf(rs.getString("id_prov")));
                provi.setId_depa(Long.valueOf(rs.getString("id_depa")));
                provi.setDesc_prov(rs.getString("desc_prov"));
                lista.add(provi);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
     public List<Distrito> lista_distrito(Long pid_depa, Long pid_prov) {
        List<Distrito> lista = null;
        try {
            lista = new ArrayList<Distrito>();
            pt = cn.prepareStatement("select * from distrito where id_depa=" + pid_depa + " and " + 
                    "id_prov = " + pid_prov + " order by desc_dist asc");
            System.out.println("select * from distrito where id_depa=" + pid_depa + " and " + 
                    "id_prov = " + pid_prov + " order by desc_dist asc");
            rs = pt.executeQuery();
            Distrito dist = new Distrito();
            while (rs.next()) {
                dist = new Distrito();
                dist.setId_dist(Integer.valueOf(rs.getString("id_dist")));
                dist.setId_prov(Integer.valueOf(rs.getString("id_prov")));
                dist.setId_depa(Integer.valueOf(rs.getString("id_depa")));
                dist.setDesc_dist(rs.getString("desc_dist"));
                lista.add(dist);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
