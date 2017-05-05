package utils;

import java.io.PrintWriter;
import java.util.Date;

public class Log {

    private static PrintWriter writer;

    public Log(PrintWriter writer) {
        this.writer = writer;
    }

    public void logException(String userName) throws Exception{
        try{
            writer.append("Bad user login: " + userName + " at " + new Date() + "\n");
            writer.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void logReport(String number) {
        try{
            writer.append("Number of samples uploaded this week: " + number + "\n");
            writer.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
