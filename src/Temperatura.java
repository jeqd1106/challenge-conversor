public class Temperatura {
	private String nombre;
	private String simbolo;
	private double desviacion;
	private double factor;

	public Temperatura(String nombre, String simbolo, double desviacion, double factor) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.desviacion = desviacion;
		this.factor = factor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getDesviacion() {
		return desviacion;
	}

	public double getFactor() {
		return factor;
	}
}