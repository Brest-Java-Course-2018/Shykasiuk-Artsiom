package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CRUD for Department.
 */
public class DepartmentDaoImpl implements DepartmentDao {

    /**
     * Class JdbcTemplate from spring JDBC.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * SQL request for get department from database.
     */
    private static final String GET_DEPARTMENTS_SQL =
            "SELECT departmentId, departmentName, description FROM department;";

    /**
     * SQL request for get departments from database.
     */
    private static final String GET_DEPARTMENTS_BY_ID_SQL =
            "SELECT departmentId, departmentName, description "
                    + " FROM department WHERE departmentId = :departmentId;";

    /**
     * SQL request for add department in database.
     */
    private static final String ADD_DEPARTMENT_SQL =
            "INSERT INTO department(departmentName, description) "
                    + "VALUES (:departmentName, :description);";

    /**
     * SQL request for update department in database.
     */
    private static final String UPDATE_DEPARTMENT_SQL =
            "UPDATE department SET departmentName = :departmentName, "
                    + "description = :description WHERE departmentId = :departmentId;";

    /**
     * SQL request for delete department from database.
     */
    private static final String DELETE_DEPARTMENT_BY_ID_SQL =
            "DELETE FROM department WHERE departmentId = :departmentId;";

    /**
     * Constructor for class DepartmentDaoImpl.
     *
     * @param dataSource from spring JDBC
     */
    public DepartmentDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate =
                new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> departments =
                jdbcTemplate.query(GET_DEPARTMENTS_SQL,
                        new DepartmentRowMapper());
        return departments;

    }

    @Override
    public Department getDepartmentById(final Integer departmentId) {
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource("departmentId", departmentId);
        try {
            Department department = namedParameterJdbcTemplate.queryForObject(
                    GET_DEPARTMENTS_BY_ID_SQL,
                    namedParametrs,
                    new DepartmentRowMapper());
            return department;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Department addDepartment(final Department department) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(
                ADD_DEPARTMENT_SQL,
                new BeanPropertySqlParameterSource(department),
                keyHolder);
        return getDepartmentById(keyHolder.getKey().intValue());
    }

    @Override
    public void updateDepartment(final Department department) {
        namedParameterJdbcTemplate.update(
                UPDATE_DEPARTMENT_SQL,
                new BeanPropertySqlParameterSource(department));
    }

    @Override
    public void deleteDepartmentById(final Integer id) {
        namedParameterJdbcTemplate.update(
                DELETE_DEPARTMENT_BY_ID_SQL,
                new MapSqlParameterSource().addValue("departmentId", id));
    }

    /**
     * Class DepartmentRowMapper is implementation
     * of interface RowMapper<Department>.
     */
    private static class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(final ResultSet resultSet, final int i)
                throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
            department.setDescription(resultSet.getString(3));
            return department;
        }
    }
}