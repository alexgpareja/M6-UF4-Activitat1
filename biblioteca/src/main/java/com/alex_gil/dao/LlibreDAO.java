package com.alex_gil.dao;

import com.alex_gil.model.Llibre;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LlibreDAO extends GenDAOImpl<Llibre> {

    public LlibreDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Llibre.class);
    }
   
    // Obtenir llibres disponibles (sense reserva)
    public List<Llibre> obtenirLlibresDisponibles() {
        try (Session ses = super.getSessionFactory().openSession()) {
            return ses.createQuery("FROM Llibre l WHERE l.reserva IS NULL", Llibre.class).list();
        } catch (HibernateException e) {
            System.err.println("Error en obtenirLlibresDisponibles(): " + e.getMessage());
            return null; // Retorna null si hi ha un error
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            return null; // Retorna null si hi ha un error inesperat
        }
    }
}
