package service;
import  domain.Course;
import domain.Grade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GradeService {
    private static List<Grade> gradeList=new ArrayList<>();
    public List<Grade> gradeAdd(String courseId, String studentId, double courseGrade){
        for (Grade g:gradeList){
            if(g.getCourseId().equals(courseId) && g.getStudentId().equals(studentId)){
                System.out.println("学生[" + studentId + "]的课程[" + courseId + "]成绩已存在！");
                return null;
            }
        }
        gradeList.add(new Grade(courseId,studentId,courseGrade));
        System.out.println("成绩录入成功！");
        return null;
    }
    public List<Grade> gradeQueryByStudentId(String studentId) {
        List<Grade> result = new ArrayList<>();
        for (Grade g : gradeList) {
            if (g.getStudentId().equals(studentId)) {
                result.add(g);
            }
        }
        return result;
    }
    public List<Grade> gradeQueryByCourseId(String courseId) {
        List<Grade> result = new ArrayList<>();
        for (Grade g : gradeList) {
            if (g.getCourseId().equals(courseId)) {
                result.add(g);
            }
        }
        return result;
    }
    public List<Grade> gradeQueryByTeacherId(String teacherId, CourseService courseService) {
        List<Grade> result = new ArrayList<>();
        // 先查教师带的课程
        List<Course> teacherCourses = courseService.courseQueryAll();
        // 再查这些课程的成绩
        for (Course c : teacherCourses) {
            if (c.getTeacherId().equals(teacherId)) {
                for (Grade g : gradeList) {
                    if (g.getCourseId().equals(c.getCourseId())) {
                        result.add(g);
                    }
                }
            }
        }
        return result;
    }
    public void gradeUpdateByStudentId(String studentId, String courseId, double newCourseGrade) {
        for (Grade g : gradeList) {
            if (g.getStudentId().equals(studentId) && g.getCourseId().equals(courseId)) {
                g.setCourseGrade(newCourseGrade);
                System.out.println("成绩更新成功！");
                return;
            }
        }
        System.out.println("成绩不存在！");
    }
    public List<Grade> gradeSortByCourseId(String courseId) {
        List<Grade> courseGrades = gradeQueryByCourseId(courseId);
        Collections.sort(courseGrades, new Comparator<Grade>() {
            @Override
            public int compare(Grade g1, Grade g2) {
                return Double.compare(g2.getCourseGrade(), g1.getCourseGrade());
            }
        });
        return courseGrades;
    }
}
