package entidad;

public class AhorcadoEntidad {

    /*
    contener como atributos, un vector con la palabra a buscar, la cantidad de letras encontradas y la cantidad
jugadas máximas que puede realizar el usuario.
     */
    private char[] buscarPalabra;
    private int cantLetrasEncontradas;
    private int cantIntentos;

    public AhorcadoEntidad() {
    }

    public AhorcadoEntidad(char[] buscarPalabra, int cantLetrasEncontradas, int cantIntentos) {
        this.buscarPalabra = buscarPalabra;
        this.cantLetrasEncontradas = cantLetrasEncontradas;
        this.cantIntentos = cantIntentos;
    }

    public char[] getBuscarPalabra() {
        return buscarPalabra;
    }

    public void setBuscarPalabra(char[] buscarPalabra) {
        this.buscarPalabra = buscarPalabra;
    }

    public int getCantLetrasEncontradas() {
        return cantLetrasEncontradas;
    }

    public void setCantLetrasEncontradas(int cantLetrasEncontradas) {
        this.cantLetrasEncontradas = cantLetrasEncontradas;
    }

    public int getCantIntentos() {
        return cantIntentos;
    }

    public void setCantIntentos(int cantIntentos) {
        this.cantIntentos = cantIntentos;
    }

}
