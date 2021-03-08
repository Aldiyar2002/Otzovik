package com.company.repository;

import com.company.Review;

import java.sql.SQLException;
import java.util.List;

public interface IReview_Rep {
    List<Review> getAllReviews() throws SQLException;
    void createReview(Review review) throws SQLException;
    List<Review> getAllPos() throws SQLException;
    List<Review> getAllNeg() throws SQLException;
}
