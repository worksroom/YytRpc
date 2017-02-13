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