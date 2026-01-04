package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.Grade;
import service.GradeService;

public class ShowGradeMenu {
    private static GradeService gradeService = new GradeService();
    private static Scanner scanner = new Scanner(System.in);
    public static void showGradeMenu() {
        while (true) {
            System.out.println("---------成绩管理--------");
            System.out.println("请选择操作：");
            System.out.println("1、成绩录入");
            System.out.println("2、查询某个学生成绩");
            System.out.println("3、查询某个老师带课成绩");
            System.out.println("4、查询某门课程成绩");
            System.out.println("5、更新某个学生课程成绩");
            System.out.println("6、对某个学生所有成绩排名");
            System.out.println("7、对某门课程所有成绩排名");
            System.out.println("n、返回主菜单");
            System.out.print("请输入操作序号或'n'返回：");
            String choice = scanner.next().trim();

            switch (choice) {
                case "1":
                    gradeInput();
                    break;
                case "2":
                    queryGradeByStudentId();
                    break;
                case "3":
                    queryGradeByTeacherId();
                    break;
                case "4":
                    queryGradeByCourseId();
                    break;
                case "5":
                    updateGradeByStudentId();
                    break;
                case "6":
                    sortGradeByStudentId();
                    break;
                case "7":
                    sortGradeByCourseId();
                    break;
                case "n":
                case "N":
                    System.out.println("返回主菜单...");
                    return;
                default:
                    System.out.println("输入无效，请重新选择！");
                    break;
            }
            System.out.println("------------------------");
        }
    }

    private static void gradeInput() {
        System.out.println("=== 成绩录入 ===");
        Grade grade = new Grade();

        System.out.print("请输入课程号：");
        grade.setCourseId(scanner.next().trim());

        System.out.print("请输入学生学号：");
        grade.setStudentId(scanner.next().trim());

        System.out.print("请输入课程成绩：");
        grade.setCourseGrade(scanner.nextDouble());

        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(grade);

        List<Grade> result = gradeService.gradeAdd(gradeList);
        System.out.println(result != null && !result.isEmpty() ? "成绩录入成功！" : "成绩录入失败！");
    }

    private static void queryGradeByStudentId() {
        System.out.println("=== 查询某个学生成绩 ===");
        System.out.print("请输入学生学号：");
        String studentId = scanner.next().trim();

        List<Grade> grades = gradeService.gradeQueryByStudentId(studentId);
        printGradeList(grades);
    }

    private static void queryGradeByTeacherId() {
        System.out.println("=== 查询某个老师带课成绩 ===");
        System.out.print("请输入老师工号：");
        String teacherId = scanner.next().trim();

        List<Grade> grades = gradeService.gradeQueryByTeacherId(teacherId);
        printGradeList(grades);
    }

    private static void queryGradeByCourseId() {
        System.out.println("=== 查询某门课程成绩 ===");
        System.out.print("请输入课程号：");
        String courseId = scanner.next().trim();

        List<Grade> grades = gradeService.gradeQueryByCourseId(courseId);
        printGradeList(grades);
    }

    private static void updateGradeByStudentId() {
        System.out.println("=== 更新某个学生课程成绩 ===");
        System.out.print("请输入学生学号：");
        String studentId = scanner.next().trim();

        List<Grade> updatedGrades = gradeService.gradeUpdateByStudentId(studentId);
        System.out.println(updatedGrades != null && !updatedGrades.isEmpty() ? "成绩更新成功！" : "成绩更新失败！");
        if (updatedGrades != null) {
            printGradeList(updatedGrades);
        }
    }

    private static void sortGradeByStudentId() {
        System.out.println("=== 对某个学生所有成绩排名 ===");
        System.out.print("请输入学生学号：");
        String studentId = scanner.next().trim();

        List<Grade> sortedGrades = gradeService.gradeSortByStudentId(studentId);
        System.out.println("排名结果：");
        printGradeList(sortedGrades);
    }

    private static void sortGradeByCourseId() {
        System.out.println("=== 对某门课程所有成绩排名 ===");
        System.out.print("请输入课程号：");
        String courseId = scanner.next().trim();

        List<Grade> sortedGrades = gradeService.gradeSortByCourseId(courseId);
        System.out.println("排名结果：");
        printGradeList(sortedGrades);
    }

    private static void printGradeList(List<Grade> grades) {
        if (grades == null || grades.isEmpty()) {
            System.out.println("未查询到相关成绩信息！");
            return;
        }
        System.out.printf("%-10s %-10s %-8s%n", "课程号", "学生学号", "成绩");

        for (Grade grade : grades) {
            System.out.printf("%-10s %-10s %-8.2f%n",
                    grade.getCourseId(),
                    grade.getStudentId(),
                    grade.getCourseGrade());
        }
    }

    public static void main(String[] args) {
        showGradeMenu();
    }
}