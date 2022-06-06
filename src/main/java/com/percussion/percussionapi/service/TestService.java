package com.percussion.percussionapi.service;

import com.percussion.percussionapi.domain.TestDomain;
import com.percussion.percussionapi.repository.MemoryTestRepository;
import com.percussion.percussionapi.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * 데이터 넣기
     * @param domain
     * @return
     */
    public int insert(TestDomain domain) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateDate(domain);
        testRepository.save(domain);
        return domain.getTestNo();
    }

    private void validateDuplicateDate(TestDomain domain) {
        testRepository.findByStr(domain.getTestStr())
                .ifPresent(testDomain -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 데이터 조회
     * @return
     */
    public List<TestDomain> findDomains() {
        return testRepository.findAll();
    }

    /**
     *한 데이터 조회
     * @param testNo
     * @return
     */
    public Optional<TestDomain> findOne(int testNo) {
        return testRepository.findByNo(testNo);
    }
}
