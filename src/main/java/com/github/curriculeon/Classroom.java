package com.github.curriculeon;


import java.util.HashMap;
import java.util.Map;

public class Classroom {
    Student [] classroom;
    Map<Student, Double> roster = new HashMap<>();

    public Classroom(Student[] students) {
        classroom = students;
    }

    public Classroom() {
        classroom = null;
    }

    public Student[] getStudents() {
        return classroom;
    }


    public Double getAverageExamScore() {
        double avg = 0;
        for (Student score : classroom){
            avg+=score.getAverageExamScore();
        }
        return avg/classroom.length;
    }

    public Boolean addStudent(Student students) {
        return null;
    }

    public Boolean removeStudent(Student student) {
        return null;
    }

    public Student[] getStudentsByScore() {
        return null;
    }

    public Map<Student, Character> getGradeBook() {
        return null;
    }

}

