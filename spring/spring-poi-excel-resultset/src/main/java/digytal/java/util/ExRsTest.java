package digytal.java.util;

import java.io.File;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;

public class ExRsTest {
	public static void main(String[] args) {
		try {
			ClassPathResource resourceFile = new ClassPathResource("transformadores.xlsx");
			File file =  resourceFile.getFile();
			
			
			ExcelResultSet exRs = new ExcelResultSet(file,0,0);
			
			Set<String> header = exRs.getHeader();
			
			System.out.println(header);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
