class Main {
    public static void main(String[] args){
        /*
        Создать внутри класса Main метод main и поле типа Employee[10], которое будет
        выполнять роль "хранилища" для записей о сотрудниках.
         */

        Employee[] employees = {
                new Employee("John Michael Anderson", "department№1", 80_000),
                new Employee("Emma Olivia Thompson", "department№1", 67_000),
                new Employee("Michael James Roberts", "department№1", 90_000),
                new Employee("Olivia Grace Smith", "department№1", 95_000),
                new Employee("James Alexander Brown", "department№1", 60_000),
                new Employee("Ava Elizabeth Johnson", "department№1", 67_000),
                new Employee("William David Williams", "department№1", 88_000),
                new Employee("Sophia Emily Harris", "department№1", 93_000),
                new Employee("Benjamin Christopher Clark", "department№1", 78_000),
                new Employee("Mia Charlotte Davis", "department№1", 90_500)
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

        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.println(totalSalary);

        System.out.println("");
        //Найти сотрудника с минимальной ЗП;

        Employee minSalary = employees[0];

        for (int x = 1; x < employees.length; x++) {
            if (employees[x].getSalary() < minSalary.getSalary()){
                minSalary = employees[x];
            }
        }
        System.out.println(minSalary);

        System.out.println("");
        //Найти сотрудника с максимальной ЗП;

        Employee maxSalary = employees[0];

        for (int x = 0; x < employees.length; x++){
            if (employees[x].getSalary() > maxSalary.getSalary()){
                maxSalary = employees[x];
            }
        }
        System.out.println(maxSalary);

        System.out.println("");
        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.println((totalSalary / 4));

        System.out.println("");
        //Распечатать ФИО всех сотрудников (метод ничего).

        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

}