package com.jsf.jpa.crud;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.jsf.jpa.crud.db.operations.DatabaseOperations;
@ManagedBean
@SessionScoped
public class SchoolBean {

	private int id;
	private String name;	
	private String editSchoolId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditSchoolId() {
		return editSchoolId;
	}

	public void setEditSchoolId(String editSchoolId) {
		this.editSchoolId = editSchoolId;
	}

	public List<SchoolBean> schoolListFromDb() {
		return DatabaseOperations.getAllSchoolDetails();		
	} 
	
	public String addNewSchool(SchoolBean schoolBean) {
		return DatabaseOperations.createNewSchool(schoolBean.getName());		
	}
	public String deleteSchoolById(int schoolId) {		
		return DatabaseOperations.deleteSchoolDetails(schoolId);		
	}
		editSchoolId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedSchoolId");		
		return "schoolEdit.xhtml";
	}
	public String updateSchoolDetails(SchoolBean schoolBean) {
		return DatabaseOperations.updateSchoolDetails(Integer.parseInt(schoolBean.getEditSchoolId()), schoolBean.getName());		
	}
}




