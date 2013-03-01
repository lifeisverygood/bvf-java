package com.rajeshpg.brv.validator;

import com.rajeshpg.brv.core.ValidationBean;

public interface Validator  {
	public void validate(ValidationBean bean);
	public void setBusinessRuleSet(String businessRuleSetName);
}
