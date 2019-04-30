package com.fattest.servicefat.filters;

import org.apache.dubbo.config.spring.ServiceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class FATPostProcessor implements BeanPostProcessor {
	@Value("${featuretest:#{null}}")
	private String featuretest;

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (featuretest != null) {
			if (bean instanceof ServiceBean) {
				ServiceBean thebean = (ServiceBean) bean;
				thebean.setTag(featuretest);
			}
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		return arg0;
	}
}
