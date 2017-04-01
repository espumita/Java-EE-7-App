package beans;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@Startup
@Singleton(name = "LogEJB")
public class LogBean implements LogBeanInterface{

    private PrintWriter writer;

    @PostConstruct
    public void init() {
        try {
            writer = new PrintWriter("Log.txt", "UTF-8");
        } catch (Exception e) { }
    }

    @Lock(LockType.WRITE)
    public void log(String name){
        writer.println(name);
        writer.close();
    }
}
