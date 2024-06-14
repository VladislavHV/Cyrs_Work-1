import java.util.Formattable;
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

    public int getId() {
        return id;
    }

    /*
    Скрыть прямой доступ к полям класса Employee и добавить возможность получать значения полей
    (геттеры) и устанавливать значения полей отдела и зарплаты (сеттеры).
     */

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
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

    //Посчитать сумму затрат на ЗП в месяц;

    static int TotalSalary(int totalSalary, Employee[] employees){
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    //Найти сотрудника с минимальной ЗП;
    public static Employee MinSalary(Employee[] employees){
        Employee minSalary = employees[0];

        for (int x = 0; x < employees.length; x++) {
            if (employees[x].getSalary() < minSalary.getSalary()) {
                minSalary = employees[x];
            }
        }
        return minSalary;
    }

    //Найти сотрудника с максимальной ЗП;

    public static Employee MaxSalary(Employee[] employees){
        Employee maxSalary = employees[0];
        for (int x = 0; x < employees.length; x++){
            if (employees[x].getSalary() > maxSalary.getSalary()){
                maxSalary = employees[x];
            }
        }
        return maxSalary;
    }

    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);

    public static int AverageValue(int averageValue, Employee[] employees){
        for (Employee employee : employees) {
            averageValue += employee.getSalary();
        }
        return averageValue;
    }

    //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)

    public void IncreaseSalary(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    public static void IndexSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            employee.IncreaseSalary(percentage);
        }
    }

    //Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов)
    //Сотрудника с минимальной зп;

    public static Employee MinimumWage(Employee[] employees, String department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)){
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    //Сотрудника с максимальной зп;

    public static Employee MaximumWage(Employee[] employees, String department){
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees){
            if (employee.getDepartment().equals(department)){
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    //Сумму затрат на зп по отделу;

    public static int CostsPerDepartment(Employee[] employees, String department){
        int costsPerDepartment = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                costsPerDepartment += employee.getSalary();
            }
        }
        return costsPerDepartment;
    }

    //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);

    public static int CostPerDepartmentAverage(Employee[] employees, String department){
        int costPerDepartmentAverage = 0;
        int count = 0;
        for (Employee employee : employees){
            if (employee.getDepartment().equals(department)){
                costPerDepartmentAverage = costPerDepartmentAverage + employee.getSalary();
                count++;
            }
        }
        return count > 0 ? costPerDepartmentAverage / count : 0;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит
    // в качестве параметра;

    public void increaseSalary(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    public static void IndexSalariesByDepartment(Employee[] employees, double percentage, String department) {
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department))
            employee.increaseSalary(percentage);
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).

    public static void PrintPerson(Employee[] employees, String department){

        for (Employee employee : employees){
            if (employee.getDepartment().equals(department)){
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    //Получить в качестве параметра число и вывести:
    // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);

    public static void SalaryIsLess(Employee[] employees, int salaryIsLess){
        for (Employee employee : employees){
            if (employee.getSalary() < salaryIsLess){
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
    public static void TheSalaryIsMore(Employee[]employees, int theSalaryIsMore){
        for (Employee employee : employees){
            if (employee.getSalary() >= theSalaryIsMore){
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
}
