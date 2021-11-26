package com.github.gcestaro.strategies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Scope("prototype")
public class FeatureXNewStrategy implements FeatureXStrategy {

    @Override
    public void process() {
      log.info("Thanks to a nice refactoring, use my new strategy!");
    }
}
