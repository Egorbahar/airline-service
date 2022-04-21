package com.godeltech.component;

import com.godeltech.exception.ProfileNotFoundException;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProfileCheckApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext.getEnvironment().getActiveProfiles().length == 0)
            throw new ProfileNotFoundException("Profile is required");
    }
}
