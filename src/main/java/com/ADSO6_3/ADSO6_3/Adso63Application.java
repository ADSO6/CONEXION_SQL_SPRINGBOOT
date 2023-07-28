package com.ADSO6_3.ADSO6_3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Adso63Application implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Adso63Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM clientes";
        List<Usuario> Usuarios = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));

//        for (Usuario usuario : Usuarios) {
//            System.out.println(usuario.getNombre());
//        }
        Usuarios.forEach(System.out::println);
        for (Usuario usuario : Usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Edad: " + usuario.getEdad());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("---------------------------");
        }
        System.out.println("--------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-4s | %-25s |\n", "ID", "Nombre", "Edad", "Email");
        System.out.println("--------------------------------------------");
        for (Usuario usuario : Usuarios) {
            System.out.printf("| %-4d | %-20s | %-4d | %-25s |\n", usuario.getId(), usuario.getNombre(), usuario.getEdad(), usuario.getEmail());
        }
        System.out.println("--------------------------------------------");

    }

}
