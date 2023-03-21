package com.github.curriculeon;


import java.util.*;

public class Classroom {
    Student [] classroom;
    Map<Student, Character> roster = new HashMap<>();

    public Classroom(Student[] students) {
        classroom = students;
    }

    public Classroom() {
        classroom = new Student[0];
    }

    public Student[] getStudents() {
        return classroom;
    }

    public Boolean contains(Student studentToLookFor){
        for (Student peeps : classroom){
            if (peeps.equals(studentToLookFor))
                    return true;
        }
        return false;
    }


    public Double getAverageExamScore() {
        double avg = 0;
        for (Student score : classroom){
            avg+=score.getAverageExamScore();
        }
        return avg/classroom.length;
    }

    public Boolean addStudent(Student... students) {
        for (Student peeps : students){
            if (!contains(peeps)){
                Student [] update = new Student[classroom.length+1];
                System.arraycopy(classroom, 0, update, 0, classroom.length);
                update[update.length-1] = peeps;
                classroom = update;
            }
        }
        return false;
    }


    public Boolean removeStudent(Student student) {
        if (contains(student)){
            Student [] update = new Student[classroom.length-1];
            int pos = 0;
            for (int x = 0; x< classroom.length-1; x++){
                if (classroom[x].equals(student)){
                    continue;
                }
                else{
                    update[pos] = classroom[x];
                    pos++;
                }
            }
            classroom = update;

            return true;
        }
        return false;
    }

    public Student[] getStudentsByScore() {
        Student [] answer= new Student[classroom.length];
        List<Double> update = new ArrayList<>();
        for (Student peep : classroom){
            update.add(peep.getAverageExamScore());
        }
        //System.out.println(update);
        update.sort(Collections.reverseOrder());
        //System.out.println(update);
        for(int x = 0; x < answer.length; x++){
            for(int i = 0; i< classroom.length; i++){
                //System.out.print(update.get(x));
                //System.out.println(" "+classroom[i].getAverageExamScore());
                if(update.get(x).equals(classroom[i].getAverageExamScore())){
                    answer[x] = classroom[i];
                    break;
                }
            }

        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }


    public Map<Student, Character> getGradeBook() {
        return null;
    }

}

