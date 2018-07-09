/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.Producto;
import java.util.List;

/**
 *
 * @author RAUL
 */
public interface ProductoService {
    public abstract boolean RegistrarProducto(Producto producto);
    public abstract boolean ModificarProducto(Producto producto);
    public abstract Producto obtenerProducto(String idProducto);
    public abstract List<Producto> ListarProductos();
    public abstract boolean EliminarProducto(String idProducto);
    
}
