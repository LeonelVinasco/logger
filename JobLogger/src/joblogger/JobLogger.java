/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joblogger;

import database.dbUtils;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leo
 */
public class JobLogger {
    
    private static boolean logToFile;
    private static boolean logToConsole;
    private static boolean logMessage;
    private static boolean logWarning;
    private static boolean logError;
    private static boolean logToDatabase;
    private static Map dbParams;
    private static Logger logger;
    
    public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
		logger = Logger.getLogger("MyLog");  
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
	}
    
//    public static void main(String[] args) {
//                  
//    }
    public  void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
                messageText=messageText.trim();
		if (messageText.isEmpty()){
                    throw new Exception("Message can not be empty");
                }else{
                    if (!logToConsole && !logToFile && !logToDatabase){
                        throw new Exception("Invalid configuration");
                    }else if((!logError && !logMessage && !logWarning) || !message && !error && !warning){
                        throw new Exception("Error or Warning or Message must be specified");
                    }else{
                        database.dbUtils.connectDB(dbParams);
		        ObjTAndL dataTAndL=BuildVarsLandT(message, error, warning, messageText);
                        File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
                        if (!logFile.exists()) {
                            logFile.createNewFile();
                        }
                        FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
                        ConsoleHandler ch = new ConsoleHandler(); 
                        LogTo(logToFile, logToConsole, logToDatabase, dataTAndL.getT(), dataTAndL.getL(), fh , ch);
                    }
                }
    }
    
    public static ObjTAndL BuildVarsLandT(boolean message, boolean error, boolean warning, String messageText){
                String l=null;
                int t=0;
                ObjTAndL numStringBld;
                if (message && logMessage) {
			    t = 1;
                            l = l + "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		        }
		        if (error && logError) {
			    t = 2;
                            l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		        }
		        if (warning && logWarning) {
			    t = 3;
                            l = l + "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		        }
                numStringBld=new ObjTAndL(t,l);
                
                return numStringBld;
    }
    
    public static void LogTo(boolean logToF, boolean logToC, boolean logToDb,int t, String messageComplete, FileHandler fHandler, ConsoleHandler cHandler ){
                              
                if(logToFile) {
			logger.addHandler(fHandler);
			logger.log(Level.INFO, messageComplete);
		}
		if(logToConsole) {
			logger.addHandler(cHandler);
			logger.log(Level.INFO, messageComplete);
		}
		if(logToDatabase) {
			dbUtils.update(messageComplete, t);
		}
                dbUtils.closeDB();
    }
    
    public static class ObjTAndL{
        int t;
        String l;
        
        public ObjTAndL(int t, String l){
            this.t=t;
            this.l=l;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public String getL() {
            return l;
        }

        public void setL(String l) {
            this.l = l;
        }
        
    }
}
