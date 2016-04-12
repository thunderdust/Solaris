CREATE database if not exists s215 ;
use s215;

/******************** EMPLOYEES *****************************************/
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


/******************** EMPLOYEE_ROLES ************************************/
CREATE TABLE IF NOT EXISTS `employee_role` (
  `employee_id` varchar(256) NOT NULL,
  `role` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

TRUNCATE employee_role;
INSERT INTO employee_role (employee_id, role)
  VALUES ('weiran', 'ADMIN');


/************************** LAPTOPS ************************************/
CREATE TABLE IF NOT EXISTS `laptops` (
  `name` varchar(256) NOT NULL,
  `brand` varchar(128) NOT NULL,
  `publish_date` datetime NOT NULL,
  `defautl_price` float(5) NOT NULL,
  `width` int(5) NOT NULL,
  `height` int(5) NOT NULL,
  `length` int(5) NOT NULL,
  `weight` int(5) NOT NULL,
  `screen_size` float(5) NOT NULL,
  `os` varchar(128) NOT NULL,
  `cpu` varchar(128) NOT NULL,
  `ram_type` varchar(128) NOT NULL,
  `ram_slot` int(2) NOT NULL,
  `ram_size` int(2) NOT NULL,
  `hard_drive_model` varchar(128) NOT NULL,
  `hard_drive_speed` int(5) NOT NULL,
  `hard_drive_size` int(4) NOT NULL,
  `ssd_size` int(5) DEFAULT NULL,
  `resolution` varchar(128) NOT NULL,
  `touch_screen` boolean NOT NULL DEFAULT FALSE,
  `gpu` varchar(128) NOT NULL,
  `graphics_card_type` varchar(64) NOT NULL,
  `graphics_memory` int(5) DEFAULT NULL,
  `battery_volume` int(5) NOT NULL,
  `battery_life` int(3) NOT NULL,
  `battery_cell` int(2) NOT NULL,
  `optical_drive` varchar(128),
  `optical_drive_speed` int(4) NOT NULL,
  `touchpad_size` varchar(64),
  `keyboard_type` varchar(64) NOT NULL,
  `track_point` boolean DEFAULT FALSE,
  `front_camera` boolean DEFAULT TRUE,
  `camera_pixel` float(3) DEFAULT NULL,
  `usb_port_2` int(2) NOT NULL,
  `usb_port_3` int(2) NOT NULL,
  `usb_port_type` varchar(32) NOT NULL,
  `vga_port` boolean NOT NULL,
  `hdmi_port` boolean NOT NULL,
  `card_reader_type` varchar(256),
  `bluetooth` varchar(128),
  `wifi_mode` varchar(256) NOT NULL,
  `office_suite` boolean NOT NULL,
  `office_suite_version` varchar(128),
  `antivirus_software` varchar(256),
  `laptop_bag` boolean,
  `warranty` int(2) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

