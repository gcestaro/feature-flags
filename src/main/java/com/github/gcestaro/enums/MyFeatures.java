package com.github.gcestaro.enums;

import org.togglz.core.Feature;
import org.togglz.core.activation.SystemPropertyActivationStrategy;
import org.togglz.core.annotation.ActivationParameter;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyFeatures implements Feature {

	@EnabledByDefault
	@Label("First Feature")
	FEATURE_ONE,

	@Label("Second Feature")
	FEATURE_TWO,

	@Label("Feature XYZ")
	@EnabledByDefault
	@DefaultActivationStrategy(
			id = SystemPropertyActivationStrategy.ID,
			parameters = {
					@ActivationParameter(
							name = SystemPropertyActivationStrategy.PARAM_PROPERTY_NAME,
							value = "xyz.feature"),
					@ActivationParameter(
							name = SystemPropertyActivationStrategy.PARAM_PROPERTY_VALUE,
							value = "true") })
	FEATURE_XYZ;

	public boolean isActive() {
		return FeatureContext.getFeatureManager().isActive(this);
	}
}