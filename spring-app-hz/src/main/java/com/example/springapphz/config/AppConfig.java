package com.example.springapphz.config;

import com.example.springapphz.service.HazelcastConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:config/appconfig.properties")
public class AppConfig {


    Logger logger= LoggerFactory.getLogger(AppConfig.class);

    @Value("${max.context.retry.count:3}")
    private int maxContextRetryCount;

    @Value("${max.context.wait.time:5000}")
    private long maxContextWaitTime;


    @PostConstruct
    public void init()
    {
        logger.info("-------- AppConfig----");
        logger.info("maxContextRetryCount :{}",maxContextRetryCount);
        logger.info("maxContextWaitTime : {}",maxContextWaitTime);

    }

    public int getMaxContextRetryCount() {
        return maxContextRetryCount;
    }

    public void setMaxContextRetryCount(int maxContextRetryCount) {
        this.maxContextRetryCount = maxContextRetryCount;
    }

    public long getMaxContextWaitTime() {
        return maxContextWaitTime;
    }

    public void setMaxContextWaitTime(long maxContextWaitTime) {
        this.maxContextWaitTime = maxContextWaitTime;
    }
}
