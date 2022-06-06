package com.percussion.percussionapi.repository;

import com.percussion.percussionapi.domain.TestDomain;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaTestRepository implements  TestRepository {

    private final EntityManager em;

    @Autowired
    public JpaTestRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public TestDomain save(TestDomain testDomain) {
        em.persist(testDomain);
        return testDomain;
    }

    @Override
    public Optional<TestDomain> findByNo(int no) {
        TestDomain domain = em.find(TestDomain.class, no);
        return Optional.ofNullable(domain);
    }

    @Override
    public Optional<TestDomain> findByStr(String str) {
        List<TestDomain> result = em.createQuery("SELECT t FROM testDomain t WHERE t.testStr = :str", TestDomain.class)
                .setParameter("str", str)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<TestDomain> findAll() {
        return em.createQuery("SELECT t FROM testDomain t", TestDomain.class)
                .getResultList();
    }
}
