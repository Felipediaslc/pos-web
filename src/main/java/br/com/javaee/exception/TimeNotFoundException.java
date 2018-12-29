package br.com.javaee.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TimeNotFoundException extends RuntimeException {
	private String timeName;
	private String fieldName;
	private Object fieldTecnico;

	public TimeNotFoundException(String timeName, String fieldName,  Object fieldTecnico) {
		super(String.format("%s not found with %s : '%s'", timeName, fieldName, fieldTecnico));
		this.timeName = timeName;
		this.fieldName = fieldName;
		this.fieldTecnico = fieldTecnico;
	}

	public String getTimeName() {
		return timeName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldTecnico() {
		return fieldTecnico;
	}
}