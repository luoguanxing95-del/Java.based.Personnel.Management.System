package test01;

public class Employee {
    private int id;
    private String name;
    private String age;
    private String sex;
    private String telNum;
    private String address;
    private String employeeId;
    private String department;
    private String position;
    private double salary;
    private String email;
    private String education;
    //封装：使用private修饰所有属性，通过public的getter/setter方法进行访问。比如name属性，外部不能直接修改，必须通过setName()方法，这样可以在方法中加入验证逻辑，保证数据安全。
    // ============ 构造方法 ============

    // 无参构造方法
    public Employee() {
        super();
    }

    // 6参数构造方法（基础信息）
    public Employee(int id, String name, String age, String sex,
                    String telNum, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telNum = telNum;
        this.address = address;
    }

    // 12参数构造方法 （完整信息）
    public Employee(int id, String name, String age, String sex,
                    String telNum, String address, String employeeId,
                    String department, String position, double salary,
                    String email, String education) {
        // 调用6参数构造方法
        this(id, name, age, sex, telNum, address);

        // 设置新增的人事属性
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.education = education;
    }

    // ============ Getter和Setter方法 ============

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeId() {
        return employeeId != null ? employeeId : "未设置";
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department != null ? department : "未设置";
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position != null ? position : "未设置";
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email != null ? email : "未设置";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education != null ? education : "未设置";
    }

    public void setEducation(String education) {
        this.education = education;
    }

    // ============ toString方法 ============

    /* 重写toString方法 - 基础版本（兼容原有系统） */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("序号：").append(id);
        sb.append(", 姓名：").append(name);
        sb.append(", 年龄：").append(age);
        sb.append(", 性别：").append(sex);
        sb.append(", 电话：").append(telNum);
        sb.append(", 地址：").append(address);

        // 新增人事信息
        if (employeeId != null) {
            sb.append(", 员工编号：").append(employeeId);
        }
        if (department != null) {
            sb.append(", 部门：").append(department);
        }
        if (position != null) {
            sb.append(", 职位：").append(position);
        }
        if (salary > 0) {
            sb.append(", 薪资：").append(String.format("%.2f", salary));
        }
        if (email != null) {
            sb.append(", 邮箱：").append(email);
        }
        if (education != null) {
            sb.append(", 学历：").append(e ducation);
        }

        return sb.toString();
    }

    /* 简洁版toString（仅显示关键信息） */
    public String toSimpleString() {
        return String.format("[%s] %s - %s - %s",
                employeeId != null ? employeeId : "无编号",
                name,
                department != null ? department : "未分配",
                position != null ? position : "未设置");
    }

    /* 表格版toString（适合表格显示） */
    public String toTableRow() {
        return String.format("| %-4d | %-8s | %-4s | %-3s | %-12s | %-10s | %-8s | %-10s | %-8.2f | %-15s | %-6s |",
                id,
                name.length() > 6 ? name.substring(0, 6) + ".." : name,
                age,
                sex,
                telNum,
                employeeId != null ? (employeeId.length() > 8 ? employeeId.substring(0, 7) + ".." : employeeId) : "未设置",
                department != null ? department : "未分配",
                position != null ? position : "未设置",
                salary,
                email != null ? (email.length() > 13 ? email.substring(0, 12) + ".." : email) : "未设置",
                education != null ? education : "未设置");
    }

    /* 人事详情版toString */
    public String toDetailString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== 员工详细信息 ==========\n");
        sb.append("序号：").append(id).append("\n");
        sb.append("员工编号：").append(getEmployeeId()).append("\n");
        sb.append("姓名：").append(name).append("\n");
        sb.append("年龄：").append(age).append("\n");
        sb.append("性别：").append(sex).append("\n");j
        sb.append("联系电话：").append(telNum).append("\n");
        sb.append("工作邮箱：").append(getEmail()).append("\n");
        sb.append("住址：").append(address).append("\n");
        sb.append("部门：").append(getDepartment()).append("\n");
        sb.append("职位：").append(getPosition()).append("\n");
        sb.append("薪资：").append(String.format("%.2f", salary)).append("元\n");
        sb.append("学历：").append(getEducation()).append("\n");
        sb.append("===================================");
        return sb.toString();
    }
}