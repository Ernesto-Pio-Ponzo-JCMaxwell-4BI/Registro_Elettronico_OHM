package registro_elettronico;

public class Verifica {
	private int voto;
	private String data;
	
	public Verifica() {
		
	}
	
	public Verifica(int voto, String data) {
		super();
		this.voto = voto;
		this.data = data;
	}
	
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
