package com.codeqm.pojo;

import lombok.Data;

/**
 * @since: 2025/6/9 15:53
 * @author: qm
 * @description: 数据库配置：
 * -- 创建表
 * CREATE TABLE schedule (
 * id SERIAL PRIMARY KEY,
 * title VARCHAR(255) NOT NULL,
 * completed BOOLEAN NOT NULL
 * );
 * <p>
 * -- 插入数据
 * INSERT INTO schedule (title, completed)
 * VALUES
 * ('学习java', true),
 * ('学习Python', false),
 * ('学习C++', true),
 * ('学习JavaScript', false),
 * ('学习HTML5', true),
 * ('学习CSS3', false),
 * ('学习Vue.js', true),
 * ('学习React', false),
 * ('学习Angular', true),
 * ('学习Node.js', false),
 * ('学习Express', true),
 * ('学习Koa', false),
 * ('学习MongoDB', true),
 * ('学习MySQL', false),
 * ('学习Redis', true),
 * ('学习Git', false),
 * ('学习Docker', true),
 * ('学习Kubernetes', false),
 * ('学习AWS', true),
 * ('学习Azure', false);
 */
@Data
public class Schedule {
    private Integer id;
    private String title;
    private Boolean completed;
}
