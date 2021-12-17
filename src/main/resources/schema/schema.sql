USE taxi;

DROP TABLE IF EXISTS `avto_klass`;
CREATE TABLE `avto_klass` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `klass` varchar(255),
                              PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `avto_owner_type`;
CREATE TABLE `avto_owner_type` (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `owner_type` varchar(255),
                                   PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `avto`;
CREATE TABLE `avto` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `mark` varchar(45),
                        `number` varchar(10),
                        `klass` int DEFAULT NULL,
                        `owner_type` int DEFAULT NULL,
                        PRIMARY KEY (`id`) ,
                        UNIQUE KEY `avto_ID_UNIQUE` (`id`),
                        UNIQUE KEY `number_UNIQUE` (`number`),
                        KEY `fk_owner` (`owner_type`),
                        KEY `fk_klass` (`klass`)
                    );

DROP TABLE IF EXISTS `support`;
CREATE TABLE `support` (
                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `name` varchar(45),
                           `mobile` text,
                           `hire_date` date DEFAULT NULL,
                           `leave_date` date DEFAULT NULL,
                           PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `name` varchar(45),
                           `mobile` varchar(45),
                           PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers` (

                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `avto_id` int unsigned NOT NULL,
                           `firstname` varchar(45),
                           `secondname` varchar(45),
                           `therdname` varchar(45),
                           `age` tinyint unsigned DEFAULT NULL,
                           `hire_date` date DEFAULT NULL,
                           `leave_date` date DEFAULT NULL,
                           `ocenka` float DEFAULT NULL,
                           `mobile` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `id` int unsigned NOT NULL AUTO_INCREMENT,
                          `adress_from` varchar(255),
                          `adress_to` varchar(255),
                          `driver_id` int unsigned DEFAULT NULL,
                          `avto_id` int unsigned DEFAULT NULL,
                          `client_id` int unsigned DEFAULT NULL,
                          `sotrudnik_id` int unsigned DEFAULT NULL,
                          `client_mobile` varchar(255),
                          PRIMARY KEY (`id`)
                      );

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers` (
                           `id` int unsigned NOT NULL AUTO_INCREMENT,
                           `avto_id` int unsigned NOT NULL,
                           `firstname` varchar(45),
                           `secondname` varchar(45),
                           `therdname` varchar(45),
                           `age` tinyint unsigned DEFAULT NULL,
                           `hire_date` date DEFAULT NULL,
                           `leave_date` date DEFAULT NULL,
                           `ocenka` float DEFAULT NULL,
                           `mobile` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
                       );