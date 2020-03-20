CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fixedSalary DOUBLE,
    hourRate DOUBLE,
    hoursWorked INT,
    commRate FLOAT,
    emplType VARCHAR(255) NOT NULL
)
