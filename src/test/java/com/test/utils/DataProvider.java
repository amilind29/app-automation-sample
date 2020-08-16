package com.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.google.gson.Gson;
import com.test.models.BaseModel;

public class DataProvider {

	public static String JSON_FILE="json";
	public static String TEXT_FILE="TEXT";

	
	public static <T extends BaseModel> T readJsonDataToModel(File file, String file_type, Class<T> type) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Gson gson = new Gson();
			return gson.fromJson(reader, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	public static String readTextContent(String file_path) {
		try {
			return new String(Files.readAllBytes(Paths.get(file_path)));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
