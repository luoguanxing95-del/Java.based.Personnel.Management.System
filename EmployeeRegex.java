package test01;

import java.util.Scanner;
/*
 *EmployeeRegex 对应 EmployeeRegex（用户输入验证类
 * 用于对用户输入的姓名，年龄等属性进行验证。
 */

public class EmployeeRegex{
	Scanner write = new Scanner(System.in); // 创建Scanner对象write

	/* 姓名验证 */
    /* 姓名验证 */
    public String nameRegex(String name) {
        while (true) {
            // 中文姓名支持（1-4个中文字符或2-20个英文字母）
            if (!name.matches("^[\\u4e00-\\u9fa5]{1,4}|[a-zA-Z\\s]{2,20}$")) {
                System.out.println("姓名格式有误！支持中文(1-4字)或英文(2-20字母)，请重新输入：");
                name = write.next(); // 重新输入
            }
            else {
                break; // 符合要求，跳出循环
            }
        }
        return name; // 最终将符合要求的telNum进行返回
    }
	
	/* 年龄验证 */
	public String ageRegex(String age) {
        while (true) {
            try {
                int ageInt = Integer.valueOf(age); // 通过valueOf将String类型的age转换成Integer类型
                if (Integer.valueOf(age) < 18 || Integer.valueOf(age) > 60) {
                    // 通过valueOf将String类型的age转换成Integer类型
                    // 如果不符合条件 则进行重新输入
                    System.out.println("您不能非法雇佣童工或超过法定退休年龄的员工！请重新输入：");
                    age = write.next(); // 重新输入
                } else {
                    break;
                }// 符合条件，跳出循环
                }catch(NumberFormatException e){
                    System.out.println("您输入的格式有误！请重新输入：");
                    age = write.next(); // 重新输入
                }
            }
        //用Integer.valueOf(age)转换，如果输入字母会抛出NumberFormatException
            return age; // 最终将符合要求的age进行返回
        }

	/* 性别验证 */
	public String sexRegex(String sex) {
		while (true) {
			if (sex.equals("m")) { // 如果传进来的是m则将其转换成M
				sex = "M";
			}
			if (sex.equals("f")) { // 如果传进来的是f则将其转换成F
				sex = "F";
			}
			if (!(sex.equals("M") || sex.equals("F"))) {
				// 如果传进来不符合要求的，则进行重新输入
				System.out.println("您输入的格式有误！请重新输入：");
				sex = write.next(); // 重新输入
			} else {
				break; // 符合要求，跳出循环
			}
		}
		return sex; // 最终将符合要求的sex进行返回
	}

	/* 联系方式验证 */
	public String telRegex(String telNum) {
		while (true) {
			int i = telNum.length(); // 获得talNum的长度
			if (i < 6 || i > 11) {
				// 如果长度不符合要求，重新输入
				System.out.println("您输入的格式有误！请重新输入：");
				telNum = write.next(); // 重新输入
			} else {
				break; // 符合要求，跳出循环
			}
		}
		return telNum; // 最终将符合要求的telNum进行返回
	}

	/* 住址验证 */
	public String addRegex(String address) {
		while (true) {
			int i = address.length(); // 获得address的长度
			if (i < 1 || i > 50) {
				// 如果长度不符合要求，重新输入
				System.out.println("您输入的格式有误！请重新输入：");
				address = write.next(); // 重新输入
			} else {
				break; // 符合要求，跳出循环
			}
		}
		return address; // 最终将符合要求的address进行返回
	}

/* 薪资验证 */
public double salaryRegex(Scanner scanner) {
    while (true) {
        System.out.print("请输入薪资：");
        String input = scanner.nextLine().trim();

        try {
            double salary = Double.parseDouble(input);
            if (salary < 0) {
                System.out.println("薪资不能为负数！");
                continue;
            }
            if (salary > 1000000) {
                System.out.println("薪资不能超过100万！");
                continue;
            }
            return Math.round(salary * 100.0) / 100.0; // 保留两位小数
        } catch (NumberFormatException e) {
            System.out.println("请输入有效的数字！");
        }
    }
}

/* 邮箱验证 */
public String emailRegex(String email) {
    while (true) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            //"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$这个正则表达式：
            //
            //^开头，$结尾
            //
            //[a-zA-Z0-9._%+-]+：用户名部分，允许字母数字和特殊字符
            //
            //@：必须有@符号
            //
            //[a-zA-Z0-9.-]+：域名部分
            //
            //\\.：必须有.
            //
            //[a-zA-Z]{2,}：顶级域名至少2个字母"
            break;
        } else {
            System.out.println("邮箱格式不正确！请重新输入：");
            email = write.next();
        }
    }
    return email;
}

/* 员工编号验证 */
public String employeeIdRegex(String empId) {
    while (true) {
        if (empId.matches("^[A-Za-z0-9]{1,10}$")) {
            break;
        } else {
            System.out.println("员工编号格式不正确！请重新输入：");
            empId = write.next();
        }
    }
    return empId;
}
}