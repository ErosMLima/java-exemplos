package digytal.java;

import java.io.File;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import digytal.java.model.Sexo;
import digytal.java.util.ExcelResultSet;

@SpringBootApplication
public class SpringExcelResultSetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExcelResultSetApplication.class, args);
	}
	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			
			ClassPathResource resourceFile = new ClassPathResource("transformadores.xlsx");
			File file =  resourceFile.getFile();
			
			ExcelResultSet exRs = new ExcelResultSet(file);
			
			while(exRs.next()) {
				String cpf = exRs.getString("Cpf");
				String nome = exRs.getString("Nome");
				LocalDate dtNascimento = exRs.getLocalDate("Data Nascimento");
				Sexo sexo = Sexo.valueOf(exRs.getString("Sexo").toUpperCase());
				Double valorHora = exRs.getDouble("Valor Hora");
				Boolean brasileiro = exRs.getBoolean("Brasileiro?", "S");
				
				System.out.println(String.format("O professor %s de Cpf %s, nascido em %s, no País %s do Sexo %s, com valor hora R$ %.2f ",
						nome,
						cpf,
						dtNascimento.toString(),
						brasileiro?"BRASIL":"EXTERIOR",
						sexo.getDescricao(),
						valorHora
						));	
			}	
		};
	}

}
