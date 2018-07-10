/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.Cliente;
import com.supermercadodw.service.ClienteService;
import com.supermercadodw.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raul
 */
public class ClienteDAO implements ClienteService{
    
    private static Transaction transaction;
    private static Session session;
    
    @Override
    public boolean RegistrarCliente(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(cliente);
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
    public boolean ModificarCliente(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(cliente);
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
    public Cliente ObtenerCliente(int dniCliente) {
        Cliente cliente = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from Cliente where dniCliente = :dniCliente";
            Query query = session.createQuery(queryString);
            query.setInteger("dniCliente", dniCliente);
            cliente = (Cliente) query.uniqueResult();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean EliminarCliente(int dniCliente) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Cliente cliente = (Cliente) session.load(Cliente.class, new Integer(dniCliente));
            session.delete(cliente);
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        } finally {
            session.flush();
            session.close();
        }
    }
    
}
