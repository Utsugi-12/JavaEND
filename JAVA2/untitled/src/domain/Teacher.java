package domain;

import java.time.LocalDate;

public class Teacher {
    private String teacherId;
    private String name;
    private String sex;
    private String academy;
    private LocalDate employDate;
    public Teacher(String teacherId,String name,String sex,String academy, LocalDate employDate) {
        this.teacherId = teacherId;
        this.name = name;
        this.sex=sex;
        this.academy = academy;
        this.employDate = employDate;
    }
    public String getTeacherId() {return teacherId;}
    public void setTeacherId(String teacherId) {this.teacherId = teacherId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSex(){return sex;}
    public void setSex(String sex){this.sex=sex;}
    public String getAcademy() {return academy;}
    public void setAcademy(String academy) {this.academy = academy;}
    public LocalDate getEmployDate() {return employDate;}
    public void setEmployDate(LocalDate employDate) {this.employDate = employDate;}
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", academy='" + academy + '\'' +
                ", employDate=" + employDate +
                '}';
    }
}