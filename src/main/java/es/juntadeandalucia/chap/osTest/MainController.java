package es.juntadeandalucia.chap.osTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class MainController {

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
//	@Value("${nombre.nodo}")
	String nombreNodo = "Nodo 1";
	
	@RequestMapping("/hola")
	public Mensaje holaMundo(){
		return new Mensaje("hola, soy " + nombreNodo);
	}
	
	@RequestMapping("/error")
	public Mensaje error(){
		return new Mensaje("Ha ocurrido un error");
	}
	
	@RequestMapping("/")
	public ArrayList<String> base(){
		ArrayList<String> mapeos = new ArrayList<String>();
		
		for(Entry<RequestMappingInfo, HandlerMethod> mapeo : handlerMapping.getHandlerMethods().entrySet()){
			String mapeoSt = mapeo.getKey().getPatternsCondition().toString();
			if(!mapeos.contains(mapeoSt)){
				mapeos.add(mapeoSt);
			}
		}
		
		return mapeos;
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