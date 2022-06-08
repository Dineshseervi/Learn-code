package com.example.springapphz.service;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.internal.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HazelcastConfiguration {



    Logger logger= LoggerFactory.getLogger(HazelcastConfiguration.class);
    private static final String HC_NOT_INITIALIZED = "hazelcast not initialized";
    private HazelcastInstance hazelcastInstance;
    private boolean isHazelcastInitialized;
    public static final String SERVICE_NAME = "service-name";

    @PostConstruct
    public void init()
    {
        logger.info("--------Starting Hazelcast----");
        String serviceName=System.getenv("SERVICE_NAME");
        if(serviceName!=null && !serviceName.isEmpty()) {
            initHazelcastInstance("TEST_HZ_INSTANCE_NAME","TEST_HZ_SERVICE",true);
        }else {
            initHazelcastInstance("TEST_HZ_INSTANCE_NAME","TEST_HZ_SERVICE",false);
        }

    }



    private void initHazelcastInstance(String instanceName, String groupName, boolean isServiceDiscoveryEnabled) {
        logger.info("Hazelcast instance name : {} and group name {}", instanceName, groupName);
        Config config = new Config();
        config.setInstanceName(instanceName);
        //config.getGroupConfig().setName(groupName);
        config.setClusterName(groupName);
        NetworkConfig network = config.getNetworkConfig();
        JoinConfig join = network.getJoin();

        //config.setClassLoader(this.getClass().getClassLoader());
        // hc.service.discovery.enabled = false in local
        logger.info("service discovery for hazelcast: " + isServiceDiscoveryEnabled);
        if (!isServiceDiscoveryEnabled) {// this is for local as it can't do service discovery
            join.getMulticastConfig().setEnabled(true);
        } else {
            join.getMulticastConfig().setEnabled(false);
            join.getKubernetesConfig().setEnabled(true);
            //String componentInstanceId = System.getenv(DMP_COMPONENT_INSTANCE_ID);
            String serviceName=System.getenv("SERVICE_NAME");
            if(serviceName!=null) {
                join.getKubernetesConfig().setProperty(SERVICE_NAME, serviceName);
            }
        }
        hazelcastInstance = Hazelcast.getOrCreateHazelcastInstance(config);
        isHazelcastInitialized = true;
    }


    public Integer getSize()
    {
        return hazelcastInstance.getMap("TEST_CACHE").size();
    }

    public Integer addEntry()
    {
        logger.info("Added entry to cache");
        Long time=System.currentTimeMillis();
        hazelcastInstance.getMap("TEST_CACHE").put(time,time);
        Integer size=  hazelcastInstance.getMap("TEST_CACHE").size();
        logger.info("cacheSize :{}",size);
        return size;
    }

    @PreDestroy
    public void destroy() {
        Preconditions.checkTrue(isHazelcastInitialized, HC_NOT_INITIALIZED);
        hazelcastInstance.shutdown();
    }


}
