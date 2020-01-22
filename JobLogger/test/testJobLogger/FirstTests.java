/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testJobLogger;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import joblogger.JobLogger;

/**
 *
 * @author leo
 */
public class FirstTests {
    
    public FirstTests() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void CorrectMessage() {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        
        
        JobLogger Job= new JobLogger(true, true, true, true, true, true, dbParamsMap);
    
    
    }
}
