create
database `crud-example`;

use
`crud-example`;

SET
FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name`  VARCHAR(50) NOT NULL,
    `email`      VARCHAR(50) NOT NULL,
    CONSTRAINT `pk_teacher` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50) NOT NULL,
    `teacher_id` INT         NOT NULL,
    CONSTRAINT `pk_comment` PRIMARY KEY (`id`),
    CONSTRAINT `fk_course_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50) NOT NULL,
    `teacher_id` INT         NOT NULL,
    CONSTRAINT `pk_test` PRIMARY KEY (`id`),
    CONSTRAINT `fk_test_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET
FOREIGN_KEY_CHECKS = 1;
