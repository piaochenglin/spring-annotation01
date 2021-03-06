package com.piao.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String os = conditionContext.getEnvironment().getProperty("os.name");
        if (os.contains("linux")) {
            return true;
        }
        return false;
    }
}
