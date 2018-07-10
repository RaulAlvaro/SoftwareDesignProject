/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.ClienteDAO;
import com.supermercadodw.dao.TarjetaDAO;
import com.supermercadodw.entidades.Cliente;
import com.supermercadodw.entidades.Tarjeta;
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
public class MantClienteBean extends MensajeSYSUtils implements Serializable {

    private Cliente cliente;
    private ClienteDAO clienteDAO;
    private Tarjeta tarjeta;
    private TarjetaDAO tarjetaDAO;
    private int dniClienteBuscar;

    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {
        cliente = new Cliente();
        clienteDAO = new ClienteDAO();
        tarjeta = new Tarjeta();
        tarjetaDAO = new TarjetaDAO();
    }

    public String registrarCliente() {
        boolean respuesta;
        respuesta = tarjetaDAO.RegistrarTarjeta(tarjeta);
        cliente.setTarjeta(tarjeta);
        if (respuesta) {
            respuesta = clienteDAO.RegistrarCliente(cliente);
            if (respuesta) {
                messageInfo("Se realizo la creación del Cliente");
            } else {
                messageError("NO se realizo la creación del Cliente");
            }
        }
        return "/Formularios/FrmMantCliente";
    } 
    
    public String modificarCliente(){
        boolean respuesta;
        respuesta = clienteDAO.ModificarCliente(cliente);
        if (respuesta) {
            messageInfo("Se realizo la actualización del Cliente");
        } else {
            messageError("NO se realizo la actualización del Cliente");
        }
        return "/Formularios/FrmMantCliente";
    }
    
    public void identificarCliente(){
        try {
            cliente = clienteDAO.ObtenerCliente(dniClienteBuscar);
            tarjeta = tarjetaDAO.BuscarTarjeta(cliente.getTarjeta().getIdTarjeta());
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro el cliente");           
        }
    }
    
    public String eliminarCliente(){
        boolean respuesta;
        //respuesta = productoDAO.EliminarProducto(idProductoEliminar);
        //respuesta = personalDAO.EliminarPersonal(idPersonalEliminar);
        respuesta = clienteDAO.EliminarCliente(dniClienteBuscar);
        if (respuesta) {
            messageInfo("Se eliminó al Cliente");
        } else {
            messageError("NO se pudo eliminar al Cliente");
        }
        return "/Formularios/FrmMantCliente";
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getDniClienteBuscar() {
        return dniClienteBuscar;
    }

    public void setDniClienteBuscar(int dniClienteBuscar) {
        this.dniClienteBuscar = dniClienteBuscar;
    }

    
    
    
}
