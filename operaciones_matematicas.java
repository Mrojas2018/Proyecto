import java.util.InputMismatchException;
import java.util.Scanner;

public class operaciones_matematicas {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		boolean salir=false;
		int opcion;
		//realiza accion, mientras no se seleccione opción salir
		while (!salir){
			//realiza acción mientras no se encuentren errores
			try{
				System.out.print("Elija una opción"+"\n"+"	1) Sumar 2 elementos"+"\n"+
						"	2) Restar 2 elementos"+"\n"+"	3) Dividir 2 elementos"+"\n"+
						"	4) Multiplicar 2 elementos"+"\n"+"	5) Volver"+"\n");
				opcion=entrada.nextInt();
				switch(opcion){
						
						case 1 : 
						//Suma de dos elementos.
						System.out.println("Suma de dos números.");
				 		System.out.println();
						System.out.print("Ingrese el primer número: ");
						a=teclado.nextDouble();
						System.out.print("ingrese el segundo número: ");
						b=teclado.nextDouble();
						respuesta=suma(a,b);
							
							
						System.out.println("El resultado de la suma ("+a+"+"+b+") es: "+respuesta);
						break;
						
						case 2 : 
						//Resta de dos elementos.
						System.out.println("Resta de dos números.");
						System.out.println();
						teclado = new Scanner(System.in);
						System.out.print("Ingrese el primer número: ");
						a = teclado.nextDouble();
						System.out.print("Ingrese el segundo número: ");
						b = teclado.nextDouble(); 
						respuesta=resta(a,b);
						System.out.println("El resultado de la resta "+a+"-"+b+" es: "+respuesta);
						break;
											
						case 3: 
						//Multiplicación de dos elementos.
						System.out.println("Multiplicación de dos números.");
						System.out.println();
						double x=0,y=0,respuesta;
						Scanner teclado=new Scanner(System.in);
						System.out.print("Ingrese el primer número: ");
						x=teclado.nextDouble();
						System.out.print("ingrese el segundo número: ");
						y=teclado.nextDouble();
						respuesta=multiplicación(x,y);
						teclado.close();
				
						System.out.print("El resultado de la multiplicación "+x+"x"+y+" es: "+respuesta);
	}	              
						break;
										 
						case 4: 
						//División de dos elementos.
										
						break;
										
						case 5: 
						//Potencia.
						System.out.println("Potenciación de números.");
						System.out.println();
						teclado = new Scanner(System.in);
						System.out.print("Ingrese la base: ");
						a = teclado.nextDouble();
						System.out.print("Ingrese el exponente: ");
						b = teclado.nextDouble(); 
						respuesta=potencia(a,b);
						System.out.println("El resultado de la potencia de base  "+ a +" elevada a "+ b +" "+respuesta);
						break;
								
						case 6: salir=true;
						break;
				}
								
				//si se ingreso un caracter distinto a un número, o surge algún error
				}catch (InputMismatchException e) {
					System.out.println("Debe insertar una opción entre 1 y 5");
					teclado.next();			
				}	
			}
		}
				


			
			public static double suma (double A,double B) {
				double respuesta=(A+B);
				return respuesta;
			}
			 public static double resta (double c, double d){
          	   double respuesta =(c-d);
          	   return respuesta;
			 }
			 public static double multiplicación(double x, double y) {
				int i=0;
				double mult=0;
				while(i<y){
				mult= mult+x;
				i++;		
			}			 
			 public static double potencia(double j, double k){
				double potencia=0;
				double x=0;
				double nro=j;
				
				for(int i=0; i<k-1; i++){
					x=0;
					potencia=0;
					while(x<j){
					potencia= potencia+nro;
					x++;
					}
					nro=potencia;
					
				}
				 return potencia;
			 }
}
