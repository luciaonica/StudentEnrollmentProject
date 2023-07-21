package com.genspark.Dto;

public class CourseDTO {

    private int courseId;

    private String name;

    private String description;

    private int maxNumberOfStudents;

    private String teacher;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String name, String description, int maxNumberOfStudents, String teacher) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.teacher = teacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxNumberOfStudents=" + maxNumberOfStudents +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
