/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.Personal;
import com.supermercadodw.service.PersonalService;
import com.supermercadodw.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raul
 */
public class PersonalDAO implements PersonalService{
    
    private static Transaction transaction;
    private static Session session;
    
    @Override
    public boolean RegistrarPersonal(Personal personal) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(personal);
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
    public boolean ModificarPersonal(Personal personal) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(personal);
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
    public Personal obtenerPersonal(String usuarioPersonal, String passwordPersonal) {
        Personal personal = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from Personal where usuarioPersonal = :usuarioPersonal and passwordPersonal = :passwordPersonal";
            Query query = session.createQuery(queryString);
            query.setString("usuarioPersonal", usuarioPersonal);
            query.setString("passwordPersonal", passwordPersonal);            
            personal = (Personal) query.uniqueResult();
            return personal;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean EliminarPersonal(int idPersonal) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Personal personal = (Personal) session.load(Personal.class, new Integer(idPersonal));
            session.delete(personal);
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
