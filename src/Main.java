class Main {
    public static void main(String[] args){
        /*
        Создать внутри класса Main метод main и поле типа Employee[10], которое будет
        выполнять роль "хранилища" для записей о сотрудниках.
         */

        Employee[] employees = {
                new Employee("John Michael Anderson", "department№1", 80_000),
                new Employee("Emma Olivia Thompson", "department№3", 67_000),
                new Employee("Michael James Roberts", "department№1", 90_000),
                new Employee("Olivia Grace Smith", "department№5", 95_000),
                new Employee("James Alexander Brown", "department№2", 60_000),
                new Employee("Ava Elizabeth Johnson", "department№1", 67_000),
                new Employee("William David Williams", "department№3", 88_000),
                new Employee("Sophia Emily Harris", "department№4", 93_000),
                new Employee("Benjamin Christopher Clark", "department№5", 78_000),
                new Employee("Mia Charlotte Davis", "department№4", 90_500)
        };

        /*
        Получить список всех сотрудников со всеми имеющимися по ним данными
        (вывести в консоль значения всех полей (toString));
         */

        for (int x = 0; x < employees.length; x++){
            System.out.println(employees[x]);
        }

        System.out.println("");
        //Посчитать сумму затрат на ЗП в месяц;

        int totalSalary = Employee.TotalSalary(employees.length, employees);
        System.out.println(totalSalary);

        System.out.println("");
        //Найти сотрудника с минимальной ЗП;

        Employee minSalaryEmployee = Employee.MinSalary(employees);
        System.out.println(minSalaryEmployee);

        System.out.println("");
        //Найти сотрудника с максимальной ЗП;

        Employee maxSalaryEmployee = Employee.MaxSalary(employees);
        System.out.println(maxSalaryEmployee);

        System.out.println("");
        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);

        int averageValue = Employee.AverageValue(employees.length, employees);
        System.out.println((averageValue / 2));

        System.out.println("");
        //Распечатать ФИО всех сотрудников (метод ничего).

        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }

        System.out.println("");
        //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)

        Employee.IndexSalary(employees, 10);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("");
        //Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов):

        int departmentNumber = 4;
        String department = "department№" + departmentNumber;

        //Сотрудника с минимальной зп;

        minSalaryEmployee = Employee.MinimumWage(employees, department);
        System.out.println(department + minSalaryEmployee);

        System.out.println("");
        //Сотрудника с максимальной зп;

        maxSalaryEmployee = Employee.MaximumWage(employees, department);
        System.out.println(department + maxSalaryEmployee);

        System.out.println("");
        //Сумму затрат на зп по отделу;

        int costsPerDepartment = Employee.CostsPerDepartment(employees, department);
        System.out.println(costsPerDepartment);

        System.out.println("");
        //Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);

        int costPerDepartmentAverage = Employee.CostPerDepartmentAverage(employees, department);
        System.out.println(costPerDepartmentAverage);

        System.out.println("");
        //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит
        // в качестве параметра;

        double percentage = 10;
        Employee.IndexSalariesByDepartment(employees, percentage, department);
        for (Employee employee : employees){
            if (employee.getDepartment().equals(department))
            System.out.println(employee);
        }

        System.out.println("");
        //Напечатать всех сотрудников отдела (все данные, кроме отдела).

        Employee.PrintPerson(employees, department);

        System.out.println("");
        //Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);

        int salaryIsLess = 80000;
        Employee.SalaryIsLess(employees, salaryIsLess);

        System.out.println("");
        //Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).

        int theSalaryIsMore = 100000;
        Employee.TheSalaryIsMore(employees, theSalaryIsMore);
    }
}