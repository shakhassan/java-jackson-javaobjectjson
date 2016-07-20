package my.example.jacksonjavaobjectjson;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjecttoJSON {
	
	public static void main(String[] args) {
		JavaObjecttoJSON obj = new JavaObjecttoJSON();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		Staff staff = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("/Users/rjirwanshah/WinApp/SampleSpringProject/jacksonjavaobjectjson/staff.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Staff createDummyObject() {

		Staff staff = new Staff();

		staff.setName("John Doe");
		staff.setAge(33);
		staff.setPosition("Developer");
		staff.setSalary(new BigDecimal("7500"));

		List<String> skills = new ArrayList<>();
		skills.add("Erlang");
		skills.add("Java");

		staff.setSkills(skills);

		return staff;

	}

}
