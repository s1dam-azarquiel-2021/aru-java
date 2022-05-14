package aplicacion;

import dao.DAOPerson;
import entities.Person;

public class Prueba {
	public static void main(String[] args) {
		DAOPerson dao = new DAOPerson();
		Person p = new Person("465253Y", "Mario", 12345);
		Person p2 = new Person(p.getDni(), "Mario de su Casa", 140250826);
		dao.add(p);
		dao.update(p2);
		System.out.println(dao.get(p2.getNombre()));
		System.out.println("------\n");
		dao.delete(p2);

		for (Person person : dao.get()) {
			System.out.println(person);
		}
	}
}
