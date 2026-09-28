package test01;

import java.util.Comparator;//实现了Comparator接口，这是接口继承。
// 多态：不同的Comparator实现类可以赋值给同一个Comparator类型变量；
// 抽象：Comparator接口就是一个抽象，它定义了compare方法但不提供实现，让具体类去实现具体的比较逻辑。
public class OrderByAge implements Comparator<Employee> {
	
		// 定义比较器实现Comparator接口
		public int compare(Employee o1, Employee o2) {
			return o1.getAge().compareTo(o2.getAge());
		}
}
