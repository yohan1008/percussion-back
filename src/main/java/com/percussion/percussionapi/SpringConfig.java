package com.percussion.percussionapi;

import com.percussion.percussionapi.repository.JpaTestRepository;
import com.percussion.percussionapi.repository.TestRepository;
import com.percussion.percussionapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public TestService testService() {
        return new TestService(testRepository());
    }

    @Bean
    public TestRepository testRepository() {
        return new JpaTestRepository(em);
    }

}
