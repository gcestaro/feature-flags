package com.github.gcestaro.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gcestaro.services.FeatureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("features")
public class FeatureResource {

    private final FeatureService service;

    @PostMapping
    public void process() {
        service.featureOne();
        service.featureTwo();
        service.featureXYZ();
        service.featureX();
    }
}
