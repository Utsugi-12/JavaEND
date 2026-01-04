package controller;

import domain.Course;
import service.CourseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ShowCourseMenu {
    private static CourseService courseService = new CourseService();
    private static Scanner scanner = new Scanner(System.in);

    public static void showCourseMenu() {
        while (true) {
            System.out.println("-------------------课程信息管理--------------------");
            System.out.println("请选择操作：");
            System.out.println("1、增加课程");
            System.out.println("2、根据课程号查询课程");
            System.out.println("3、根据课程名查询课程");
            System.out.println("4、更新课程信息");
            System.out.println("5、删除课程信息");
            System.out.println("6、查询所有课程");
            System.out.println("7、返回主菜单");
            System.out.print("请输入您的选择：");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 消费换行符

                switch (choice) {
                    case 1:
                        addCourse();
                        break;
                    case 2:
                        queryCourseById();
                        break;
                    case 3:
                        queryCourseByName();
                        break;
                    case 4:
                        updateCourse();
                        break;
                    case 5:
                        deleteCourse();
                        break;
                    case 6:
                        queryAllCourses();
                        break;
                    case 7:
                        System.out.println("返回主菜单...");
                        return;
                    default:
                        System.out.println("输入错误，请输入1-7之间的数字！");
                        break;
                }
            } catch (Exception e) {
                System.out.println("输入格式错误，请输入数字！");
                scanner.nextLine(); // 清除错误输入
            }

            System.out.println(); // 添加空行分隔
        }
    }

    private static void addCourse() {
        System.out.println("=== 增加课程 ===");
        System.out.print("请输入课程号：");
        String courseId = scanner.nextLine().trim();

        System.out.print("请输入课程名：");
        String courseName = scanner.nextLine().trim();

        System.out.print("请输入授课教师工号：");
        String teacherId = scanner.nextLine().trim();

        System.out.print("请输入开课日期(格式:yyyy-MM-dd)：");
        String dateStartStr = scanner.nextLine().trim();
        LocalDate courseDateStart;
        try {
            courseDateStart = LocalDate.parse(dateStartStr);
        } catch (Exception e) {
            System.out.println("日期格式错误，使用默认日期！");
            courseDateStart = LocalDate.now();
        }

        System.out.print("请输入结课日期(格式:yyyy-MM-dd)：");
        String dateEndStr = scanner.nextLine().trim();
        LocalDate courseDateEnd;
        try {
            courseDateEnd = LocalDate.parse(dateEndStr);
        } catch (Exception e) {
            System.out.println("日期格式错误，使用默认日期！");
            courseDateEnd = LocalDate.now();
        }

        courseService.courseAdd(courseId, courseName, teacherId, courseDateStart, courseDateEnd);
    }

    private static void queryCourseById() {
        System.out.println("=== 根据课程号查询课程 ===");
        System.out.print("请输入课程号：");
        String courseId = scanner.nextLine().trim();

        Course course = courseService.courseQueryById(courseId);
        if (course != null) {
            System.out.println("找到的课程信息：");
            printCourse(course);
        } else {
            System.out.println("未找到课程号为 " + courseId + " 的课程！");
        }
    }

    private static void queryCourseByName() {
        System.out.println("=== 根据课程名查询课程 ===");
        System.out.print("请输入课程名：");
        String courseName = scanner.nextLine().trim();

        List<Course> courses = courseService.courseQueryByName(courseName);
        if (!courses.isEmpty()) {
            System.out.println("找到 " + courses.size() + " 门课程：");
            for (Course course : courses) {
                printCourse(course);
            }
        } else {
            System.out.println("未找到课程名为 " + courseName + " 的课程！");
        }
    }

    private static void updateCourse() {
        System.out.println("=== 更新课程信息 ===");
        System.out.print("请输入要更新的课程号：");
        String courseId = scanner.nextLine().trim();

        System.out.print("请输入新的课程名：");
        String newCourseName = scanner.nextLine().trim();

        System.out.print("请输入新的授课教师工号：");
        String newTeacherId = scanner.nextLine().trim();

        courseService.courseUpdateById(courseId, newCourseName, newTeacherId);
    }

    private static void deleteCourse() {
        System.out.println("=== 删除课程信息 ===");
        System.out.print("请输入要删除的课程号：");
        String courseId = scanner.nextLine().trim();

        courseService.courseDeleteById(courseId);
    }

    private static void queryAllCourses() {
        System.out.println("=== 查询所有课程 ===");
        List<Course> courses = courseService.courseQueryAll();

        if (!courses.isEmpty()) {
            System.out.println("所有课程信息：");
            for (Course course : courses) {
                printCourse(course);
            }
        } else {
            System.out.println("暂无课程信息！");
        }
    }

    private static void printCourse(Course course) {
        System.out.printf("课程号: %s, 课程名: %s, 教师工号: %s, 开课日期: %s, 结课日期: %s%n",
                course.getCourseId(), course.getCourseName(), course.getTeacherId(),
                course.getCourseDateStart(), course.getCourseDateEnd());
    }

    public static void main(String[] args) {
        showCourseMenu();
    }
}