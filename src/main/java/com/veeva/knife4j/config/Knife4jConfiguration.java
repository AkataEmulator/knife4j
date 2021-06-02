package com.veeva.knife4j.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.annotation.Resource;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {
    /**
     * 引入Knife4j提供的扩展类
     */
    @Resource
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "veeva-v1")
    public Docket defaultApi2() {
        String groupName = "211.3.100";
        Contact contact = new Contact("sunshuo@veeva.com", "", "");
        ApiInfo apiInfo = new ApiInfoBuilder().title("swagger-bootstrap-ui-demo RESTful APIs")
                                              .description("# swagger-bootstrap-ui-demo RESTful APIs")
                                              .termsOfServiceUrl(
                                                      "https://doc.xiaominfo.com/knife4j/documentation/get_start.html")
                                              .contact(contact)
                                              .version("1.0")
                                              .build();

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                                                      //分组名称
                                                      .groupName(groupName)
                                                      .select()
                                                      //这里指定Controller扫描包路径
                                                      .apis(RequestHandlerSelectors.basePackage(
                                                              "com.veeva.knife4j.controller"))
                                                      .paths(PathSelectors.any())
                                                      .build()
                                                      //赋予插件体系
                                                      .extensions(openApiExtensionResolver.buildExtensions(groupName));
    }
}
