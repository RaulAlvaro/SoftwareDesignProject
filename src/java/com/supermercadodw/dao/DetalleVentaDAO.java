/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.DetalleVenta;
import com.supermercadodw.service.DetalleVentaService;
import com.supermercadodw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raul
 */
public class DetalleVentaDAO implements DetalleVentaService{
    
    private static Transaction transaction;
    private static Session session;
    
    @Override
    public boolean RegistrarDetalleVenta(DetalleVenta detalleVenta) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try {
            session.save(detalleVenta);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<DetalleVenta> ListarDetallesVenta(int idVenta) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try {
            String hql = " from DetalleVenta";        
            Query query = session.createQuery(hql);
            List<DetalleVenta> listaDetallesVenta= (List<DetalleVenta>) query.list();
            return listaDetallesVenta;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        
    }
    
}
