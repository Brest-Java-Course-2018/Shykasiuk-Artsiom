package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

/**
 * CRUD for Employee.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_ID = "employeeId";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_NAME = "employeeName";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_SALARY = "salary";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_MAIL = "mail";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_DEPT_ID = "deptId";

    /**
     * Query for select.
     */
    @Value("${employee.select}")
    private String select;
    /**
     * Query for select by department.
     */
    @Value("${employee.selectByDepartmentId}")
    private String selectByDepartmentId;
    /**
     * Query for select by id.
     */
    @Value("${employee.selectById}")
    private String selectById;
    /**
     * Query for inserting.
     */
    @Value("${employee.insert}")
    private String insert;
    /**
     * Query for updating.
     */
    @Value("${employee.update}")
    private String update;
    /**
     * Query for deleting.
     */
    @Value("${employee.delete}")
    private String delete;

    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Constructor.
     *
     * @param namedParameterJdbcTemplate new namedParameterJdbcTemplate.
     */
    public EmployeeDaoImpl(
            final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Employee> getEmployees() {
        LOGGER.debug("getEmployees()");
        List<Employee> employees = namedParameterJdbcTemplate
                .getJdbcOperations().query(select,
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public List<Employee> getEmployeeByDepartmentId(
            final Integer departmentId) {
        LOGGER.debug("getEmployeeByDepartmentId({})", departmentId);
        List<Employee> employees =
                namedParameterJdbcTemplate.getJdbcOperations().query(
                        selectByDepartmentId, new Object[]{departmentId},
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public Employee getEmployeeById(final Integer employeeId) {
        LOGGER.debug("getEmployeeById({})", employeeId);
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource(EMPLOYEE_ID, employeeId);
        Employee employee = namedParameterJdbcTemplate.queryForObject(
                selectById, namedParametrs,
                BeanPropertyRowMapper.newInstance(Employee.class));

        return employee;
    }

    @Override
    public Employee addEmployee(final Employee employee) {
        LOGGER.debug("addEmployee({})", employee);
        SqlParameterSource namedParameters =
                new BeanPropertySqlParameterSource(employee);

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(
                insert, namedParameters, generatedKeyHolder);
        employee.setEmployeeId(generatedKeyHolder.getKey().intValue());

        return employee;
    }

    @Override
    public void updateEmployee(final Employee employee) {
        LOGGER.debug("updateEmployee({})", employee);
        SqlParameterSource namedParameter =
                new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(update, namedParameter);
    }

    @Override
    public void deleteEmployeeById(final Integer employeeId) {
        LOGGER.debug("deleteEmployeeById({})", employeeId);
        namedParameterJdbcTemplate.getJdbcOperations().update(
                delete, employeeId);
    }
}
