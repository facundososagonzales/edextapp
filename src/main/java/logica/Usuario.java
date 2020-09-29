package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
	@Id
	private String nick;
	private String nombre;
	private String apellido;
	@Column(name="correo", unique=true)	
	private String correo;
	private Date fechaNac;
	private String Password;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<Usuario>();
	@ManyToMany(mappedBy = "seguidos")
	private List<Usuario> seguidores = new ArrayList<Usuario>();
	

	public Usuario() {
		super();
	}

	public Usuario(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public void seguirUsuario(Usuario u) {
		if (!this.seguidos.contains(u)) {
			this.seguidos.add(u);
			u.agregarSeguidor(this);
		}
	}
	
	public void dejarSeguirUsuario(Usuario u) {
		this.seguidos.remove(u);
		u.quitarSeguidor(this);
	}
	
	public void agregarSeguidor(Usuario u) {
		if (!this.seguidores.contains(u)) {
			this.seguidores.add(u);			
		}

	}
	public void quitarSeguidor(Usuario u) {
		this.seguidores.remove(u);
	}
}