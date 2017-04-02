package registro_elettronico;

public class Studente extends Persona{

	private static final int MAX_VOTI = 100;
	private Verifica[] verifiche = new Verifica[MAX_VOTI];
	
	public Studente() {
		
	}
	public Studente (String nome, String cognome, String classe, int id, String password){
		super(nome, cognome, classe, id, password); //chiama il costruttore della classe padre (Persona)
	}
	public Verifica[] getVerifiche() {
		return verifiche;
	}
	public void setVerifiche(Verifica[] verifiche) {
		this.verifiche = verifiche;
	}
	
}
