package com.reversetech.account_service.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.reversetech")
public class CassandraConfiguration  {
   /*
    @Value("${spring.cassandra.contact-points}")
    private String contactPoint;
    
    @Value("${spring.cassandra.port}")
    private int port;
    
    @Value("${spring.cassandra.keyspace-name}")
    private String keyspaceName;
    
    @Value("${spring.cassandra.username}")
    private String username;
    
    @Value("${spring.cassandra.password}")
    private String password;
    
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }
    
    @Override
    protected int getPort() {
        return port;
    }
    
    @Override
    protected String getContactPoints() {
        return contactPoint;
    }
    
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .withLocalDatacenter("datacenter1")
                .withKeyspace(keyspaceName)
                .withAuthCredentials(username, password)
                .build();
    }
    
    */

    
}
