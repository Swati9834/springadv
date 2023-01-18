package com.csi.controller;

import com.csi.model.Employee;
import com.csi.services.EmployeeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServicesImpl;

    @PostMapping("/signup")
    public ResponseEntity<String>signUp(@RequestBody Employee employee){
        log.info("#########Trying to save data Employee:"+employee.getEmpName());
        employeeServicesImpl.signUp(employee);
        return ResponseEntity.ok("Employee Signup done Successfully");

    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")

    public ResponseEntity<Boolean>signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServicesImpl.signIn(empEmailId,empPassword));
    }
    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee>getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServicesImpl.getDataById(empId));
    }
    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>>getDataByName(@PathVariable String empName){
        return  ResponseEntity.ok(employeeServicesImpl.getDataByName(empName));

    }
    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee>getDataByContactNumber(@PathVariable long empContactNumber){
        return ResponseEntity.ok(employeeServicesImpl.getDataByContactNumber(empContactNumber));

    }

    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee>getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServicesImpl.getDataByEmailId(empEmailId));
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity updateData(@PathVariable int empId, @RequestBody Employee employee ){
        employeeServicesImpl.updateData(empId,employee);
        return ResponseEntity.ok("Update Data Successfully");
    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>>sortByName(){
        return ResponseEntity.ok(employeeServicesImpl.sortByName());
    }
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>>sortById(){
        return ResponseEntity.ok(employeeServicesImpl.sortById());
    }
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>>sortBySalary(){
        return ResponseEntity.ok(employeeServicesImpl.sortBySalary());
    }
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>>sortByDOB(){
        return ResponseEntity.ok(employeeServicesImpl.sortByDOB());
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeServicesImpl.getAllData());
    }
    @PostMapping("/getdatabyusinganyinput")
    public ResponseEntity<List<Employee>>getDataByUsingAnyInput(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServicesImpl.getDatabyUsingAnyInput(employee));
    }
    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>>filterDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServicesImpl.filterDataBySalary(empSalary));
    }
    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServicesImpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");

    }
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData(){
        employeeServicesImpl.deleteAllData();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }



}
