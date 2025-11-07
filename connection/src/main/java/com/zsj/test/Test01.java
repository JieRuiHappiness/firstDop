package com.zsj.test;

import com.zsj.entity.Student;
import com.zsj.entity.Subject;

import java.util.*;
import java.util.stream.Collectors;

public class Test01 {
    public static List<Student> buildStudentListData() {

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student("stuName"+i, i % 2 == 0 ? "male" : "female", buildSubjectListData()));
        }

        return studentList;
    }

    public static List<Subject> buildSubjectListData() {
        List<Subject> subjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0 -> subjectList.add(new Subject("语文", Math.random() * 100));
                case 1 -> subjectList.add(new Subject("数学", Math.random() * 100));
                case 2 -> subjectList.add(new Subject("英语", Math.random() * 100));
                case 3 -> subjectList.add(new Subject("物理", Math.random() * 100));
                case 4 -> subjectList.add(new Subject("化学", Math.random() * 100));
            }
        }

        return subjectList;
    }

//
//    二、题目
//1、查询所有学生的姓名和平均成绩
//    要求1：求出每个学生的平均成绩
//    要求2：最终结果把学生姓名和该学生的平均成绩封装到 Map 集合中
//    Map 的 key：学生姓名
//    Map 的 value：学生平均成绩
    public static Map<String, Double> getAvgStore(){
      return   Test01.buildStudentListData().stream().collect(Collectors.toMap(student -> student.getStuName(),
                student -> student.getSubjectList().stream().mapToDouble(Subject::getSubjectScore).average().orElse(0)
                ));
    }

//2、查询所有男同学的语文成绩
    public static List<Double> getScore(){

      return Test01.buildStudentListData().stream().filter(student -> student.getGender().equals("male")).
              flatMap(student -> {
                    return student.getSubjectList().stream().filter(subject -> subject.getSubjectName().equals("语文")).
                            map(Subject::getSubjectScore);
                }).toList();
    }
//3、查询总分最高的学生姓名和总分

    public static Map<String,Double> getSum(){
        return Test01.buildStudentListData().stream().collect(Collectors.toMap(Student::getStuName,student ->
        {
        return  student.getSubjectList().stream().mapToDouble(Subject::getSubjectScore).sum();
        }));
    }




    public static void main(String[] args) {
        Map<String, Double> avgStore = Test01.getAvgStore();
        Iterator<Map.Entry<String, Double>> iterator = avgStore.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Double> next = iterator.next();
            System.out.println(next);
        }

        Test01.getScore().forEach(System.out::println);
        Set<Map.Entry<String, Double>> entries = Test01.getSum().entrySet();

        Optional<Map.Entry<String, Double>> max = Test01.getSum().entrySet().stream().
                max(Comparator.comparing(map->map.getValue()));
        System.out.println(max);


    }

}
