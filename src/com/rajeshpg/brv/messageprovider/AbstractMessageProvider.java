package com.rajeshpg.brv.messageprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.rajeshpg.brv.core.ValidationBean;

/**
 * Abstract implementation of {@link MessageProvider} interface.
 * 
 *
 */

public abstract class AbstractMessageProvider implements MessageProvider{
	
	/**
	 * Holds the configuration properties for AbstractMessageProvider 
	 * properties like list of resource bundles for {@link PropsMessageProvider} or 
	 * database details for {@link DBMessageProvider}. 
	 */
	private Properties properties;
	
	/**
	 * 
	 * Holds language as key and message as value.
	 * 
	 */
	private Map msgProviderMap = new HashMap();
	
	/**
	 * Language for the messages.
	 * Default is English 
	 */
	private String language = "en"; 

	public AbstractMessageProvider(Properties properties)
	{
		this.properties = properties;
	}

	/**
	 * load message description for message id 
	 */
	public void loadDescription(ValidationBean bean) {
		setLanguage(bean.getLanguage());
		for (Object obj : bean.getMessageList()) {
			Message msg = (Message) obj;
			loadDescription(msg);
		}
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}



	protected Properties getProperties() {
		return properties;
	}

	protected Map getMsgProviderMap() {
		return msgProviderMap;
	}
}
