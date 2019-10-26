package com.codve.read;

import org.springframework.context.annotation.Conditional;

/**
 * 只有 JdbcTemplate 类存在时, 才会创建 ConditionService 这个 bean.
 * @author admin
 * @date 2019/10/26 13:40
 */
@Conditional(JdbcTemplateCondition.class)
public class ConditionService {
}
