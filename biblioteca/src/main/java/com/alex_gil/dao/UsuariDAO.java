package com.alex_gil.dao;

import com.alex_gil.model.Usuari;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UsuariDAO extends GenDAOImpl<Usuari> {

    public UsuariDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Usuari.class);
    }

    // Llegir un usuari pel seu DNI
    public Usuari read(String dni) {
        try (Session ses = super.getSessionFactory().openSession()) {
            // Executar la consulta per trobar l'usuari pel DNI
            Usuari usuari = ses.createQuery("FROM Usuari WHERE dni = :dni", Usuari.class)
                    .setParameter("dni", dni)
                    .uniqueResult();

            // Comprovem si l'usuari és null
            if (usuari == null) {
                System.out.println("❌ No s'ha trobat cap usuari amb el DNI: " + dni);
            } else {
                System.out.println("🆔 Usuari trobat: " + usuari);
            }
            return usuari;
        } catch (HibernateException hbe) {
            System.err.println("Error d'Hibernate: " + hbe.getMessage());
            return null; // Retorna null si no es pot llegir l'usuari
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            return null; // Retorna null si hi ha altres errors
        }
    }
}
