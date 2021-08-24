package datatypes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCursoDetalle1 extends DtCursoBase{ 
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private ArrayList<String> previas = new ArrayList<>();
	private ArrayList<DtEdicionBasico>ediciones = new ArrayList<>();
	private ArrayList<String> categorias= new ArrayList<>();
	
	public DtCursoDetalle1() {
		super();
	}
	
	public DtCursoDetalle1(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR, String url,
			ArrayList<String> previas, ArrayList<DtEdicionBasico> ediciones, ArrayList<String> categorias) {
		
		super(nombre, descripcion);
		
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.previas = previas;
		this.ediciones = ediciones;
		this.categorias = categorias;
	}
	public String getDuracion() {
		return duracion;
	}
	public Time getCantHoras() {
		return cantHoras;
	}
	public int getCreditos() {
		return creditos;
	}
	public Date getFechaR() {
		return fechaR;
	}
	public String getUrl() {
		return url;
	}

	public ArrayList<DtEdicionBasico> getEdiciones() {
		return ediciones;
	}
	
	protected String imprimirPrevias() {
		String dato = "**************\nPrevias:\n";
		for(String c:this.previas) {
			dato= dato + c +"\n";
		}
		return dato;
	}
	
	protected String imprimirEdiciones() {
		String datob = "**************\nEdiciones:\n";
		for(DtEdicionBasico dt:ediciones) {
			datob= datob + dt.toString() +"\n";
		}
		return datob;
	}
	
	protected String imprimirCategorias() {
		String datoCat = "**************\nCategorias:\n";
		for(String s:categorias) {
			datoCat= datoCat + s +"\n";
		}
		return datoCat;
	}
	
	@Override
	public String toString() {
		String a = this.imprimirEdiciones();
		String b = this.imprimirPrevias();
		String cat = this.imprimirCategorias();
		return  super.toString()+ "\n Duracion: "+duracion+"\nCantHoras: "+cantHoras+"\nCreditos: "+creditos+"\nFechaR: "+fechaR+"\n"+b+""+a+""+cat;
		
	}

	public ArrayList<String> getPrevias() {
		return previas;
	}

	public void setPrevias(ArrayList<String> previas) {
		this.previas = previas;
	}
}