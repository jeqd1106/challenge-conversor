public class Moneda {
	private String nombre;
	private String codigo;
	private String simboloMoneda;
	private double valor;

	public Moneda(String nombre, String codigo, String simboloMoneda, double valor) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.simboloMoneda = simboloMoneda;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getSimbolo() {
		return simboloMoneda;
	}

	public double getValor() {
		return valor;
	}
}