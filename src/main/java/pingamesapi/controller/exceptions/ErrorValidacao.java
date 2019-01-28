package pingamesapi.controller.exceptions;

public class ErrorValidacao {
	
	private String fieldName;
	
	private String menssage;
	
	

	public ErrorValidacao(String fieldName, String menssage) {
		this.fieldName = fieldName;
		this.menssage = menssage;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMenssage() {
		return menssage;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	
	
}
