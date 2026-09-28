package test01;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;


/*
 * Operate 对应  Operate（业务处理类）：定义每一个具体操作的方法，
 */

public class Operate {
	Scanner in = new Scanner(System.in); // 创建Scanner对象i
	ArrayList<Employee> list = new ArrayList<Employee>(); // 创建ArrayList集合
    //选择ArrayList主要基于以下几点考虑：
    //
    //访问需求：员工信息需要频繁按序号访问（如查找第n个员工），ArrayList基于数组实现，通过索引随机访问的时间复杂度是O(1)，而LinkedList需要遍历，是O(n)。
    //
    //数据特点：员工信息需要按添加顺序保存，ArrayList保持了插入顺序。虽然LinkedList插入删除更快，但我的系统中主要操作是遍历展示和查找，插入删除相对较少。
    //
    //内存效率：ArrayList每个元素只需要存储数据本身，而LinkedList每个节点还需要存储前后指针，内存开销更大。
    //
    //实际考虑：作为课程设计，数据量不会很大（通常几十到几百条），ArrayList的简单性和性能平衡更适合。"
	Menu menu = new Menu(); // 创建Menu对象
    EmployeeRegex t = new EmployeeRegex(); // 创建EmployeeRegex对象
	int num = 0;
	/* 主控台 */
	public void mainLogic() {
		menu.mainMenu();
		String s1 = in.next();
		while (true) {
			if (s1.equals("1") || s1.equals("2") || s1.equals("3") || s1.equals("4") || s1.equals("5")
					|| s1.equals("6")) {// 通过if中的equals判断是否符合选项要求
				switch (s1) { // 通过switch语句进行选择
				case "1":
					addLogic();
					break;
				case "2":
					searchLogic();
					break;
				case "3":
					modifyLogic();
					break;
				case "4":
					deleteLogic();
					break;
                    case "5":
                        orderLogic();
                        break;
                    case "6":
                        System.out.println("感谢您的使用！");
                        try {
						write();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
			} else {
				System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
				s1 = in.next();// 对s1进行重新输入及赋值
			}
		}

	}
	
	
	/* 添加记录 */
	public void addLogic() {
		// TODO Auto-generated method stub
		menu.addMenu();
		String s2 = in.next();// 用户输入选择的数字
		while (true) {
			if (s2.equals("1") || s2.equals("2") || s2.equals("3")) {// 通过if中的equals判断是否符合选项要求
				switch (s2) { // 通过switch语句进行选择
				case "1":
					addOperation();
					addLogic();
					break;
				case "2":
					showAll();
					addLogic();
					break;
				case "3":
					mainLogic();
					break;
				}
			} else {
				System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
				s2 = in.next();// 对s2进行重新输入及赋值
			}
		}
	}
	
	
	/*查找记录*/
    public void searchLogic() {
        menu.searchMenu();
        String s3 = in.next();// 用户输入选择的数字
        while (true) {
            if (s3.equals("1") || s3.equals("2") || s3.equals("3") || s3.equals("4") || s3.equals("5") || s3.equals("6")
                    || s3.equals("7") || s3.equals("8") || s3.equals("9")) {// 通过if中的equals判断是否符合选项要求
                switch (s3) { // 通过switch语句进行选择
                    case "1":
                        searchByName();
                        searchLogic();
                        break;
                    case "2":
                        searchByAge();
                        searchLogic();
                        break;
                    case "3":
                        searchBySex();
                        searchLogic();
                        break;
                    case "4":
                        searchByTelNum();
                        searchLogic();
                        break;
                    case "5":
                        searchByAdd();
                        searchLogic();
                        break;
                    case "6":
                        searchByDepartment();  // 添加按部门查找
                        searchLogic();
                        break;
                    case "7":
                        searchByEmployeeId();  // 添加按员工编号查找
                        searchLogic();
                        break;
                    case "8":
                        showAll();
                        searchLogic();
                        break;
                    case "9":
                        mainLogic();
                        break;
                }
            } else {
                System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
                s3 = in.next();// 对s3进行重新输入及赋值
            }
        }
    }
	
	
	/* 修改记录 */
	public void modifyLogic() {
		// TODO Auto-generated method stub
		menu.modifyMenu();
		String s4 = in.next();// 用户输入选择的数字
		while (true) {
			if (s4.equals("1") || s4.equals("2") || s4.equals("3")) {// 通过if中的equals判断是否符合选项要求
				switch (s4) { // 通过switch语句进行选择
				case "1":
					showAll();
					modifyLogic();
					break;
				case "2":
					modify();
					modifyLogic();
					break;
				case "3":
					mainLogic();
					break;
				}
			} else {
				System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
				s4 = in.next();// 对s4进行重新输入及赋值
			}
		}
	}
	
	
	/* 删除记录 */
	public void deleteLogic() {
		// TODO Auto-generated method stub
		menu.deleteMenu();
		String s6 = in.next();
		while (true) {
			if (s6.equals("1") || s6.equals("2") || s6.equals("3") || s6.equals("4")) {// 通过if中的equals判断是否符合选项要求
				switch (s6) { // 通过switch语句进行选择
				case "1":
					showAll();
					deleteLogic();
					break;
				case "2":
					delete();
					deleteLogic();
                    break;
				case "3":
					deleteAll();
					deleteLogic();
                    break;
				case "4":
					mainLogic();
					break;
				}
			} else {
				System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
				s6 = in.next();// 对s6进行重新输入及赋值
			}
		}
	}
	
	/* 排序记录 */
    public  void orderLogic() {
        // TODO Auto-generated method stub
        menu.orderMenu();
        String s7 = in.next();
        while (true) {
            // 修复：将判断条件改为1-7（包含7）
            if (s7.equals("1") || s7.equals("2") || s7.equals("3") || s7.equals("4") || s7.equals("5")
                    || s7.equals("6") || s7.equals("7")) {// 通过if中的equals判断是否符合选项要求
                switch (s7) { // 通过switch语句进行选择
                    case "1":
                        orderName();
                        orderLogic();
                        break;
                    case "2":
                        orderAge();
                        orderLogic();
                        break;
                    case "3":
                        orderSex();
                        orderLogic();
                        break;
                    case "4":
                        orderDepartment();  // 修复：改为按部门排序
                        orderLogic();
                        break;
                    case "5":
                        orderSalary();      // 修复：改为按薪资排序
                        orderLogic();
                        break;
                    case "6":
                        showAll();          // 修复：查看全部记录
                        orderLogic();
                        break;
                    case "7":
                        mainLogic();        // 修复：返回上一级
                        break;
                }
            } else {
                System.out.println("输入错误，请重新进行输入！");// 如不符合要求则在此进行重新输入
                s7 = in.next();// 对s5进行重新输入及赋值
            }
        }
    }
    /* 按部门排序 */
    public void orderDepartment() {
        Collections.sort(list, new OrderByDepartment());
        System.out.println("按部门排序成功！");
    }

    /* 按薪资排序 */
    public void orderSalary() {
        Collections.sort(list, new OrderBySalary());
        System.out.println("按薪资排序成功！");
    }
	
	
	
	
	/* 添加新牛马 */
    public void addOperation() {
        // TODO Auto-generated method stub
        System.out.println("===== 添加新员工 =====");
        //基础信息
        System.out.println("请输入姓名：(1-4个中文字符或2-20个英文字母)");
        String name = in.next(); // 用户输入名字
        name = t.nameRegex(name); // 验证输入的名字是否合法
        System.out.println("请输入年龄：(18~60)");  // 修复：提示范围0~60，与验证一致
        String age = in.next(); // 用户输入年龄
        age = t.ageRegex(age);// 验证输入的年龄是否合法
        System.out.println("请选择性别（男：m或M  女：f或F）");
        String sex = in.next(); // 用户输入性别
        sex = t.sexRegex(sex);// 验证输入的性别是否合法
        System.out.println("请输入联系方式：(6~11位数字)");
        String telNum = in.next(); // 用户输入联系方式
        telNum = t.telRegex(telNum);// 验证输入的联系方式是否合法
        System.out.println("请输入住址：(1~50位字母或数字)");
        String address = in.next(); // 用户输入地址
        address = t.addRegex(address);// 验证输入的地址是否合法

        in.nextLine(); // 清除缓冲区

        System.out.println("请输入员工编号：");
        String employeeId = in.nextLine();// 用户输入员工编号
        employeeId = t.employeeIdRegex(employeeId);// 验证员工编号是否合法
        System.out.println("请输入部门：");
        String department = in.nextLine();// 用户输入部门

        System.out.println("请输入职位：");
        String position = in.nextLine();// 用户输入职位

        // 修复：移除这里的"请输入薪资："提示，因为t.salaryRegex()方法内部会提示
        double salary = t.salaryRegex(in);// 用户输入薪资并验证

        System.out.println("请输入邮箱：");
        String email = in.next();// 用户输入邮箱
        email = t.emailRegex(email);// 验证邮箱是否合法

        System.out.println("请输入学历（如：本科/硕士）：");
        String education = in.next();// 用户输入学历

        num++; // 用于标记用户的id

        // 如果只有基础信息
        Employee emp = new Employee(num, name, age, sex, telNum, address);

        // 如果需要设置人事信息
        emp.setEmployeeId(employeeId);
        emp.setDepartment(department);
        emp.setPosition(position);
        emp.setSalary(salary);
        emp.setEmail(email);
        emp.setEducation(education);
        // 调用Employee有参的构造方法，进行属性的赋值
        list.add(emp); // 将per加入到集合中
        System.out.println("新员工添加成功！");
        System.out.println(" 是否继续添加      是-1  （选择除 1 以外则默认为'否'） ");
        String s1 = in.next(); // 是否继续的输入
        if (!s1.equals("1")) {
            addLogic(); // 如果不再继续，返回添加信息的菜单中
        } else {
            addOperation(); // 如果继续添加，再次调用此方法
        }
    }

	/* 查看全记录 */
	public void showAll() {
		Iterator<Employee> it = list.iterator();
		int id = 1;
		while (it.hasNext()) {
            Employee employee = it.next();
			employee.setId(id++);
			System.out.println(" 序号：" + employee.getId() + "#" + employee);
		}
		
	}
    //精确匹配，用equals()方法。如果需要模糊匹配，可以改用contains()。这是可以改进的地方，比如支持输入部分姓名就能查找。
    //模糊匹配版本
    //if (e.getName().contains(na)) {
    //    System.out.println(e.toString());
    //}

	/* 按姓名进行查找 */
	public void searchByName() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查找员工的姓名：");
		boolean b = true; // 标志
		String na = in.next(); // 输入姓名
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (na.equals(e.getName())) {
				System.out.println(e.toString()); // 找到后 输出打印
				b = false;
			}
		}
		if (b) {
			System.out.println("您所要查找的员工不存在！");

		}
		
	}

	/* 按年龄进行查找 */
	public void searchByAge() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查找的员工的年龄：");
		boolean b = true; // 标志
		String ag = in.next(); // 用户输入的年龄
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (ag.equals(e.getAge())) {
				System.out.println(e.toString()); // 找到后 输出打印
				b = false;
			}
		}
		if (b) {
			System.out.println("您所要查找的员工不存在！");

		}
		
	}

	/* 按性别进行查找 */
	public void searchBySex() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查找的员工的性别：");
		boolean b = true; // 标志
		String sx = in.next(); // 用户输入的性别
		sx = t.sexRegex(sx); // 进行验证
		sexSch(sx); // 进行查找
		if ((sx == "M" || sx == "F")) {
			b = false; // 输入正确b进行转换
		}
		if (b) {
			System.out.println("您所要查找的员工不存在！");

		}
		
	}

	public void sexSch(String sx) {
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (sx.equals(e.getSex())) {
				System.out.println(e.toString()); // 找到后 输出打印
			}
		}
	}

	/* 按联系方式进行查找 */
	public void searchByTelNum() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查找的员工的联系方式：");
		boolean b = true; // 标志
		String tel = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e =  it.next(); // 将集合中的元素取出
			if (tel.equals(e.getTelNum())) {
				System.out.println(e.toString()); // 找到后 输出打印
				b = false;
			}
		}
		if (b) {
			System.out.println("您所要查找的员工不存在！");

		}
		
	}
    /* 按部门进行查找 */
    public void searchByDepartment() {
        System.out.println("请输入您要查找的部门：");
        boolean b = true;
        String dept = in.next();
        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (dept.equals(e.getDepartment())) {
                System.out.println(e.toSimpleString());
                b = false;
            }
        }
        if (b) {
            System.out.println("您所查找的员工不存在于该部门！");
        }
    }
    /* 按员工编号进行查找 */
    public void searchByEmployeeId() {
        System.out.println("请输入您要查找的员工编号：");
        boolean b = true;
        String empId = in.next();
        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (empId.equals(e.getEmployeeId())) {
                System.out.println(e.toString());
                b = false;
            }
        }
        if (b) {
            System.out.println("您所要查找的员工不存在！");
        }
    }

	/* 按地址进行查找 */
	public void searchByAdd() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要查找的员工的地址：");
		boolean b = true;
		String ad = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e =  it.next(); // 将集合中的元素取出
			if (ad.equals(e.getAddress())) {
				System.out.println(e.toString()); // 找到后 输出打印
				b = false;
			}
		}
		if (b) {
			System.out.println("您所要查找的员工不存在！");

		}

		
	}

	/* 删除指定用户信息 */
    public void delete() {
        // TODO Auto-generated method stub
        System.out.println("========== 当前员工列表 ==========");
        showAll();  // 先显示所有员工
        System.out.println("=================================");

        if (list.isEmpty()) {
            System.out.println("当前没有员工记录！");
            return;
        }

        System.out.println("\n请输入您要删除的员工序号（如上表所示）：");
        boolean b = true;

        try {
            Integer s2 = in.nextInt(); // 用户输入的序号

            // 验证序号是否在有效范围内
            if (s2 < 1 || s2 > list.size()) {
                System.out.println("序号无效！请输入1到" + list.size() + "之间的数字。");
                in.nextLine(); // 清除输入缓冲区
                return;
            }

            // 确认删除
            System.out.println("您确定要删除序号为 " + s2 + " 的员工吗？(y/n)");
            in.nextLine(); // 清除换行符
            String confirm = in.nextLine();

            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("取消删除操作。");
                return;
            }

            // 查找并删除
            Iterator<Employee> it = list.iterator(); // 获取Iterator对象
            int currentIndex = 1;

            while (it.hasNext()) { // 判断集合中是否存在下一个元素
                Employee e = it.next(); // 将集合中的元素取出
                if (currentIndex == s2) {
                    System.out.println("即将删除员工：" + e.getName() + " (员工编号：" + e.getEmployeeId() + ")");
                    it.remove(); // 找到后进行删除
                    //在遍历集合时直接调用list.remove()会抛出ConcurrentModificationException。
                    //迭代器的remove()方法会同时更新迭代器的状态，避免这个问题。这是Java集合框架的一个注意事项。
                    System.out.println("删除成功！");

                    // 重新设置所有员工的ID（保持连续）
                    int newId = 1;
                    for (Employee emp : list) {
                        emp.setId(newId++);
                    }
                    num = list.size(); // 更新num变量

                    b = false;
                    break;
                }
                currentIndex++;
            }

            if (b) {
                System.out.println("您所要删除的员工不存在！");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("输入错误！请输入数字序号。");
            in.nextLine(); // 清除错误的输入
        }
    }

	/* 删除全部用户信息 */
	public void deleteAll() {
		// TODO Auto-generated method stub
		list.removeAll(list); // 清空集合中的所有元素
		System.out.println("已清空！");
		
	}

	/* 按姓名进行排序 */
	public void orderName() {
		// TODO Auto-generated methodstub
		Collections.sort(list, new OrderByName()); // 传入比较器
		System.out.println("排序成功！");
		
	}
//使用Collections.sort()方法，配合不同的Comparator实现类。
// 比如按姓名排序用OrderByName类，它实现了compare()方法，比较两个员工的姓名。
// 每个排序方式都要单独写一个类符合单一职责原则，每个类只负责一种排序逻辑。也方便扩展，要加新的排序方式只需要新增一个类，不用修改现有代码，符合开闭原则。
	

	/* 按年龄排序 */
	public void orderAge() {
		// TODO Auto-generated method stub
		Collections.sort(list, new OrderByAge()); // 传入比较器
		System.out.println("排序成功！");
		
	}

	

	/* 按性别排序 */
	public void orderSex() {
		// TODO Auto-generated method stub
		Collections.sort(list, new OrderBySex()); // 传入比较器
		System.out.println("排序成功！");
		
	}

    /* 按部门排序 */
    public void OrderDepartment() {
        Collections.sort(list, new OrderByDepartment());
        System.out.println("按部门排序成功！");
        showAll(); // 排序后显示结果
    }

    /* 按薪资排序 */
    public void OrderSalary() {
        Collections.sort(list, new OrderBySalary());
        System.out.println("按薪资排序成功！");
        showAll(); // 排序后显示结果
    }
// 使用Collections.sort()方法，配合不同的Comparator实现类。
// 目前都是升序。要改降序有两种方式：一是在比较器里调换o1和o2的位置；
// 二是用Collections.reverseOrder()包装比较器。
// 降序排序
//Collections.sort(list, Collections.reverseOrder(new OrderByName()));
	

	/* 修改指定用户信息 */
    public void modify() {
        //  先显示所有员工
        showAll();

        // 获取要修改的员工序号
        System.out.print("\n请输入要修改的员工序号：");
        try {
            int employeeId = in.nextInt();
            in.nextLine(); // 清除换行符

            // 查找员工
            Employee targetEmployee = null;
            for (Employee emp : list) {
                if (emp.getId() == employeeId) {
                    targetEmployee = emp;
                    break;
                }
            }

            if (targetEmployee == null) {
                System.out.println("未找到序号为 " + employeeId + " 的员工！");
                return;
            }

            System.out.println("\n当前员工信息：");
            System.out.println(targetEmployee.toDetailString());

            final Employee finalTarget = targetEmployee;// 创建 final 变量供 lambda 表达式使用
            //  使用现有的子菜单
            boolean continueModify = true;
            while (continueModify) {
                // 使用Menu类中的subModifyMenu
                menu.subModifyMenu();
                String choice = in.next();
                in.nextLine(); // 清除换行符

                switch (choice) {
                    case "1":
                        modifyField(finalTarget, "姓名", () -> {
                            System.out.print("请输入新姓名：");
                            String newName = in.nextLine();
                            return t.nameRegex(newName);
                        }, finalTarget::setName);
                        break;

                    case "2":
                        modifyField(finalTarget, "年龄", () -> {
                            System.out.print("请输入新年龄：");
                            String newAge = in.nextLine();
                            return t.ageRegex(newAge);
                        }, finalTarget::setAge);
                        break;

                    case "3":
                        modifyField(finalTarget, "性别", () -> {
                            System.out.print("请输入新性别(M/F)：");
                            String newSex = in.nextLine();
                            return t.sexRegex(newSex);
                        }, finalTarget::setSex);
                        break;

                    case "4":
                        modifyField(finalTarget, "电话", () -> {
                            System.out.print("请输入新电话：");
                            String newTel = in.nextLine();
                            return t.telRegex(newTel);
                        }, finalTarget::setTelNum);
                        break;

                    case "5":
                        modifyField(finalTarget, "住址", () -> {
                            System.out.print("请输入新住址：");
                            String newAddress = in.nextLine();
                            return t.addRegex(newAddress);
                        }, finalTarget::setAddress);
                        break;

                    // 扩展功能：人事信息修改
                    case "6":
                        boolean continueHRModify = true;
                        while (continueHRModify) {
                            System.out.println("=== 人事信息修改 ===");
                            System.out.println("1. 修改部门");
                            System.out.println("2. 修改职位");
                            System.out.println("3. 修改薪资");
                            System.out.println("4. 修改邮箱");
                            System.out.println("5. 修改学历");
                            System.out.println("6. 返回上一级");
                            System.out.print("请选择：");
                            String hrChoice = in.nextLine();

                            if (hrChoice.equals("6")) {
                                continueHRModify = false;
                                continue;  // 继续主修改循环
                            }

                            switch (hrChoice) {
                                case "1":
                                    modifyField(finalTarget, "部门", () -> {
                                        System.out.print("请输入新部门：");
                                        return in.nextLine();
                                    }, finalTarget::setDepartment);
                                    break;
                                case "2":
                                    modifyField(finalTarget, "职位", () -> {
                                        System.out.print("请输入新职位：");
                                        return in.nextLine();
                                    }, finalTarget::setPosition);
                                    break;
                                case "3":
                                    modifyField(finalTarget, "薪资", () -> {
                                        System.out.print("请输入新薪资：");
                                        String salaryStr = in.nextLine();
                                        try {
                                            double salary = Double.parseDouble(salaryStr);
                                            if (salary < 0) {
                                                System.out.println("薪资不能为负数！使用原值");
                                                return Double.toString(finalTarget.getSalary());
                                            }
                                            return salaryStr;
                                        } catch (NumberFormatException e) {
                                            System.out.println("格式错误！使用原值");
                                            return Double.toString(finalTarget.getSalary());
                                        }
                                    }, (value) -> finalTarget.setSalary(Double.parseDouble(value)));
                                    break;
                                case "4":
                                    modifyField(finalTarget, "邮箱", () -> {
                                        System.out.print("请输入新邮箱：");
                                        String email = in.nextLine();
                                        if (!email.isEmpty()) {
                                            return t.emailRegex(email);
                                        }
                                        return email;
                                    }, finalTarget::setEmail);
                                    break;
                                case "5":
                                    modifyField(finalTarget, "学历", () -> {
                                        System.out.print("请输入新学历：");
                                        return in.nextLine();
                                    }, finalTarget::setEducation);
                                    break;
                                default:
                                    System.out.println("无效选择！");
                            }

                            if (!hrChoice.equals("6") && !hrChoice.equals("7")) {
                                System.out.println("\n是否继续修改其他人事信息？(y/n)");
                                String continueHRChoice = in.nextLine();
                                if (!continueHRChoice.equalsIgnoreCase("y")) {
                                    continueHRModify = false;
                                }
                            }
                        }
                        break;
                    case "7": // 返回上一级
                        continueModify = false;
                        break;

                    default:
                        System.out.println("无效选择！");
                }

                if (continueModify) {
                    System.out.println("\n是否继续修改此员工的其他信息？(是请输入 y/Y，否请输入 n/N 或其他键)：");
                    String continueChoice = in.nextLine();
                    if (!continueChoice.equalsIgnoreCase("y")) {
                        continueModify = false;
                        System.out.println("返回人事信息修改主菜单...");
                    }
                }
            }

            System.out.println("\n修改完成！当前员工信息：");
            System.out.println(targetEmployee.toDetailString());

        } catch (Exception e) {
            System.out.println("输入错误：" + e.getMessage());
            in.nextLine(); // 清除错误输入
        }
    }

    private void modifyField(Employee emp, String fieldName, Supplier<String> inputGetter, Consumer<String> setter) {
        // 多态：使用了Supplier和Consumer函数式接口，可以通过lambda表达式实现不同的行为。
        System.out.print("当前" + fieldName + "：" + getFieldValue(emp, fieldName) + "，");
        String newValue = inputGetter.get();
        if (!newValue.trim().isEmpty()) {
            setter.accept(newValue);
            System.out.println(fieldName + "已修改为：" + newValue);
        } else {
            System.out.println(fieldName + "未修改");
        }
    }

    private String getFieldValue(Employee emp, String fieldName) {
        switch (fieldName) {
            case "姓名": return emp.getName();
            case "年龄": return emp.getAge();
            case "性别": return emp.getSex();
            case "电话": return emp.getTelNum();
            case "住址": return emp.getAddress();
            case "部门": return emp.getDepartment();
            case "职位": return emp.getPosition();
            case "薪资": return String.format("%.2f", emp.getSalary());
            case "邮箱": return emp.getEmail();
            case "学历": return emp.getEducation();
            default: return "";
        }
    }

	/* 修改姓名 */
	public void modName() {
		// TODO Auto-generated method stub
		int f = 1; // 标志
		System.out.println("请输入您要修改的员工的姓名：");
		String s3 = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (s3.equals(e.getName())) {
				System.out.println("请输入您要修改的内容：");
				String s4 = in.next();
				e.setName(s4); // 进行修改
				System.out.println("已成功修改！");
				f = 0;
			}
		}
		if (f == 1) {
			System.out.println("您所要查找的员工不存在！请核对后再试！");
		}
		
	}

	/* 修改年龄 */
	public void modAge() {
		// TODO Auto-generated method stub
		int f = 1;
		System.out.println("请输入您要修改的员工的姓名：");
		String s3 = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (s3.equals(e.getName())) {
				System.out.println("请输入您要修改的内容：");
				String s4 = in.next();
				e.setAge(s4); // 进行修改
				System.out.println("已成功修改！");
				f = 0;
			}
		}
		if (f == 1) {
			System.out.println("您所要查找的员工不存在！请核对后再试！");
		}
		
	}

	/* 修改性别 */
	public void modSex() {
		// TODO Auto-generated method stub
		int f = 1;
		System.out.println("请输入您要修改的员工的姓名：");
		String s3 = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (s3.equals(e.getName())) {
				System.out.println("请输入您要修改的内容：");
				String s4 = in.next();
				s4 = t.sexRegex(s4); // 进行性别验证
				e.setSex(s4); // 进行修改
				System.out.println("已成功修改！");
				f = 0;
			}
		}
		if (f == 1) {
			System.out.println("您所要查找的员工不存在！请核对后再试！");
		}
		
	}

	/* 修改联系方式 */
	public void modNumber() {
		// TODO Auto-generated method stub
		int f = 1;
		System.out.println("请输入您要修改的员工的姓名：");
		String s3 = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象
		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (s3.equals(e.getName())) {
				System.out.println("请输入您要修改的内容：");
				String s4 = in.next();
				e.setTelNum(s4); // 进行修改
				System.out.println("已成功修改！");
				f = 0;
			}
		}
		if (f == 1) {
			System.out.println("您所要查找的员工不存在！请核对后再试！");
		}
		
	}

	/* 修改住址 */
	public void modAdd() {
		// TODO Auto-generated method stub
		int f = 1;
		System.out.println("请输入您要修改的员工的姓名：");
		String s3 = in.next();
		Iterator<Employee> it = list.iterator(); // 获取Iterator对象

		while (it.hasNext()) { // 判断集合中是否存在下一个元素
            Employee e = (Employee) it.next(); // 将集合中的元素取出
			if (s3.equals(e.getName())) {
				System.out.println("请输入您要修改的内容：");
				String s4 = in.next();
				e.setAddress(s4); // 进行修改
				System.out.println("已成功修改！");
				f = 0;
			}
		}
		if (f == 1) {
			System.out.println("您所要查找的员工不存在！请核对后再试！");
		}
		
	}
    /*io读记录到程序中 */
    public void read() throws IOException {
        // 创建文件对象，指向数据文件
        File fromFile = new File("Contact employee.txt");

        // 检查文件是否存在，如果不存在则提示并返回
        if (!fromFile.exists()) {
            System.out.println("数据文件不存在，将创建新文件");
            return;  // 直接返回，避免后续文件操作异常
        }

        // 创建字符输入流读取文件内容
        Reader reader = new FileReader(fromFile);
        // 使用缓冲流提高读取效率
        BufferedReader br = new BufferedReader(reader);
        //有缓冲区，可以减少实际读写磁盘的次数，提高性能。特别是数据量大时，性能提升明显。
        String str = "";  // 用于存储读取的每一行数据

        // 用于记录文件中的最大id值，确保新增记录的id连续递增
        int maxId = 0;

        // 循环读取文件的每一行，直到文件末尾（null）
        while ((str = br.readLine()) != null) {
            if (str.trim().isEmpty()) {
                continue;  // 跳过本次循环的剩余部分
            }

            String[] arr = str.split("#");

            // 创建新的Employee对象，用于存储当前行的数据
            Employee e = new Employee();

            // 使用try-catch处理可能的转换异常
            try {
                // 设置基本属性（原有6个属性）
                e.setId(Integer.parseInt(arr[0].trim()));      // 序号
                e.setName(arr[1].trim());                      // 姓名
                e.setAge(arr[2].trim());                       // 年龄
                e.setSex(arr[3].trim());                       // 性别
                e.setTelNum(arr[4].trim());                    // 电话号码
                e.setAddress(arr[5].trim());                   // 地址

                // 更新最大id值，用于后续添加记录时生成新id
                if (e.getId() > maxId) {
                    maxId = e.getId();
                }
                    if (arr.length >= 12) {
                        // 设置人事属性
                        e.setEmployeeId(arr[6].trim());                       // 员工编号
                        e.setDepartment(arr[7].trim());                       // 部门
                        e.setPosition(arr[8].trim());                         // 职位
                        e.setSalary(Double.parseDouble(arr[9].trim()));       // 薪资
                        e.setEmail(arr[10].trim());                           // 邮箱
                        e.setEducation(arr[11].trim());                       // 学历
                    }
                    // 如果字段数量在7-11之间，说明是过渡格式，部分人事信息
                    else if (arr.length > 6) {
                        // 遍历额外的字段，根据位置判断字段类型
                        for (int i = 6; i < arr.length; i++) {
                            switch (i) {
                                case 6:
                                    e.setEmployeeId(arr[i].trim());   // 第7个字段是员工编号
                                    break;
                                case 7:
                                    e.setDepartment(arr[i].trim());   // 第8个字段是部门
                                    break;
                                case 8:
                                    e.setPosition(arr[i].trim());     // 第9个字段是职位
                                    break;
                                case 9:
                                    try {
                                        // 第10个字段是薪资，需要转换为double类型
                                        e.setSalary(Double.parseDouble(arr[i].trim()));
                                    } catch (NumberFormatException ex) {
                                        // 如果转换失败，设置为默认值0.0
                                        e.setSalary(0.0);
                                    }
                                    break;
                                case 10:
                                    e.setEmail(arr[i].trim());        // 第11个字段是邮箱
                                    break;
                                case 11:
                                    e.setEducation(arr[i].trim());    // 第12个字段是学历
                                    break;
                            }
                        }
                    }
                    // 如果只有6个字段，就是旧格式，只有基本属性

                    // 将处理好的Employee对象添加到集合中
                    list.add(e);

                } catch(Exception ex){
                    // 处理读取数据时的异常，打印错误信息但不中断程序
                    System.out.println("读取数据行时出错: " + str);
                    ex.printStackTrace();  // 打印详细异常信息，便于调试
                }

            }
        // 设置下一个员工的id（当前最大id + 1）
        // 确保新添加的记录的id是唯一的、递增的
        num = maxId + 1;

        // 关闭流资源，释放系统资源
        br.close();
        reader.close();

        // 提示用户加载了多少条记录
        System.out.println("已加载 " + list.size() + " 条员工记录");
    }

    /*io输出*/
    public void write() throws IOException {
        // 创建FileWriter对象，第二个参数false表示覆盖文件（true表示追加）
        Writer fileWriter = new FileWriter("Contact employee.txt", false);

        // 使用缓冲流提高写入效率
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //有缓冲区，可以减少实际读写磁盘的次数，提高性能。特别是数据量大时，性能提升明显。
        Iterator<Employee> it = list.iterator();  // 使用迭代器遍历集合

        int writeCount = 0;  // 计数器，记录成功写入的记录数量

        // 遍历集合中的所有员工记录
        while (it.hasNext()) {
            Employee e = it.next();  // 获取下一个员工对象

            try {
                // 使用StringBuilder构建要写入的一行数据
                StringBuilder line = new StringBuilder();

                // 添加基本属性到字符串
                line.append(e.getId()).append("#");          // 序号
                line.append(e.getName()).append("#");        // 姓名
                line.append(e.getAge()).append("#");         // 年龄
                line.append(e.getSex()).append("#");         // 性别
                line.append(e.getTelNum()).append("#");      // 电话
                line.append(e.getAddress()).append("#");     // 地址

                // 添加人事属性到字符串
                line.append(e.getEmployeeId()).append("#");  // 员工编号
                line.append(e.getDepartment()).append("#");  // 部门
                line.append(e.getPosition()).append("#");    // 职位

                // 薪资格式化为两位小数
                line.append(String.format("%.2f", e.getSalary())).append("#");

                line.append(e.getEmail()).append("#");       // 邮箱
                line.append(e.getEducation());               // 学历

                // 将构建好的字符串写入文件
                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();  // 写入换行符（比\r\n更可移植，适应不同操作系统）

                writeCount++;  // 成功写入一条记录，计数器加1

            } catch (Exception ex) {
                // 处理写入异常，打印错误信息但不中断程序
                System.out.println("写入员工记录时出错: " + e.getName());
                ex.printStackTrace();  // 打印详细异常信息
            }
        }

        // 刷新缓冲区，确保所有数据都写入文件
        bufferedWriter.flush();
        // 关闭流资源
        bufferedWriter.close();
        fileWriter.close();

        // 提示用户保存了多少条记录
        System.out.println("写入完成！共保存 " + writeCount + " 条员工记录");
    }
}



