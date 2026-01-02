package controller;
import service.StudentService;
import domain.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ShowStudentMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public void showStudentMenu(){
        while(true){
            System.out.println("\n------学生信息管理------");
            System.out.println("1、新增学生");
            System.out.println("2、根据学号查询学生");
            System.out.println("3、根据姓名查询学生");
            System.out.println("4、根据专业查询学生");
            System.out.println("5、更新某个学生信息");
            System.out.println("6、删除某个学生信息");
            System.out.println("7、查询所有学生信息");
            System.out.println("n、返回主菜单");
            System.out.print("请选择操作：");
            String choice = scanner.next();

            if ("n".equalsIgnoreCase(choice)) {
                break;
            }
            switch (choice) {
                case "1":
                    System.out.print("请输入学号：");
                    String stuId=scanner.next();
                    System.out.print("请输入姓名：");
                    String stuName = scanner.next();
                    System.out.print("请输入性别：");
                    String stuSex = scanner.next();
                    System.out.print("请输入生源地：");
                    String stuSource = scanner.next();
                    System.out.print("请输入专业：");
                    String stuMajor = scanner.next();
                    System.out.print("请输入学院：");
                    String stuAcademy = scanner.next();
                    System.out.print("请输入入学日期(yyyy-MM-dd)：");
                    LocalDate enrollDate = LocalDate.parse(scanner.next(), df);
                    studentService.addStudent(stuId, stuName, stuSex, stuSource, stuMajor, stuAcademy, enrollDate);
                    break;
                case "2":
                    System.out.print("请输入学号：");
                    Student stu = studentService.studentQueryById(scanner.next());
                    System.out.println(stu == null ? "未找到该学生" : stu);
                    break;
                case "3":
                    System.out.print("请输入姓名：");
                    List<Student> nameList = studentService.studentQueryByName(scanner.next());
                    nameList.forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("请输入专业：");
                    List<Student> majorList = studentService.studentQueryByMajor(scanner.next());
                    majorList.forEach(System.out::println);
                    break;
                case "5":
                    System.out.print("请输入学号：");
                    String updateId = scanner.next();
                    System.out.print("请输入新姓名：");
                    String newName = scanner.next();
                    System.out.print("请输入新专业：");
                    String newMajor = scanner.next();
                    studentService.studentUpdateById(updateId, newName, newMajor);
                    break;
                case "6":
                    System.out.print("请输入学号：");
                    studentService.studentDeleteById(scanner.next());
                    break;
                case "7":
                    studentService.studentQueryAll().forEach(System.out::println);
                    break;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }
}
