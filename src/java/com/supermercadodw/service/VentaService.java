/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.Venta;

/**
 *
 * @author raul
 */
public interface VentaService {
    public abstract boolean RegistrarVenta(Venta venta);
    public abstract Venta buscarVenta();
    public abstract boolean ActualizarMontoVenta(Venta venta);
}
