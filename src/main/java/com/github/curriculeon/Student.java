package com.github.curriculeon;


import java.util.Arrays;
import java.util.Collection;

public class Student implements Comparable<Student> {

    private String firstName;

    private String lastName;

    private Double[] scores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = testScores;
    }

    public Student() {
        this.firstName = null;
        this.lastName = null;
        this.scores = new Double[0];
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double[] getExamScores() {
        return scores;
    }

    public void addExamScore(double examScore) {
        Double[] update = new Double[scores.length+1];
        System.arraycopy(scores, 0, update, 0, scores.length);
        update[update.length-1] = examScore;
        scores = update;
    }


    public void setExamScore(int examNum, double updateScore) {
        scores[examNum] = updateScore;
    }


    public Double getAverageExamScore() {
        double avg = 0;
        for (double score : scores){
            avg+=score;
        }
        return avg/scores.length;
    }

    @Override
    public String toString() {
        String record = firstName + " " + lastName+":";
        for (double score : scores){
            record += " "+score;
        }
        return record;
    }

    /**
     * @param studentToCompareAgainst the object to be compared; compare by grade, then by name
     * @return
     */
    @Override
    public int compareTo(Student studentToCompareAgainst) {
        double compare = getAverageExamScore();
        double compareAgainst = studentToCompareAgainst.getAverageExamScore();
        if (compare == compareAgainst){
            return studentToCompareAgainst.getLastName().compareTo(lastName);
        }
        return (studentToCompareAgainst.getAverageExamScore().compareTo(getAverageExamScore()));
        /*
        if(getAverageExamScore()< studentToCompareAgainst.getAverageExamScore()){
            return -1;
        }
        else if(getAverageExamScore()> studentToCompareAgainst.getAverageExamScore()){
            return 1;
        }
        else{
            return firstName.compareTo(studentToCompareAgainst.getFirstName());
        }

         */

        //return Integer.valueOf(null);
    }
}

