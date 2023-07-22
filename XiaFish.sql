CREATE TABLE `goods`  (
  `goods_id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ori_price` float NULL DEFAULT NULL,
  `cur_price` float NOT NULL,
  `goods_category_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `release_time` datetime NOT NULL,
  `inventory` int NOT NULL,
  `goods_profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE,
  UNIQUE INDEX `goods_id_UNIQUE`(`goods_id` ASC) USING BTREE,
  INDEX `fk_goods_user_idx`(`seller_id` ASC) USING BTREE,
  INDEX `fk_goods_category_idx`(`goods_category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `goods_category`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `category_id_UNIQUE`(`category_id` ASC) USING BTREE,
  UNIQUE INDEX `category_name_UNIQUE`(`category_name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `goods_comment`  (
  `goods_comment_id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL,
  `buyer_id` int NOT NULL,
  `goods_comment_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`goods_comment_id`) USING BTREE,
  UNIQUE INDEX `goods_comment_id_UNIQUE`(`goods_comment_id` ASC) USING BTREE,
  INDEX `fk_goods_comment_goods_idx`(`goods_id` ASC) USING BTREE,
  INDEX `fk_goods_comment_buyer_idx`(`buyer_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `goods_img`  (
  `goods_img_id` int NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL,
  `goods_img_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`goods_img_id`) USING BTREE,
  UNIQUE INDEX `goods_id_UNIQUE`(`goods_img_id` ASC) USING BTREE,
  UNIQUE INDEX `goods_img_url_UNIQUE`(`goods_img_url` ASC) USING BTREE,
  INDEX `fk_img_goods_idx`(`goods_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `order`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `buyer_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `goods_id` int NOT NULL,
  `order_num` int NOT NULL,
  `order_sum_price` float NOT NULL,
  `order_status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_date_time` datetime NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  UNIQUE INDEX `order_id_UNIQUE`(`order_id` ASC) USING BTREE,
  INDEX `fk_order_goods_idx`(`goods_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `shopping_cart`  (
  `shopping_cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL,
  `goods_id` int NOT NULL,
  `collect_time` datetime NOT NULL,
  `collect_num` int NOT NULL,
  PRIMARY KEY (`shopping_cart_id`) USING BTREE,
  INDEX `fk_collect_goods_idx`(`goods_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_phone_num` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_passwd` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_status` int NOT NULL,
  `user_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_campus` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_gender` int NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id_UNIQUE`(`user_id` ASC) USING BTREE,
  UNIQUE INDEX `user_phone_num_UNIQUE`(`user_phone_num` ASC) USING BTREE,
  UNIQUE INDEX `user_email_UNIQUE`(`user_email` ASC) USING BTREE,
  UNIQUE INDEX `user_name_UNIQUE`(`user_name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `user_comment`  (
  `user_comment_id` int NOT NULL AUTO_INCREMENT,
  `buyer_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `user_comment_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`user_comment_id`) USING BTREE,
  UNIQUE INDEX `user_comment_id_UNIQUE`(`user_comment_id` ASC) USING BTREE,
  INDEX `fk_user_comment_buyer_idx`(`buyer_id` ASC) USING BTREE,
  INDEX `fk_user_comment_seller_idx`(`seller_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_category` FOREIGN KEY (`goods_category_id`) REFERENCES `goods_category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_user` FOREIGN KEY (`seller_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `goods_comment` ADD CONSTRAINT `fk_goods_comment_buyer` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `goods_comment` ADD CONSTRAINT `fk_goods_comment_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `goods_img` ADD CONSTRAINT `fk_img_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `order` ADD CONSTRAINT `fk_order_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `order` ADD CONSTRAINT `fk_order_buyer` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `order` ADD CONSTRAINT `fk_order_seller` FOREIGN KEY (`seller_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `shopping_cart` ADD CONSTRAINT `fk_collect_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `shopping_cart` ADD CONSTRAINT `fk_collect_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `user_comment` ADD CONSTRAINT `fk_user_comment_buyer` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `user_comment` ADD CONSTRAINT `fk_user_comment_seller` FOREIGN KEY (`seller_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

