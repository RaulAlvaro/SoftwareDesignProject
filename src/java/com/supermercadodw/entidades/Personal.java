package com.supermercadodw.entidades;
// Generated 11/07/2018 01:39:17 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Personal generated by hbm2java
 */
public class Personal  implements java.io.Serializable {


     private Integer idPersonal;
     private String nombrePersonal;
     private String apellidoMaternoPersonal;
     private String apellidoPaternoPersonal;
     private String usuarioPersonal;
     private String passwordPersonal;
     private Set ventas = new HashSet(0);

    public Personal() {
    }

    public Personal(String nombrePersonal, String apellidoMaternoPersonal, String apellidoPaternoPersonal, String usuarioPersonal, String passwordPersonal, Set ventas) {
       this.nombrePersonal = nombrePersonal;
       this.apellidoMaternoPersonal = apellidoMaternoPersonal;
       this.apellidoPaternoPersonal = apellidoPaternoPersonal;
       this.usuarioPersonal = usuarioPersonal;
       this.passwordPersonal = passwordPersonal;
       this.ventas = ventas;
    }
   
    public Integer getIdPersonal() {
        return this.idPersonal;
    }
    
    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }
    public String getNombrePersonal() {
        return this.nombrePersonal;
    }
    
    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }
    public String getApellidoMaternoPersonal() {
        return this.apellidoMaternoPersonal;
    }
    
    public void setApellidoMaternoPersonal(String apellidoMaternoPersonal) {
        this.apellidoMaternoPersonal = apellidoMaternoPersonal;
    }
    public String getApellidoPaternoPersonal() {
        return this.apellidoPaternoPersonal;
    }
    
    public void setApellidoPaternoPersonal(String apellidoPaternoPersonal) {
        this.apellidoPaternoPersonal = apellidoPaternoPersonal;
    }
    public String getUsuarioPersonal() {
        return this.usuarioPersonal;
    }
    
    public void setUsuarioPersonal(String usuarioPersonal) {
        this.usuarioPersonal = usuarioPersonal;
    }
    public String getPasswordPersonal() {
        return this.passwordPersonal;
    }
    
    public void setPasswordPersonal(String passwordPersonal) {
        this.passwordPersonal = passwordPersonal;
    }
    public Set getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set ventas) {
        this.ventas = ventas;
    }




}


