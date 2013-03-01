package com.rajeshpg.brv.core;

import java.util.ArrayList;
import java.util.List;

import com.rajeshpg.brv.messageprovider.Message;

public class ValidationBean {
	private List messageList = new ArrayList();
	private String langId= "en";
	private Validatable targetBeanObject;
	private boolean isValidated = true;
	
	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public  ValidationBean(Validatable targetBeanObject) 
	{
		this.targetBeanObject = targetBeanObject;
	}

	public Validatable getTargetBeanObject() {
		return targetBeanObject;
	}

	public List getMessageList() {
		return messageList;
	}
	
	public void addMessage(Message msg)
	{	
		messageList.add(msg);
	}
	
	public void setLanguage(String langId){
		this.langId = langId;
	}

	public String getLanguage(){
		return langId;
	}

}
