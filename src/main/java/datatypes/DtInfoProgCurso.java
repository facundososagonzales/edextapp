package datatypes;

public class DtInfoProgCurso {
	private DtCursoDetalle1 dt;
	private String texto;
	public DtInfoProgCurso() {
		super();
	}
	public DtInfoProgCurso(DtCursoDetalle1 dt, String texto) {
		super();
		this.dt = dt;
		this.texto = texto;
	}
	public DtCursoDetalle1 getDt() {
		return dt;
	}
	public String getTexto() {
		return texto;
	}
	
	@Override
	public String toString() {
		return  dt.toString()+ " "+texto;
		
	}
}