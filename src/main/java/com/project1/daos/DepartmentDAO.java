package com.project1.daos;

import com.project1.connection.DatabaseConnection;
import com.project1.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements CrudDAO<Department> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Department obj) {
    }

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM department");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Department department = new Department();

                department.setId(rs.getInt("id"));
                department.setName_dept(rs.getString("name_dept"));

                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }

    @Override
    public Department findById(String id) {
        return null;
    }

    @Override
    public boolean update(Department updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public String toString() {
        return "DepartmentDAO{" +
                "con=" + con +
                '}';
    }
}
