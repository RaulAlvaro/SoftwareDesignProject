/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.bean;

import com.supermercadodw.dao.ProductoDAO;
import com.supermercadodw.dao.TarjetaDAO;
import com.supermercadodw.entidades.Producto;
import com.supermercadodw.entidades.Tarjeta;
import com.supermercadodw.utils.MensajeSYSUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class MantProductoBean extends MensajeSYSUtils implements Serializable{
    
    private String idProductobuscar;
    private String idProductoEliminar;
    private Producto producto;
    private ProductoDAO productoDAO;
    private List<Producto> listadoProductos;
    
    @PostConstruct
    private void init() {
        initInstancia();
    }

    private void initInstancia() {
        producto = new Producto();
        productoDAO = new ProductoDAO();
        listadoProductos = new ArrayList<>();
    }
    
    public String registrarProducto() {
        boolean respuesta;
        respuesta = productoDAO.RegistrarProducto(producto);
        if (respuesta) {
            messageInfo("Se realizo la creación del Producto");
        } else {
            messageError("NO se realizo la creación del Producto");
        }
        return "/Formularios/FrmMantProducto";
    }
    
    public String modificarProducto(){
        boolean respuesta;
        respuesta = productoDAO.ModificarProducto(producto);
        if (respuesta) {
            messageInfo("Se realizo la actualización del Producto");
        } else {
            messageError("NO se realizo la actualización del Producto");
        }
        return "/Formularios/FrmMantProducto";
    }
    
    public void buscarProducto(){
        try {
            producto = productoDAO.obtenerProducto(idProductobuscar);
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro el producto");           
        }
    }
    
    public void listarProductos(){
        try {
            listadoProductos = productoDAO.ListarProductos();
        } catch (Exception e) {
            e.printStackTrace();
            messageError("No se encontro el producto");           
        }
    }
    
    public String eliminarProducto(){
        boolean respuesta;
        respuesta = productoDAO.EliminarProducto(idProductoEliminar);
        if (respuesta) {
            messageInfo("Se realizo la creación del Producto");
        } else {
            messageError("NO se realizo la creación del Producto");
        }
        return "/Formularios/FrmMantProducto";
    }
    
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getIdProductobuscar() {
        return idProductobuscar;
    }

    public void setIdProductobuscar(String idProductobuscar) {
        this.idProductobuscar = idProductobuscar;
    }

    public List<Producto> getListaProductos() {
        return listadoProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listadoProductos = listaProductos;
    }

    public void setIdProductoEliminar(String idProductoEliminar) {
        this.idProductoEliminar = idProductoEliminar;
    }

    public void setListadoProductos(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }
    
    
    
    
    
    
    
    
    
    
}
