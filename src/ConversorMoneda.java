import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ConversorMoneda {
	public void mostrarOpcionesMonedas() {
		Object[] possibleValues = {"De Soles a Dólar", "De Soles a Euros", "De Soles a Libras Esterlinas",
				"De Soles a Yen Japonés", "De Soles a Won sul-coreano", "De Dólar a Soles", "De Euros a Soles",
				"De Libras Esterlinas a Soles", "De Yen Japonés a Soles", "De Won sul-coreano a Soles"};
		List<Moneda> monedas = new ArrayList<>();
		monedas.add(new Moneda("Soles", "PEN", "S/", 1.0));
		monedas.add(new Moneda("Dólar", "USD", "$", 0.28));
		monedas.add(new Moneda("Euros", "EUR", "€", 0.25));
		monedas.add(new Moneda("Libras Esterlinas", "GBP", "£", 0.21));
		monedas.add(new Moneda("Yen Japonés", "JPY", "¥", 38.78));
		monedas.add(new Moneda("Won sul-coreano", "KRW", "₩", 352.86));
		String selectedValue = (String) JOptionPane.showInputDialog(null,
		             "Elija la moneda a la que deseas convertir tu dinero", "Monedas",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             possibleValues, possibleValues[0]);
		if (selectedValue != null) {
			String[] monedasSeleccionadas = selectedValue.substring(3).split(" a ");
			List<Moneda> listaMonedasSeleccionadas = new ArrayList<>();
			for (String monedaSeleccionada: monedasSeleccionadas) {
				for (Moneda moneda: monedas) {
					if (moneda.getNombre().equals(monedaSeleccionada)) {
						listaMonedasSeleccionadas.add(moneda);
					}
				}
			}
			calcularValor(listaMonedasSeleccionadas);
		}
	}

	public void calcularValor(List<Moneda> lMS) {
		boolean mostrarVentana = true;
		while (mostrarVentana) {
			try {
				Object insertedValue = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir");
				if (insertedValue == null) {
					mostrarVentana = false;
				} else {
					double valor = Double.parseDouble((String) insertedValue);
					DecimalFormat numberFormat = new DecimalFormat("#.00");
					valor *= lMS.get(1).getValor()/ lMS.get(0).getValor();
					String aux = "Tienes "+lMS.get(1).getSimbolo()+" "+numberFormat.format(valor);
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