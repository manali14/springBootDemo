package com.airtel;

import com.airtel.dao.User;
import com.airtel.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@Configuration
@SpringBootApplication
@EnableJpaRepositories({"com.airtel.repository"})
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.airtel")
//@EnableWebMvc
public class FeedbackPortalApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FeedbackPortalApplication.class, args);
    }

    @Bean
    InitializingBean bootstrapData() {
        return new InitializingBean() {
            @Override
            public void afterPropertiesSet() throws Exception {
                if (userRepository.count() == 0) {
                    User user = new User();
                    user.setUsername("manalikhanna92@gmail.com");
                    user.setPassword("password");
                    user.setDateCreated(new Date());
                    user.setLastUpdated(new Date());
                    userRepository.save(user);
                }
            }
        };
    }
}
