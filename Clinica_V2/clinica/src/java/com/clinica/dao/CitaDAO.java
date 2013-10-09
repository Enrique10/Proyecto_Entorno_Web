package com.clinica.dao;

import com.clinica.bean.Cita;
import com.clinica.bean.Especialidad;
import com.clinica.bean.Paciente;
import com.clinica.bean.Persona;
import com.clinica.util.DBconex;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    private Connection cn = DBconex.getConexion();
    private PreparedStatement pt;
    private CallableStatement call;
    private ResultSet rs;

    public List<Cita> lista_busquedaCita() {
        List<Cita> lista = null;
        try {
            lista = new ArrayList<Cita>();
            String cadena = "select c.*, per.dni_psn, per.nomb_psn, per.apepat_psn, per.apemat_psn, " + 
                            "espe.* from cita c, persona per, especialidad espe, paciente paci  " + 
                            "where c.id_paci=paci.id_paci and c.id_espe=espe.id_espe and paci.id_psn=per.id_psn;";            
            pt = cn.prepareStatement(cadena);
            rs = pt.executeQuery();
            Cita cita = new Cita();
            while (rs.next()) {
                
                Persona persona = new Persona();
                persona.setDni_psn(rs.getString("dni_psn"));
                persona.setApepat_psn(rs.getString("nomb_psn"));
                persona.setApemat_psn(rs.getString("apepat_psn"));
                
                Paciente paciente = new Paciente();
                paciente.setPersona(persona);            
                
                Especialidad especialidad = new Especialidad();
                especialidad.setId_espe(Long.MIN_VALUE);
                especialidad.setNomb_espe(cadena);
                
                cita = new Cita();
                cita.setHoraCita(rs.getString("hor_cta"));
                cita.setId_cta(Long.valueOf(rs.getString("id_cta")));
                cita.setFec_cta(rs.getString("fec_cta"));
                cita.setId_paci(rs.getString("id_paci"));
                cita.setPaciente(paciente);
                cita.setEspecialidad(especialidad);
                lista.add(cita);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }
}
