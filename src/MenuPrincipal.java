import javax.swing.JOptionPane;
public class MenuPrincipal {
	public void mostrarMenuPrincipal() {
		Object[] possibleValues = {"Conversor de Moneda", "Conversor de Temperatura"};
		String selectedValue = (String) JOptionPane.showInputDialog(null,
		             "Seleccione una opción de conversión", "Menu",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             possibleValues, possibleValues[0]);
		if (selectedValue != null) {
			if (selectedValue.equals("Conversor de Moneda")) {
				ConversorMoneda conversorMoneda = new ConversorMoneda();
				conversorMoneda.mostrarOpcionesMonedas();
			} else if (selectedValue.equals("Conversor de Temperatura")) {
				ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
				conversorTemperatura.mostrarOpcionesTemperatura();
			}
		}
	}

	public void terminarPrograma() {
		int option = JOptionPane.showOptionDialog(
                null,
                "¿Desea continuar?",
                "Continuar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                "Sí"
        );
        if (option == JOptionPane.YES_OPTION) {
            mostrarMenuPrincipal();
        } else {
        	JOptionPane.showMessageDialog(null, "Programa terminado");
            System.exit(0);
        }
	}
}