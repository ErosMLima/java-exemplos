package digytal.java.exemplos.spring.jwt.model;

import java.util.Collection;

public class ResponseBot {
	private String status="success";
	private Object body;
	private Integer itens=0;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
		this.itens=1;
		if(body instanceof Collection) {
			this.itens = ((Collection)body).size();
		}
	}
	public Integer getItens() {
		return itens;
	}
	
}
