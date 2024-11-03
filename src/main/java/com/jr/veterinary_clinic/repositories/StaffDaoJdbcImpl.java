package com.jr.veterinary_clinic.repositories;

import com.jr.veterinary_clinic.models.Authority;
import com.jr.veterinary_clinic.models.Staff;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class StaffDaoJdbcImpl implements StaffDao {

    private final NamedParameterJdbcTemplate jdbc;

    public StaffDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbc = namedParameterJdbcTemplate;
    }

    final String GET_STAFF_BY_MAIL = "SELECT DISTINCT s.id, s.name, s.mail, s.password, s.active FROM Staff AS s " +
            "INNER JOIN Staff_Authorities AS sa ON s.id = sa.staff_id " +
            "INNER JOIN Authorities AS a ON a.id = sa.role_id WHERE mail = :mail;";

    final String GET_STAFF_ROLES_BY_MAIL = "SELECT a.id, a.role FROM Staff AS s " +
            "INNER JOIN Staff_Authorities AS sa ON s.id = sa.staff_id " +
            "INNER JOIN Authorities AS a ON a.id = sa.role_id WHERE mail = :mail;";

    @Override
    public Staff getStaffByMail(String mail) {
        MapSqlParameterSource paramsAuthority = new MapSqlParameterSource();
        paramsAuthority.addValue("mail", mail);

        List<Authority> authorities = jdbc.query(GET_STAFF_ROLES_BY_MAIL, paramsAuthority,
                new BeanPropertyRowMapper<>(Authority.class));

        Staff staff = jdbc.queryForObject(GET_STAFF_BY_MAIL, paramsAuthority, (rs, rowNum) -> {
            Staff s = new Staff();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setMail(rs.getString("mail"));
            s.setPassword(rs.getString("password"));
            s.setActive(rs.getBoolean("active"));
            return s;
        });
        Objects.requireNonNull(staff).setAuthorities(authorities);

        return staff;
    }

}

