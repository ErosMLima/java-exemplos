package digytal.java.exemplos.springrestapi.resource.requesttype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import digytal.java.exemplos.springrestapi.model.Endereco;
import digytal.java.exemplos.springrestapi.repository.FakeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/request-type")
public class RequestType {
	@Autowired
	private FakeRepository repository;
	
	@ApiOperation(value = "Retorna uma lista de endereços")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Operação realizada com sucesso",response = Endereco.class)
	})
	@GetMapping
	public List<Endereco> get(){
		return repository.findAll();
	}
	
	@ApiOperation(value = "Adiciona um endereço")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Operação realizada com sucesso")
	})
	@PostMapping
	public void post(@RequestBody(required = true) Endereco endereco){
		repository.save(endereco);
	}
	
	@ApiOperation(value = "Altera um endereço")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Operação realizada com sucesso")
	})
	@PutMapping
	public void put(@RequestBody(required = true) Endereco endereco){
		repository.update(endereco);
	}
	@ApiOperation(value = "Remove um endereço passando o cep na URL ex.: /enderecos/65300123")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Operação realizada com sucesso")
	})
	@DeleteMapping(path = "/{cep}")
	public void delete(@ApiParam(value = "Número do Cep", required = true) @PathVariable("cep") String cep){
		repository.remove(cep);
	}
	@ApiOperation(value = "Remove um endereço passando cep o como parametro ex.: /enderecos?cep=65300123")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Operação realizada com sucesso")
	})
	@DeleteMapping()
	public void deleteParam(@ApiParam(value = "Número do Cep", required = true) @RequestParam("cep") String cep){
		repository.remove(cep);
	}
}
