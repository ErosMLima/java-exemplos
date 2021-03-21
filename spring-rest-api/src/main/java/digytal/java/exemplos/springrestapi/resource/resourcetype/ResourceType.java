package digytal.java.exemplos.springrestapi.resource.resourcetype;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import digytal.java.exemplos.springrestapi.model.FileBody;

@RestController
@RequestMapping("/resource-type")
public class ResourceType {
	
	@GetMapping(value = "/resource-path/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getClassPathResource(@PathVariable ("id") String id) throws IOException {

        ClassPathResource resourceFile = new ClassPathResource(String.format("img/%s.jpeg", id));
        byte[] bytes = bytes( resourceFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
    
    @GetMapping(value = "/temp-dir/{img}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getTempDirResource(@PathVariable ("img") String img) throws IOException {

    	Path path = Paths.get("/temp/" + img);
        byte[] bytes = bytes( Files.newInputStream(path));

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
    private byte[] bytes (InputStream is) throws IOException {
    	 byte[] bytes = StreamUtils.copyToByteArray(is);
    	 return bytes;
    }
    
    //COM POSTMAN FUNCIONA
   
    @PostMapping("/multi-upload")
    public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files) {
    	List<Object> fileDownloadUrls = new ArrayList<>();
    	Arrays.asList(files)
    			.stream()
    			.forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file).getBody()));
    	return ResponseEntity.ok(fileDownloadUrls);
    }
   
    //SWAGGER
    
    /*
    @RequestMapping(path = "/multi-upload", method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public ResponseEntity multiUpload(@RequestBody FileBody files) {
    	List<Object> fileDownloadUrls = new ArrayList<>();
    	Arrays.asList(files.getFile())
    			.stream()
    			.forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file).getBody()));
    	return ResponseEntity.ok(fileDownloadUrls);
    }
    
     */
    @PostMapping("/upload")
    public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	Path path = Paths.get("/temp/" + fileName);
    	try {
    		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
    			//.path("/files/download/")
    			.path("/resource-type/temp-dir/")
    			.path(fileName)
    			.toUriString();
    	return ResponseEntity.ok(fileDownloadUri);
    }
    
    /*
    @GetMapping
    public MultipartFile[] getImage() throws IOException {
    	String [] ids = {"1","2","3"};
    	Object [] imgs = new Object[ids.length];
    	
    	for(int x=0;x<ids.length;x++) {
    		ClassPathResource imgFile = new ClassPathResource(String.format("img/%s.jpeg", ids[x]));
            imgs[x]=StreamUtils.copyToByteArray(imgFile.getInputStream());
    	}
        
        return ResponseEntity
                .ok()
                .body(imgs);
    }
	*/
}
