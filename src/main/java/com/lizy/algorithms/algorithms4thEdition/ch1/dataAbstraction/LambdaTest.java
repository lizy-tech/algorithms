package com.lizy.algorithms.algorithms4thEdition.ch1.dataAbstraction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-8-16 10:00
 */
public class LambdaTest {
    public interface Filter{
        boolean filter(Student student);
    }
    public static void main(String[] args) {
//        (String p) -> System.out.println(p);
        List<Student> studentList = getDataList();
        List<Student> startWithYeList = filterStudent(studentList, (student) -> student.getName().startsWith("叶"));
        List<Student> ageList = filterStudent(studentList, (student) -> student.getAge() > 18);
    }

    private static List<Student> filterStudent(List<Student> studentList,Filter filter){
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (filter.filter(student)) {
                students.add(student);
            }
        }
        return students;
    }

    private static List<Student> getDataList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("leavesC", 9));
        studentList.add(new Student("叶应是叶", 17));
        studentList.add(new Student("叶", 18));
        studentList.add(new Student("叶", 14));
        studentList.add(new Student("叶应是叶", 4));
        studentList.add(new Student("叶应是叶", 17));
        studentList.add(new Student("叶应是叶", 5));
        studentList.add(new Student("leavesC", 13));
        studentList.add(new Student("陈", 0));
        studentList.add(new Student("叶应是叶", 12));
        studentList.add(new Student("leavesC", 15));
        studentList.add(new Student("leavesC", 20));
        studentList.add(new Student("叶应是叶", 8));
        studentList.add(new Student("陈", 1));
        studentList.add(new Student("叶应是叶", 14));
        studentList.add(new Student("叶应是叶", 4));
        studentList.add(new Student("leavesC", 15));
        studentList.add(new Student("叶", 17));
        studentList.add(new Student("叶应是叶", 4));
        studentList.add(new Student("陈", 13));
        studentList.add(new Student("叶应是叶", 20));
        studentList.add(new Student("叶", 10));
        studentList.add(new Student("leavesC", 4));
        studentList.add(new Student("陈", 22));
        studentList.add(new Student("leavesC", 7));
        return studentList;
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Age: " + age;
    }
}
