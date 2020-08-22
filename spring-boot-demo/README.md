## 自学spring boot 案例

### 1,日志配置 
    在配置文件中 application.yaml 增加配置
        ##日志配置, 只能配置在主 配置文件中
        logging:
            config: classpath:logback.xml
    引用logback.xml配置 日志配置
    详情请查看 logback.xml 文件
    
### 2, lombok 的是使用
    需要引入jar 包
          <dependency>
             <groupId>org.projectlombok</groupId>
             <artifactId>lombok</artifactId>
             <optional>true</optional>
         </dependency>
         
    lombok 注解的使用 `案例:User.java   HollerController.java`
    
          @Data 标签，生成getter/setter toString()等方法 
          @NonNull : 让你不在担忧并且爱上NullPointerException 
          @CleanUp : 自动资源管理：不用再在finally中添加资源的close方法 
          @Setter/@Getter : 自动生成set和get方法 
          @ToString : 自动生成toString方法 
          @EqualsAndHashcode : 从对象的字段中生成hashCode和equals的实现 
          @NoArgsConstructor/@RequiredArgsConstructor/@AllArgsConstructor 
          自动生成构造方法 
          @Data : 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法 
          @Value : 用于注解final类 
          @Builder : 产生复杂的构建器api类 
          @SneakyThrows : 异常处理（谨慎使用） 
          @Synchronized : 同步方法安全的转化 
          @Getter(lazy=true) : 
          @Log : 支持各种logger对象，使用时用对应的注解，如：@Log4j
          
### 3, spring boot 异步 框架

#### 1,spring boot 的异步调用
    spring boot 中使用异步调用,@Async为异步注解，放到方法上，表示调用该方法的线程与此方法异步执行
     @Async 注解需要配合@EnableAsync注解使用
    
    1,开启异步任务   `案例:AsyncConfiguration.java`
        采用 @EnableAsync 注解是 需要确认 类是否注入到IOC容器中.
         没有加入到IOC 容器中的话 需要配合使用 @Configurable 注解 将类注入到IOC容器中
    
    2,在方法上标记 @Async 异步调用  `案例:DemoAsyncController.java`
        注意: @Async 注解是标记在方法上的
                      
    _自定义线程池_  
        1,AsyncConfiguration.java 中创建 自定义线程
        2,使用 @Async 需要指定线程 bean 名称
          
### 4, spring boot Swagger2 的使用 自动生成接口文档
文档访问地址:http:IP:post/swagger-ui.html
#### 1, pom.xml导入依赖jar包
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>
    
#### 2, 配置Swagger2 到IOC容器中 `案例:SwaggerConfig.java`
application.yaml 配置  spring.swagger.enabled=true 是用于区别于生产和测试环境是否开启api文档
    
    /**
     * @ClassName : SwaggerConfig.java
     * @Description : Swagger2 api 文档生成工具配置
     * @Author : lizhiwen
     * @Date: 2020-08-21 08:27
     */
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Value(value = "spring.swagger.enabled")
        private Boolean swaggerEnabled;
    
        /**
         * 创建 Docket
         * 用于配置swagger2，包含文档基本信息
         * 指定swagger2的作用域（这里指定包路径下的所有API）
         * @return
         */
        @Bean
        public Docket createResApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .enable(swaggerEnabled)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.demo.boot"))
                    .paths(PathSelectors.any())
                    .build();
        }
    
        public ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("接口文档")
                    .description("spring-boot-demo")
    //                //团队地址
    //                .termsOfServiceUrl("")
                    // 设置联系方式
                    .contact(new Contact("lizhiwen", "", "719272090@qq.com"))
                    .version("1.0")
                    .build();
        }
    }
#### 3, Swagger2 注解配置 解释
|               | Swagger2 常用注解             |  | |
| ------------ | ------------- | -----------    | -----------       |
| 注解          |  用途          | 注解位置        |  参数方法          |                                                                                                                         
| @Api         | 表示标识这个类是swagger的资源                |  用于类   | @Api(value = "用户相关接口",tags = {"用户操作接口"})  |
| @ApiOperation| 表示一个http请求的操作                      |  用于方法  | @ApiOperation(value="根据用户ID获取用户信息",notes="提示内容") |
| @ApiParam()  | 表示对参数的添加元数据（说明或是否必填等）,不方便使用建议使用@ApiImplicitParams      |  用于方法  | @ApiParam(name = "userId",value = "用户ID",required = true) Long id ,@ApiParam(name = "userName",value = "用户姓名" |
| @ApiImplicitParams() | 表示对参数的添加元数据（说明或是否必填等） |  用于方法    | @ApiImplicitParams({ 填写 @ApiImplicitParam 注解}) |
| @ApiImplicitParam()  | 表示对参数的添加元数据（说明或是否必填等） |  用于方法    | @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Long", required = true) |
| @ApiModel()  | 表示对类进行说明，用于参数用实体类接收         |  用于类    | @ApiModel(value = "ResultVO 对象",description = "请求返回结果") |
| @ApiModelProperty() | 表示对model属性的说明或者数据操作更改  |  用于方法   | @ApiModelProperty(value = "请求返回状态码",name = "code",example = "0000") |


