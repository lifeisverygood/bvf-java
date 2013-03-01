package com.rajeshpg.brv.messageprovider;

import com.rajeshpg.brv.core.ValidationBean;
/**
 * 
 * 
 *
 */
public interface MessageProvider {

	public void configure();	
	public void loadDescription(Message msg);
	public void loadDescription(ValidationBean bean);
	
}
