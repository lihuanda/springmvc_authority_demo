package com.lihuanda.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import com.lihuanda.beans.AuthorityType;
import com.lihuanda.beans.ResultTypeEnum;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FireAuthority {
	
    AuthorityType[] authorityTypes();
    ResultTypeEnum resultType() default ResultTypeEnum.page;
    
}
