/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/9/22 14:43:41                           */
/*==============================================================*/


drop table if exists ad;

drop table if exists ad_category;

drop table if exists chat_record;

drop table if exists chat_session;

drop table if exists fragment_home;

drop table if exists friend;

drop table if exists friend_apply;

drop table if exists info_category;

drop table if exists info_content;

drop table if exists user;

drop table if exists user_buyer;

drop table if exists user_seller;

drop table if exists user_third_bind;

/*==============================================================*/
/* Table: ad                                                    */
/*==============================================================*/
create table ad
(
   id                   int not null auto_increment comment '广告ID',
   ad_type              varchar(20) comment '广告类别',
   img                  blob comment '广告图片',
   des                  varchar(2000) comment '广告描述',
   url                  varchar(200) comment '跳转地址',
   used                 int comment '是否有效：0 有效，-1 无效',
   create_time          timestamp comment '创建时间',
   primary key (id)
);

alter table ad comment '广告';

/*==============================================================*/
/* Table: ad_category                                           */
/*==============================================================*/
create table ad_category
(
   id                   varchar(20) not null comment '广告类别ID',
   name                 varchar(50) comment '广告类别名称',
   create_time          timestamp comment '创建时间',
   primary key (id)
);

alter table ad_category comment '广告类别';

/*==============================================================*/
/* Table: chat_record                                           */
/*==============================================================*/
create table chat_record
(
   id                   int not null auto_increment comment '主键',
   session_id           int comment '会话ID',
   user_id              int comment '说话人ID',
   content              varchar(200) comment '聊天内容',
   create_time          timestamp comment '聊天内容时间',
   type                 int comment '聊天内容类型：扩展使用',
   push_type            int comment '是否已推送：0-未推送，1-已推送',
   primary key (id)
);

alter table chat_record comment '聊天记录';

/*==============================================================*/
/* Table: chat_session                                          */
/*==============================================================*/
create table chat_session
(
   id                   int not null auto_increment comment '会话ID',
   user_id              int comment '用户ID',
   friend_id            int comment '好友ID,可以是非好友ID',
   create_time          timestamp comment '会话创建时间',
   last_time            timestamp comment '最后聊天时间',
   last_content         varchar(200) comment '最后聊天内容',
   lastr_uid            int comment 'lastr_uid',
   primary key (id)
);

alter table chat_session comment '会话列表';

/*==============================================================*/
/* Table: fragment_home                                         */
/*==============================================================*/
create table fragment_home
(
   id                   int not null auto_increment comment '主键',
   rank                 int comment '排序，数字越小排序越靠前',
   type                 int comment '类型，1 类别区（展示样式为）；2 一行一图区域；3 一行两图区域；4 一行三图区域',
   content              varchar(1000) comment '内容，格式：[{"img":"...","url":"..."},{"img":"...","url":"..."}]',
   used                 int comment '是否有效，0 有效；-1 无效',
   create_time          timestamp comment '创建时间',
   primary key (id)
);

alter table fragment_home comment '首页碎片区';

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   user_id              int not null comment '用户ID',
   friend_id            int not null comment '好友ID',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   primary key (user_id, friend_id)
);

alter table friend comment '我的好友';

/*==============================================================*/
/* Table: friend_apply                                          */
/*==============================================================*/
create table friend_apply
(
   id                   int not null auto_increment comment '主键',
   user_id              int comment '用户ID',
   friend_id            int comment '好友ID',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   status               int comment '申请状态：0-申请 1-通过 -1-拒绝',
   msg                  varchar(100) comment '申请留言',
   primary key (id)
);

alter table friend_apply comment '好友申请';

/*==============================================================*/
/* Table: info_category                                         */
/*==============================================================*/
create table info_category
(
   id                   int not null auto_increment comment '类别ID',
   name                 varchar(50) comment '类别名称',
   parent_id            int comment '父类别ID',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   primary key (id)
);

alter table info_category comment '信息管理类型';

/*==============================================================*/
/* Table: info_content                                          */
/*==============================================================*/
create table info_content
(
   id                   int comment '资讯ID',
   weight               int comment '权重',
   user_id              int comment '用户ID',
   class_id             int comment '资讯分类ID',
   title                varchar(100) comment '资讯标题',
   type                 int comment '内容类型：1 内容页 html格式，2.内容页 json格式',
   des                  varchar(200) comment '简介',
   photo                blob comment '配图',
   content              varchar(2000) comment '资讯内容',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间'
);

alter table info_content comment '信息内容';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment comment '用户ID，自增',
   create_time          timestamp comment '注册时间',
   update_time          timestamp comment '修改时间',
   user_name            varchar(30) comment '用户名',
   nick_name            varchar(50) comment '用户昵称',
   email                varchar(50) comment '邮箱',
   phone                varchar(11) comment '手机号',
   primary key (user_id)
);

alter table user comment '用户表';

/*==============================================================*/
/* Table: user_buyer                                            */
/*==============================================================*/
create table user_buyer
(
   user_id              int not null comment '用户ID',
   card_number          varchar(30) comment '身份证号码',
   card_f_photo         blob comment '证件照正面',
   card_b_photo         blob comment '证件照背面',
   user_card_photo      blob comment '手持证件照',
   status               int comment '审核状态：0-待审 1-通过 -1-打回',
   msg                  varchar(100) comment '打回原因',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   primary key (user_id)
);

alter table user_buyer comment '买家认证';

/*==============================================================*/
/* Table: user_seller                                           */
/*==============================================================*/
create table user_seller
(
   user_id              int not null comment '用户ID',
   card_number          varchar(30) comment '身份证号码',
   card_f_photo         blob comment '证件照正面',
   card_b_photo         blob comment '证件照背面',
   user_card_photo      blob comment '手持证件照',
   licence_phone        blob comment '营业执照',
   status               int comment '审核状态：0-待审 1-通过 -1-打回',
   msg                  varchar(100) comment '打回原因',
   create_time          timestamp comment '创建时间',
   update_time          timestamp comment '修改时间',
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_third_bind                                       */
/*==============================================================*/
create table user_third_bind
(
   user_id              int comment '用户ID',
   third_id             varchar(100) comment '第三方唯一标识ID',
   type                 int comment '绑定类型',
   create_time          timestamp comment '绑定时间'
);

alter table user_third_bind comment '用户三方绑定关系';

