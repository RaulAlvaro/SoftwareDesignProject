/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.Tarjeta;
import com.supermercadodw.service.TarjetaService;
import com.supermercadodw.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author RAUL
 */
public class TarjetaDAO implements TarjetaService{
    
    private static Transaction transaction;
    private static Session session; 

    @Override
    public boolean RegistrarTarjeta(Tarjeta tarjeta) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(tarjeta);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            session.close();
        }
    }

    @Override
    public Tarjeta BuscarTarjeta(int idTarjeta) {
        Tarjeta tarjeta = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from Tarjeta where idTarjeta = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idTarjeta);
            tarjeta = (Tarjeta) query.uniqueResult();
            return tarjeta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }  
}
