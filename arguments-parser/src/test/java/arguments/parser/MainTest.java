package arguments.parser;

import org.junit.Test;

public class MainTest {

    @Test
    public void numberOfParsedArgumentsIsCorrect() {
        String[] args = {"program_name", "-l -p 8080 -d /usr/logs"};

        Main.main(args);

        // TODO test correct println
    }

}
