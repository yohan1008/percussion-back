package com.percussion.percussionapi.domain;

import javax.persistence.*;

@Entity(name = "testDomain")
public class TestDomain {

    @Id
    @Column(name = "testNo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testNo;

    @Column(name = "testStr")
    private String testStr;

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
