package net.ximatai.muyun.demo.schedule;

import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.ximatai.muyun.database.IDatabaseOperationsStd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Startup
@ApplicationScoped
public class DemoJob {

    private final Logger logger = LoggerFactory.getLogger(DemoJob.class);

    @Inject
    IDatabaseOperationsStd db;

    @PostConstruct
    void init() {
        Map<String, Object> row = db.row("select 1");
        logger.info(row.toString());
    }

    @Scheduled(every = "10s")
    public void executeTask() {
        logger.info("定时任务执行中...");
    }

    // 使用 cron 表达式，每天晚上11点执行任务
    @Scheduled(cron = "0 0 23 * * ?")
    public void dailyTask() {
        logger.info("每天晚上11点执行任务");
    }

}
