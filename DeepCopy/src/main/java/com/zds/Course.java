package com.zds;

/**
 * description: please add the description
 * author: ZDS
 * create_date : 2019/8/7
 * create_time : 12:17
 */
public class Course {
    String course_name;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Course(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_name='" + course_name + '\'' +
                '}';
    }
}
