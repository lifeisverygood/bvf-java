package com.rajeshpg.brv.messageprovider;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropsMessageProvider extends AbstractMessageProvider 
{

	/**
	 * list of resource bundles for English and other languages.
	 */
	private String[] messageBundleList;	
	
	private ResourceBundle rb = null;
	
	public PropsMessageProvider(Properties resourceProps){
		super(resourceProps);
	}

	/**
	 * 
	 */
	public void configure() 
	{
		messageBundleList = getProperties().getProperty("msgBundleList").split(",");
		String[] rb_locale = new String[2];
		ResourceBundle 	resourceBundle = null;
		for (String messageBundleName : messageBundleList) {
			if(messageBundleName.indexOf('_')>0){
				rb_locale = messageBundleName.split("_"); 
			}else{
				rb_locale[0] = messageBundleName;
				rb_locale[1] = "en";
			}
			resourceBundle = ResourceBundle.getBundle(rb_locale[0],new Locale(rb_locale[1]));
			getMsgProviderMap().put(rb_locale[1], resourceBundle);
		}		
	}
	
	public void loadDescription(Message msg) 
	{
		if(rb==null){
			rb = (ResourceBundle)getMsgProviderMap().get(getLanguage());
		}		
		msg.setDescription(rb.getString(msg.getMessageId()));
	}

	
	
}
