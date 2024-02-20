package OOP.Objects;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Employee implements Comparable<Employee>, Serializable {
    String employeeID, name, department;
    int salary;

    Employee(String employeeID, String name, String department, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[" +
                employeeID + ", " +
                name + ", " +
                department + ", " +
                salary +
                "]";
    }

    @Override
    public int compareTo(Employee e) {
        return this.employeeID.compareTo(e.employeeID);
    }
}

class Company implements Serializable {
    String name, industry;
    double valuation;
    List<Employee> employeeList;

    Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
        employeeList = new ArrayList<Employee>();
    }

    public void showEmployees() {
        System.out.println("Employee list: ");
        for (Employee e: employeeList)
            System.out.println(e.toString());
        System.out.println();
    }

    public void sortEmployeeList() {
        Collections.sort(employeeList);
    }

    public void addEmployee(Employee employee) {
        Employee e = getEmployee(employee.employeeID);

        if (e == null) {
            employeeList.add(employee);
            System.out.println("Following employee added: ");
            System.out.println(employee.toString());
        }
        else {
            System.out.println("Employee is already present in the list.");
        }
    }

    public Employee getEmployee(String employeeID) {
        for (Employee e : employeeList) {
            if (e.employeeID.equals(employeeID))
                return e;
        }

        // if no employee has given ID
        return null;
    }

    public void removeEmployee(String employeeID) {
        Employee removedEmployee = null;
        List<Employee> newList = new ArrayList<>();
        for (Employee e : employeeList) {
            if (! e.employeeID.equals(employeeID))
                newList.add(e);
            else
                removedEmployee = e;
        }

        if (removedEmployee == null) {
            System.out.println("Employee is not present in the list.");
            return;
        }
        employeeList = newList;

        System.out.println("Following employee removed from the list: ");
        System.out.println(removedEmployee.toString());
    }

}
public class WorkingWithObjects {
    public static void main(String[] args) {
        Company company = new Company("Jio", "Telecom");

        Employee emp1 = new Employee(
                "E108",
                "Aditya",
                "Product Engieering",
                25000
        );

        company.addEmployee(emp1);

        company.addEmployee(
                new Employee(
                "E101",
                "Akash",
                "Sales",
                20000
                )
        );

        company.addEmployee(
                new Employee(
                        "E203",
                        "Ritika",
                        "Marketing",
                        25000
                )
        );

        company.addEmployee(
                new Employee(
                        "E119",
                        "Priya",
                        "Finance",
                        28000
                )
        );

        company.showEmployees();
        company.sortEmployeeList();
        company.removeEmployee("E108");
        company.showEmployees();


        /*
        Since the class Company implements Serializable,
        we can convert the objects of Company class to byte stream
        and store it in a file.
        This file can then be used later to recreate the object.
         */

        try {
            FileOutputStream fileOut = new FileOutputStream("company.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);

            oos.writeObject(company);
            System.out.println("Company object serialized to the file company.ser");
        }
        catch (IOException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }


        // To read a serialized object from a file
        try {
            FileInputStream fileIn = new FileInputStream("company.ser");
            ObjectInputStream ois = new ObjectInputStream(fileIn);

            Company deserializedCompany = (Company) ois.readObject();

            System.out.println("Deserialized company object...");
            deserializedCompany.showEmployees();
        }
        catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found exception");
            e.printStackTrace();
        }

    }
}


