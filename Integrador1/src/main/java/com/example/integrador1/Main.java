package com.example.integrador1;

import com.example.integrador1.utils.HelperMySQL;

public class Main {


    public static void main(String[] args) throws Exception {
        HelperMySQL db = new HelperMySQL();
        db.dropTables();
        db.createTables();


    }
}