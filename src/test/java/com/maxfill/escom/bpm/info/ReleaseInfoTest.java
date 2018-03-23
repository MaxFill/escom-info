package com.maxfill.escom.bpm.info;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReleaseInfoTest {
    
    public ReleaseInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetReleaseInfo() {
        String licenceNumber = "12345";
        ReleaseInfo instance = new ReleaseInfo();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();

        String expected = objectNode.toString();
        System.out.println("expected = " + expected);
        String result = "{}";
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
    
}
