package com.hibernateexample.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernateexample.Student;
import com.hibernateexample.util.HibernateUtil;

public class BaseRepository<T> implements IRepository<T> {
    public Class<T> entityClass;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void save(T t) {
        merge(t);
    }

    public void update(T t) {
        merge(t);
    }

    private void merge(T t) {
        Transaction transaction = null;

        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            session.merge(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public T getById(long id) {
        Transaction transaction = null;
        T t = null;

        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            t = session.get(entityClass, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return t;
    }

    public List<T> getAll() {
        Transaction transaction = null;
        List<T> entities = null;

        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entities = session.createQuery("from Student", entityClass).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return entities;
    }

    public void delete(long id) {
        Transaction transaction = null;
        T t = null;

        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            t = session.get(entityClass, id);
            session.remove(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
