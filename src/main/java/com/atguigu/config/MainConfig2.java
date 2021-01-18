package com.atguigu.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
//类中组件统一设置。满足当前条件，这个配置类中的所有bean注册才能生效
//@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class})
public abstract class MainConfig2 {

	//默认单实例
	/**
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
	 * @return
	 * 
	 * prototype:多实例：ioc容器每次启动并不会去调用方法创建对象放在容器中。
	 * 					每次获取的时候才会调用方法创建对象；
	 * singleton:单实例（默认值） ioc容器启动会调用方法创建对象放到ioc容器中。
	 * 					以后每次获取就是直接从(map.get())中拿，
	 * request:同一请求创建一个实例
	 * session:同一个session创建一个实例
	 * 
	 * 懒加载：
	 * 		单实例bean:默认在容器启动的时候创建对象；
	 * 		懒加载：容器启动不创建对象。对一次使用(获取)Bean创建对象， 并初始化
	 */
//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("给容器中添加Person...");
		return new Person(19, "zhangsan");
	}
	
	/**
	 * @Conditional({Condition}):按照一定的条件进行判断，满足条件给容器中注册bean
	 * 
	 * 如果系统是windows,给容器中注册（“bill"）
	 * 如果系统是linux,给容器中注册（”linus“）
	 */

	@Bean("bill")
	public Person person01() {
		return new Person(30,"Gates");
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02() {
		return new Person(48,"linus");
	}
	
	/**
	 * 给容器注册组件：
	 * 1）、包扫描+组件标注注解（@Controller,@Service,@Repository,@Component）
	 * 2)、@Bean[导入第三方包里面的注解]
	 * 3）、@Import[快速的给容器中导入一个组件]
	 * 		1)、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
	 */
	
	
}
