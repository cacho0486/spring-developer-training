package com.pfcti.spring_data.springbeans.config;

import com.pfcti.spring_data.repository.ClienteRepository;
import com.pfcti.spring_data.springbeans.AdministradorClientes;
import com.pfcti.spring_data.springbeans.dto.ClienteQueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfiguration {
    @Autowired
    private ClienteRepository clienteRepository;

    @Bean({"defaultCedula","criteriaByCedula"})
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientes(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }
    @Bean("defaultNombre")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientesByNpmbre(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }
    @Bean("defaultNombrePrototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public AdministradorClientes administradorClientesPropotype(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombreRequest")
    @RequestScope
    @Lazy
    public AdministradorClientes administradorClientesByNpmbre1(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombreSession")
    @SessionScope
    @Lazy
    public AdministradorClientes administradorClientesByNpmbre2(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombreApplication")
    @ApplicationScope
    @Lazy
    public AdministradorClientes administradorClientesByNpmbre3(){
        //Puede tener logica adicional si es necesario
        //
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }
}
