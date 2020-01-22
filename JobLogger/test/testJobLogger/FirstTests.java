/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testJobLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author leo
 */
public class FirstTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLogMessage() throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(false, false, false, true, true, true, dbParamsMap);
         boolean message = true;
        boolean warning = false;
        boolean error = false;
        obj.LogMessage("testMessage", message, warning, error);
        assertEquals("hello", outContent.toString());
    }
    
    @Test
    public void testLogMessage2() throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(true, true, true, true, true, true, dbParamsMap);
        boolean message = true;
        boolean warning = false;
        boolean error = false;
        obj.LogMessage("testMessage", message, warning, error);
        assertEquals("ene 22, 2020 2:10:42 PM jlogger.Jlogger LogTo\n" +
        "INFORMACIÓN: message 22 de enero de 2020testMessage\n" +
        "ene 22, 2020 2:10:42 PM jlogger.Jlogger LogTo\n" +
        "INFORMACIÓN: message 22 de enero de 2020testMessage\n" +
        "ene 22, 2020 2:10:42 PM jlogger.Jlogger LogTo\n" +
        "INFORMACIÓN: message 22 de enero de 2020testMessage", outContent.toString());
        fail("The method is not working properly");
    }
    
    @Test(expected = NullPointerException.class)
    public void NullPointer()  throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(true, true, true, true, true, true, dbParamsMap);
        System.out.println("LogMessage");
        String messageText = "hello test";
        boolean message = true;
        boolean warning = false;
        boolean error = false;
        //Jlogger instance = null;
        obj.LogMessage(messageText, message, warning, error);
    }
    
    @Test(expected = NullPointerException.class)
    public void NullPointer2()  throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(false, true, false, true, true, true, dbParamsMap);
        String messageText = "";
        boolean message = true;
        boolean warning = false;
        boolean error = false;
        //Jlogger instance = null;
        obj.LogMessage(messageText, message, warning, error);
    }
    
    @Test(expected = IOException.class)
        public void IO()  throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(false, true, false, true, true, true, dbParamsMap);
        System.out.println("LogMessage");
        String messageText = "hello test";
        boolean message = true;
        boolean warning = false;
        boolean error = false;
        //Jlogger instance = null;
        obj.LogMessage(messageText, message, warning, error);
    }
    
    @Test(expected = SQLException.class)
    public void SQL()  throws Exception {
        Map<String, String> dbParamsMap=new HashMap<String, String>();
        dbParamsMap.put("logFileFolder", "/p_wrk1");
        dbParamsMap.put("database", "testdatabase");
        dbParamsMap.put("userName", "Leo");
        dbParamsMap.put("password", "bElatr1x**");
        dbParamsMap.put("serverName", "localhost");
        dbParamsMap.put("dbms", "postgresql");
        dbParamsMap.put("portNumber", "5432");
        dbParamsMap.put("dbName", "logsbelatrix");
        Jlogger obj= new Jlogger(false, true, false, true, true, true, dbParamsMap);
        System.out.println("LogMessage");
        String messageText = "hello test";
        boolean message = true;
        boolean warning = true;
        boolean error = true;
        //Jlogger instance = null;
        obj.LogMessage(messageText, message, warning, error);
    }
}
