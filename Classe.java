package registro_elettronico;

public class Classe {
	
	String nomeClasse;
	Studente [] studenti = new Studente[30];
	Professore [] professori = new Professore[10];
	
	public Classe(String nomeClasse, Studente[] studenti, Professore[] professori) {
		this.nomeClasse = nomeClasse;
		this.studenti = studenti;
		this.professori = professori;
	}
	
	public String getNomeClasse() {
		return nomeClasse;
	}
	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	public Studente[] getStudenti() {
		return studenti;
	}
	public void setStudenti(Studente[] studenti) {
		this.studenti = studenti;
	}
	public Professore[] getProfessori() {
		return professori;
	}
	public void setProfessori(Professore[] professori) {
		this.professori = professori;
	}
	
	public int getIdStudente(int id, String password, String classe, Studente [] studenti){
		int idStudente = 0;
		
		for (int i=0; i< studenti.length; i++)
		{
			if(studenti[i] != null)
			{
				if(studenti[i].getId()== id && studenti[i].getPassword().equals(password) && studenti[i].getClasse().equals(classe))
				{
					idStudente = studenti[i].getId();
				}
			}
		}
		return idStudente;
	}
	
	public int getIdProfessore(int id, String password, String classe, Professore [] professori){
		int idProfessore = 0;
		
		for (int i=0; i< professori.length; i++)
		{
			if(professori[i] != null)
			{
				if(professori[i].getId()== id && professori[i].getPassword().equals(password) && professori[i].getClasse().equals(classe))
				{
					idProfessore = professori[i].getId();
				}
			}
		}
		return idProfessore;
	}
	
	
}
