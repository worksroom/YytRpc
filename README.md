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
