package com.percussion.percussionapi.controller;

import com.percussion.percussionapi.domain.TestDomain;
import com.percussion.percussionapi.service.TestService;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    private final TestService testService;
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    //API호출테스트
    @GetMapping("test")
    @ResponseBody
    public String test() {
        logger.info("test API 호출");
        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        return "success";
    }

    //API호출테스트(쿼리스트링)
    @GetMapping("test-queryString")
    @ResponseBody
    public String test(@RequestParam("test") String test) {
        logger.info("test-queryString API 호출");
        return test;
    }

    //DB전체 데이터 값 가져오기 테스트
    @GetMapping("test-findDomains")
    @ResponseBody
    public List<TestDomain> findDomains() {
        logger.info("test-findDomains API 호출");
        List<TestDomain> result = testService.findDomains();
        return result;
    }

    //DB 특정데이터 값 가져오기 테스트
    @GetMapping("test-findOne")
    @ResponseBody
    public Optional<TestDomain> findOne(@RequestParam("testNo") int testNo) {
        logger.info("test-findOne API 호출");
        Optional<TestDomain> result = testService.findOne(testNo);
        return result;
    }

    //DB 데이터 insert 테스트
    @GetMapping("test-insert")
    @ResponseBody
    public int insert(@RequestParam("testStr") String testStr) {
        logger.info("test-insert API 호출");
        TestDomain domain = new TestDomain();
        domain.setTestStr(testStr);
        int result = testService.insert(domain);
        return result;
    }

}
