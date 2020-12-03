package cn.acorg.framework.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * MybatisPlus 配置类，组件注入到 Spring
 * @author C-XS
 * @version V1.0
 * @date 2020/3/9
 **/
@Component
public class MybatisPlusConfig {

    /**
     * Mybatis plus 拓展设置
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     * @author 松果
     * @return com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
     * @date 2020/10/20
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 开启乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 分页配置
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }


    /**
     * ID 主键生成策略自定义，需优化，暂不启用
     * @author 松果
     * @date 2020/10/21
     * @return 自定义主键策略类
     */
    /*@Bean
    public IdentifierGenerator idGenerator() {
        return new CustomIdGenerator();
    }*/


}
