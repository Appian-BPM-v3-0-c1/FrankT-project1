package com.project1.services;

import com.project1.daos.DepartmentDAO;

import com.project1.models.Department;


import java.util.List;

public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }


    public boolean isValidDepartment(Department department) {
        List<Department> departmentList = departmentDAO.findAll();

        return false;
    }

    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }

}
