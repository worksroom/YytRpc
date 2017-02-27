"# YytRpc"
```

alter table `yyt`.`mall_product_category` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '分类ID',
   add primary key(`id`);

alter table `yyt`.`mall_product_category_pro` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '分类属性ID',
   add primary key(`id`);
   
alter table `yyt`.`mall_product_category_pro_value` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '分类属性值ID',
   add primary key(`id`);


```

# 货品
```
alter table `yyt`.`mall_goods` 
   add column `shop_id` int(11) NULL after `name`, 
   add column `shop_name` varchar(200) NULL after `shop_id`,
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT,
   add primary key(`id`);

alter table `yyt`.`mall_goods` 
   add column `status` int(11) NOT NULL COMMENT '0 待审 1 审核通过' after `name`
  
```


# 店铺
```
CREATE TABLE `user_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sell_user_id` int(11) NOT NULL ,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '0 待审 1 审核通过',
  `main_product` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `logo` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```


```

alter table `yyt`.`mall_index` 
   add column `status` int(4) NULL COMMENT '0 无效  1有效' after `type`,
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '×ÔÔöid'
```
```
alter table `yyt`.`mall_product` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID';
alter table `yyt`.`mall_product` 
   add column `rank` int(11) NULL after `class_id`;
   alter table `yyt`.`mall_product_sale_pro` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment 'id',
   add primary key(`id`);
   alter table `yyt`.`mall_product_sale_pro` 
   add column `class_pro_id` int(11) NULL after `goods_id`,
   change `deliver_id` `goods_id` int(11) NULL  comment '货品ID';



CREATE TABLE `store_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL ,
  `f_code` int(11) NOT NULL ,
  `f_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `s_code` int(11) NOT NULL COMMENT '二级地址编码',
  `s_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `fare_mould` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL ,
  `shop_id` int(11) NOT NULL ,
  `type` int(11) NOT NULL ,
  `price` decimal(11,2) not null DEFAULT 0,
  `num` int(11) NOT NULL DEFAULT 1,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `mall_product_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT 0,
  `goods_id` int(11) NOT NULL DEFAULT 0,
  `product_id` int(11) NOT NULL DEFAULT 0,
  `thrid_id` int(11) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


alter table `yyt`.`mall_product_category_pro` 
   add column `is_multiple` int(11) DEFAULT 0 after `type`;

alter table `yyt`.`mall_product_category_pro` 
   add column `is_sku` int(4) DEFAULT '0' NULL COMMENT '是否销售属性 0 非 1是' after `is_multiple`;


alter table `yyt`.`product_evaluate_record` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT,
   add primary key(`id`);




   CREATE TABLE `shop_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL ,
  `user_id` int(11) NOT NULL ,
  `type` int(11) NOT NULL ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE INDEX idx_shopid_userid ON shop_user(shop_id,user_id);




CREATE TABLE `mall_good_base_pro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL DEFAULT 0,
  `class_pro_id` int(11) NOT NULL DEFAULT 0,
  `class_pro_value_id` int(11) NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

ALTER TABLE `mall_goods`
MODIFY COLUMN `img`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片的结果集\r\n            {[\r\n               img\r\n            ]}' AFTER `update_time`;

ALTER TABLE `ad_category`
MODIFY COLUMN `id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '广告类别ID' FIRST ;

ALTER TABLE `ad`
MODIFY COLUMN `ad_type`  int(11) NULL DEFAULT NULL COMMENT '广告类别' AFTER `id`,
MODIFY COLUMN `img`  varchar(500) NULL DEFAULT NULL COMMENT '广告图片' AFTER `ad_type`;

alter table `yyt`.`mall_good_base_pro` 
   change `class_pro_value_id` `class_pro_value` varchar(400) default '0' NOT NULL;




