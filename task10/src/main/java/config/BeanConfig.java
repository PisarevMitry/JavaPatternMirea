package config;

import entity.Drummer;
import entity.Guitarist;
import entity.Musician;
import entity.Trombonist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "entity")
@Configuration
public class BeanConfig {

    @Bean
    public Musician drummer() {
        return new Drummer();
    }

    @Bean
    public Musician guitarist() {
        return new Guitarist();
    }

    @Bean
    public Musician trombonist() {
        return new Trombonist();
    }
}
