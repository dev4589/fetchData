package training.problems;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
	public static final String PATH = "src/main/java/training/problems/";

	public static void main(String args[]) {

		ObjectMapper navi = new ObjectMapper();
		File file = new File(PATH + "ex.txt");
		try {
			List<Object> list = (List<Object>) navi.readValue(file, new TypeReference<ArrayList<Object>>() {
			});

			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) list.get(2);
			System.out.println(map.get("age"));

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
