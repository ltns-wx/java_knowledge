package cm.ltns.basic.object_.demo3;

public class Employee {
    public String name;

    public int salary;

    public String hireDay;

    //如果两个雇员对象的姓名、 薪水和雇佣日期都一样
    public boolean equals(Object otherObject) {
// a quick test to see if the objects are identical
        if (this == otherObject) {
            return true;
        }
// must return false if the explicit parameter is null
        if (otherObject == null) {
            return false;
        }
// if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass()){
            return false;
        }
// now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;
// test whether the fields have identical values
        return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
    }
}
