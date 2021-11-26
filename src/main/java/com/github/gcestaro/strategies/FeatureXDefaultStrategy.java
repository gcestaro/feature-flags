package com.github.gcestaro.strategies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Scope("prototype")
public class FeatureXDefaultStrategy implements FeatureXStrategy {

    @Override
    public void process() {
        log.info("New strategy isn´t ready yet. Using default strategy!");
    }
}
