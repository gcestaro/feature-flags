package com.github.gcestaro.services;

import com.github.gcestaro.aspects.FeatureAssociation;
import com.github.gcestaro.enums.MyFeatures;
import com.github.gcestaro.enums.MyStrategyFeatures;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeatureService {

    private final ApplicationContext applicationContext;

    @FeatureAssociation(value = MyFeatures.FEATURE_TWO)
    public void featureTwo() {
        log.info("Hi! I´m feature 2");
    }

    @FeatureAssociation(value = MyFeatures.FEATURE_ONE)
    public void featureOne() {
        log.info("Hi! I´m feature 1");
    }

    @FeatureAssociation(value = MyFeatures.FEATURE_XYZ)
    public void featureXYZ() {
        log.info("Hi! I´m feature XYZ");
    }

    public void featureX() {
        applicationContext.getBean(MyStrategyFeatures.FEATURE_X.getStrategy()).process();
    }
}
