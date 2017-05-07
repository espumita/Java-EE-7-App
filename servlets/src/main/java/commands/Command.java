package commands;

import javax.servlet.ServletException;
import java.io.IOException;

public interface Command {
    void run() throws IOException, ServletException;
}
