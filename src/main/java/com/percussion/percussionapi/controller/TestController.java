package com.percussion.percussionapi.controller;

import com.percussion.percussionapi.domain.TestDomain;
import com.percussion.percussionapi.service.TestService;
import org.aspectj.weaver.ast.Test;
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

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    //API호출테스트
    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "success";
    }

    //API호출테스트(쿼리스트링)
    @GetMapping("test-queryString")
    @ResponseBody
    public String test(@RequestParam("test") String test) {

        return test;
    }

    //DB전체 데이터 값 가져오기 테스트
    @GetMapping("test-findDomains")
    @ResponseBody
    public List<TestDomain> findDomains() {
        List<TestDomain> result = testService.findDomains();
        return result;
    }

    //DB 특정데이터 값 가져오기 테스트
    @GetMapping("test-findOne")
    @ResponseBody
    public Optional<TestDomain> findOne(@RequestParam("testNo") int testNo) {
        Optional<TestDomain> result = testService.findOne(testNo);
        return result;
    }

    //DB 데이터 insert 테스트
    @GetMapping("test-insert")
    @ResponseBody
    public int insert(@RequestParam("testStr") String testStr) {
        TestDomain domain = new TestDomain();
        domain.setTestStr(testStr);
        int result = testService.insert(domain);
        return result;
    }

}
