package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.Facade;
import services.Service1;
import services.Service2;

@Configuration
public class ResourceAndBeanConfig {

    @Bean
    public Service1 service1() {return new Service1();}

    @Bean
    public Service2 service2() {return new Service2();}
    @Bean
    public Facade facade() {
        Facade facade=new Facade();
        facade.setService1(service1());
        facade.setService2(service2());
        return facade;
    }

}
