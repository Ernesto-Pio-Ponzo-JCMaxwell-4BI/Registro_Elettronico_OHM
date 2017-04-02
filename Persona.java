package registro_elettronico;

public class Persona {
	private String nome;
	private String cognome;
	private String classe;
	private int id;
	private String password;
	
	public Persona(){
		
	}

	public Persona(String nome, String cognome, String classe, int id, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.classe = classe;
		this.id = id;
		this.password = password;
	}

	//getter e setter
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
