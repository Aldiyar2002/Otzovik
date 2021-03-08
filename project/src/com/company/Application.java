package com.company;

import com.company.repository.Review_Rep;

import java.util.List;
import java.util.Scanner;
public class Application {
    private final Review_Rep controller;
    private final Scanner scanner;
    private final Scanner scannerInt;

    public Application(){
        controller = new Review_Rep(new DB());
        scanner = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to Otzovik");
            System.out.println("Choose what you want to do:");
            System.out.println("1) View all reviews");
            System.out.println("2) Write a review");
            System.out.println("3) View all positive reviews");
            System.out.println("4) View all negative reviews");
            System.out.println("5) Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scannerInt.nextInt();
                if(option == 1){
                    getAllReviews();
                }
                else if(option == 2){
                    createReview();
                }
                else if(option == 3){
                    getPosReviews();
                }
                else if(option == 4){
                    getNegReviews();
                }
                else if(option == 5){
                    return;
                }
                else{
                    break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("==============================================");
        }
    }

    public void getAllReviews(){
        try {
            List<Review> reviews = controller.getAllReviews();
            for (Review r: reviews) {
                System.out.println(r.getId()+" ; "+r.getText()+" ; "+r.getScore()+" ; "+r.getName()+ " ; "+r.getGender());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void createReview() {
        try {
            Review rv = new Review();
            System.out.print("Enter your review: ");
            rv.setText(scanner.nextLine());
            System.out.print("Enter rating (1-10): ");
            rv.setScore(scannerInt.nextInt());
            System.out.print("Enter your name: ");
            rv.setName(scanner.nextLine());
            System.out.print("Enter your gender (M/W): ");
            rv.setGender(scanner.nextLine());
            controller.createReview(rv);
            System.out.println("Saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getPosReviews(){
        try{
        List<Review> reviews = controller.getAllPos();
            for (Review r: reviews) {
                System.out.println(r.getId()+" ; "+r.getText()+" ; "+r.getScore()+" ; "+r.getName()+ " ; "+r.getGender());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void getNegReviews(){
        try{
        List<Review> reviews = controller.getAllNeg();
            for (Review r: reviews) {
                System.out.println(r.getId()+" ; "+r.getText()+" ; "+r.getScore()+" ; "+r.getName()+ " ; "+r.getGender());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
