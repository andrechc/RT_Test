public class Caja2 {
	public static void main(String[] args) {
		
		double[] billetes = {500, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.25, 0.10, 0.05, 0.01};
		int[] resultados  = new int[billetes.length];
		
		double salario  = 1500;
		double acumula  = 0;
		double auxiliar = salario;
		
		int i = 0, j = 0;
		
		while(i < billetes.length && acumula < salario) {		
			double r = auxiliar / billetes[i];			
			resultados[i] = (int)r;		
			
			auxiliar = (((r + 0.000000001) - (int)r)*billetes[i]);
			acumula += resultados[i]*billetes[i];
			i++;
		}
		
		for(int n : resultados) {
			if(n > 0) {
				if(billetes[j] >= 1) {
					System.out.println("BILLETES DE $"+ (int)billetes[j]+ ": " + n);
				} else {
					System.out.println("MONEDAS DE $"+ billetes[j]+ ": " + n);
				}	
			}
			j++;
		}
	}
 }
