package beans;

import utils.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;


@Singleton(name = "LogEJB")
public class LogBean implements LogBeanInterface{

    @PostConstruct
    public void init() {

    }

    @Lock(LockType.WRITE)
    public void log(String name) throws Exception {
        new Log(new PrintWriter(new FileOutputStream(
                new File("/home/david/bad-login-log.txt"), true ))).logException(name);
    }

    //@Schedule(second = "59", minute = "59", hour = "23")
    @Lock
    public void logReport(String number) throws  Exception {
        new Log(new PrintWriter(new FileOutputStream(
                new File("/home/david/report-log.txt"), true ))).logException(number);
    }
}
