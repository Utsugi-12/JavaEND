package src.domain;

import java.time.LocalDate;

public class Course {
    private String courseId;
    private String courseName;
    private String teacherId;
    private LocalDate courseDateStart;
    private LocalDate courseDateEnd;
    public Course(String courseId, String courseName, String teacherId, LocalDate courseDateStart, LocalDate courseDateEnd) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.courseDateStart = courseDateStart;
        this.courseDateEnd = courseDateEnd;
    }
    public String getCourseId() {return courseId;}
    public void setCourseId(String courseId) {this.courseId = courseId;}
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public String getTeacherId() {return teacherId;}
    public void setTeacherId(String teacherId) {this.teacherId = teacherId;}
    public LocalDate getCourseDateStart() {return courseDateStart;}
    public void setCourseDateStart(LocalDate courseDateStart) {this.courseDateStart = courseDateStart;}
    public LocalDate getCourseDateEnd() {return courseDateEnd;}
    public void setCourseDateEnd(LocalDate courseDateEnd) {this.courseDateEnd = courseDateEnd;}
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", courseDataStart='" + courseDateStart + '\'' +
                ", courseDataEnd=" + courseDateEnd +
                '}';
    }
}