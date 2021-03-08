package com.company.repository;

import com.company.IDB;
import com.company.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Review_Rep implements IReview_Rep {

    private final IDB db;
    public Review_Rep(IDB db){
        this.db = db;
    }

    @Override
    public List<Review> getAllReviews() throws SQLException {
        Connection con = null;
        List<Review> ret = new ArrayList<>();
        try {
            con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM reviews");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Review rv = new Review();
                rv.setId(rs.getLong(1));
                rv.setText(rs.getString(2));
                rv.setScore(rs.getInt(3));
                rv.setName(rs.getString(4));
                rv.setGender(rs.getString(5));
                ret.add(rv);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(con!=null) con.close();
        }
        return  ret;
    }

    @Override
    public void createReview(Review review) throws SQLException {
        List<Review> ret = new ArrayList<>();
        try (Connection con = db.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO reviews (text, score, name, gender) VALUES(?,?,?,?)");
            pstmt.setString(1, review.getText());
            pstmt.setInt(2, review.getScore());
            pstmt.setString(3, review.getName());
            pstmt.setString(4, review.getGender());
            pstmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> getAllPos() throws SQLException {
        Connection con = null;
        List<Review> ret = new ArrayList<>();
        try {
            con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM reviews WHERE score>5");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Review rv = new Review();
                rv.setId(rs.getLong(1));
                rv.setText(rs.getString(2));
                rv.setScore(rs.getInt(3));
                rv.setName(rs.getString(4));
                rv.setGender(rs.getString(5));
                ret.add(rv);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(con!=null) con.close();
        }
        return  ret;
    }

    @Override
    public List<Review> getAllNeg() throws SQLException {
        Connection con = null;
        List<Review> ret = new ArrayList<>();
        try {
            con = db.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM reviews WHERE score<6");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Review rv = new Review();
                rv.setId(rs.getLong(1));
                rv.setText(rs.getString(2));
                rv.setScore(rs.getInt(3));
                rv.setName(rs.getString(4));
                rv.setGender(rs.getString(5));
                ret.add(rv);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(con!=null) con.close();
        }
        return  ret;
    }
}
