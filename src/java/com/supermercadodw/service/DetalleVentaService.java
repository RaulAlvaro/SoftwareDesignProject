/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.DetalleVenta;
import java.util.List;

/**
 *
 * @author raul
 */
public interface DetalleVentaService {
    public abstract boolean RegistrarDetalleVenta(DetalleVenta detalleVenta);
    public abstract List<DetalleVenta> ListarDetallesVenta(int idVenta);
    
}
