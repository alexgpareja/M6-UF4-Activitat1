package com.alex_gil.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.alex_gil.model.*;

public class CategoriaDAO extends GenDAOImpl<Categoria> {

    public CategoriaDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Categoria.class);
    }

    public List<Object[]> comptarLlibresPerCategoria() {
        try (Session session = super.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT c.nomCategoria, COUNT(l) FROM Categoria c LEFT JOIN c.llibres l GROUP BY c.nomCategoria",
                    Object[].class).list();
        } catch (HibernateException e) {
            System.err.println("Error en comptarLlibresPerCategoria(): " + e.getMessage());
            return null;
        }
    }
}