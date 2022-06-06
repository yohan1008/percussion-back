package com.percussion.percussionapi.service;

import com.percussion.percussionapi.domain.TestDomain;
import com.percussion.percussionapi.repository.MemoryTestRepository;
import com.percussion.percussionapi.repository.TestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceTest {

    @Autowired TestService testService;
    @Autowired TestRepository testRepository;

    @BeforeEach
    public void beforeEach() {
        testRepository = new MemoryTestRepository();
        testService = new TestService(testRepository);
    }

    @Test
    void 데이터삽입() {
        //given
        TestDomain domain = new TestDomain();
        domain.setTestStr("test");

        //when
        int saveNo = testService.insert(domain);

        //then
        TestDomain findDomain = testService.findOne(saveNo).get();
        Assertions.assertThat(domain.getTestStr()).isEqualTo(findDomain.getTestStr());
    }

    @Test
    public void 중복데이터예외() {
        //given
        TestDomain domain1 = new TestDomain();
        domain1.setTestStr("test");

        TestDomain domain2 = new TestDomain();
        domain2.setTestStr("test");

        //when
        testService.insert(domain1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> testService.insert(domain2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then

    }

    @Test
    void findDomains() {
    }

    @Test
    void findOne() {
    }
}