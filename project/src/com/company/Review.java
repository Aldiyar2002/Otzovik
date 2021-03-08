package com.company;

import java.util.Objects;

public class Review {
    private long id;
    private String text;
    private int score;
    private String name;
    private String gender;

    public Review() {
    }

    public Review(int id, String text, int score) {
        this.id = id;
        this.text = text;
        this.score = score;
    }

    public Review(String text, int score) {
        this.text = text;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && score == review.score && Objects.equals(text, review.text) && Objects.equals(name, review.name) && Objects.equals(gender, review.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, score, name, gender);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
