package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import digytal.java.exemplos.utils.FileReaderUtils;

public class FileReaderUtilsTest {
	public static void main(String[] args) {
		readerFileToString();
	}
	
	private static void readerFileToString() {
		String filePath = "C:\\dev\\file.txt";
		try {
			Stream<String> stream = FileReaderUtils.stream(filePath) ;
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
