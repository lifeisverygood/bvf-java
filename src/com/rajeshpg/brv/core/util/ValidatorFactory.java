package com.rajeshpg.brv.core.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rajeshpg.brv.core.BusinessRuleSet;
import com.rajeshpg.brv.validator.Validator;

public class ValidatorFactory {
	private static Validator deafultValidator = null;
	private static ClassPathXmlApplicationContext context;
	private static String defaultValidatorName = "businessRuleValidator";
	private static String applicationContextXML = "classpath:**/businessValidatorContext.xml";
	Map businessRuleSetCollection = new HashMap();

	private ValidatorFactory() {
	}

	static{
		context = new ClassPathXmlApplicationContext(applicationContextXML);
	}
	
	public static Validator getValidator(String validatorName) {
		try {
			deafultValidator = (Validator) context.getBean(validatorName);
		} catch (NoSuchBeanDefinitionException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deafultValidator;
	}

	public static Validator getValidator() {

		try {
			deafultValidator = (Validator) context.getBean(defaultValidatorName);
		} catch (NoSuchBeanDefinitionException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deafultValidator;
	}
	
	public static BusinessRuleSet getBusinessRuleSet(String businessRuleSetName){
		
		//if(businessRuleSetCollectio.con)
		//{}
		BusinessRuleSet businessRuleSet = null;
		try {
			businessRuleSet = (BusinessRuleSet) context.getBean(businessRuleSetName);
		} catch (NoSuchBeanDefinitionException ex) {
			
		} catch (Exception e) {
			
		} 
		return businessRuleSet;
	}

}
