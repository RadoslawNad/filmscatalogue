package com.radek.jpacatalogue;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class MovieDao {
    private final EntityManager entityManager;

    public MovieDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    Insert new record to database by two parameters "title" and "year".
    */

    public void addMovie(Movie model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    /*
    Display all records from data base.
    */
    public List<Movie> showAll() {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m", Movie.class);
        return query.getResultList();
    }

    public void deleteMovie(Movie model) {
        entityManager.getTransaction().begin();
        entityManager.remove(model);
        entityManager.getTransaction().commit();
    }

    public Movie searchById(int id) {
        return entityManager.find(Movie.class, id);
    }

    public List<Movie> searchByRate(double rate) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.rating >= ?1 and m.rating < ?2", Movie.class);
        query.setParameter(1, rate);
        query.setParameter(2, rate + 1);
        return query.getResultList();
    }

    public List<Movie> searchByTitle(String eTitle) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.title LIKE :eTitle", Movie.class);
        query.setParameter("eTitle", "%" + eTitle + "%");
        return query.getResultList();
    }

    public List<Movie> searchByDate(LocalDate eDate) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.dateNow = :eDate", Movie.class);
        query.setParameter("eDate", eDate);
        return query.getResultList();
    }

}
