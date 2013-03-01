import client.domain.RectangularBox;

import com.rajeshpg.brv.core.ValidationBean;
import com.rajeshpg.brv.core.util.ValidatorFactory;
import com.rajeshpg.brv.messageprovider.Message;
import com.rajeshpg.brv.validator.Validator;

public class Client {

	public static void main(String[] args) {

		RectangularBox box = new RectangularBox();
		box.setLength(80);
		box.setBreadth(20);
		box.setHeight(300);

		ValidationBean validatingBox = new ValidationBean(box);
		validatingBox.setLanguage("de"); 
		
		Validator validator1 = ValidatorFactory.getValidator("brv1");
		validator1.setBusinessRuleSet("rule1");
		validator1.validate(validatingBox);

		Validator validator2 = ValidatorFactory.getValidator("brv2");
		validator2.setBusinessRuleSet("rule2");
		validator2.validate(validatingBox);
		
		for (Object obj : validatingBox.getMessageList()) {
			Message message = (Message) obj;
			System.out.println(message.getMessageType()+" "+message.getDescription());
		}		
	}

}
