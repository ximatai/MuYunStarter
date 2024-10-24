package net.ximatai.muyun.starter;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusMain
public class MainApp implements QuarkusApplication {

    private final Logger logger = LoggerFactory.getLogger(MainApp.class);

    @Override
    public int run(String... args) {
        Quarkus.waitForExit();
        return 0;
    }
}
