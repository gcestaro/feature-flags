package com.github.gcestaro.configurations;

import com.github.gcestaro.enums.MyFeatures;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.mongodb.MongoStateRepository;

@SuppressWarnings("ALL")
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
