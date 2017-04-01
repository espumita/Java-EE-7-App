package utils;

import java.io.PrintWriter;
import java.util.Date;

public class Log {

    private static PrintWriter writer;

    public Log(PrintWriter writer) {
        this.writer = writer;
    }

    public void log(String userName) throws Exception{
        try{
            writer.append("Bad user login: " + userName + " at " + new Date() + "\n");
            writer.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
