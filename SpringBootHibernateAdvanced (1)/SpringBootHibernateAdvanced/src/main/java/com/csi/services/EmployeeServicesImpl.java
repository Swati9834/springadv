package com.csi.services;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    EmployeeDao employeeDaoImpl;
    @Override
    public void signUp(Employee employee) {
        employeeDaoImpl.signUp(employee);


    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    @Override
    public Employee getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    @Override
    public List<Employee> getDatabyUsingAnyInput(Employee employee) {
        return employeeDaoImpl.getDatabyUsingAnyInput(employee);
    }

    @Override
    public List<Employee> getDataByName(String empName) {
        return employeeDaoImpl.getDataByName(empName);
    }

    @Override
    public Employee getDataByEmailId(String empEmailId) {
        return employeeDaoImpl.getDataByEmailId(empEmailId);
    }

    @Override
    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        employeeDaoImpl.updateData(empId,employee);
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    @Override
    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    @Override
    public void deleteById(int empId) {
        employeeDaoImpl.deleteById(empId);
    }

    @Override
    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }
}
