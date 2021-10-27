/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.example.${feature}.${framework?replace('-', '.')};

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

<#assign frameworkName="">
<#list framework?split("-") as framework1>
    <#assign frameworkName=frameworkName + framework1?cap_first>
</#list>
@MapperScan("org.apache.shardingsphere.example.${feature}.springboot.starter.mybatis.repository")
@SpringBootApplication
public class ${mode?cap_first}${transaction?cap_first}${feature?cap_first}${frameworkName}Example {
    
    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(${mode?cap_first}${transaction?cap_first}${feature?cap_first}${frameworkName}Example.class, args)) {
            ${mode?cap_first}${transaction?cap_first}${feature?cap_first}${frameworkName}ExampleService exampleService = applicationContext.getBean(${mode?cap_first}${transaction?cap_first}${feature?cap_first}${frameworkName}ExampleService.class);
            exampleService.run();
        }
    }
}