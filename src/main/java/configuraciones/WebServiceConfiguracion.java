package configuraciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;



	public class WebServiceConfiguracion {
		//devuelve la ruta de mi carpeta personal al menos en linux + dentro de mi home carpeta oculta con archivo 
		//.properties que aca va a buscar la configuracion de que puerto e ip utilizar
		
		//cat properties
		//WS_IP=127.0.0.1
		//WS_PORT = 1942
		private String path = System.getProperty("user.home") + "\\edextapp\\properties.txt";
	    private HashMap<String, String> configs;
		   


public WebServiceConfiguracion() throws Exception {
    configs = new HashMap<>();
    System.out.println(path);
    @SuppressWarnings("resource")
	BufferedReader reader = new BufferedReader(new FileReader(path));
    String properties;
    try {
    	
        while((properties = reader.readLine()) != null){
            if(properties.startsWith("-")) {
            
                String[] div = properties.split("=");
                configs.put(div[0], div[1]);
            	
            }
        }
    } catch(Exception e) {
        //throw new ErrorEnFileException();
        System.out.println(e);
    }
}

	public String getConfigOf(String nombre) {
    return configs.get(nombre); 
	}
}