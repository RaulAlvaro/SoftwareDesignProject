/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.ClienteDAO;
import com.supermercadodw.dao.PersonalDAO;
import com.supermercadodw.dao.VentaDAO;
import com.supermercadodw.entidades.Cliente;
import com.supermercadodw.entidades.Personal;
import com.supermercadodw.entidades.Venta;
import com.supermercadodw.utils.MensajeSYSUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author raul
 */
@ManagedBean
@ViewScoped
public class MantVentaBeanTest extends MensajeSYSUtils implements Serializable{
    
    private Venta venta;
    private VentaDAO ventaDAO;
    private Personal personal;
    private PersonalDAO personalDAO;
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    private String usuarioPersonalbuscar;
    private String passwordPersonalbuscar;
    private int dniClientebuscar;
    private float montoventaactualizar;
    
    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {
        venta = new Venta();
        ventaDAO = new VentaDAO();
        personal = new Personal();
        personalDAO = new PersonalDAO();
        cliente = new Cliente();
        clienteDAO = new ClienteDAO();
    }
    
    public Date obtenerFechayHora(){
        //DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(hourdateFormat.format(date));
        java.util.Date fechaActual = new java.util.Date(); 
        System.out.println(fechaActual);
        return fechaActual;
    }
    
    public String registrarVenta(){
        boolean respuesta;
        personal = personalDAO.obtenerPersonal(usuarioPersonalbuscar, passwordPersonalbuscar);
        cliente = clienteDAO.ObtenerCliente(dniClientebuscar);
        venta.setPersonal(personal);
        venta.setCliente(cliente);
        venta.setMontoVenta(0f);
        venta.setFechaVenta(obtenerFechayHora());
        
        respuesta = ventaDAO.RegistrarVenta(venta);
        if (respuesta) {
            messageInfo("Se realizo la creación de la Venta");
        } else {
            messageError("NO se realizo la creación de la Venta");
        }
        return "/Formularios/FrmMantVentaTest";
    }
    
     public String modificarVenta(){
        boolean respuesta;
        venta.setMontoVenta(montoventaactualizar);
        respuesta = ventaDAO.ActualizarMontoVenta(venta);
        if (respuesta) {
            messageInfo("Se realizo la actualización del Personal");
        } else {
            messageError("NO se realizo la actualización del Personal");
        }
        return "/Formularios/FrmMantVentaTest";
    }
    
    public void identificarUltimaVenta(){
        try {
            //producto = productoDAO.obtenerProducto(idProductobuscar);
            venta = ventaDAO.buscarVenta();
            cliente = venta.getCliente();
            personal = venta.getPersonal();
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro el producto");           
        }
    } 
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUsuarioPersonalbuscar() {
        return usuarioPersonalbuscar;
    }

    public void setUsuarioPersonalbuscar(String usuarioPersonalbuscar) {
        this.usuarioPersonalbuscar = usuarioPersonalbuscar;
    }

    public String getPasswordPersonalbuscar() {
        return passwordPersonalbuscar;
    }

    public void setPasswordPersonalbuscar(String passwordPersonalbuscar) {
        this.passwordPersonalbuscar = passwordPersonalbuscar;
    }

    public int getDniClientebuscar() {
        return dniClientebuscar;
    }

    public void setDniClientebuscar(int dniClientebuscar) {
        this.dniClientebuscar = dniClientebuscar;
    }

    public float getMontoventaactualizar() {
        return montoventaactualizar;
    }

    public void setMontoventaactualizar(float montoventaactualizar) {
        this.montoventaactualizar = montoventaactualizar;
    }
       
    
}
