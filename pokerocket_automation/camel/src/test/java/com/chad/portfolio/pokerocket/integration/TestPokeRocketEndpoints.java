package com.chad.portfolio.pokerocket.integration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPokeRocketEndpoints {

    @BeforeClass()
    @Parameters({"url", "username", "password"})
    public void init(String url, String username, String password) {

    }

    @AfterClass
    public void destroy() {

    }

    @Test(groups = "integration")
    public void test() {


    }


}
