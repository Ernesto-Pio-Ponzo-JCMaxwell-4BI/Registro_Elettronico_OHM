package registro_elettronico;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("*** REGISTRO ELETTRONICO OHM ***\n");
		
		Registro accesso = new Registro();
		
		Scanner input = new Scanner(System.in);
		//inizializiamo studenti e classi
		Studente [] studenti = new Studente[30];
                //"Nome"; "Cognome"; "Classe"; ID; "Password"
		studenti[0] =  new Studente ("Luigi", "Verdi", "4A Info", 1, "123");
		studenti[1] =  new Studente ("Anna", "Bianchi", "4A Info", 2, "456");
		studenti[2] =  new Studente ("Mario", "Rossi", "4A Info", 3, "789");
//		System.out.println("studenti: "+studenti[0].getNome());
		
		Studente [] studenti2 = new Studente[30];
		studenti2[0] =  new Studente ("Ernesto", "Ponzo", "4B Info", 1, "098"); 
		studenti2[1] =  new Studente ("Luca", "Ferocino", "4B Info", 2,  "765"); 
		studenti2[2] =  new Studente ("Maria", "Gialli", "4B Info", 3, "789");
//		System.out.println("studenti2: "+studenti2[0].getNome());
                
                Studente [] studenti3 = new Studente[30];
                //"Nome"; "Cognome"; "Classe"; ID; "Password"
		studenti3[0] =  new Studente ("Gianluca", "Lano", "4A Tele", 1, "753");
		studenti3[1] =  new Studente ("Giuseppe", "Simone", "4A Tele", 2, "984");
		studenti3[2] =  new Studente ("Stefano", "Cilenti", "4A Tele", 3, "126");
//		System.out.println("studenti: "+studenti[0].getNome());
		
		Professore [] professori = new Professore[10];
		professori[0] =  new Professore ("Andrea", "Blu", "4A Info", 1, "123", "Informatica"); 
		professori[1] =  new Professore ("Piero", "Viola", "4A Info", 2,  "456", "Italiano"); 
		professori[2] =  new Professore ("Marco", "Nero", "4A Info", 3, "789", "Inglese");
                
                Professore [] professori2 = new Professore[10];
		professori2[0] =  new Professore ("Gianna", "Graco", "4B Info", 1, "754", "Diritto"); 
		professori2[1] =  new Professore ("Pietro", "Smusi", "4B Info", 2,  "457", "Scienze"); 
		professori2[2] =  new Professore ("Marco", "Gennarini", "4B Info", 3, "956", "Latino");
                
                Professore [] professori3 = new Professore[10];
		professori3[0] =  new Professore ("Pippo", "Franco", "4A Tele", 1, "754", "Diritto"); 
		professori3[1] =  new Professore ("Franco", "Impastato", "4A Tele", 2,  "457", "Scienze"); 
		professori3[2] =  new Professore ("Paolo", "Ken", "4B Info", 3, "956", "Latino");
		
		Classe [] classi = new Classe [3];
		classi[0] = new Classe("4A INFO", studenti, professori);
		classi[1] = new Classe("4B INFO", studenti2, professori2);
                classi[2] = new Classe("4A TELE", studenti3, professori3);
		
		int continua = 0;
		
		do
		{
			System.out.println("0: Esci");
			System.out.println("1: Login");
		
			continua = input.nextInt();
			input.nextLine();
			
			switch (continua) {
				case 1:
					break;
				case 0 :
					break;
			}
		
		
		if(continua == 1)
		{
		
		
		String tipoPersona = accesso.login();
		
		accesso.credenziali(classi,tipoPersona);
//		System.out.println("classeLogin"+ accesso.classeLogin.getStudenti()[0].getCognome());
		//System.out.println("Sei un " + tipoPersona);
		int scelta = 0;
		
		 if(tipoPersona.equals("studente")) {
			do{
				System.out.println("0: Effettua il logout");
				System.out.println("1: Visualizza i voti");
				
				scelta = input.nextInt();
				input.nextLine();
				
				switch (scelta) {
					case 1:
						accesso.visualizzaVerificheStudente();
						break;
					case 0 :
						break;
				}
			} while(scelta != 0);
		 }else{

			do{
				System.out.println("0: Effettua il logout");
				System.out.println("1: Inserisci i voti");
				System.out.println("2: Visualizza i voti degli studenti");
				
				scelta = input.nextInt();
				input.nextLine();
				
				switch (scelta) {
					case 1:
						accesso.inserisciVerifica();
						break;
					case 2:
						accesso.visualizzaVotiStudenti();
						break;
					case 0 :
						if(tipoPersona.equals("professore")){
							if(accesso.getProfessoreLogin().getClasse().equals("4A Info")){
								classi[0] = accesso.getClasseLogin();
							}
							else if(accesso.getProfessoreLogin().getClasse().equals("4B Info")){
								classi[1] = accesso.getClasseLogin();
							}
						}
						else if(tipoPersona.equals("studente")){
							if(accesso.getStudenteLogin().getClasse().equals("4A Info")){
								classi[0] = accesso.getClasseLogin();
							}
							else if(accesso.getStudenteLogin().getClasse().equals("4B Info")){
								classi[1] = accesso.getClasseLogin();
							}
						}
						
						break;
				}
			} while(scelta != 0);
		 }
		
		System.out.println("Hai eseguito il logout");
		}
		}while(continua != 0);	
		
		System.out.println("FINE PROGRAMMA");
	}

}
