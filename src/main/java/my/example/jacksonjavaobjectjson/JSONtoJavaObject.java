package my.example.jacksonjavaobjectjson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONtoJavaObject {
	
	public static void main(String[] args) {
		JSONtoJavaObject obj = new JSONtoJavaObject();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			Staff staff = mapper.readValue(new File("/Users/rjirwanshah/WinApp/SampleSpringProject/jacksonjavaobjectjson/staff.json"), Staff.class);
			System.out.println(staff);

			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"John Doe\",\"salary\":7500,\"skills\":[\"Erlang\",\"Java\"]}";
			Staff staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff1);

			//Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
