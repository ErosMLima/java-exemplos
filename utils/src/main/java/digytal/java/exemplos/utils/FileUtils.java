package digytal.java.exemplos.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	public static File file(String parent, String fileName) {
		return new File(parent,fileName);
	}
	public static File file(String filePath) {
		return new File(filePath);
	}
	public static InputStream inputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(filePath);	
	}
	public static InputStream inputStream(File file) throws FileNotFoundException {
		return new FileInputStream(file);	
	}
	
	public static Path path(String parent, String fileName) {
		return Paths.get(parent, fileName);
	}
	public static Path path(String filePath) {
		return Paths.get(filePath);
	}
}
