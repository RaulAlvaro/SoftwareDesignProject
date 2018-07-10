/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.service;

import com.supermercadodw.entidades.Personal;
import com.supermercadodw.entidades.Producto;

/**
 *
 * @author raul
 */
public interface PersonalService {
    public abstract boolean RegistrarPersonal(Personal personal);
    public abstract boolean ModificarPersonal(Personal personal);
    public abstract Personal obtenerPersonal(String usuario, String passwrod);
    public abstract boolean EliminarPersonal(int idPersonal);
    
    
    
    
}
