package com.example.controller;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomerController extends HttpServlet {
    private CustomerDao customerDao= new CustomerDao();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //res.setContentType("text/html;charset=UTF-8");
       // res.getWriter().write("<!DOCTYPE html><html><head><title>Hello World</title></head><body><h1>This is a Heading</h1><p>Hello  world</p></body></html>");
        int id=extractIdFromPath(req);
        res.setContentType("application/json");
        if(id==-1){
            res.getWriter().write(mapper.writeValueAsString(customerDao.getAllCustomers()));
        }else {
            Customer customer=customerDao.getCustomer(id);
            if(customer==null){
                res.sendError(HttpServletResponse.SC_NOT_FOUND, "No customer found with id: " + id);

            }else {
                res.getWriter().write(mapper.writeValueAsString(customer));
            }
        }
    }

    @Override
    protected void  doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        Customer newCustomer= mapper.readValue(req.getReader(),Customer.class);

        newCustomer =CustomerDao.creteCustomer(newCustomer);

        res.setContentType("application/json");
        res.getWriter().write(mapper.writeValueAsString(newCustomer));
    }

    private int extractIdFromPath(HttpServletRequest req) {
        String path=req.getPathInfo();
        if(path==null || path.equals("/")){
            return -1;
        }else {
            try {
                return Integer.parseInt(path.substring(1));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("Invalid customer id: " + path.substring(1));
            }

        }
    }
    @Override
    protected void doPut(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        int id= extractIdFromPath(req);
        if (id == -1) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "No customer id provided");
            return;
        }
        Customer existingCustomer = mapper.readValue(req.getReader(), Customer.class);
        customerDao.updateCustomer(existingCustomer);
        res.setStatus(HttpServletResponse.SC_OK);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = extractIdFromPath(req);
        if (id == -1) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No customer id provided");
            return;
        }
        customerDao.deleteCustomer(id);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
