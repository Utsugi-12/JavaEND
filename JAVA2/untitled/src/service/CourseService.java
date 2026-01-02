package service;
import  domain.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static List<Course> courseList=new ArrayList<>();
    public void courseAdd(String courseId, String courseName, String teacherId, LocalDate courseDateStart, LocalDate courseDateEnd) {
        for(Course c:courseList){
            if(c.getCourseId().equals(courseId)){
                System.out.println("课程号[" + courseId + "]已存在，新增失败！");
                return;
            }
        }
        courseList.add(new Course(courseId, courseName, teacherId, courseDateStart, courseDateEnd));
        System.out.println("课程[" + courseName + "]新增成功！");
    }
    public Course courseQueryById(String courseId){
        for(Course c:courseList){
            if(c.getCourseId().equals(courseId)){
                return c;
            }
        }
        return null;
    }
    public List<Course> courseQueryByName(String courseName) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getCourseName().contains(courseName)) {
                result.add(c);
            }
        }
        return result;
    }

    public void courseUpdateById(String courseId, String newCourseName, String newTeacherId) {
        for (Course c : courseList) {
            if (c.getCourseId().equals(courseId)) {
                c.setCourseName(newCourseName);
                c.setTeacherId(newTeacherId);
                System.out.println("课程号[" + courseId + "]课程信息修改成功！");
                return;
            }
        }
        System.out.println("课程号[" + courseId + "]课程不存在！");
    }
    public void courseDeleteById(String courseId) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseId().equals(courseId)) {
                courseList.remove(i);
                System.out.println("课程号[" + courseId + "]课程删除成功！");
                return;
            }
        }
        System.out.println("课程号[" + courseId + "]课程不存在！");
    }
    public List<Course> courseQueryAll() {
        return new ArrayList<>(courseList);
    }
}
