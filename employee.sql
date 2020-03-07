CREATE TABLE IF NOT EXISTS employee  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    salary double
);
INSERT INTO employee VALUES 
(1, 'Regular Employee', 'regular',100000),
(2, 'Hourly Employee', 'hourly',0),
(3, 'Commissioned Employee', 'commissioned',0),
(4, 'Salary Commissioned Employee', 'sCommissioned',0);
