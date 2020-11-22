package com.mutez.valot.web.jpa;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
//import javax.naming.NamingException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped // Bean is created once for users's browser session. Unique for this user
public class StudentManager1 {
	
	List<Student1> list_students;
	
	public List<Student1> getList_students() {
		return list_students;
	}

	public void setList_students(List<Student1> list_students) {
		this.list_students = list_students;
	}
	
	public void loadStudents() {
		try {
			list_students = StudentDbUtil1.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String addStudent(Student1 stu) {
		StudentDbUtil1.addStudent(stu);
		return "List-students1.xhtml";
	}
	
	public String loadStudent(int id) throws SQLException {
		Student1 theStudent = StudentDbUtil1.fetchStudent(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext(); 
		Map<String, Object> RequestMap = externalContext.getRequestMap(); 
		RequestMap.put("student1", theStudent);
		return "Edit-student1.xhtml";
	}
	
	public String updateStudent(Student1 stu) {
		StudentDbUtil1.updateStudent(stu);
		return "List-students1.xhtml";
	}
	
	public String deleteStudent(int id) {
		StudentDbUtil1.deleteStudent(id);
		return "List-students1.xhtml";
	}
	
	public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		if(value==null){ 
			return;
		}
		String data = value.toString();
		if(data.length() > 45) {
			FacesMessage message = new FacesMessage("Your email adress is too long (more than 45 characters"); 
			throw new ValidatorException(message);
		}
		if((!data.endsWith(".com")) && (!data.endsWith(".fr"))) {
			FacesMessage message = new FacesMessage("Your email adress needs to finish with .fr or .com"); 
			throw new ValidatorException(message);
		}
		if(!data.contains("@")) {
			FacesMessage message = new FacesMessage("Your email adress needs to have an @"); 
			throw new ValidatorException(message);
		}
		if((data.contains("#")) || (data.contains("..")) || (data.contains("-@"))) {
			FacesMessage message = new FacesMessage("Your email adress is incorrect"); 
			throw new ValidatorException(message);
		}
		if (data.startsWith(".")) {
			FacesMessage message = new FacesMessage("Your email adress can't begin with a dot"); 
			throw new ValidatorException(message);
		}
	}
}
