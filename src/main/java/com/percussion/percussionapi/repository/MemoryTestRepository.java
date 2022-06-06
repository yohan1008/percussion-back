package com.percussion.percussionapi.repository;

import com.percussion.percussionapi.domain.TestDomain;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryTestRepository implements TestRepository {

    private static Map<Integer, TestDomain> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public TestDomain save(TestDomain testDomain) {
        testDomain.setTestNo(++sequence);
        store.put(testDomain.getTestNo(), testDomain);
        return testDomain;
    }

    @Override
    public Optional<TestDomain> findByNo(int no) {
        return Optional.ofNullable(store.get(no));
    }

    @Override
    public Optional<TestDomain> findByStr(String str) {
        return store.values().stream()
                .filter(testDomain -> testDomain.getTestStr().equals(str))
                .findAny();
    }

    @Override
    public List<TestDomain> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
