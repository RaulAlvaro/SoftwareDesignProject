/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author JUAN
 */
public class MensajeSYSUtils {
    public void messageError(String sMensaje)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mod. Administración", sMensaje));
    }        
    
    public void messageFatal(String sMensaje)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Mod. Administración", sMensaje));
    }   
    
    public void messageInfo(String sMensaje)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mod. Administración", sMensaje));
    }  
    
    public void messageWarn(String sMensaje)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mod. Administración", sMensaje));
    }     
    
}
