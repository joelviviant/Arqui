package com.example.integrador1;

import com.example.integrador1.dao.ClienteDAO;
import com.example.integrador1.dao.ProductoDAO;
import com.example.integrador1.entities.Cliente;
import com.example.integrador1.factory.AbstractFactory;
import com.example.integrador1.factory.MySQLDAOFactory;
import com.example.integrador1.utils.HelperMySQL;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws Exception {
        HelperMySQL db = new HelperMySQL();  //Levanto el helper, para llenar la base de datos
        db.dropTables();
        db.createTables();
        db.populateDB();
        Connection conn  = MySQLDAOFactory.createConnection();//hago una conexion con la base de datos
        ProductoDAO productoConMayorRecaudación= new ProductoDAO(conn);
        productoConMayorRecaudación.obtenerProductoConMayorRecaudacion();

    }
}