package clinica;

public class Paciente {
	private String name;
	private String company;

	public Paciente(String name, String company) {
		this.name = name;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Nombre: " + name + "\nCompañia: " + company + "\n";
	}

}
