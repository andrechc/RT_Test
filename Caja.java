import java.util.Arrays;

public class Caja {
	
	/*int[] billetesArray = {1, 2, 5, 10, 20, 50, 100};*/
	
	public static void generarSobre(Empleado empleado, int[] billetes) {
		calcular(empleado, billetes);					/* Envía un array con los billetes y sus valores junto con el salario a pagar */		
	}
	
	private static void calcular(Empleado empleado, int[] billetes) {
		Arrays.sort(billetes);						/* Ordena de menor a mayor la lista de billetes recibida */
		
		int salario = empleado.getLegajo() + empleado.getSueldo();
		
		int[] queBilletes = new int[billetes.length];			/* Crea un nuevo array para ir guardando qué billetes deberán ser utilizados para pagar */
		int posBilletes   = 0;						/* Variable utilizada para saber a qué billete le incrementamos el contador (L33)*/		
		int cantBilletes  = 0;							
		
		int posArray	  = billetes.length - 1;			/* Variable utilizada para comenzar a descender desde el mayor billete hasta el menor */	
		int divisaActual  = billetes[posArray];				/* Se encarga de almacenar en que valor del array estamos */
		
		do {
			while(salario >= divisaActual) {			/* Analiza si el billete actual es denominador o necesita cambiar al próximo menor valor */
				salario -= divisaActual;
				cantBilletes++;
				queBilletes[posBilletes]++;				
			} if(salario > 0 && divisaActual == billetes[0]) {
				salario -= divisaActual;			/* Cuando no hay un billete/moneda inferior al monto restante, redondea a favor del empleado */
				cantBilletes++;
				queBilletes[posBilletes]++;
			} else if(salario > 0) {
				posBilletes++;
				posArray--;
				divisaActual = billetes[posArray];		/* Cambia al siguiente billete de menor valor */
			}				
		} while(salario > 0);		
		
		empleado.setLegajo(salario);					/* Al empleado se le resta del próximo mes el extra que recibió por falta de cambio (ver linea 14) */
		
		System.out.println("CANTIDAD DE BILLETES EMPLEADOS: " + cantBilletes);
		
		for(int i = 0; i < queBilletes.length; i++) {			/* Muestra sólo qué billetes son necesarios y en qué cantidad por cada billete */
			if(queBilletes[i] > 0) {
				System.out.println("BILLETES DE:$" + billetes[(billetes.length-1)-i] );
				System.out.println(queBilletes[i]);
			}			
		}	
	}	
}
