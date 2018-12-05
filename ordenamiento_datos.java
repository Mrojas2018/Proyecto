
import java.util.Scanner;
import java.util.InputMismatchException;
public class ordenamiento_de_datos {

	public static void main (String []args) {
		//El siguiente código permite ordenar una serie de números "N" según determine el usuario.
		Scanner entrada=new Scanner(System.in);
		int N = 0;
		int M=0;
		int i;int j;
		int aux;
		int opcion;
		boolean salir=false;
		boolean salida=false;
		String auxiliar;
		try{
			while(!salida){
				
			System.out.println("Ingrese total de datos a leer: ");//Aquí determinamos la cantidad de datos a ordenar
			N=entrada.nextInt();
			System.out.println("¿Que desea ordenar?"+"\n"+" 1)Números"+"\n"+" 2)Textos");
			opcion=entrada.nextInt();
			auxiliar=entrada.nextLine();
			switch (opcion){
			
				case 1://creacion de arreglo int para nros
					int arreglo[]=new int[N];
		
				for(i=0; i<N; i++){
					System.out.print("X[" +(i+1)+ "] = " );
					arreglo[i]=entrada.nextInt();
				}
				while(!salir){
				
						System.out.print("¿Cómo desea ordenar?: " + "\n" + "(1) Ascendente " + "\n" + "(2) Descendente"+ "\n");
						M=entrada.nextInt();
						switch (M){
						//Aquí determinamos de manera ascendente el ordenamiento
						case 1:	for(i=0; i<N; i++){
									for(j=i+1; j<N; j++){
										if(arreglo[i]>arreglo[j]){
											aux=arreglo[i];
											arreglo[i]=arreglo[j];
											arreglo[j]=aux;
										}
									}
								}
							System.out.print("Arreglo {");
							for(i=0; i<N; i++){
								System.out.print(arreglo[i] + " , ");
							}
							System.out.print("}");	
							salir=true;
							break;
					case 2: //Aquí determinamos de manera descendente el ordenamiento de nros
							for(i=0; i<N; i++){
								for(j=i+1; j<N; j++){
									if(arreglo[i]<arreglo[j]){
										aux=arreglo[i];
										arreglo[i]=arreglo[j];
										arreglo[j]=aux;
									}	
								}
							}
							System.out.print("Arreglo {");
								for(i=0; i<N; i++){
									System.out.print(arreglo[i] + " , ");
								}
							System.out.print("}");	
							salir=true;
							break;
						
					default:System.out.println("ingrese opción válida" ); // Permite retornar nuevamente a la pregunta de como ordenar los datos en caso de ingresar una opción incorrecta
							entrada.next();
							break;					
						}
				
				}
				break;
			
				case 2://creacion de arreglo string, para ingresar textos
					String arreglo1[]=new String[N];
			 		for(i=0; i<arreglo1.length; i++) {
			 			System.out.println("ingrese texto: "+(i+1));
			 			arreglo1[i] = entrada.nextLine();
			 		}
			 		System.out.print("¿Cómo desea ordenar?: " + "\n" + "(1) Ascendente " + "\n" + "(2) Descendente"+ "\n");
					M=entrada.nextInt();
					switch (M){

					case 1:
					// Inicio del metodo de ordenamiento de la Burbuja
			 		for(i=1; i<=arreglo1.length; i++) {
			 			for(j=0; j<arreglo1.length-i; j++) {
			 				if( arreglo1[j].compareTo( arreglo1[j+1] ) > 0 ) {
			 					auxiliar= arreglo1[j];
			 					arreglo1[j]  = arreglo1[j+1];
			 					arreglo1[j+1]= auxiliar;
			 				}
			 			}
			 		}
			 		// Fin del metodo de ordenamiento de la Burbuja	
			 		break;
					case 2:
						// Inicio del metodo de ordenamiento de la Burbuja
						for(i=1; i<=arreglo1.length; i++){
							for(j=0; j<arreglo1.length-i; j++){
								if( arreglo1[j].compareTo( arreglo1[j+1] ) < 0 ) {
									auxiliar= arreglo1[j];
									arreglo1[j]  = arreglo1[j+1];
									arreglo1[j+1]= auxiliar;
								}
							}
						}
						// Fin del metodo de ordenamiento de la Burbuja	
						break;
					default:System.out.println("Opcion no válida");
					break;
					}
			 		//Mostrar Ordenamiento de datos
			 		for(i=0; i<arreglo1.length; i++) 
			 		{System.out.println( " A[" + (i+1) + "] = " + arreglo1[i] ); }
			 		break;
			 		
				default:System.out.println("Dato no válido");
					break;
				}	
			System.out.println("¿Que desea hacer?.."+"\n"+"   1)Ingresar Datos nuevamente"+"\n"+"   2)Volver");
			opcion=entrada.nextInt();
			switch (opcion){
			case 1: break;
			case 2: salida=true;
					break;
			default: System.out.println("Dato incorrecto");
				break;
			}
			}
		}catch (InputMismatchException e) { // errores
					System.out.println("Ingrese opción válida");
					entrada.next();
		}
	}		
}
