package com.example.integrador1;

import com.example.integrador1.dao.ClienteDAO;
import com.example.integrador1.entities.Cliente;
import com.example.integrador1.factory.AbstractFactory;
import com.example.integrador1.factory.MySQLDAOFactory;
import com.example.integrador1.utils.HelperMySQL;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws Exception {
        HelperMySQL db = new HelperMySQL();
        db.dropTables();
        db.createTables();
        Connection conn = MySQLDAOFactory.createConnection();
        Cliente joel = new Cliente(2,"joel","joelviviant@gmail.com");
        Cliente maria = new Cliente(1,"maria","mariaviviant@gmail.com");
        ClienteDAO c = new ClienteDAO(conn);
        c.insertCliente(joel);
        c.insertCliente(maria);
        c.delete(1);

    }
}