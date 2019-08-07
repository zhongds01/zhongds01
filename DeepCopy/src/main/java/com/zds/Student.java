package com.zds;

/**
 * description: 深拷贝与浅拷贝案例分析
 * author: ZDS
 * create_date : 2019/8/7
 * create_time : 12:15
 */
public class Student {
    String student_name;
    Course course;

    public Student(String student_name, Course course) {
        this.student_name = student_name;
        this.course = course;
    }
    //重载构造函数
    public Student(Student student){
        this(student.student_name,student.course);
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ", course=" + course +
                '}';
    }

    public static void main(String[] args) {
        Course course = new Course("语文");
        Student s1 = new Student("仲东生", course);
        //浅拷贝结果
        Student s2 = new Student(s1);
        System.out.println("s1的信息为："+s1);
        System.out.println("s2的信息为："+s2);
        /*
        s1的信息为：Student{student_name='仲东生', course=Course{course_name='语文'}}
        s2的信息为：Student{student_name='仲东生', course=Course{course_name='语文'}}
         */
        s2.setStudent_name("小明");
        s2.course.setCourse_name("英语");
        System.out.println("s1的信息为："+s1);
        System.out.println("s2的信息为："+s2);
        /*
        s1的信息为：Student{student_name='仲东生', course=Course{course_name='英语'}}
        s2的信息为：Student{student_name='小明', course=Course{course_name='英语'}}
         */
        //深拷贝结果
        s2.setCourse(new Course("物理"));
        System.out.println("s1的信息为："+s1);
        System.out.println("s2的信息为："+s2);
        /*
        s1的信息为：Student{student_name='仲东生', course=Course{course_name='英语'}}
        s2的信息为：Student{student_name='小明', course=Course{course_name='物理'}}
         */
    }
}
