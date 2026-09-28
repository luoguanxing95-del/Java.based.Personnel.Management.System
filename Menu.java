package test01;


/*
 * Menu 对应  Menu （菜单类）：定义多个方法
 * 显示各种操作对应的菜单 调用Operate类中的方法实现菜单中的内容
 */

public class Menu {

	

	/* 主菜单 */
	public void mainMenu() {
		// TODO Auto-generated method stub

		System.out.println("*******************");
		System.out.println("**    1.添加记录           **");
		System.out.println("**    2.查找记录           **");
		System.out.println("**    3.修改记录           **");
		System.out.println("**    4.删除记录           **");
		System.out.println("**    5.排序记录           **");
		System.out.println("**    6.退出系统           **");
		System.out.println("*******************");
		System.out.println("请输入正确的数字，最小是：1 最大是：6");
	}
		
	/* 添加用户菜单 */
	public void addMenu() {
		System.out.println("*******************");
		System.out.println("**    1.添加新记录       **");
		System.out.println("**    2.查看全记录       **");
		System.out.println("**    3.返回上一级       **");
		System.out.println("*******************");
		System.out.println("请输入正确的数字，最小是：1 最大是：3");

		
	}

	/* 查找用户菜单 */
	public void searchMenu() {
		System.out.println("*******************");
		System.out.println("**    1.按姓名查找       **");
		System.out.println("**    2.按年龄查找       **");
		System.out.println("**    3.按性别查找       **");
		System.out.println("**    4.按号码查找       **");
		System.out.println("**    5.按住址查找       **");
        System.out.println("**    6.按部门查找       **");
        System.out.println("**    7.按员工编号查找   **");
		System.out.println("**    8.查看全记录       **");
		System.out.println("**    9.返回上一级       **");
		System.out.println("*******************");
		System.out.println("请输入正确的数字，最小是：1 最大是：9");

	
	}

	/* 修改用户信息主菜单 */
	public void modifyMenu() {
		System.out.println("*******************");
		System.out.println("**    1.查看全记录       **");
		System.out.println("**    2.修改指定记录   **");
		System.out.println("**    3.返回上一级       **");
		System.out.println("*******************");
		System.out.println("请输入正确的数字，最小是：1 最大是：3");

		
	}

    /* 修改用户信息子菜单 */
    public void subModifyMenu() {
        System.out.println("\n=== 选择修改项目 ===");
        System.out.println("1. 修改姓名");
        System.out.println("2. 修改年龄");
        System.out.println("3. 修改性别");
        System.out.println("4. 修改电话");
        System.out.println("5. 修改住址");
        System.out.println("6. 修改人事信息（部门/职位/薪资等）");
        System.out.println("7. 返回上一级（修改其他员工）");
        System.out.print("请选择 (1-7)：");
    }

	/* 删除用户信息菜单 */
	public void deleteMenu() {
		System.out.println("*******************");
		System.out.println("**    1.查看全记录       **");
		System.out.println("**    2.删除指定记录   **");
		System.out.println("**    3.删除全部记录   **");
		System.out.println("**    4.返回上一级       **");
		System.out.println("*******************");
		System.out.println("请输入正确的数字，最小是：1 最大是：4");
	}

	/* 排序用户信息菜单 */
    public void orderMenu() {
        System.out.println("*******************");
        System.out.println("**    1.按姓名排序           **");
        System.out.println("**    2.按年龄排序           **");
        System.out.println("**    3.按性别排序           **");
        System.out.println("**    4.按部门排序           **");
        System.out.println("**    5.按薪资排序           **");
        System.out.println("**    6.查看全部记录       **");
        System.out.println("**    7.返回上一级           **");
        System.out.println("*******************");
        System.out.println("请输入正确的数字，最小是：1 最大是：7");
    }
}
