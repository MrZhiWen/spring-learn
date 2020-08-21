##自学spring boot 案例
###1,日志配置 
    在配置文件中 application.yaml 增加配置
        ## 日志配置, 只能配置在主 配置文件中
        logging:
            config: classpath:logback.xml
    引用logback.xml配置 日志配置
    详情请查看 logback.xml 文件
    
###2, lombok 的是使用
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
          
###3, spring boot 异步 框架
####1,spring boot 的异步调用
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
          
###4, spring boot 异步 框架          
          