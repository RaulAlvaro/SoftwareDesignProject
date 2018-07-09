/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermercadodw.dao;

import com.supermercadodw.entidades.Producto;
import com.supermercadodw.service.ProductoService;
import com.supermercadodw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author RAUL
 */
public class ProductoDAO implements ProductoService {

    private static Transaction transaction;
    private static Session session;

    @Override
    public boolean RegistrarProducto(Producto producto) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(producto);
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
    public boolean ModificarProducto(Producto producto) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(producto);
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
    public Producto obtenerProducto(String idProducto) {
        Producto producto = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from Producto where idProducto = :idToFind";
            Query query = session.createQuery(queryString);
            query.setString("idToFind", idProducto);
            producto = (Producto) query.uniqueResult();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Producto> ListarProductos() {
        List<Producto> producto = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = " from Producto";
            Query query = session.createQuery(hql);
            List<Producto> listarProducto = (List<Producto>) query.list();
            return listarProducto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean EliminarProducto(String idProducto) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Producto producto = (Producto) session.load(Producto.class, new Integer(idProducto));
            session.delete(producto);
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
