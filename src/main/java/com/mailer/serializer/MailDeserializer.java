/**
 * 
 */
package com.mailer.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mailer.model.Mail;

/**
 * @author Vinoth.Gopu
 * Deserializer for Mail pojo
 */
public class MailDeserializer implements Deserializer<Mail> {

	private Logger LOGGER = LoggerFactory.getLogger(MailDeserializer.class);
			
	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#configure(java.util.Map, boolean)
	 */
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#deserialize(java.lang.String, byte[])
	 */
	@Override
	public Mail deserialize(String topic, byte[] data) {
		Mail mail = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			mail = mapper.readValue(data, Mail.class);
		} catch (Exception e) {
			LOGGER.error("Error in deserialisation of mail object");
			e.printStackTrace();
		}
		return mail;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.serialization.Deserializer#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
	}
}
