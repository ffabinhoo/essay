package br.com.fabio.essay.essay;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "essay")
public class Essay {
	@Id
    public String id;
   
    @Indexed(unique = true)
    private String name;
    
    private String content;
    
    private Calendar data;
    
    private Float grade;

    
	public Float getGrade() {
		return grade;
	}


	public void setGrade(Float grade) {
		this.grade = grade;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Essay(String name, String content, Float grade) {
		this.name = name;
	    this.content = content;
	    this.grade = grade;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

   
    
}