package digytal.java.exemplos.springrestapi.model;

import org.springframework.web.multipart.MultipartFile;

public class FileBody {
	private MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}