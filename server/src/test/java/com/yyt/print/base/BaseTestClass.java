package com.yyt.print.base;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class BaseTestClass {

    protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
    protected static String name;

    protected static Object getBean(String name) {
        return ctx.getBean(name);
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
}
