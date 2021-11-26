package com.github.gcestaro.enums;

import com.github.gcestaro.strategies.FeatureXDefaultStrategy;
import com.github.gcestaro.strategies.FeatureXNewStrategy;
import com.github.gcestaro.strategies.FeatureXStrategy;
import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyStrategyFeatures implements Feature {

    @EnabledByDefault
    @Label("Feature X")
    FEATURE_X(FeatureXNewStrategy.class, FeatureXDefaultStrategy.class);

    private final Class<? extends FeatureXStrategy> enabledStrategy;

    private final Class<? extends FeatureXStrategy> disabledStrategy;

    MyStrategyFeatures(Class<? extends FeatureXStrategy> enabledStrategy,
                       Class<? extends FeatureXStrategy> disabledStrategy) {
        this.enabledStrategy = enabledStrategy;
        this.disabledStrategy = disabledStrategy;
    }

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

    public Class<? extends FeatureXStrategy> getStrategy() {
        return isActive() ? enabledStrategy : disabledStrategy;
    }
}