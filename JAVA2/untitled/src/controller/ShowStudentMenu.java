package controller;

import domain.Student;
import service.StudentService;
import controller.ShowMenu;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ShowStudentMenu {
    private static StudentService studentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void showStudentMenu() {
        while (true) {
            System.out.println("-------------------学生信息管理--------------------");
            System.out.println("请选择操作：");
            System.out.println("1、增加学生");
            System.out.println("2、根据学号查询学生");
            System.out.println("3、根据姓名查询学生");
            System.out.println("4、根据专业查询学生");
            System.out.println("5、更新学生信息");
            System.out.println("6、删除学生信息");
            System.out.println("7、查询所有学生");
            System.out.println("8、返回主菜单");
            System.out.print("请输入您的选择：");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 消费换行符

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        queryStudentById();
                        break;
                    case 3:
                        queryStudentByName();
                        break;
                    case 4:
                        queryStudentByMajor();
                        break;
                    case 5:
                        updateStudent();
                        break;
                    case 6:
                        deleteStudent();
                        break;
                    case 7:
                        queryAllStudents();
                        break;
                    case 8:
                        System.out.println("返回主菜单...");
                        ShowMenu.showMainMenu();
                        return;
                    default:
                        System.out.println("输入错误，请输入1-8之间的数字！");
                        break;
                }
            } catch (Exception e) {
                System.out.println("输入格式错误，请输入数字！");
                scanner.nextLine(); // 清除错误输入
            }

            System.out.println(); // 添加空行分隔
        }
    }

    private static void addStudent() {
        System.out.println("=== 增加学生 ===");
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();

        System.out.print("请输入姓名：");
        String name = scanner.nextLine().trim();

        System.out.print("请输入性别：");
        String sex = scanner.nextLine().trim();

        System.out.print("请输入生源地：");
        String source = scanner.nextLine().trim();

        System.out.print("请输入专业：");
        String major = scanner.nextLine().trim();

        System.out.print("请输入学院：");
        String academy = scanner.nextLine().trim();

        System.out.print("请输入入学日期(格式:yyyy-MM-dd)：");
        String dateStr = scanner.nextLine().trim();
        LocalDate enrollmentDate;
        try {
            enrollmentDate = LocalDate.parse(dateStr);
        } catch (Exception e) {
            System.out.println("日期格式错误，使用默认日期！");
            enrollmentDate = LocalDate.now();
        }

        studentService.addStudent(studentId, name, sex, source, major, academy, enrollmentDate);
    }

    private static void queryStudentById() {
        System.out.println("=== 根据学号查询学生 ===");
        System.out.print("请输入学号：");
        String studentId = scanner.nextLine().trim();

        Student student = studentService.studentQueryById(studentId);
        if (student != null) {
            System.out.println("找到的学生信息：");
            printStudent(student);
        } else {
            System.out.println("未找到学号为 " + studentId + " 的学生！");
        }
    }

    private static void queryStudentByName() {
        System.out.println("=== 根据姓名查询学生 ===");
        System.out.print("请输入姓名：");
        String name = scanner.nextLine().trim();

        List<Student> students = studentService.studentQueryByName(name);
        if (!students.isEmpty()) {
            System.out.println("找到 " + students.size() + " 名学生：");
            for (Student student : students) {
                printStudent(student);
            }
        } else {
            System.out.println("未找到姓名包含 " + name + " 的学生！");
        }
    }

    private static void queryStudentByMajor() {
        System.out.println("=== 根据专业查询学生 ===");
        System.out.print("请输入专业：");
        String major = scanner.nextLine().trim();

        List<Student> students = studentService.studentQueryByMajor(major);
        if (!students.isEmpty()) {
            System.out.println("找到 " + students.size() + " 名学生：");
            for (Student student : students) {
                printStudent(student);
            }
        } else {
            System.out.println("未找到专业为 " + major + " 的学生！");
        }
    }

    private static void updateStudent() {
        System.out.println("=== 更新学生信息 ===");
        System.out.print("请输入要更新的学号：");
        String studentId = scanner.nextLine().trim();

        System.out.print("请输入新的姓名：");
        String newName = scanner.nextLine().trim();

        System.out.print("请输入新的专业：");
        String newMajor = scanner.nextLine().trim();

        studentService.studentUpdateById(studentId, newName, newMajor);
    }

    private static void deleteStudent() {
        System.out.println("=== 删除学生信息 ===");
        System.out.print("请输入要删除的学号：");
        String studentId = scanner.nextLine().trim();

        studentService.studentDeleteById(studentId);
    }

    private static void queryAllStudents() {
        System.out.println("=== 查询所有学生 ===");
        List<Student> students = studentService.studentQueryAll();

        if (!students.isEmpty()) {
            System.out.println("所有学生信息：");
            for (Student student : students) {
                printStudent(student);
            }
        } else {
            System.out.println("暂无学生信息！");
        }
    }

    private static void printStudent(Student student) {
        System.out.printf("学号: %s, 姓名: %s, 性别: %s, 生源地: %s, 专业: %s, 学院: %s, 入学日期: %s%n",
                student.getStudentId(), student.getName(), student.getSex(),
                student.getSource(), student.getMajor(), student.getAcademy(),
                student.getEnrollmentDate());
    }

    public static void main(String[] args) {
        showStudentMenu();
    }
}