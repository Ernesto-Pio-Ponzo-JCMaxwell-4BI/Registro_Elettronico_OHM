package registro_elettronico;

public class Professore extends Persona{

	private String materia;
	
	public Professore() {
		
	}
	public Professore (String nome, String cognome, String classe, int id, String password, String materia){
		super(nome, cognome, classe, id, password); //chiama il costruttore della classe padre (Persona)
		this.materia = materia;
	}
	
}
