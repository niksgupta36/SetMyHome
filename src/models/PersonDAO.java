package models;

import java.util.List;

public interface PersonDAO {
	
	public List<Person> getPerson(Person p);
	public void setPerson(Person p);
	public void deletePerson(Person p);
	public boolean loginPerson(Person p);
	
}
