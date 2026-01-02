package controller;

import domain.Course;
import service.CourseService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ShowCourseMenu {
    
    private CourseService courseService;
    private Scanner scanner;
    
    public ShowCourseMenu() {
        this.courseService = new CourseService();
        this.scanner = new Scanner(System.in);
    }

    public void showCourseMenu() {
        while (true) {
            System.out.println("\n----------- 课程信息管理 -----------");
            System.out.println("请选择操作：");
            System.out.println("1、增加课程");
            System.out.println("2、根据课程号查询课程");
            System.out.println("3、根据课程名查询课程");
            System.out.println("4、更新课程信息");
            System.out.println("5、删除课程信息");
            System.out.println("6、查询所有课程信息");
            System.out.println("7、返回主菜单");
            
            System.out.print("请输入选择：");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addCourse();
                    break;
                case "2":
                    queryCourseById();
                    break;
                case "3":
                    queryCourseByName();
                    break;
                case "4":
                    updateCourse();
                    break;
                case "5":
                    deleteCourse();
                    break;
                case "6":
                    queryAllCourses();
                    break;
                case "7":
                    return; // 返回主菜单
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    private void addCourse() {
        System.out.println("\n--- 增加课程 ---");
        
        System.out.print("请输入课程号：");
        String courseId = scanner.nextLine();
        
        System.out.print("请输入课程名称：");
        String courseName = scanner.nextLine();
        
        System.out.print("请输入任课老师工号：");
        String teacherId = scanner.nextLine();
        
        System.out.println("请输入课程开始日期：");
        System.out.print("年份（yyyy）：");
        int startYear = Integer.parseInt(scanner.nextLine());
        System.out.print("月份（1-12）：");
        int startMonth = Integer.parseInt(scanner.nextLine());
        System.out.print("日期（1-31）：");
        int startDay = Integer.parseInt(scanner.nextLine());
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        
        System.out.println("请输入课程结束日期：");
        System.out.print("年份（yyyy）：");
        int endYear = Integer.parseInt(scanner.nextLine());
        System.out.print("月份（1-12）：");
        int endMonth = Integer.parseInt(scanner.nextLine());
        System.out.print("日期（1-31）：");
        int endDay = Integer.parseInt(scanner.nextLine());
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
        
        courseService.courseAdd(courseId, courseName, teacherId, startDate, endDate);
        System.out.println("课程添加成功！");
    }

    private void queryCourseById() {
        System.out.println("\n--- 根据课程号查询课程 ---");
        System.out.print("请输入课程号：");
        String courseId = scanner.nextLine();
        
        Course course = courseService.courseQueryById(courseId);
        if (course != null) {
            System.out.println("查询结果：");
            System.out.println(course);
        } else {
            System.out.println("未找到课程号为 " + courseId + " 的课程！");
        }
    }

    private void queryCourseByName() {
        System.out.println("\n--- 根据课程名查询课程 ---");
        System.out.print("请输入课程名：");
        String courseName = scanner.nextLine();
        
        // courseService.courseQueryByName方法返回List<Course>，不是单个Course
        List<Course> courses = courseService.courseQueryByName(courseName);
        if (courses != null && !courses.isEmpty()) {
            System.out.println("查询结果：");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("未找到课程名为 " + courseName + " 的课程！");
        }
    }

    private void updateCourse() {
        System.out.println("\n--- 更新课程信息 ---");
        System.out.print("请输入要更新的课程号：");
        String courseId = scanner.nextLine();
        
        Course oldCourse = courseService.courseQueryById(courseId);
        if (oldCourse == null) {
            System.out.println("未找到该课程！");
            return;
        }
        
        System.out.println("当前课程信息：");
        System.out.println(oldCourse);
        System.out.println("\n请输入新的课程信息：");
        
        System.out.print("课程名称（留空保持不变）：");
        String courseName = scanner.nextLine();
        // 如果输入为空，则使用原来的值
        if (courseName.trim().isEmpty()) {
            courseName = oldCourse.getCourseName();
        }
        
        System.out.print("任课老师工号（留空保持不变）：");
        String teacherId = scanner.nextLine();
        // 如果输入为空，则使用原来的值
        if (teacherId.trim().isEmpty()) {
            teacherId = oldCourse.getTeacherId();
        }
        
        System.out.println("课程开始日期（留空保持不变，按回车跳过）：");
        LocalDate startDate = oldCourse.getCourseDateStart();
        System.out.print("是否修改开始日期？(y/n): ");
        String modifyStart = scanner.nextLine();
        if ("y".equalsIgnoreCase(modifyStart)) {
            System.out.print("年份（yyyy）：");
            int startYear = Integer.parseInt(scanner.nextLine());
            System.out.print("月份（1-12）：");
            int startMonth = Integer.parseInt(scanner.nextLine());
            System.out.print("日期（1-31）：");
            int startDay = Integer.parseInt(scanner.nextLine());
            startDate = LocalDate.of(startYear, startMonth, startDay);
        }
        
        System.out.println("课程结束日期（留空保持不变，按回车跳过）：");
        LocalDate endDate = oldCourse.getCourseDateEnd();
        System.out.print("是否修改结束日期？(y/n): ");
        String modifyEnd = scanner.nextLine();
        if ("y".equalsIgnoreCase(modifyEnd)) {
            System.out.print("年份（yyyy）：");
            int endYear = Integer.parseInt(scanner.nextLine());
            System.out.print("月份（1-12）：");
            int endMonth = Integer.parseInt(scanner.nextLine());
            System.out.print("日期（1-31）：");
            int endDay = Integer.parseInt(scanner.nextLine());
            endDate = LocalDate.of(endYear, endMonth, endDay);
        }
        
        // 调用服务更新课程信息 - 使用正确的方法参数
        courseService.courseUpdateById(courseId, courseName, teacherId);
        
        // 需要手动更新日期，因为courseUpdateById方法不处理日期
        Course updatedCourse = courseService.courseQueryById(courseId);
        if (updatedCourse != null) {
            updatedCourse.setCourseDateStart(startDate);
            updatedCourse.setCourseDateEnd(endDate);
            System.out.println("课程信息更新成功！");
            System.out.println(updatedCourse);
        } else {
            System.out.println("更新失败！");
        }
    }

    private void deleteCourse() {
        System.out.println("\n--- 删除课程信息 ---");
        System.out.print("请输入要删除的课程号：");
        String courseId = scanner.nextLine();
        
        courseService.courseDeleteById(courseId);
        // 原来的代码试图接收一个void方法的返回值，现在直接调用即可
    }

    private void queryAllCourses() {
        System.out.println("\n--- 所有课程信息 ---");
        List<Course> courses = courseService.courseQueryAll();
        
        if (courses.isEmpty()) {
            System.out.println("暂无课程信息！");
        } else {
            System.out.println("共有 " + courses.size() + " 门课程：");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i));
            }
        }
    }
}