package com.percussion.percussionapi.repository;

import com.percussion.percussionapi.domain.TestDomain;

import java.util.List;
import java.util.Optional;

public interface TestRepository {

    TestDomain save(TestDomain testDomain);
    Optional<TestDomain> findByNo(int no);
    Optional<TestDomain> findByStr(String str);
    List<TestDomain> findAll();

}
