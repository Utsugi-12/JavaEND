package src.service;
import src.domain.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class StudentService{
    private static List<Student> studentsList = new ArrayList<>();

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

}
