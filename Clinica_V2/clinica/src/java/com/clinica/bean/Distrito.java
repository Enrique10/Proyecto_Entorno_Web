package com.clinica.bean;

public class Distrito {

    private int id_dist;
    private int id_prov;
    private int id_depa;
    private String desc_dist;

    public String getDesc_dist() {
        return desc_dist;
    }

    public void setDesc_dist(String desc_dist) {
        this.desc_dist = desc_dist;
    }

    public int getId_depa() {
        return id_depa;
    }

    public void setId_depa(int id_depa) {
        this.id_depa = id_depa;
    }

    public int getId_dist() {
        return id_dist;
    }

    public void setId_dist(int id_dist) {
        this.id_dist = id_dist;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }   
    
    
}
