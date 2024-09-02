package com.example.ejemplodaoypatrones;

import com.example.ejemplodaoypatrones.dao.DireccionDAO;
import com.example.ejemplodaoypatrones.dao.PersonaDAO;
import com.example.ejemplodaoypatrones.dto.PersonaDTO;
import com.example.ejemplodaoypatrones.factory.AbstractFactory;
import com.example.ejemplodaoypatrones.utils.HelperMySQL;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        HelperMySQL dbMySQL = new HelperMySQL();
        dbMySQL.createTables();
    }
}
