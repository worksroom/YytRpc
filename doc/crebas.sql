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
   id                   int not null auto_increment comment '���ID',
   ad_type              varchar(20) comment '������',
   img                  blob comment '���ͼƬ',
   des                  varchar(2000) comment '�������',
   url                  varchar(200) comment '��ת��ַ',
   used                 int comment '�Ƿ���Ч��0 ��Ч��-1 ��Ч',
   create_time          timestamp comment '����ʱ��',
   primary key (id)
);

alter table ad comment '���';

/*==============================================================*/
/* Table: ad_category                                           */
/*==============================================================*/
create table ad_category
(
   id                   varchar(20) not null comment '������ID',
   name                 varchar(50) comment '����������',
   create_time          timestamp comment '����ʱ��',
   primary key (id)
);

alter table ad_category comment '������';

/*==============================================================*/
/* Table: chat_record                                           */
/*==============================================================*/
create table chat_record
(
   id                   int not null auto_increment comment '����',
   session_id           int comment '�ỰID',
   user_id              int comment '˵����ID',
   content              varchar(200) comment '��������',
   create_time          timestamp comment '��������ʱ��',
   type                 int comment '�����������ͣ���չʹ��',
   push_type            int comment '�Ƿ������ͣ�0-δ���ͣ�1-������',
   primary key (id)
);

alter table chat_record comment '�����¼';

/*==============================================================*/
/* Table: chat_session                                          */
/*==============================================================*/
create table chat_session
(
   id                   int not null auto_increment comment '�ỰID',
   user_id              int comment '�û�ID',
   friend_id            int comment '����ID,�����ǷǺ���ID',
   create_time          timestamp comment '�Ự����ʱ��',
   last_time            timestamp comment '�������ʱ��',
   last_content         varchar(200) comment '�����������',
   lastr_uid            int comment 'lastr_uid',
   primary key (id)
);

alter table chat_session comment '�Ự�б�';

/*==============================================================*/
/* Table: fragment_home                                         */
/*==============================================================*/
create table fragment_home
(
   id                   int not null auto_increment comment '����',
   rank                 int comment '��������ԽС����Խ��ǰ',
   type                 int comment '���ͣ�1 �������չʾ��ʽΪ����2 һ��һͼ����3 һ����ͼ����4 һ����ͼ����',
   content              varchar(1000) comment '���ݣ���ʽ��[{"img":"...","url":"..."},{"img":"...","url":"..."}]',
   used                 int comment '�Ƿ���Ч��0 ��Ч��-1 ��Ч',
   create_time          timestamp comment '����ʱ��',
   primary key (id)
);

alter table fragment_home comment '��ҳ��Ƭ��';

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   user_id              int not null comment '�û�ID',
   friend_id            int not null comment '����ID',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   primary key (user_id, friend_id)
);

alter table friend comment '�ҵĺ���';

/*==============================================================*/
/* Table: friend_apply                                          */
/*==============================================================*/
create table friend_apply
(
   id                   int not null auto_increment comment '����',
   user_id              int comment '�û�ID',
   friend_id            int comment '����ID',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   status               int comment '����״̬��0-���� 1-ͨ�� -1-�ܾ�',
   msg                  varchar(100) comment '��������',
   primary key (id)
);

alter table friend_apply comment '��������';

/*==============================================================*/
/* Table: info_category                                         */
/*==============================================================*/
create table info_category
(
   id                   int not null auto_increment comment '���ID',
   name                 varchar(50) comment '�������',
   parent_id            int comment '�����ID',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   primary key (id)
);

alter table info_category comment '��Ϣ��������';

/*==============================================================*/
/* Table: info_content                                          */
/*==============================================================*/
create table info_content
(
   id                   int comment '��ѶID',
   weight               int comment 'Ȩ��',
   user_id              int comment '�û�ID',
   class_id             int comment '��Ѷ����ID',
   title                varchar(100) comment '��Ѷ����',
   type                 int comment '�������ͣ�1 ����ҳ html��ʽ��2.����ҳ json��ʽ',
   des                  varchar(200) comment '���',
   photo                blob comment '��ͼ',
   content              varchar(2000) comment '��Ѷ����',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��'
);

alter table info_content comment '��Ϣ����';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment comment '�û�ID������',
   create_time          timestamp comment 'ע��ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   user_name            varchar(30) comment '�û���',
   nick_name            varchar(50) comment '�û��ǳ�',
   email                varchar(50) comment '����',
   phone                varchar(11) comment '�ֻ���',
   primary key (user_id)
);

alter table user comment '�û���';

/*==============================================================*/
/* Table: user_buyer                                            */
/*==============================================================*/
create table user_buyer
(
   user_id              int not null comment '�û�ID',
   card_number          varchar(30) comment '���֤����',
   card_f_photo         blob comment '֤��������',
   card_b_photo         blob comment '֤���ձ���',
   user_card_photo      blob comment '�ֳ�֤����',
   status               int comment '���״̬��0-���� 1-ͨ�� -1-���',
   msg                  varchar(100) comment '���ԭ��',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   primary key (user_id)
);

alter table user_buyer comment '�����֤';

/*==============================================================*/
/* Table: user_seller                                           */
/*==============================================================*/
create table user_seller
(
   user_id              int not null comment '�û�ID',
   card_number          varchar(30) comment '���֤����',
   card_f_photo         blob comment '֤��������',
   card_b_photo         blob comment '֤���ձ���',
   user_card_photo      blob comment '�ֳ�֤����',
   licence_phone        blob comment 'Ӫҵִ��',
   status               int comment '���״̬��0-���� 1-ͨ�� -1-���',
   msg                  varchar(100) comment '���ԭ��',
   create_time          timestamp comment '����ʱ��',
   update_time          timestamp comment '�޸�ʱ��',
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_third_bind                                       */
/*==============================================================*/
create table user_third_bind
(
   user_id              int comment '�û�ID',
   third_id             varchar(100) comment '������Ψһ��ʶID',
   type                 int comment '������',
   create_time          timestamp comment '��ʱ��'
);

alter table user_third_bind comment '�û������󶨹�ϵ';

