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
