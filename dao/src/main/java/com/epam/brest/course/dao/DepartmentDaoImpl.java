package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CRUD for Department.
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String DEPARTMENT_ID = "departmentId";
    public static final String DEPARTMENT_NAME = "departmentName";
    public static final String DESCRIPTION = "description";
    @Value("${department.select}")
    private String departmentSelect;

    @Value("${department.selectById}")
    private String departmentSelectById;

    @Value("${department.insert}")
    private String departmentInsert;

    @Value("${department.update}")
    private String departmentUpdate;

    @Value("${department.delete}")
    private String departmentDelete;

    @Value("${department.checkDepartment}")
    private String departmentCheck;

    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DepartmentDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Department> getDepartments() {
        LOGGER.debug("getDepartments()");
        List<Department> departments =
                namedParameterJdbcTemplate.getJdbcOperations().query(departmentSelect,
                        new DepartmentRowMapper());
        return departments;

    }

    /*    @Override
        public Department getDepartmentById(final Integer departmentId) {
            SqlParameterSource namedParametrs =
                    new MapSqlParameterSource(DEPARTMENT_ID, departmentId);
            try {
                Department department = namedParameterJdbcTemplate.queryForObject(
                        departmentSelectById,
                        namedParametrs,
                        new DepartmentRowMapper());
                return department;
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        }*/
    @Override
    public Department getDepartmentById(final Integer departmentId) {
        LOGGER.debug("getDepartmentById({})",departmentId);
        SqlParameterSource namedParameters =
                new MapSqlParameterSource(DEPARTMENT_ID, departmentId);
        Department department =
                namedParameterJdbcTemplate.queryForObject(departmentSelectById, namedParameters,
                        BeanPropertyRowMapper.newInstance(Department.class));
        return department;

    }


    @Override
    public Department addDepartment(final Department department) {
        LOGGER.debug("addDepartment({})",department);
        MapSqlParameterSource namedParameters =
                new MapSqlParameterSource("departmentName",
                        department.getDepartmentName());

        Integer result =
                namedParameterJdbcTemplate.queryForObject(departmentCheck,
                        namedParameters, Integer.class);
        LOGGER.debug("result({})",result);
        if (result == 0) {

            SqlParameterSource namedParameter =
                    new BeanPropertySqlParameterSource(department);
            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(departmentInsert,
                    namedParameter, generatedKeyHolder);
            department.setDepartmentId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException("Department with the same name already exists");
        }

        return department;
    }

    @Override
    public void updateDepartment(final Department department) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(department);
        namedParameterJdbcTemplate.update(
                departmentUpdate,
                namedParameter);
    }

    @Override
    public void deleteDepartmentById(final Integer departmentId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(
                departmentDelete, departmentId);
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
            department.setDepartmentId(resultSet.getInt(DEPARTMENT_ID));
            department.setDepartmentName(resultSet.getString(DEPARTMENT_NAME));
            department.setDescription(resultSet.getString(DESCRIPTION));
            return department;
        }
    }
}
