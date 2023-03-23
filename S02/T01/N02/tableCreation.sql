SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `youtube`; 

CREATE SCHEMA IF NOT EXISTS `youtube` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE IF NOT EXISTS `youtube`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `bitrhday` DATE NOT NULL,
  `gender` VARCHAR(8) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `zip_code` VARCHAR(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  -- email and channel name must be unique
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`publications` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL DEFAULT 'private',
  `title` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `users_id` INT(11) NOT NULL,
  `video_id` INT(11) NOT NULL,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `thumbnail` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  -- a video can be published only once
  UNIQUE INDEX `video_id_UNIQUE` (`video_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_publications_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_publications_videos`
    FOREIGN KEY (`video_id`)
    REFERENCES `youtube`.`videos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`videos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `size` VARCHAR(45) NOT NULL,
  `file_name` VARCHAR(45) NOT NULL,
  `duration` FLOAT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`tags` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  -- the name of a tag must be unique
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`channels` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(150) NULL DEFAULT NULL,
  `creation_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  -- a user can have only one channel
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_channels_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`video_likes_and_dislikes` (
  `users_id` INT(11) NOT NULL,
  `publications_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `value` TINYINT(4) DEFAULT NULL COMMENT '0 -> dislike / 1 -> like / NULL -> none',
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- a user can only give a like or a dislike to a video once
  PRIMARY KEY (`users_id`, `publications_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_video_likes_and_dislikes_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_video_likes_and_dislikes_publications`
    FOREIGN KEY (`publications_id`)
    REFERENCES `youtube`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`playlist` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `status` VARCHAR(10) NULL DEFAULT 'private',
  `users_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_playlist_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`comments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(150) NULL DEFAULT NULL,
  `date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `comment_col` VARCHAR(45) NULL DEFAULT NULL,
  `users_id` INT(11) NOT NULL,
  `publications_id` INT(11) NOT NULL,
  -- a user can publish many commentaries in a video
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_publications`
    FOREIGN KEY (`publications_id`)
    REFERENCES `youtube`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`has_tag` (
  `publication_id` INT(11) NOT NULL,
  `tag_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`publication_id`, `tag_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_has_tag_publications`
    FOREIGN KEY (`publication_id`)
    REFERENCES `youtube`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_has_tag_tags`
    FOREIGN KEY (`tag_id`)
    REFERENCES `youtube`.`tags` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`comment_likes_and_dislikes` (
  `users_id` INT(11) NOT NULL,
  `comments_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `value` TINYINT(4) DEFAULT NULL COMMENT '0 -> dislike / 1 -> like / NULL -> none',
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- a user can give a like or a dislike to a comment only once
  PRIMARY KEY (`users_id`, `comments_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_comment_likes_and_dislikes_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_likes_and_dislikes_comments`
    FOREIGN KEY (`comments_id`)
    REFERENCES `youtube`.`comments` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`video_views` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `users_id` INT(11) NOT NULL,
  `publications_id` INT(11) NOT NULL,
  -- a user can see a video more than once
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_video_views_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_video_views_publications`
    FOREIGN KEY (`publications_id`)
    REFERENCES `youtube`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`subscriptions` (
  `users_id` INT(11) NOT NULL,
  `channels_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  -- a user can be subscribed to a channel only once
  PRIMARY KEY (`users_id`, `channels_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_is_subscribed_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `youtube`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_is_subscribed_channels`
    FOREIGN KEY (`channels_id`)
    REFERENCES `youtube`.`channels` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `youtube`.`is_in_playlist` (
  `playlist_id` INT(11) NOT NULL,
  `publications_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  -- a video can be in a playlist only once
  PRIMARY KEY (`playlist_id`, `publications_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_is_in_playlist_playlist`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `youtube`.`playlist` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_is_in_playlist_publications`
    FOREIGN KEY (`publications_id`)
    REFERENCES `youtube`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
