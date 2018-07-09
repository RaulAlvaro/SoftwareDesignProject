/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.Tarjeta;
import org.hibernate.Session;

/**
 *
 * @author RAUL
 */
public interface TarjetaService {
    public abstract boolean RegistrarTarjeta(Tarjeta tarjeta);
    public abstract Tarjeta BuscarTarjeta(int idTarjeta);
}
