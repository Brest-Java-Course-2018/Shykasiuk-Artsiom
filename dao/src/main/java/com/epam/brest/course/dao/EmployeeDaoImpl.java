package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public static final String EMPLOYEE_ID = "employeeId";
    public static final String EMPLOYEE_NAME = "employeeName";
    public static final String SALARY = "salary";
    public static final String DEPARTMENT_ID = "departmentId";

    @Value("${employee.select}")
    private String employeeSelect;

    @Value("${employee.selectById}")
    private String employeeSelectById;

    @Value("${employee.selectByDep}")
    private String employeeSelectByDepartment;

    @Value("${employee.insert}")
    private String employeeInsert;

    @Value("${employee.update}")
    private String employeeUpdate;

    @Value("${employee.delete}")
    private String employeeDelete;

    @Value("${employee.check}")
    private String employeeCheck;
    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees =
                namedParameterJdbcTemplate.getJdbcOperations().query(employeeSelect,
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(EMPLOYEE_ID, employeeId);
        Employee employee =
                namedParameterJdbcTemplate.queryForObject(employeeSelectById, namedParameters,
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(DEPARTMENT_ID, departmentId);
        List<Employee> employees =
                namedParameterJdbcTemplate.query(employeeSelectByDepartment, namedParameters,
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        MapSqlParameterSource namedParameters =
                new MapSqlParameterSource(EMPLOYEE_NAME, employee.getEmployeeName());
        Integer result =  namedParameterJdbcTemplate.queryForObject(employeeCheck, namedParameters, Integer.class);

        if (result == 0) {
            namedParameters = new MapSqlParameterSource();
            namedParameters.addValue(EMPLOYEE_NAME, employee.getEmployeeName());
            namedParameters.addValue(SALARY, employee.getSalary());
            namedParameters.addValue(DEPARTMENT_ID, employee.getDepartmentId());
            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(employeeInsert, namedParameters, generatedKeyHolder);
            employee.setEmployeeId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException("Employee with the same name already exists");
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(
                employeeUpdate,
                namedParameter);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(
                employeeDelete, employeeId);

    }
}
