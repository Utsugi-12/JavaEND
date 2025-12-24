package src.domain;

import java.time.LocalDate;
public class Student {
    private String studentId;
    private String name;
    private String sex;
    private String source;
    private String major;
    private String academy;
    private LocalDate enrollmentDate;
    public Student(String studentId,String name,String sex,String source,String major,String academy,LocalDate enrollmentDate) {
        this.studentId = studentId;
        this.name = name;
        this.sex =sex;
        this.source = source;
        this.major = major;
        this.academy = academy;
        this.enrollmentDate = enrollmentDate;
    }
    public String getStudentId() {return studentId;}
    public void setStudentId(String studentId) {this.studentId = studentId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSex(){return sex;}
    public void setSex(String sex){this.sex=sex;}
    public String getSource(){return source;}
    public void setSource(String source){this.source=source;}
    public String getMajor(){return major;}
    public void setMajor(String major){this.major=major;}
    public String getAcademy(){return academy;}
    public void setAcademy(String academy){this.academy=academy;}
    public LocalDate getEnrollmentDate(){return enrollmentDate;}
    public void setEnrollmentDate(LocalDate enrollmentDate){this.enrollmentDate=enrollmentDate;}
    @Override
    public String toString(){
        return "Student{" +
                "stuId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", source='" + source + '\'' +
                ", major='" + major + '\'' +
                ", academy='" + academy + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
