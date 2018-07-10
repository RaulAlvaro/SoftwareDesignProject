/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.DetalleVentaDAO;
import com.supermercadodw.dao.ProductoDAO;
import com.supermercadodw.dao.VentaDAO;
import com.supermercadodw.entidades.DetalleVenta;
import com.supermercadodw.entidades.Producto;
import com.supermercadodw.entidades.Venta;
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
public class MantDetalleVentaBeanTest extends MensajeSYSUtils implements Serializable{
    
    private Venta venta;
    private VentaDAO ventaDAO;
    private Producto producto;
    private ProductoDAO productoDAO;
    private DetalleVenta detalleVenta;
    private DetalleVentaDAO detalleVentaDAO;
    private int cantProductos;
    private String idProductoBuscar;
    
    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {
        venta = new Venta();
        producto = new Producto();
        detalleVenta = new DetalleVenta();
        ventaDAO = new VentaDAO();
        productoDAO = new ProductoDAO();
        detalleVentaDAO = new DetalleVentaDAO();
    }
    
    public String registrarDetalleVenta(){
        venta = ventaDAO.buscarVenta();
        producto = productoDAO.obtenerProducto(idProductoBuscar);
         detalleVenta.setVenta(venta);
         detalleVenta.setProducto(producto);
         detalleVenta.setCantidadProductoVenta(cantProductos);
         detalleVenta.setMontoFinalProductoVenta(producto.getPrecioProducto()*cantProductos);
         detalleVentaDAO.RegistrarDetalleVenta(detalleVenta);
        return "/Formularios/FrmMantDetalleVenta";
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
    }

    public String getIdProductoBuscar() {
        return idProductoBuscar;
    }

    public void setIdProductoBuscar(String idProductoBuscar) {
        this.idProductoBuscar = idProductoBuscar;
    }

    
}
