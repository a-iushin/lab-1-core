package com.luxoft.springioc.lab1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorldTest {

    protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    private UsualPerson expectedPerson;

    private AbstractApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext(new String[]{APPLICATION_CONTEXT_XML_FILE_NAME});
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
        UsualPerson person = (UsualPerson) context.getBean("person", Person.class);

        System.out.println("-->" + person.getCountry().getA());
    }

    private UsualPerson getExpectedPerson() {
        UsualPerson person = (UsualPerson) context.getBean("person");

        Country country = (Country) context.getBean("country1");
        System.out.println("-->" + country.getName());
        System.out.println("-->" + country.getA());

        return person;
    }

    @After
    public void tearDown() throws Exception {
        if (context != null)
            context.close();
    }
}
