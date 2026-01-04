<<<<<<< HEAD
=======
package service;
import  domain.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class StudentService{
    private static List<Student> studentsList = new ArrayList<>();

    // 初始化测试数据的方法
    public static void initTestData() {
        // 添加一些测试学生数据
        addStudentStatic("001", "张三", "男", "北京", "计算机科学", "信息学院", LocalDate.of(2020, 9, 1));
        addStudentStatic("002", "李四", "女", "上海", "软件工程", "信息学院", LocalDate.of(2020, 9, 1));
        addStudentStatic("003", "王五", "男", "广东", "数学", "理学院", LocalDate.of(2020, 9, 1));
        addStudentStatic("004", "赵六", "女", "江苏", "物理学", "理学院", LocalDate.of(2020, 9, 1));
    }

    // 用于初始化数据的辅助方法（不检查重复性，因为是初始化）
    private static void addStudentStatic(String studentId, String name, String sex, String source, String major, String academy, LocalDate enrollmentDate) {
        studentsList.add(new Student(studentId, name, sex, source, major, academy, enrollmentDate));
        System.out.println("初始化学生数据: " + name);
    }

    public void   addStudent(String studentId, String name, String sex, String source, String major, String academy, LocalDate enrollmentDate){
      for(Student s:studentsList){
          if(s.getStudentId().equals(studentId)){
              System.out.println("学号[" + studentId + "]已存在，新增失败！");
              return;
          }
      }
      studentsList.add(new Student(studentId,name,sex,source,major,academy,enrollmentDate));
        System.out.println("学生[" + name + "]新增成功！");
    }
    public Student studentQueryById(String studentId) {
        for(Student s:studentsList){
            if(s.getStudentId().equals(studentId)){
                return s;
            }
        }
        return null;
    }
    public List<Student> studentQueryByName(String studentName) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getName().contains(studentName)) {
                result.add(s);
            }
        }
        return result;
    }
    public void studentUpdateById(String studentId, String newName, String newMajor) {
        for (Student s : studentsList) {
            if (s.getStudentId().equals(studentId)) {
                s.setName(newName);
                s.setMajor(newMajor);
                System.out.println("学号[" + studentId + "]学生信息修改成功！");
                return;
            }
        }
        System.out.println("学号[" + studentId + "]学生不存在！");
    }
    public void studentDeleteById(String studentId) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getStudentId().equals(studentId)) {
                studentsList.remove(i);
                System.out.println("学号[" + studentId + "]学生删除成功！");
                return;
            }
        }
        System.out.println("学号[" + studentId + "]学生不存在！");
    }
    public List<Student> studentQueryAll() {
        return new ArrayList<>(studentsList);
    }
    public List<Student> studentQueryByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getMajor().equals(major)) {
                result.add(s);
            }
        }
        return result;
    }
}
>>>>>>> parent of d2716e7 (？)
