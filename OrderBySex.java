package test01;

import java.util.Comparator;

public class OrderBySex implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}