package es.juntadeandalucia.chap.osTest;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Value("${nombre.nodo}")
	String nombreNodo;
	
	@GetMapping("/hola")
	public Mensaje holaMundo(){
		return new Mensaje("hola, soy " + nombreNodo);
	}
}

class Mensaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3349040986856672498L;

	private String mensaje;

	public Mensaje(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public Mensaje() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}