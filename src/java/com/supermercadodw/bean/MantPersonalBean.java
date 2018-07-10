/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.PersonalDAO;
import com.supermercadodw.entidades.Personal;
import com.supermercadodw.utils.MensajeSYSUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author raul
 */
@ManagedBean
@ViewScoped
public class MantPersonalBean extends MensajeSYSUtils implements Serializable{
    
    private Personal personal;
    private PersonalDAO personalDAO;
    private String usuarioPersonal;
    private String passwordPersonal;
    private int idPersonalEliminar;
    
    @PostConstruct
    private void init() {
        initInstancia();
    }
    
    private void initInstancia() {
       personal = new Personal();
       personalDAO = new PersonalDAO();
    }


    public String registrarPersonal(){
        boolean respuesta;
        respuesta = personalDAO.RegistrarPersonal(personal);
        if (respuesta) {
            messageInfo("Se realizo la creación del Personal");
        } else {
            messageError("NO se realizo la creación del Personal");
        }
        return "/Formularios/FrmMantPersonal";
    }
    
    public String modificarPersonal(){
        boolean respuesta;
        respuesta = personalDAO.ModificarPersonal(personal);
        if (respuesta) {
            messageInfo("Se realizo la actualización del Personal");
        } else {
            messageError("NO se realizo la actualización del Personal");
        }
        return "/Formularios/FrmMantPersonal";
    }
    
    public void identificarPersonal(){
        try {
            //producto = productoDAO.obtenerProducto(idProductobuscar);
            personal = personalDAO.obtenerPersonal(usuarioPersonal, passwordPersonal);
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro el producto");           
        }
    }
    
    public String eliminarPersonal(){
        boolean respuesta;
        //respuesta = productoDAO.EliminarProducto(idProductoEliminar);
        respuesta = personalDAO.EliminarPersonal(idPersonalEliminar);
        if (respuesta) {
            messageInfo("Se eliminó al Personal");
        } else {
            messageError("NO se pudo eliminar al Personal");
        }
        return "/Formularios/FrmMantPersonal";
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public PersonalDAO getPersonalDAO() {
        return personalDAO;
    }

    public void setPersonalDAO(PersonalDAO personalDAO) {
        this.personalDAO = personalDAO;
    }

    public String getUsuarioPersonal() {
        return usuarioPersonal;
    }

    public void setUsuarioPersonal(String usuarioPersonal) {
        this.usuarioPersonal = usuarioPersonal;
    }

    public String getPasswordPersonal() {
        return passwordPersonal;
    }

    public void setPasswordPersonal(String passwordPersonal) {
        this.passwordPersonal = passwordPersonal;
    }

}
