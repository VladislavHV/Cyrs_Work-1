import java.util.Objects;

public class Employee {
    /*
    Создать класс Employee, который содержит информацию о ФИО, отделе и зарплате сотрудника.
    Отделы для простоты должны быть названы от 1 до 5.
     */

    private String fullName;
    private String department;
    private int salary;

    //Добавить статическую переменную-счетчик, которая будет отвечать за id.

    private static int counter = 0;

    /*
    По-умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем
    (включая id, который нужно получить из счетчика).
     */

    public Employee(String fullName, String department, int salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    /*
    Добавить в класс Employee поле id, которое проставляется из счетчика,
    а затем счетчик увеличивает свое значение.
     */

    private int id;

    /*
    Скрыть прямой доступ к полям класса Employee и добавить возможность получать значения полей
    (геттеры) и устанавливать значения полей отдела и зарплаты (сеттеры).
     */

    public String getFullName() {
        return fullName;
    }

    public String getDepartment1() {
        return department;
    }


    public int getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    //Реализовать в классе Employee контракты equals и hashCode.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(fullName, employee.fullName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id ,fullName, department, salary);
    }

    /*
    Создать статические методы, которые будут взаимодействовать с массивом из пункта
    6 и возвращать результат:
    */

    public int meter(int id){
        return id;
    }

    @Override
    public String toString() {
        return "fullName: " + fullName + " department: " + department + " salary: " + salary;
    }

}
