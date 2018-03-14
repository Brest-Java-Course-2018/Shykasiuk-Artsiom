DROP TABLE IF EXISTS department;
CREATE TABLE department (
  departmentId   INT          NOT NULL AUTO_INCREMENT,
  departmentName VARCHAR(255) NOT NULL,
  description    VARCHAR(255) NULL,
  PRIMARY KEY (departmentId)
);
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  employeeId   INT          NOT NULL AUTO_INCREMENT,
  employeeName VARCHAR(255) NULL,
  salary       INT          NOT NULL DEFAULT 0,
  departmentId INT          NOT NULL,
  PRIMARY KEY (employeeId),
  CONSTRAINT employeeToDepartmentFK
  FOREIGN KEY (departmentId)
  REFERENCES department (departmentId)
);
