package com.yyt.print.product;

import com.yyt.print.product.pojo.MallProductExt;

import java.lang.reflect.Field;

/**
 * Created by lenovo on 2017/2/16.
 */
public class Help {

    private static String LINE = "\n";

    private static String toDbCol(String name){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<name.length();i++){
            char c = name.charAt(i);
            if (Character.isLowerCase(c) || i==0){
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append("_").append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }




    private static String getresultMap(Class clazz){
        StringBuilder sb = new StringBuilder("<resultMap type=\""+clazz.getSimpleName()+"\" id=\""+clazz.getSimpleName()+"Map\">").append(LINE);
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            sb.append("<result property=\""+field.getName()+"\" column=\""+toDbCol(field.getName())+"\"/>").append(LINE);
        }
        sb.append("</resultMap>").append(LINE);
        return sb.toString();
    }

    private static String getDbCol(Class clazz){
        StringBuilder sb = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field field = fields[i];
            if(field.getName().equals("id")) continue;
            sb.append(" "+toDbCol(field.getName()));
            if(i<fields.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }


    private static String getBeanCol(Class clazz){
        StringBuilder sb = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field field = fields[i];
            if(field.getName().equals("id")) continue;

            sb.append(" #{"+field.getName() + "}");
            if(i<fields.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }



    private static String getInsert(Class clazz){
        StringBuilder sb = new StringBuilder();

        sb.append("<insert id=\"insert\" parameterType=\""+clazz.getSimpleName()+"\">").append(LINE);

        sb.append("insert into " + toDbCol(clazz.getSimpleName()) + " (").append(LINE);
        sb.append(getDbCol(clazz)).append(")"+LINE);
        sb.append("VALUES" + LINE);
        sb.append("(").append(getBeanCol(clazz)).append(")").append(LINE);


        sb.append("<selectKey resultType=\"int\" keyProperty=\"id\">").append(LINE);
        sb.append("select LAST_INSERT_ID() AS id").append(LINE);
        sb.append("</selectKey>").append(LINE);
        sb.append("</insert>").append(LINE);
        return sb.toString();
    }


    private static String getUpdate(Class clazz){
        StringBuilder sb = new StringBuilder();
        sb.append("<update id=\"update\" parameterType=\""+clazz.getSimpleName()+"\">").append(LINE);
        sb.append("update " + toDbCol(clazz.getSimpleName()) + " set ");
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Field field = fields[i];
            if(field.getName().equals("id")) continue;
            sb.append(toDbCol(field.getName()) + " = #{" + field.getName() + "}");
            if(i<fields.length-1){
                sb.append(",");
            }
        }
        sb.append("where id=#{id}").append(LINE);
        sb.append("</update>").append(LINE);
        return sb.toString();

    }

    private static String getDelete(Class clazz){
        StringBuilder sb = new StringBuilder();
        sb.append("<delete id=\"delete\" parameterType=\"int\">").append(LINE);
        sb.append("delete from "+toDbCol(clazz.getSimpleName())+" where id=#{id}").append(LINE);
        sb.append("</delete>").append(LINE);
        return sb.toString();
    }


    private static String getGet(Class clazz){
        StringBuilder sb = new StringBuilder();
        sb.append("<select id=\"select\" parameterType=\"int\" resultMap=\""+clazz.getSimpleName()+"Map\">").append(LINE);
        sb.append("select id , ").append(getDbCol(clazz)).append(" from " + toDbCol(clazz.getSimpleName())).append(" where id=#{id}").append(LINE);
        sb.append("</select>").append(LINE);
        return sb.toString();
    }

    public static String getXML(Class clazz){
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(LINE);
        sb.append("<!DOCTYPE mapper  PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">").append(LINE);;
        sb.append("<mapper namespace=\""+clazz.getSimpleName()+"\">").append(LINE);
        sb.append(getresultMap(clazz));
        sb.append(getInsert(clazz));
        sb.append(getUpdate(clazz));
        sb.append(getGet(clazz));
        sb.append(getDelete(clazz));
        sb.append("</mapper>");
        return sb.toString();
    }

    //============================DAO=========================================
    private static String firstToLower(String name){
        return Character.toLowerCase(name.charAt(0)) + name.substring(1,name.length());
    }
    public static String getDAO(Class clazz){
        StringBuilder sb = new StringBuilder("");
        String className = clazz.getSimpleName();
        sb.append("==============================================================================").append(LINE);
        sb.append("public interface I"+className+"DAO{").append(LINE);
        sb.append(String.format("int save%s(%s %s);",className,className,firstToLower(className))).append(LINE);

        sb.append(String.format("int update%s(%s %s);",className,className,firstToLower(className))).append(LINE);

        sb.append(String.format("%s get%s(int id);",className,className)).append(LINE);

        sb.append(String.format("int del%s(int id);",className)).append(LINE);


        sb.append("}").append(LINE);
        return sb.toString();
    }


    public static String getDAOImpl(Class clazz){
        StringBuilder sb = new StringBuilder("");
        String className = clazz.getSimpleName();
        sb.append("==============================================================================").append(LINE);
        sb.append(String.format("@Repository(\"%sDAO\")",firstToLower(className))).append(LINE);
        //
        sb.append(String.format("public class %sDAOImpl extends YytBaseDAO<%s> implements I%sDAO {",
                className,className,className)).append(LINE);

        sb.append(String.format("@Override")).append(LINE);

        sb.append(String.format("public int save%s(%s %s){return super.insert(%s);}",className,className,firstToLower(className),firstToLower(className))).append(LINE);

        sb.append(String.format("@Override")).append(LINE);
        sb.append(String.format("public int update%s(%s %s){return super.update(%s);}",className,className,firstToLower(className),firstToLower(className))).append(LINE);

        sb.append(String.format("@Override")).append(LINE);
        sb.append(String.format("public %s get%s(int id){return super.get(id);}",className,className)).append(LINE);

        sb.append(String.format("@Override")).append(LINE);
        sb.append(String.format("public int del%s(int id){return super.delete(id);}",className)).append(LINE);


        sb.append("}").append(LINE);
        return sb.toString();
    }

    public static void main(String[] args) {
        Class clazz = MallProductExt.class;
        System.out.println(getXML(clazz));
        System.out.println(getDAO(clazz));
        System.out.println(getDAOImpl(clazz));
    }
}
