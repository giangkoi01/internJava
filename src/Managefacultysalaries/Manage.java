package Managefacultysalaries;

interface Manage {
	public void createTeacher(); 
	
	public void outputTeacher();
	
	public void CreateSubject();
	
	public void outputSubject();
	
	public Teacher SearchTeacher(int id);
	
	public Subject SearchSubject(int id);
	
	public void createTeaching();
	
	public void outputTeaching();
	
	public void sortByName();
}
