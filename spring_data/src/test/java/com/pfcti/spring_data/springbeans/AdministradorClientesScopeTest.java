package com.pfcti.spring_data.springbeans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdministradorClientesScopeTest {
    @Autowired
    @Qualifier("defaultNombre")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultNombre")
    private AdministradorClientes singleton2;
    @Autowired
    @Qualifier("defaultNombrePrototype")
    private AdministradorClientes prototype1;
    @Autowired
    @Qualifier("defaultNombrePrototype")
    private AdministradorClientes prototype2;

    @Autowired
    @Qualifier("defaultNombreRequest")
    private AdministradorClientes requestInstance;

    @Autowired
    @Qualifier("defaultNombreSession")
    private AdministradorClientes requestSession;

    @Autowired
    @Qualifier("defaultNombreApplication")
    private AdministradorClientes requestApplication;
    @Test
    void instancias() {
        System.out.println("singleton1 " + singleton1);
        System.out.println("singleton2 " + singleton2);
        System.out.println("prototype1 " + prototype1);
        System.out.println("prototype2 " + prototype2);
        System.out.println("Request " + requestInstance);
        System.out.println("Session " + requestSession);
        System.out.println("Application " + requestApplication);
        Assertions.assertEquals(1, 1);
    }


}
