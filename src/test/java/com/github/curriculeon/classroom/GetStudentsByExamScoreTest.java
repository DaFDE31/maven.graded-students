package com.github.curriculeon.classroom;

import com.github.curriculeon.Classroom;
import com.github.curriculeon.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GetStudentsByExamScoreTest {
    // given
    private void test(Student[] students, Student[] expected) {
        // when
        Classroom classroom = new Classroom(students);
        Student[] actual = classroom.getStudentsByScore();

        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));

        // then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void test0(){
        Student student1 = new Student("Mel", "Hammer", new Double[]{ 50.0, 50.0 });
        Student student2 = new Student("Kyle", "Ant", new Double[]{ 75.0, 75.0 });
        Student student3 = new Student("Katrina", "High", new Double[]{ 100.0, 100.0 });
        Student[] students = {student1, student2, student3};

        Student[] expected = {student3, student2, student1};

        test(students, expected);
    }



    @Test
    public void test1(){
        Student student1 = new Student("Mel", "Hammer", new Double[]{ 100.0, 100.0 });
        Student student2 = new Student("Kyle", "Ant", new Double[]{ 75.0, 75.0 });
        Student student3 = new Student("Katrina", "High", new Double[]{ 100.0, 75.0 });
        Student[] students = {student1, student2, student3};
        Student[] expected = {student1, student3, student2};
        test(students, expected);
    }



    @Test
    public void test2(){
        Student student1 = new Student("Ashley", "Aero", new Double[]{ 100.0, 100.0 });
        Student student2 = new Student("Bob", "Barker", new Double[]{ 75.0, 75.0 });
        Student student3 = new Student("Cathryn", "Carpenter", new Double[]{ 100.0, 100.0 });
        Student[] students = {student3, student1, student2};
        Student[] expected = {student1, student3, student2};
        test(students, expected);
    }

    @Test
    public void test3(){
        Student student1 = new Student("Ashley", "Aero", new Double[]{ 100.0, 100.0 });
        Student student2 = new Student("Bob", "Barker", new Double[]{ 100.0, 100.0 });
        Student student3 = new Student("Cathryn", "Carpenter", new Double[]{ 100.0, 100.0 });
        Student[] students = {student3, student1, student2};
        Student[] expected = {student1, student2, student3};
        test(students, expected);
    }



    @Test
    public void test4(){
        Student student1 = new Student("Ashley", "Aero", new Double[]{ 100.0, 100.0 });
        Student student2 = new Student("Ashley", "Barker", new Double[]{ 100.0, 100.0 });
        Student student3 = new Student("Ashley", "Carpenter", new Double[]{ 100.0, 100.0 });
        Student[] students = {student3, student1, student2};
        Student[] expected = {student1, student2, student3};
        test(students, expected);
    }

    @Test
    public void test5(){
        Student student1 = new Student("Ashley", "Aero", new Double[]{ 100.0, 100.0 });
        Student student2 = new Student("Ashley", "Aero", new Double[]{ 99.0, 100.0 });
        Student student3 = new Student("Ashley", "Aero", new Double[]{ 98.0, 100.0 });
        Student[] students = {student3, student1, student2};
        Student[] expected = {student1, student2, student3};
        test(students, expected);
    }
}
