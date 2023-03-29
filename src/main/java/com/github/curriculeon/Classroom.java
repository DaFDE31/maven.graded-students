package com.github.curriculeon;


import java.util.*;

public class Classroom {
    Student [] classroom;

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
        if (contains(student)) {
            Student[] update = new Student[classroom.length - 1];
            int pos = 0;
            for (Student peep : classroom) {
                if (!peep.equals(student)) {
                    update[pos] = peep;
                    pos++;
                }
            }

            classroom = update;
            return true;
        }
        return false;
    }

    /*public Student[] getStudentsByScore1() {
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

    public Student[] getStudentsByScore2() {
        Student [] answer= new Student[classroom.length+1];
        int pop = 0;
        List<Student> update = new ArrayList<>();
        for(int x = 0; x< answer.length-1; x++){
            if(classroom[pop].compareTo(classroom[x]) > 0){
                update.add(0, classroom[pop]);
            }
            else{
                update.add(classroom[pop]);
            }
            pop++;
        }
        System.out.println(update);
        answer = update.toArray(new Student[0]);

        return answer;
    }

     */

    public Student[] getStudentsByScore() {
        return Arrays.asList(classroom)
                .stream()
                .sorted()
                .toArray(Student[]::new);
    }


    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> gradebook = new HashMap<>();
        for (Student peep: classroom){
            char grade;
            if (peep.getAverageExamScore() >= 84){
                grade = 'A';
            }
            else if (peep.getAverageExamScore() >= 71){
                grade = 'B';
            }
            else if (peep.getAverageExamScore() >= 56){
                grade = 'C';
            }
            else if (peep.getAverageExamScore() >= 46){
                grade = 'D';
            }
            else{
                grade = 'F';
            }
            gradebook.put(peep, grade);
        }
        return gradebook;
    }

}

