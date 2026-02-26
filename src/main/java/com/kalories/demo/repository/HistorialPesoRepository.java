package com.kalories.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kalories.demo.model.HistorialPeso;

@Repository
public class HistorialPesoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class HistorialPesoRowMapper implements RowMapper<HistorialPeso> {

        @Override
        public HistorialPeso mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HistorialPeso(
                    rs.getLong("id"),
                    rs.getString("fecha"),
                    rs.getInt("peso"));
        }
    }

    public List<HistorialPeso> findAll() {
        String sql = "SELECT * FROM historial_pesos";
        return jdbcTemplate.query(sql, new HistorialPesoRowMapper());
    }

    public List<HistorialPeso> findByWeight(int peso) {
        String sql = "SELECT * FROM historial_pesos WHERE peso = ?";
        return jdbcTemplate.query(sql, new HistorialPesoRowMapper(), peso);
    }

    public List<HistorialPeso> findByDate(String fecha) {
        String sql = "SELECT * FROM historial_pesos WHERE FECHA = ?";
        return jdbcTemplate.query(sql, new HistorialPesoRowMapper(), fecha);
    }

    public int save(HistorialPeso historialPeso) {
        String sql = "INSERT INTO historial_pesos (FECHA, PESO) VALUES (?, ?)";
        return jdbcTemplate.update(sql, historialPeso.getFecha(), historialPeso.getPeso());
    }

    public int delete(HistorialPeso historialPeso) {
        String sql = "DELETE FROM historial_pesos WHERE FECHA = ? AND PESO = ?";
        return jdbcTemplate.update(sql, historialPeso.getFecha(), historialPeso.getPeso());
    }
}
