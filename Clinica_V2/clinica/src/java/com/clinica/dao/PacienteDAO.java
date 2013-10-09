/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinica.dao;

import com.clinica.bean.Paciente;
import com.clinica.bean.Persona;
import com.clinica.util.DBconex;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection cn = DBconex.getConexion();
    private PreparedStatement pt;
    private CallableStatement call;
    private ResultSet rs;

    public List<Paciente> lista_busquedaPaciente(String pdni_paci, String pnomb_paci) {
        List<Paciente> lista = null;
        try {
            lista = new ArrayList<Paciente>();
            String cadena = "select pa.id_paci, pa.fecing_paci, per.* from paciente pa, persona per " + 
                    "where pa.id_psn = per.id_psn and per.dni_psn like '%" + pdni_paci + "%' " + 
                    "and per.nomb_psn like '%" + pnomb_paci + "%'";
            System.out.println(cadena);
            pt = cn.prepareStatement(cadena);
            rs = pt.executeQuery();
            Paciente paciente = new Paciente();
            Persona persona = new Persona();
            while (rs.next()) {
                persona = new Persona();
                persona.setId_psn(Integer.parseInt(rs.getString("id_psn")));
                persona.setDni_psn(rs.getString("dni_psn"));
                persona.setNomb_psn(rs.getString("nomb_psn"));
                persona.setApepat_psn(rs.getString("apepat_psn"));
                persona.setApemat_psn(rs.getString("apemat_psn"));
                persona.setSexo_psn(rs.getString("sexo_psn"));
                persona.setFecnac_psn(rs.getString("fecnac_psn"));
                persona.setLugnac_psn(rs.getString("lugnac_psn"));
                persona.setDepa_psn(Long.valueOf(rs.getString("depa_psn")));
                persona.setProv_psn(Long.valueOf(rs.getString("prov_psn")));
                persona.setDist_psn(Long.valueOf(rs.getString("dist_psn")));
                persona.setDire_psn(rs.getString("dire_psn"));
                persona.setTelef_psn(rs.getString("telef_psn"));
                persona.setMovil_psn(rs.getString("movil_psn"));

                paciente = new Paciente();
                paciente.setId_paci(Long.valueOf(rs.getString("id_paci")));
                paciente.setFecing_paci(rs.getString("fecing_paci"));
                paciente.setPersona(persona);
                lista.add(paciente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public int registraPaciente(Persona persona) {
        int i = 0;
        try {
            String cadena = "{ call sp_ins_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            call = cn.prepareCall(cadena);

            call.setString(1, persona.getDni_psn());
            call.setString(2, persona.getNomb_psn());
            call.setString(3, persona.getApepat_psn());
            call.setString(4, persona.getApemat_psn());
            call.setString(5, persona.getSexo_psn());
            call.setString(6, persona.getFecnac_psn());
            call.setString(7, persona.getLugnac_psn());
            call.setLong(8, persona.getDepa_psn());
            call.setLong(9, persona.getProv_psn());
            call.setLong(10, persona.getDist_psn());
            call.setString(11, persona.getDire_psn());
            call.setString(12, persona.getTelef_psn());
            call.setString(13, persona.getMovil_psn());
            i = call.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    public int editaPaciente(Persona persona) {
        int i = 0;
        try {
            String cadena = "{ call sp_upd_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            call = cn.prepareCall(cadena);
            call.setInt(1, persona.getId_psn());
            call.setString(2, persona.getDni_psn());
            call.setString(3, persona.getNomb_psn());
            call.setString(4, persona.getApepat_psn());
            call.setString(5, persona.getApemat_psn());
            call.setString(6, persona.getSexo_psn());
            call.setString(7, persona.getFecnac_psn());
            call.setString(8, persona.getLugnac_psn());
            call.setLong(9, persona.getDepa_psn());
            call.setLong(10, persona.getProv_psn());
            call.setLong(11, persona.getDist_psn());
            call.setString(12, persona.getDire_psn());
            call.setString(13, persona.getTelef_psn());
            call.setString(14, persona.getMovil_psn());
            i = call.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
}
