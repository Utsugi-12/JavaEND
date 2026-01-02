package src.service;
import  src.domain.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();
    public void teacherAdd(String teacherId,String name,String sex,String academy, LocalDate employDate) {
        for(Teacher t:teacherList){
            if(t.getTeacherId().equals(teacherId)){
                System.out.println("工号[" + teacherId + "]已存在，新增失败！");
                return;
            }
        }
        teacherList.add(new Teacher(teacherId,name,sex,academy,employDate));
        System.out.println("教师[" + name + "]新增成功！");
    }
    public Teacher teacherQueryById(String teacherId) {
        for(Teacher t:teacherList){
            if(t.getTeacherId().equals(teacherId)){
                return t;
            }
        }
        return null;
    }
    public List<Teacher> teacherQueryByName(String teacherName) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher t : teacherList) {
            if (t.getName().contains(teacherName)) {
                result.add(t);
            }
        }
        return result;
    }
    public void teacherUpdateById(String teacherId, String newName,String newAcademy) {
        for(Teacher t:teacherList){
            if(t.getTeacherId().equals(teacherId)){
                t.setName(newName);
                t.setAcademy(newAcademy);
                System.out.println("工号[" + teacherId + "]教师信息修改成功！");
                return;
            }
        }
        System.out.println("工号[" + teacherId + "]教师不存在！");
    }
    public void teacherDeleteById(String teacherId) {
        for(int i=0;i<teacherList.size();i++){
            if(teacherList.get(i).getTeacherId().equals(teacherId)){
                teacherList.remove(i);
                System.out.println("工号[" + teacherId + "]教师删除成功！");
                return;
            }
        }
        System.out.println("工号[" + teacherId + "]教师不存在！");
    }
    public List<Teacher> teacherQueryAll() {
        return new ArrayList<>(teacherList);
    }
}
