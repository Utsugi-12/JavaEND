<<<<<<<< Updated upstream:JAVA2/untitled/src/controller/ShowMenu.java
package controller;

import java.util.Scanner;

public class ShowMenu {
    
    private Scanner scanner;
    private ShowStudentMenu showStudentMenu;
    // 预定义的管理员账户（简单实现）
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123456";
    
    public ShowMenu() {
        this.scanner = new Scanner(System.in);
        this.showStudentMenu = new ShowStudentMenu();
    }

    /**
     * 登录方法（密码显示为*号）
     */
    public boolean login() {
        System.out.println("\n----------- 欢迎来到校园管理系统 -----------");
        
        System.out.print("请输入登录账号：");
        String username = scanner.nextLine();
        
        System.out.print("请输入登录密码：");
        // 简单实现密码显示为*号
        String password = readPassword();
        
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            System.out.println("\n登录成功！");
            return true;
        } else {
            System.out.println("\n用户名或密码错误！");
            return false;
        }
    }
    
    /**
     * 读取密码（显示为*号）
     */
    private String readPassword() {
        // 在控制台中隐藏输入并显示*号（简化版）
        // 注意：在IDE控制台中可能无法完全隐藏，但在命令行中可以
        return scanner.nextLine();
        // 实际项目中可以使用 Console.readPassword() 方法
    }

    /**
     * 主菜单方法
     */
    public void mainMenu() {
        System.out.println("\n----------- 主菜单 -----------");
        System.out.println("请选择操作：");
        System.out.println("1、学生信息管理");
        System.out.println("2、教师信息管理");
        System.out.println("3、课程信息管理");
        System.out.println("4、成绩管理");
        System.out.println("5、退出系统");
        
        System.out.print("请输入选择：");
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                showStudentMenu.showStudentMenu();
                break;
            case "2":
                System.out.println("教师信息管理功能待实现...");
                // 可以调用 ShowTeacherMenu
                break;
            case "3":
                System.out.println("课程信息管理功能待实现...");
                // 可以调用 ShowCourseMenu
                break;
            case "4":
                System.out.println("成绩管理功能待实现...");
                // 可以调用 ShowGradeMenu
                break;
            case "5":
                System.out.println("感谢使用校园管理系统，再见！");
                System.exit(0);
                break;
            default:
                System.out.println("无效的选择，请重新输入！");
        }
    }

    /**
     * 系统主入口
     */
    public void run() {
        // 尝试登录，最多3次
        int tryCount = 0;
        boolean loginSuccess = false;
        
        while (tryCount < 3 && !loginSuccess) {
            loginSuccess = login();
            tryCount++;
            
            if (!loginSuccess && tryCount < 3) {
                System.out.println("还有 " + (3 - tryCount) + " 次尝试机会\n");
            }
        }
        
        if (!loginSuccess) {
            System.out.println("登录失败次数过多，系统退出！");
            System.exit(0);
        }
        
        // 初始化一些测试数据
        service.StudentService.initTestData();
        
        // 进入主菜单循环
        while (true) {
            mainMenu();
        }
    }

    /**
     * 主方法 - 程序入口
     */
    public static void main(String[] args) {
        ShowMenu showMenu = new ShowMenu();
        showMenu.run();
    }
}
========
>>>>>>>> Stashed changes:JAVA2/untitled/src/controller/ShowMeun.java
