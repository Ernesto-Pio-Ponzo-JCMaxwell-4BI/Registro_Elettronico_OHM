package registro_elettronico;

import java.util.Scanner;

public class Registro {
	private Scanner input = new Scanner(System.in);
	private String tipoPersona;
	
	Classe classeLogin = new Classe();
	Studente studenteLogin = new Studente();
	Professore professoreLogin = new Professore();

	public Classe getClasseLogin() {
		return classeLogin;
	}

	public Studente getStudenteLogin() {
		return studenteLogin;
	}

	public Professore getProfessoreLogin() {
		return professoreLogin;
	}
	
	public String login(){
		boolean fine = false;
		System.out.println("Sei un professore o uno studente?");

		do {
			tipoPersona = input.next(); // next prende in input una stringa
			input.nextLine();
			if (tipoPersona.equals("studente") || tipoPersona.equals("Studente"))
			{
				tipoPersona = "studente";
				fine = true;
			}
			else if (tipoPersona.equals("professore") || tipoPersona.equals("Professore"))
			{
				tipoPersona = "professore";
				fine = true;
			}
			else
			{
				System.out.println("Errore, sei uno studente o un professore?");
				//System.out.println(tipoPersona);
			}
		}
		while (!fine);

		return tipoPersona;	
	}

	public String[] credenziali(Classe[] classi, String tipoPersona){
		String credenziali[] = null;
		int idEstistente = 0;
		boolean fine = false;

		do {
			System.out.println("Inserisci id-password-classe (separati col '-'): ");
			String linea ;
			linea = input.nextLine(); //prende in input una linea
//			input.nextLine();
//			System.out.println(linea);

			if(linea != null && !linea.equals(""))
			{
				credenziali = linea.split("-");

				if(credenziali.length == 3)
				{
					int id = Integer.parseInt(credenziali[0]);
					String password = credenziali[1];
					String classe = credenziali[2];
					
//					System.out.println("Credenziali: " + id + " " + password + " " + classe);
					 
					for(int i=0;i<classi.length;i++)
					{
						if(tipoPersona.equals("studente")){
							idEstistente = classi[i].getIdStudente(id, password, classe, classi[i].studenti);
							if(idEstistente != 0)
							{
								classeLogin = classi[i];
								studenteLogin = classi[i].studenti[idEstistente-1];
								System.out.println("Benvenuto: " + studenteLogin.getNome() + " " + studenteLogin.getCognome());
								break;
							}
						} else{
							idEstistente = classi[i].getIdProfessore(id, password, classe, classi[i].professori);
							if(idEstistente != 0)
							{
								classeLogin = classi[i];
								professoreLogin = classi[i].professori[idEstistente-1];
								System.out.println("Benvenuto: " + professoreLogin.getNome() + " " + professoreLogin.getCognome());
								break;
							}
						}
						
					}
				}
			}
			if(idEstistente != 0)
			{
				fine = true;
			}
			else
			{
				System.out.println("Studente non esistente o non valido per nessuna classe!");
			}
		} while(!fine);

//		System.out.println("OK");
		return credenziali;
		
	}

	public void inserisciVerifica(){
		Studente studente = new Studente();
		String datiVerifica[] = null;
		int id;
		do{
			System.out.println("Inserisci l'id dello studente per cui vuoi inserire il voto: ");
			 id = input.nextInt();
			input.nextLine(); 
			
			studente = ricercaStudenteDaId(id);
			
		}while(studente==null);
		
		System.out.println("Inserisci i dati della verifica che sono voto e data (separati con uno spazio): ");
		String linea ;
		linea = input.nextLine(); 
		if(linea != null && !linea.equals("")){
			datiVerifica = linea.split(" ");
		}
		
		Verifica verifiche [] = studente.getVerifiche();
		for(int i=0; i<verifiche.length; i++){
			if(verifiche[i]==null){
				verifiche[i]=new Verifica();
				verifiche[i].setVoto(Integer.parseInt(datiVerifica[0]));
				verifiche[i].setData(datiVerifica[1]);
				break;
			}
		}
		
		ricercaStudenteDaId(id).setVerifiche(verifiche);
	}
	
	public Studente ricercaStudenteDaId(int id){
		Studente studente = new Studente();
		
		for(int i=0; i<classeLogin.studenti.length; i++){
//			System.out.println("classeLogin.studenti"+classeLogin.studenti[i].getCognome());
			if(classeLogin.studenti[i]!=null){
				if(classeLogin.studenti[i].getId() == id){
					studente = classeLogin.studenti[i];
					break;
				}
			}
		}
		
		return studente;
	}
	
	public void visualizzaVotiStudenti(){
		for(int i=0; i<classeLogin.studenti.length && classeLogin.studenti[i]!=null; i++){
			System.out.println("Lo studente: " + classeLogin.studenti[i].getNome() + " " + classeLogin.studenti[i].getCognome());
			System.out.println("Ha le seguenti valutazioni: ");
			Verifica [] verifiche = classeLogin.studenti[i].getVerifiche();
			for(int j=0; j<verifiche.length && verifiche[j]!=null; j++){
				System.out.println("data: " + verifiche[j].getData() + " " + " e voto: " + verifiche[j].getVoto());
			}
		}
	}
	
	public void visualizzaVerificheStudente(){
		System.out.println("I voti dello studente: " + studenteLogin.getNome() + " " + studenteLogin.getCognome() + " sono: ");
		Verifica [] verifiche = studenteLogin.getVerifiche();
		for(int j=0; j<verifiche.length && verifiche[j]!=null; j++){
			System.out.println("data: " + verifiche[j].getData() + " " + " e voto: " + verifiche[j].getVoto());
		}
		
	}
}

