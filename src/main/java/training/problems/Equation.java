package training.problems;

import java.io.*;
import java.util.*;

public class Equation {

	public static final String PATH = "src/main/java/training/problems/problem_input/10/";

	public static void main(String args[]) throws IOException {

		FileReader fileEquation = new FileReader(PATH + "Equations");
		BufferedReader buffRead = new BufferedReader(fileEquation);

		String str = "";
		
		while((str=buffRead.readLine())!=null){
			String[] equation = str.split("[+=]");
	
			Set<String> index = new HashSet<>();
			for (int i = 0; i < equation.length; i++) {
				equation[i] = equation[i].trim();
				if (equation[i].contains("*"))
					index.add(equation[i]);
			}
	
			Map<String, List<String>> equations = new HashMap<>();
			List<String> indexList = new ArrayList<>();
			Iterator<String> it = index.iterator();
			while (it.hasNext()) {
				indexList.add(it.next().toString());
			}
	
			for (String s : indexList) {
				equations.put(s, fetchList(s, str));
			}
	
			for (int i = 0; i < equations.size(); i++) {
				if (i == 0) {
					List<String> finalEq = replaceMethod(equations.get(indexList.get(i)), indexList.get(i), str);
					equations.replace(indexList.get(i), finalEq);
				} else {
					List<List<String>> oldValue = new ArrayList<>();
					oldValue.addAll(equations.values());
					List<String> finalEq = new ArrayList<>();
					for (int j = 0; j < oldValue.get(i - 1).size(); j++) {
						finalEq.addAll(replaceMethod(equations.get(indexList.get(i)),
								indexList.get(i),oldValue.get(i - 1).get(j)));
					}
					equations.replace(indexList.get(i), finalEq);
				}
			}
	
			List<String> output = new ArrayList<>();
			output = equations.get(indexList.get(indexList.size() - 1));
	
			for (String s : output)
				System.out.println(s);
		}
		buffRead.close();
	}

	static List<String> replaceMethod(List<String> equations, String regx, String str) {
		List<String> newCodedList = new ArrayList<>();
		for (int i = 0; i < equations.size(); i++) {
			String s = str.replace(regx, equations.get(i));
			newCodedList.add(s);
		}
		return newCodedList;
	}

	static List<String> fetchList(String reg, String equation) throws IOException {

		FileReader fileCodes = new FileReader(PATH + "LatestIcd10Codes");
		BufferedReader buffRead = new BufferedReader(fileCodes);

		String str = "";

		List<String> code = new ArrayList<>();
		while ((str = buffRead.readLine()) != null) {
			if (str.matches(reg)) {
				code.add(str);
			}
		}
		buffRead.close();
		return code;

	}

}
