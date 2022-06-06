package com.percussion.percussionapi.repository;

import com.percussion.percussionapi.domain.TestDomain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemoryTestRepositoryTest {

    MemoryTestRepository repository = new MemoryTestRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        TestDomain domain = new TestDomain();
        domain.setTestStr("testStr");

        repository.save(domain);
        TestDomain result = repository.findByNo(domain.getTestNo()).get();

        Assertions.assertEquals(domain, result);
    }

    @Test
    public void findByName() {
        TestDomain domain1 = new TestDomain();
        domain1.setTestStr("testStr1");
        repository.save(domain1);

        TestDomain domain2 = new TestDomain();
        domain2.setTestStr("testStr2");
        repository.save(domain2);

        TestDomain result = repository.findByStr(domain1.getTestStr()).get();
        Assertions.assertEquals(domain1, result);
    }

    @Test
    public void findAll() {
        TestDomain domain1 = new TestDomain();
        domain1.setTestStr("testStr1");
        repository.save(domain1);

        TestDomain domain2 = new TestDomain();
        domain2.setTestStr("testStr2");
        repository.save(domain2);

        List<TestDomain> result = repository.findAll();
        Assertions.assertEquals(2, result.size());
    }
}
