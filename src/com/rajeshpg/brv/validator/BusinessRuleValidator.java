package com.rajeshpg.brv.validator;

import java.util.Iterator;
import java.util.Set;

import com.rajeshpg.brv.core.BusinessRuleSet;
import com.rajeshpg.brv.core.Rule;
import com.rajeshpg.brv.core.ValidationBean;
import com.rajeshpg.brv.core.util.ValidatorFactory;
import com.rajeshpg.brv.messageprovider.MessageProvider;
import com.rajeshpg.brv.validator.Validator;

public class BusinessRuleValidator implements Validator 
{	
	private BusinessRuleSet businessRuleSet; 
	private MessageProvider messageProvider;
	
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	
	public void setBusinessRuleSet(BusinessRuleSet businessRuleSet) {
		this.businessRuleSet = businessRuleSet;
	}
	
	public void setBusinessRuleSet(String businessRuleSetName) {
		this.businessRuleSet = ValidatorFactory.getBusinessRuleSet(businessRuleSetName);
	}
	
	private void processMessages(ValidationBean bean){
		messageProvider.loadDescription(bean);
	}
	
	public void validate(ValidationBean bean) {
		
		Set sRules = businessRuleSet.getRules();
		
		for (Iterator iterator = sRules.iterator(); iterator.hasNext();) 
		{			
			try 
			{
				Rule rule = (Rule) iterator.next();
				rule.validate(bean);
			}			
			catch (Exception e) 
			{
				bean.setValidated(false);
			}
		} 

		processMessages(bean);
	}
}
