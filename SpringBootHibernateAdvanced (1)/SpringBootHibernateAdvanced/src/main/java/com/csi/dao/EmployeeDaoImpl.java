package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private static SessionFactory factory =new AnnotationConfiguration().configure().buildSessionFactory();


    @Override
    public void signUp(Employee employee) {
        Session session =factory.openSession();
        Transaction transaction =session.beginTransaction();

        session.save(employee);
        transaction.commit();

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag =false;

        for(Employee employee:getAllData()){
            if(employee.getEmpEmailId().equals(empEmailId) &&employee.getEmpPassword().equals(empPassword)){
                flag =true;
            }
        }
        return flag;
    }

    @Override
    public Employee getDataById(int empId) {
        Session session = factory.openSession();
        Employee employee = (Employee) session.get(Employee.class,empId);
        return employee;
    }

    @Override
    public List<Employee> getDatabyUsingAnyInput(Employee employee) {

        List<Employee>employeeList=new ArrayList<>();

        for (Employee employee1:getAllData()){
            if(employee1.getEmpId()==employee.getEmpId()
            ||employee1.getEmpName().equals(employee.getEmpName())
            ||employee1.getEmpContactNumber()==employee.getEmpContactNumber()
            ||employee1.getEmpEmailId().equals(employee.getEmpEmailId())){
                employeeList.add(employee1);
            }
        }
        return employeeList;


    }

    @Override
    public List<Employee> getDataByName(String empName) {

        List<Employee>employeeList =new ArrayList<>();
        for (Employee employee:getAllData()){
            if(employee.getEmpName().equals(empName)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {
        Employee employee2 = new Employee();

        for (Employee employee:getAllData()){
            if(employee.getEmpEmailId().equals(empEmailId)){
                employee2 =employee;

            }
        }
        return employee2;
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {
        Employee employee2 =new Employee();
        for (Employee employee:getAllData()){
            if(employee.getEmpContactNumber()==(empContactNumber)){
                employee2 = employee;
            }

        }


        return employee2;
    }

    @Override
    public List<Employee> getAllData() {
        Session session = factory.openSession();

        return ( session.createQuery("from Employee")).list();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 =(Employee) session.get(Employee.class,empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());
        session.update(employee1);
        transaction.commit();
     }

    @Override
    public List<Employee> sortByName() {
        return getAllData().stream().sorted((e1,e2)->e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());

    }

    @Override
    public List<Employee> sortBySalary() {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());

    }

    @Override
    public List<Employee> sortByDOB() {
        return getAllData().stream().sorted((e1,e2)->e1.getEmpDOB().compareTo(e2.getEmpDOB())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortById() {
        return getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpId)).collect(Collectors.toList());

    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return getAllData().stream().filter(employee -> employee.getEmpSalary()>=empSalary).collect(Collectors.toList());

    }

    @Override
    public void deleteById(int empId) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee =getDataById(empId);
        session.delete(employee);
        transaction.commit();



    }

    @Override
    public void deleteAllData() {
        Session session =factory.openSession();

        for(Employee employee:getAllData()){
            Transaction transaction = session.beginTransaction();

            session.delete(employee);
            transaction.commit();
        }

    }
}

