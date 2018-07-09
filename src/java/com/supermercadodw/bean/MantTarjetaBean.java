/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.TarjetaDAO;
import com.supermercadodw.entidades.Tarjeta;
import com.supermercadodw.utils.MensajeSYSUtils;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class MantTarjetaBean extends MensajeSYSUtils implements Serializable {

    private Tarjeta tarjeta;
    private TarjetaDAO tarjetaDAO;
    private int idTarjetaBuscar;
    
    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {
        tarjeta = new Tarjeta();
        tarjetaDAO = new TarjetaDAO();
    }

    public String registrarTarjeta() {
        boolean respuesta;
        respuesta = tarjetaDAO.RegistrarTarjeta(tarjeta);
        if (respuesta) {
            messageInfo("Se realizo la creación de la Tarjeta");
        } else {
            messageError("NO se realizo la creación de la Tarjeta");
        }
        return "/Formularios/FrmMantTarjeta";
    }
    
    public void buscarTarjeta(){
        boolean respuesta;
        try {
            tarjeta = tarjetaDAO.BuscarTarjeta(idTarjetaBuscar);
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro a la tarjeta");           
        }
        //return "/Formularios/FrmMantTarjeta";        
    }
    
    public void limpiarcampos(){
        
    }

    public int getIdTarjetaBuscar() {
        return idTarjetaBuscar;
    }

    public void setIdTarjetaBuscar(int idTarjetaBuscar) {
        this.idTarjetaBuscar = idTarjetaBuscar;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
    
    
}
