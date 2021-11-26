package com.github.gcestaro.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.repository.StateRepository;
import org.togglz.mongodb.MongoStateRepository;

import com.mongodb.MongoClient;

@Configuration
public class TogglzConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabaseName;

    @Value("${spring.togglz.collection-name}")
    private String togglzCollectionName;

    private final MongoClient mongoClient;

    public TogglzConfiguration(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    /**
     * @see application.properties
     * togglz.feature-enums=com.github.gcestaro.enums.MyFeatures, com.github.gcestaro.enums.MyStrategyFeatures
     */
//    @Bean
//    public FeatureProvider featureProvider() {
//        return new EnumBasedFeatureProvider(MyFeatures.class);
//    }
    @Bean
    public StateRepository stateRepository() {
        return MongoStateRepository
                .newBuilder(mongoClient, mongoDatabaseName)
                .collection(togglzCollectionName)
                .build();
    }
}
