package datatypes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class DtCursoDetalle extends DtCursoBase{
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private ArrayList<DtPFormacion>programas = new ArrayList<>();
	private ArrayList<DtEdicionBase>ediciones = new ArrayList<>();
	
	public DtCursoDetalle() {
		super();
	}	
	public DtCursoDetalle(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR, String url,
			ArrayList<DtPFormacion> programas, ArrayList<DtEdicionBase> ediciones) {
		super(nombre, descripcion);
		
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.programas = programas;
		this.ediciones = ediciones;
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
	public ArrayList<DtPFormacion> getProgramas() {
		return programas;
	}
	
	public ArrayList<DtEdicionBase> getEdiciones() {
		return ediciones;
	}
	
	protected String imprimirProgramas() {
		String dato = "Programas de Formacion:\n\n";
		for(DtPFormacion dt:programas) {
			dato= dato + dt.toString() +"\n";
		}
		return dato;
	}
	
	protected String imprimirEdiciones() {
		String datob = "Ediciones:\n\n";
		for(DtEdicionBase dt:ediciones) {
			datob= datob + dt.toString() +"\n";
		}
		return datob;
	}
	
	@Override
	public String toString() {
		String a = this.imprimirEdiciones();
		String b = this.imprimirProgramas();
		return  super.toString()+ "\n Duracion: "+duracion+"\nCantHoras: "+cantHoras+"\nCreditos: "+creditos+"\nFechaR: "+fechaR+"\nEdiciones:"+a
				+"\nProgramas: "+b;
		
	}
	

	
}
