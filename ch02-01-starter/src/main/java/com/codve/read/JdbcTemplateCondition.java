package com.codve.read;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件化配置, 创建了一个条件, 如果存在 JdbcTemplate, 就返回 true.
 * @see ConditionService
 *
 * @author admin
 * @date 2019/10/26 13:38
 */
public class JdbcTemplateCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
