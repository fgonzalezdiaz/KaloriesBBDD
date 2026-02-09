package com.kalories.demo.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kalories.demo.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    rs.getLong("id"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("genero"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getInt("altura"),
                    rs.getBigDecimal("peso"),
                    rs.getInt("nivel_actividad"),
                    rs.getInt("objetivo"),
                    rs.getString("img_path"));
        }
    }

    // Read todos
    public List<User> findAll() {
        String sql = "Select * from users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // Crear un usuario
    public int save(String email, String contrasena, String genero, LocalDate fechaNacimiento, Integer altura,
            BigDecimal peso, Integer nivelActividad, Integer objetivo, String imgPath) {
        String sql = "INSERT INTO USERS (EMAIL, CONTRASENA, GENERO, FECHA_NACIMIENTO, ALTURA, PESO, NIVEL_ACTIVIDAD, OBJETIVO, IMG_PATH) VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, email, contrasena, genero, fechaNacimiento, altura, peso, nivelActividad,
                objetivo, imgPath);
    }

    public int save(User user) {
        String sql = "INSERT INTO USERS (EMAIL, CONTRASENA, GENERO, FECHA_NACIMIENTO, ALTURA, PESO, NIVEL_ACTIVIDAD, OBJETIVO, IMG_PATH) VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getEmail(), user.getContrasena(), user.getGenero(),
                user.getFechaNacimiento(), user.getAltura(), user.getPeso(), user.getNivelActividad(),
                user.getObjetivo(), user.getImgPath());
    }

    // Read por id
    public List<User> findById(Long id) {
        String sql = "Select * from users where id == ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), id);
    }

}
