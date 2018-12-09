import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class operaciones_matematicas {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		boolean salir=false;
		int opcion;
		double a;double b;
		double respuesta;
		//realiza accion, mientras no se seleccione opción salir
		while (!salir){
			//realiza acción mientras no se encuentren errores
			try{
				System.out.print("Elija una opción"+"\n"+"	1) Sumar 2 elementos"+"\n"+
						"	2) Restar 2 elementos"+"\n"+"	3) Multiplicar 2 elementos"+"\n"+
						"	4) Dividir 2 elementos"+"\n"+"	5) Potencia"+"\n"+"	6) Volver"+"\n");
				opcion=entrada.nextInt();
				
				switch(opcion){
						
						case 1 : 
						//Suma de dos elementos.
						System.out.println("Suma de dos números.");
				 		System.out.println();
						System.out.print("Ingrese el primer número: ");
						a=entrada.nextDouble();
						System.out.print("ingrese el segundo número: ");
						b=entrada.nextDouble();
						respuesta=suma(a,b);
							
							
						System.out.println("El resultado de la suma "+a+"+"+b+" es: "+respuesta);
						break;
						
						case 2 : 
						//Resta de dos elementos.
						System.out.println("Resta de dos números.");
						System.out.println();
						System.out.print("Ingrese el primer número: ");
						a = entrada.nextDouble();
						System.out.print("Ingrese el segundo número: ");
						b = entrada.nextDouble(); 
						respuesta=resta(a,b);
						System.out.println("El resultado de la resta "+a+"-"+b+" es: "+respuesta);
						break;

						case 3:
						//Multiplicación de dos elementos.
						System.out.println("Multiplicación de dos números.");
						System.out.println();
						System.out.println("Ingrese factor 1");
						a=entrada.nextDouble();
						System.out.println("Ingrese factor 2");
						b=entrada.nextDouble();
						respuesta=multiplicacion(a,b);
						System.out.println("La multiplicación entre "+a+" y "+b+" es: "+respuesta);
						break;
										 
						case 4: 
						//División de dos elementos.
						System.out.println("División de dos números.");
						System.out.println();
						System.out.println("Ingrese dividendo");
						a=entrada.nextDouble();
						System.out.println("Ingrese divisor");
						b=entrada.nextDouble();
						respuesta=division(a,b);
						System.out.println("La división entre "+a+" y "+b+" es: "+respuesta);
						break;
										
						case 5: 
						//Potencia.
						System.out.println("Potenciación de números:");
						entrada = new Scanner(System.in);
						System.out.print("Ingrese la base: ");
						a = entrada.nextDouble();
						System.out.print("Ingrese el exponente: ");
						b = entrada.nextDouble(); 
						respuesta=pow(a,b);
						System.out.println("El resultado de la potencia de base  "+ a +" elevada a "+ b +" es: "+respuesta);
						break;

						case 6: salir=true;
						continue;
				}
					System.out.println("¿Qué desea hacer ahora?"+"\n"+"	1)Elegir otra opción."+"\n"+"	2)Salir.");
					opcion=entrada.nextInt();
					switch (opcion){					
					case 1:break;
					case 2:
						salir=true;
						break;
					default:System.out.println("Opcion incorrecta.");
						entrada.next();
						break;
					}
				//si se ingreso un caracter distinto a un número, o surge algún error
				}catch (InputMismatchException e) {
					System.out.println("Debe insertar una opción entre 1 y 5.");
					entrada.next();
				}
			}
		}
			
		public static double suma (double A,double B) {
			//truncar decimal "y"
			//NumberFormat nf = NumberFormat.getInstance();
			//Establecemos el numero de decimales
			//nf.setMaximumFractionDigits(10);
			//Convertimos el numero
			//String st=nf.format(A+B);
			//lo vuelves a convertir a double
			//valor decimal de y
			//double respuesta = Double.parseDouble(st);
			double respuesta=(A+B);
			return respuesta;
		}
		public static double resta (double c, double d){
			//truncar decimal "y"
			//NumberFormat nf = NumberFormat.getInstance();
			//Establecemos el numero de decimales
			//nf.setMaximumFractionDigits(10);
			//Convertimos el numero
			//String st=nf.format(c-d);
			//lo vuelves a convertir a double
			//valor decimal de y
			//double respuesta = Double.valueOf(st);
			double respuesta =(c-d);
          	return respuesta;
		}

		public static double pow(double j, double k){
			double potencia=0;
			double x=0;
			double nro=j;
			boolean aux=false;
			
			if (k<0){
				k=Math.abs(k);
				aux=true;
			}
			if (j>0){
			//si base es positiva
			for(int i=0; i<k-1; i++){
				x=0;
				potencia=0;
				while(x<j){
				potencia=multiplicacion(j,nro);
				x++;
				}
				nro=potencia;
			}

			}else{
				if(j<0){
					//si base es negativa
					for(int i=0; i<k-1; i++){
						x=0;
						potencia=0;
						while(x>j){
							potencia=multiplicacion(j,nro);
							x--;
						}
						nro=potencia;
					}
				}
			}
			if (aux==true){
				potencia=division(1,potencia);
			}
			return potencia;
		}
		public static double multiplicacion(double x, double y){
			int i=0;
			double mult=0;
			double valor=0;
			double dou=0;
			//multiplica "y" parte entera
			if (y>0){
				while(i<(int)y){
					mult= suma(mult,x);
					i++;
				}
			}else{
				if (y<0){
					while(i>(int)y){
						mult= resta(mult,x);
						i--;
					}
				}
			}
			
			//multiplica parte decimal de "y"
			if (y!=(int)y){
				//saca parte decimal
				dou=resta(y,(int)y);
				
				//multiplica parte decimal
				//divide parte decimal por 1, y x por su valor...
				valor=division(1,dou);
				//System.out.println("valor "+valor);
				dou=division(x,valor);
				//System.out.println("dou "+dou);
			}
			mult=mult+dou;
			return mult;
		}
		public static double division (double a, double b){

			double cont=0;
			double valor=0;
			double resultado=0;
			double div=0;
			double nro=0;
			String total="";
			
			if (b==0){
				System.out.print("No se puede dividir.");
			}else{
				if(a!=0){

					double dou=resta(b,(int)b);
					//saca los nros decimales, convirtiendo a nros enteros
					while (dou!=0){
						b=multiplicacion(b,10);
						a=multiplicacion(a,10);
						dou=resta(b,(int)b);
						cont++;
						if (cont>15){
							dou=0;
						}
					}
					cont=0;
					dou=resta(a,(int)a);
					while (dou!=0){
						b=multiplicacion(b,10);
						a=multiplicacion(a,10);
						dou=resta(a,(int)a);
						cont++;
						if (cont>15){
							dou=0;
						}
					}
					cont=0;
					//divide parte entera
					while ((resta(a,valor))>=b){
						valor=suma(valor,b);
						cont++;
					}
					
					//resultado division parte entera					
					resultado=cont;
					cont=0;
					
					//division de decimales					
					if (resta(a,valor)>0){
						//asigna resultado a string total
						total=String.valueOf((int)resultado)+".";
						div=resta(a,valor);
						div=multiplicacion(div,10);
						
						//mientras el resto no sea 0
						while(div>0){
							valor=0;
							cont=0;
							//divide el resto
							while ((resta(div,valor))>=b){
								valor=suma(valor,b);
								//resultado de division
								cont++;
							}
							//calcula el siguiente resto
							div=resta(div,valor);
							div=multiplicacion(div,10);
							//asigna a total
							total=total.concat(String.valueOf((int)cont));
							//trunca a hay 15 decimales.
							if (total.length()==20){
								div=b;
							}
						}
						resultado=Double.valueOf(total);
					}
				}else{
					resultado=0;
				}
			}
			return resultado;
	}
