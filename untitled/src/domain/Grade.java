package domain;
public class Grade {
    private String courseId;
    private String studentId;
    private double courseGrade;
    public Grade(String courseId, String studentId, double courseGrade){
        this.courseId=courseId;
        this.studentId=studentId;
        this.courseGrade=courseGrade;
    }
    public String getCourseId(){return courseId;}
    public void setCourseId(String courseId){this.courseId=courseId;}
    public String getStudentId(){return studentId;}
    public void setStudentId(String studentId){this.studentId=studentId;}
    public double getCourseGrade(){return courseGrade;}
    public void setCourseGrade(double courseGrade){this.courseGrade=courseGrade;}
    @Override
    public String toString(){
        return "Grade{" +
                "courseId='" + courseId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseGrade=" + courseGrade +
                '}';
    }
}