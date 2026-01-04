package controller;

import java.util.Scanner;

public class ShowMenu {
    private static Scanner scanner = new Scanner(System.in);
    
    // 预设的账号密码用于测试
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        if (login()) {
            showMainMenu();
        } else {
            System.out.println("登录失败，程序退出！");
        }
    }

    public static boolean login() {
        System.out.println("-------------------欢迎来到校园管理系统-------------------");
        
        System.out.print("请输入登录账号：");
        String username = scanner.nextLine().trim();
        
        System.out.print("请输入登录密码：");
        String password = readPassword();
        
        // 简单验证账号密码
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            System.out.println("登录成功！");
            return true;
        } else {
            System.out.println("账号或密码错误！");
            return false;
        }
    }

    // 使用Scanner实现密码隐藏输入
    private static String readPassword() {
        char[] password = System.console() != null ? 
            System.console().readPassword() : 
            scanner.nextLine().toCharArray();
        
        // 如果控制台不可用，使用Scanner方式
        if (password == null) {
            System.out.print("(控制台不可用，直接输入密码，不会隐藏)：");
            String pass = scanner.nextLine();
            return pass;
        }
        
        return new String(password);
    }

    public static void showMainMenu() {
        while (true) {
            System.out.println("-------------------欢迎来到校园管理系统-------------------");
            System.out.println("请选择操作：");
            System.out.println("1、学生信息管理");
            System.out.println("2、教师信息管理");
            System.out.println("3、课程信息管理");
            System.out.println("4、成绩管理");
            System.out.println("5、退出系统");
            System.out.print("请输入您的选择：");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 消费换行符

                switch (choice) {
                    case 1:
                        System.out.println("进入学生信息管理...");
                        ShowStudentMenu.showStudentMenu();
                        break;
                    case 2:
                        System.out.println("进入教师信息管理...");
                        // 这里需要调用ShowTeacherMenu，但当前没有实现，暂时提示
                        System.out.println("该功能暂未实现！");
                        break;
                    case 3:
                        System.out.println("进入课程信息管理...");
                        ShowCourseMenu.showCourseMenu();
                        break;
                    case 4:
                        System.out.println("进入成绩管理...");
                        ShowGradeMenu.showGradeMenu();
                        break;
                    case 5:
                        System.out.println("退出系统，再见！");
                        return;
                    default:
                        System.out.println("输入错误，请输入1-5之间的数字！");
                        break;
                }
            } catch (Exception e) {
                System.out.println("输入格式错误，请输入数字！");
                scanner.nextLine(); // 清除错误输入
            }

            System.out.println(); // 添加空行分隔
        }
    }
}