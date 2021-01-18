package com.atguigu.config;

import org.springframework.cglib.proxy.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;

//������==������
@Configuration //����Spring����һ��������
@ComponentScans(value = {
		@ComponentScan(value = "com.atguigu",includeFilters = {
				/*
				 * @Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
				 * 
				 * @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
				 */
				@Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
		},useDefaultFilters = false)
})
//@ConponentScan value:ָ��Ҫɨ���·��
//excludeFilters = Filter[],ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[],ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION,����ע��
//FilterType.ASSIGNABLE_TYPE,���ո���������
//FilterType.ASPECTJ,ʹ��ASPECTJ���ʽ
//FilterType.REGEX ʹ��������ʽ
//FilterType.CUSTOM,ʹ���Զ������
public class MainConfig {
	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01() {
		return new Person(20,"����");
	}
	
	
}
