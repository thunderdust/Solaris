CREATE database if not exists s215 ;
use s215;

CREATE TABLE IF NOT EXISTS `employees` (
  `firstname` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `gender` varchar(2) NOT NULL,
  `id` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `contact_number` varchar(128) NOT NULL,
  `password` varchar(256) NOT NULL,
  `time_joined` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

TRUNCATE employees;
/* admin account password is admin123 */
INSERT INTO employees (firstname, lastname, gender, id, email, contact_number, password, time_joined)
  VALUES ('Weiran', 'Liu', 'M', 'weiran', 'liuweiran.nus@gmail.com', '90753586', '202cb962ac59075b964b07152d234b70', '2016-04-07 14:44:02.340000');


CREATE TABLE IF NOT EXISTS `employee_role` (
  `employee_id` varchar(256) NOT NULL,
  `role` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

TRUNCATE employee_role;
INSERT INTO employee_role (employee_id, role)
  VALUES ('weiran', 'ADMIN');



