package manager.common.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomerJsonDateDeserialize extends JsonDeserializer<Date>{
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		String date = jp.getText();
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
