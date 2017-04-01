package utils;

import java.io.PrintWriter;
import java.util.Date;

public class Log {

    private static PrintWriter writer;

    public Log(PrintWriter writer) {
        this.writer = writer;
    }

    public void log(String userName) {
        try{
            writer.println("Bad user login: " + userName + " at " + new Date());
            writer.close();
        } catch (Exception e) { }
    }
}
