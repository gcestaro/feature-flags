package com.github.gcestaro.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FeaturesAspect {

    @Around("@within(featureAssociation) || @annotation(featureAssociation)")
    public Object checkAspect(ProceedingJoinPoint joinPoint,
                              FeatureAssociation featureAssociation) throws Throwable {

        String featureMessage = "Feature " + featureAssociation.value().name();

        if (featureAssociation.value().isActive()) {
            log.info(featureMessage + " is enabled!");
            return joinPoint.proceed();
        }

        log.info(featureMessage + " is not enabled!");

        return null;
    }
}