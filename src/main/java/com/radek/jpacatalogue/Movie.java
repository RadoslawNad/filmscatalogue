package com.radek.jpacatalogue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String year;
    private double rating;

    @Column(name = "date")
    private LocalDate dateNow = LocalDate.now();

    @ElementCollection
    private List<MoviesRate> rateList = new ArrayList<>();

    @ElementCollection
    private List<String> commentsList = new ArrayList<>();

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public List<MoviesRate> getRateList() {
        return rateList;
    }

    public void setRateList(List<MoviesRate> rateList) {
        this.rateList = rateList;
    }

    public List<String> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<String> commentsList) {
        this.commentsList = commentsList;
    }

    public double calculateRating() {
        double sum = 0;
        for (MoviesRate rateList : rateList) {
            sum += rateList.getRate();
        }
        double retRate = sum /rateList.size();
        return retRate;
    }

    public String toString() {
        return String.format("\t%s. %s(%s) %s\n", id, title, year, rating);
    }

}