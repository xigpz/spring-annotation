package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	//返回值，就是要导入到容器中的组件全类名
	//AnnotationMetadata：当前标注@import注解的类的所有注解信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		//importingClassMetadata.get
		
		//不要返回null
		return new String[] {"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};
	}

}
