package utils;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class PostgresConnectionProviderShould {

    @Test
    public void tell_us_that_the_db_is_connected() throws Exception {
        PostgresConnectionProvider connectionProvider = new PostgresConnectionProvider();

        boolean isConnected = connectionProvider.connect();

        assertThat(isConnected, is(true));
    }
}
