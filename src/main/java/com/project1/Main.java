package com.project1;

import com.project1.daos.CustomersDAO;
import com.project1.daos.ItemsDAO;
import com.project1.services.CustomerService;
import com.project1.services.ItemsService;
import com.project1.ui.LoginMenu;


public class Main {


    public static void main(String[] args) {
        ItemsService itemsService;

      new LoginMenu(new CustomerService(new CustomersDAO()), new ItemsService(new ItemsDAO())).start();




        //Connection con = DatabaseConnection.getCon();
        //System.out.println(con);

//        DepartmentDAO departmentDAO = new DepartmentDAO();
//        List<Department> departments = departmentDAO.findAll();
//
//        System.out.println(departments);

//            List<Items> items = new ItemsDAO().findAll();
//
//        ItemsDAO itemsDAO = new ItemsDAO();
//        System.out.println(items);




    }
}
