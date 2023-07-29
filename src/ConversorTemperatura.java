import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
	public void mostrarOpcionesTemperatura() {
		Object[] possibleValues = {"De Celsius a Fahrenheit", "De Celsius a Kelvin",
				"De Fahrenheit a Celsius", "De Kelvin a Celsius"};
		List<Temperatura> temperaturas = new ArrayList<>();
		temperaturas.add(new Temperatura("Celsius", "°C", 0.0, 5.0));
		temperaturas.add(new Temperatura("Fahrenheit", "°F", -32.0, 9.0));
		temperaturas.add(new Temperatura("Kelvin", "K", -273.0, 5.0));
		String selectedValue = (String) JOptionPane.showInputDialog(null,
		             "Elija la temperatura a la que deseas convertir", "Temperaturas",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             possibleValues, possibleValues[0]);
		if (selectedValue != null) {
			String[] temperaturasSeleccionadas = selectedValue.substring(3).split(" a ");
			List<Temperatura> listaTemperaturasSeleccionadas = new ArrayList<>();
			for (String temperaturaSeleccionada: temperaturasSeleccionadas) {
				for (Temperatura temperatura: temperaturas) {
					if (temperatura.getNombre().equals(temperaturaSeleccionada)) {
						listaTemperaturasSeleccionadas.add(temperatura);
					}
				}
			}
			calcularValor(listaTemperaturasSeleccionadas);
		}
	}

	public void calcularValor(List<Temperatura> lTS) {
		boolean mostrarVentana = true;
		while (mostrarVentana) {
			try {
				Object insertedValue = JOptionPane.showInputDialog("Ingresa la temperatura que deseas convertir");
				if (insertedValue == null) {
					mostrarVentana = false;
				} else {
					double valor = Double.parseDouble((String) insertedValue);
					DecimalFormat numberFormat = new DecimalFormat("#.00");
					valor = ((valor+lTS.get(0).getDesviacion())*(lTS.get(1).getFactor()/ lTS.get(0).getFactor()))-lTS.get(1).getDesviacion();
					String aux;
					if (valor == 0) {
						aux = "Eso equivale a 0 "+lTS.get(1).getSimbolo();
					} else {
						aux = "Eso equivale a "+numberFormat.format(valor)+" "+lTS.get(1).getSimbolo();
					}
					JOptionPane.showMessageDialog(null, aux, "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				mostrarVentana = false;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Valor no válido");
			}
		}
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.terminarPrograma();
	}
}