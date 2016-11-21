package com.izanaar.chwin.translate.providers.local;

import com.izanaar.chwin.translate.providers.ApiProvider;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NoApiProviderCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().getBeanNamesForType(ApiProvider.class).length == 0;
    }
}
