/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.Cliente;

/**
 *
 * @author raul
 */
public interface ClienteService {
    public abstract boolean RegistrarCliente(Cliente cliente);
    public abstract boolean ModificarCliente(Cliente cliente);
    public abstract Cliente ObtenerCliente(int dniCliente);
    public abstract boolean EliminarCliente(int dniCliente); 
}
