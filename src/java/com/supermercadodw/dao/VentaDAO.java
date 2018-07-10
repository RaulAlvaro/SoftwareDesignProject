/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.Venta;
import com.supermercadodw.service.VentaService;
import com.supermercadodw.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raul
 */
public class VentaDAO implements VentaService{
    
    private static Transaction transaction;
    private static Session session;

    @Override
    public boolean RegistrarVenta(Venta venta) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(venta);
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
    public Venta buscarVenta() {
        Venta venta = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from Venta v where maxelement(v.idVenta)";
            Query query = session.createQuery(queryString);
            venta = (Venta) query.uniqueResult();
            return venta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean ActualizarMontoVenta(Venta venta) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(venta);
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
    

    
}
