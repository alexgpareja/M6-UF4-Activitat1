package com.alex_gil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.alex_gil.model.Llibre;

public class MainTest {

    public static void main(String[] args) {
        // Obtenir la sessió de Hibernate
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Comprovar que es pot obrir una sessió
        if (session != null) {
            System.out.println("✅ Connexió a Hibernate establerta correctament!");
        } else {
            System.err.println("❌ Error en establir la connexió a Hibernate.");
        }

        // Crear una transacció de prova
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Testejant una consulta (pot ser una categoria o llibre existent)
            Llibre llibreTest = session.get(Llibre.class, 1);
            if (llibreTest != null) {
                System.out.println("📖 S'ha trobat un llibre: " + llibreTest);
            } else {
                System.out.println("⚠️ No s'ha trobat cap llibre amb ID 1.");
            }

            // Confirmar transacció
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
