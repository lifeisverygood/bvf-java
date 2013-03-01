package client.businessRules;


import client.domain.RectangularBox;

import com.rajeshpg.brv.core.Rule;
import com.rajeshpg.brv.core.ValidationBean;
import com.rajeshpg.brv.messageprovider.Message;
import com.rajeshpg.brv.messageprovider.Message.MessageType;


public class RectBoxBreadthRule implements Rule {

	public void validate(ValidationBean bean) throws Exception 
	{
		RectangularBox oldBox = (RectangularBox) bean.getTargetBeanObject();
		
		if(oldBox.getBreadth() < 100)
		{
			Message message = new Message(MessageType.INFO,"5678");
			bean.addMessage(message);
		}
	}
}
