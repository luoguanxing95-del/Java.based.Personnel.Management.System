package test01;

import java.io.IOException;

public class App {

/*
 * App  对应  Application（程序入口方法）：主类
  */

	public static void main(String[] args)  {
	// TODO Auto-generated method stub
			Operate oper = new Operate();
			try {
				oper.read(); // 通过调用oper的read（）方法将保存在文本文件中的员工写入到程序中
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("目前现有的员工如下所示：");
			oper.showAll(); // 将文本文件中的员工打印出来
			oper.mainLogic();
	}
}
