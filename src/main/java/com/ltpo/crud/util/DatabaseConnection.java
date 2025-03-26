package com.ltpo.crud.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            executarScriptSQL(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    private static void executarScriptSQL(Connection connection) {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("schema.sql")) {
            if (inputStream == null) {
                throw new RuntimeException("Arquivo schema.sql não encontrado!");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String script = reader.lines().collect(Collectors.joining("\n"));
                try (Statement stmt = connection.createStatement()) {
                    stmt.execute(script);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao executar script SQL", e);
        }
    }
}
