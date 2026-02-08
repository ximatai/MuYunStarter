package net.ximatai.muyun.starter;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import net.ximatai.muyun.core.config.MuYunConfig;
import net.ximatai.muyun.database.core.IDatabaseOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@QuarkusMain
public class MainApp implements QuarkusApplication {

    private final Logger logger = LoggerFactory.getLogger(MainApp.class);

    @Inject
    MuYunConfig config;

    @Inject
    IDatabaseOperations db;

    @Override
    public int run(String... args) {
        logger.info("PROFILE ON {}", config.profile());
        db.row("select 1");
        Quarkus.waitForExit();
        return 0;
    }
}
