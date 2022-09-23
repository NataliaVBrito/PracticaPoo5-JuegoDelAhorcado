package extra6.pkg1_poo;

import entidad.AhorcadoEntidad;
import servicio.AhorcadoServicio;

public class Extra61_poo {

    public static void main(String[] args) {
        AhorcadoServicio ahorcadoServicio = new AhorcadoServicio();
        AhorcadoEntidad ahorcadoEntidad = ahorcadoServicio.crearJuego();
        
        ahorcadoServicio.jugarJuego(ahorcadoEntidad);
    }    
}
