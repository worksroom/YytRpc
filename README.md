"# YytRpc"
```

alter table `yyt`.`mall_product_category` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '����ID',
   add primary key(`id`);

alter table `yyt`.`mall_product_category_pro` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '��������ID',
   add primary key(`id`);
   
alter table `yyt`.`mall_product_category_pro_value` 
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT comment '��������ֵID',
   add primary key(`id`);


```

# ��Ʒ
```
alter table `yyt`.`mall_goods` 
   add column `shop_id` int(11) NULL after `name`, 
   add column `shop_name` varchar(200) NULL after `shop_id`,
   change `id` `id` int(11) NOT NULL AUTO_INCREMENT,
   add primary key(`id`);

alter table `yyt`.`mall_goods` 
   add column `status` int(11) NOT NULL COMMENT '0 ���� 1 ���ͨ��' after `name`
  
```


# ����
```
CREATE TABLE `user_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sell_user_id` int(11) NOT NULL ,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '0 ���� 1 ���ͨ��',
  `main_product` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '�޸�ʱ��',
  `logo` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT 'ͼƬ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```