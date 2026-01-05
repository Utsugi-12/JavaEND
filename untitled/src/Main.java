import controller.ShowMenu;

public class Main {
    public static void main(String[] args) {
        ShowMenu menu = new ShowMenu();
        if (menu.login()) {
            menu.showMainMenu();
        } else {
            System.out.println("登录失败！");
        }
    }
}