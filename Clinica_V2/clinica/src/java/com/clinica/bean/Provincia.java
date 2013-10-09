package com.clinica.bean;

public class Provincia {

    private Long id_prov;
    private Long id_depa;
    private String desc_prov;

    public String getDesc_prov() {
        return desc_prov;
    }

    public void setDesc_prov(String desc_prov) {
        this.desc_prov = desc_prov;
    }

    public Long getId_depa() {
        return id_depa;
    }

    public void setId_depa(Long id_depa) {
        this.id_depa = id_depa;
    }

    public Long getId_prov() {
        return id_prov;
    }

    public void setId_prov(Long id_prov) {
        this.id_prov = id_prov;
    }       
    
    
}
