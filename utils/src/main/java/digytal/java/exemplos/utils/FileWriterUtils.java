package digytal.java.exemplos.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterUtils {
	public static void write(byte [] bytes,String newFile) throws IOException {
		Path path = Paths.get(newFile);
        Files.write(path, bytes);
	}
	public static void write(File file,String newFile) throws IOException  {
		write(FileReaderUtils.bytes(file), newFile);
	}
	public static void write(String sourceFile,String newFile) throws IOException  {
		write(Files.readAllBytes(Paths.get(sourceFile)), newFile);
	}
}
