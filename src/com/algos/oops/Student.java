package com.algos.oops;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * arr [mark]
 */

public class Student implements Cloneable, Comparable<Student>{
    String name;
    int marks;

    Student(int marks, String name) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        if(this.marks == o.marks)
            return 0;

        return this.marks> o.marks ? 1:-1;
    }

    static ArrayList<Student> sortByMarks(ArrayList<Student> students, Student student) {
        ArrayList<Student> result = new ArrayList<>();

        if(students.isEmpty() && student!=null ){
            students.add(student);
            return students;
        }

        boolean inserted = false;
        for(int i=0; i<students.size(); i++) {
            if(student.marks < students.get(i).marks){
                result.add(student);
                inserted = true;
            }else{
                result.add(students.get(i));
            }
        }

        if(!inserted){
            result.add(student);
        }else{
            result.add(students.get(students.size()-1));
        }
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("In the sorting program");
        Student std1 = new Student(10,"a");
        Student std2 = new Student(40,"b");
        Student std3 = new Student(30,"c");
        Student std4 = new Student(50,"d");

        ArrayList<Student> topMarksList = new ArrayList<>();

        topMarksList = sortByMarks(topMarksList, std1);
        topMarksList = sortByMarks(topMarksList, std2);
        topMarksList = sortByMarks(topMarksList, std3);
        topMarksList = sortByMarks(topMarksList, std4);

        for(Student std : topMarksList){
            System.out.println(std.name + " --- " + std.marks);
        }

        Student std5 = (Student) std1.clone();
        System.out.println(std5.name +" --> "+ std5.marks);

        //Student std6 = new Student(std1.name, std1.marks);

        Set<Student> students = new TreeSet();
        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);

        for(Student std : students){
            System.out.println(std.name + " --- " + std.marks);
        }

    }


}
