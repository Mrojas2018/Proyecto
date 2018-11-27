import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

public class operaciones_binarias {
	
	//convierte decimal fraccionario a base x
	public static double dec_base(double valor,int base){
		
		double binario=0;
		double modulo=0;
		double resultado=0;
		int contador=0;
		
		//calcula el valor decimal exacto de valor fraccionario, mediante bigdecimal (tipo string)
		BigDecimal bg=new BigDecimal(String.valueOf(valor));
		//Extrae parte decimal de bigdecimal
		BigDecimal fPart = bg.remainder(BigDecimal.ONE);
		//transforma bigdecimal a double
		//valor de parte decimal
		double cantidad=fPart.doubleValue();
		
		int exp;
        exp=0;
        binario=0;
        while((int)valor!=0){
        		//calcula el resto del valor
                modulo = (int)(valor % base);               
                binario =(double) (binario+(modulo * Math.pow(10, exp)));  
                exp++;
                valor = valor/base;
        }
        
        resultado=binario;
		exp=-1;
		binario=0;
		//si es que tiene decimales
		if (cantidad>0){
			//mientras cantidad sea distinto de 1
			while (cantidad!=1){
				modulo=(int)(cantidad*base);
				binario= (double)(binario+(modulo*Math.pow(10, exp)));
				exp--;
				cantidad=cantidad*base;
				if (cantidad>1){
					cantidad=cantidad-1;
				}
				contador++;
				if (contador>15){
					cantidad=1;
				}
			}
		}
		resultado=resultado+binario;
		return resultado;
	}
	//convierte numero de base x, no fraccionario, a decimal
	public static int base_dec(int valor,int base){
		int modulo;
		int resultado;
		
		int exp=0;
		int decimal=0;
		
		while(valor>0){
			//saca cada dígito (de la unidad)
			modulo=valor%10;
			if (modulo>base){
				System.out.println("Número no válido");				
				resultado=-1;
				valor=0;
			}else{
				decimal=(int) (decimal+(modulo*Math.pow(base, exp)));
				exp++;
				valor=valor/10;
			}
		}
		
		resultado=decimal;
		return resultado;
	}
	//convierte decimal fraccionario a hexadecimal
	public static String dec_hex (double valor){
	
		String hex="";
		int modulo=0;
		String resultado="";
		int contador=0;
		//calcula el valor decimal exacto del valor, mediante bigdecimal (tipo string)
		BigDecimal bg=new BigDecimal(String.valueOf(valor));
		//Extrae parte decimal de bigdecimal
		BigDecimal fPart = bg.remainder(BigDecimal.ONE);
		//transforma bigdecimal a double
		//valor de parte decimal
		double cantidad=fPart.doubleValue();
	
        hex="";
        while((int)valor!=0){
                modulo = (int)(valor % 16);
                if (modulo>9){
                	switch(modulo){
                	case 10: hex=("A").concat(hex);
                		break;
                	case 11: hex=("B").concat(hex);
                		break;
                	case 12: hex=("C").concat(hex);
                		break;
                	case 13: hex=("D").concat(hex);
                		break;
                	case 14: hex=("E").concat(hex);
                		break;
                	case 15: hex=("F").concat(hex);
                		break;
                	}
                }else{
                hex =(String.valueOf(modulo)+hex);  
                }
                valor = valor/16;
        }
		resultado=hex;
		hex="";
		//si es que tiene decimales
		if (cantidad>0){
			//mientras cantidad sea mayor que 0
			while (cantidad>0){
				modulo=(int)(cantidad*16);
				  if (modulo>9){
					  //verifica cada string
	                	switch(modulo){
	                	case 10: hex=hex.concat("A");
	                		break;
	                	case 11: hex=hex.concat("B");
	                		break;
	                	case 12: hex=hex.concat("C");
	                		break;
	                	case 13: hex=hex.concat("D");
	                		break;
	                	case 14: hex=hex.concat("E");
	                		break;
	                	case 15: hex=hex.concat("F");
	                		break;
	                	}
	               }else{
	               hex =(hex+String.valueOf(modulo));  
	               }
				  
				cantidad=cantidad*16;
				
				//calcula el valor decimal exacto de cantidad, mediante bigdecimal (tipo string)
				bg=new BigDecimal(String.valueOf(cantidad));
				//Extrae parte decimal de bigdecimal
				fPart = bg.remainder(BigDecimal.ONE);
				//transforma bigdecimal a double
				//valor de parte decimal
				cantidad=fPart.doubleValue();
				contador=contador+1;
				if (contador>15){
					cantidad=0;
				}
			}
		}
		resultado=resultado+"."+hex;
		return resultado;
	
	}
	//convierte hexadecimal,no fraccionario, en decimal
	public static int hex_dec(String valor){
		String modulo;
		valor=valor.toUpperCase().trim();
		int suma=0;
		int exp=0;
		int largo=valor.length();
		
		while(largo>0){
			//saca cada letra del string (de la unidad)
			modulo=valor.substring(largo-1,largo);
			switch(modulo){
			case "0":suma=(int) (suma+(0*Math.pow(16, exp)));
					break;
			case "1": suma=(int) (suma+(1*Math.pow(16, exp)));
					break;
			case "2": suma=(int) (suma+(2*Math.pow(16, exp)));
					break;
			case "3":suma=(int) (suma+(3*Math.pow(16, exp)));
					break;
			case "4":suma=(int) (suma+(4*Math.pow(16, exp)));
					break;
			case "5":suma=(int) (suma+(5*Math.pow(16, exp)));
					break;
			case "6":suma=(int) (suma+(6*Math.pow(16, exp)));
					break;
			case "7":suma=(int) (suma+(7*Math.pow(16, exp)));
					break;
			case "8":suma=(int) (suma+(8*Math.pow(16, exp)));
					break;
			case "9":suma=(int) (suma+(9*Math.pow(16, exp)));
					break;
			case "A":suma=(int) (suma+(10*Math.pow(16, exp)));
					break;
			case "B":suma=(int) (suma+(11*Math.pow(16, exp)));
					break;
			case "C":suma=(int) (suma+(12*Math.pow(16, exp)));
					break;
			case "D":suma=(int) (suma+(13*Math.pow(16, exp)));
					break;
			case "E":suma=(int) (suma+(14*Math.pow(16, exp)));
					break;
			case "F":suma=(int) (suma+(15*Math.pow(16, exp)));
					break;
			default:System.out.println("Número hexadecimal no válido");
					suma=-1;
					largo=1;
					break;
			}
			largo--;
			exp++;
		}		
		return suma;
	}
	public static void cambio_base(){
		Scanner nro=new Scanner(System.in);
		int n1,n2,n3;
		int numero;
		System.out.println("Ingrese número a convertir:");
		n1=nro.nextInt();
		
		System.out.println("Ingrese su base:");
		n2=nro.nextInt();
		
		System.out.println("Ingrese base de número a convertir:");
		n3=nro.nextInt();

		numero= base_dec(n1,n2);
		
		if (n3==16){
			String resultado= dec_hex((double)n1);
			System.out.println("El número "+n1+" de base "+n2+" convertido a hexadecimal es "+resultado);
		}else{
			if(n3==10){
				System.out.println("El número "+n1+" de base "+n2+" convertido a decimal es "+numero);
			}else{
				numero=(int) dec_base(numero,n3);
				System.out.println("El número "+n1+" de base "+n2+" convertido a base "+n3+" es "+numero);
			}
		}
		
	}
	public static void binario(){
		Scanner nro= new Scanner(System.in);
		double suma=0;
		boolean salir=false;
		boolean aux=false;
		double a,b,respuesta;
		int op;
		while(!salir){
			try{
				
				System.out.println("Ingrese primer número decimal:");
				a= nro.nextDouble();

				System.out.println("Ingrese segundo número decimal:");
				b= nro.nextDouble();
				suma=a+b;
				
				System.out.println("La suma de los números decimales "+a+" y "+b+" es: "+suma);
				respuesta=dec_base(suma,2);
				System.out.println("Y su suma en binarios (base 2) es: "+respuesta+"\n");
				aux=false;
				
				while (!aux){
						System.out.println("¿Que desea realizar ahora?"+"\n"+"1) Sumar nuevamente"+"\n"+"2) Volver al menú anterior");
						op=nro.nextInt();
						switch(op){
						case 1: aux=true;
								break;
						case 2: aux=true;
								salir=true;
								break;
						default: System.out.println("Debe ingresar opción 1 o 2");
								 break;
						}
				}
				
			}catch (InputMismatchException e) {
				System.out.println("Error:Debe ingresar un valor válido");
				nro.next();			
			}
		}
		//nro.close();
	}

	public static void hexadecimal(){
		Scanner nro= new Scanner(System.in);
		double suma=0;
		boolean salir=false;
		boolean aux=false;
		String resp="";
		String total="";
		
		while(!salir){
			try{
				System.out.println("Ingrese número decimal");
				suma=suma+nro.nextDouble();
				while(!aux){
					System.out.println("Ingrese otro número decimal a sumar");
					suma=suma+nro.nextDouble();
					System.out.println("¿Desea sumar otro número?, (SI/NO)");
					resp=nro.next();
					resp=resp.toUpperCase().trim();
					switch(resp){
						case "SI":
							break;
						case "NO":
							total=dec_hex(suma);
							System.out.println("La suma total es: "+suma+", y sus suma en hexadecimal es: "+total);
							aux=true;
							salir=true;
							break;
						default:System.out.println("Debe ingresar SI o NO");
							nro.next();
							break;
					}
				}		
				
			}catch (InputMismatchException e) {
				System.out.println("Error:Debe ingresar un valor válido");
				nro.next();			
			}
		}
	}
	
	public static void main(String[] args) {
		
		boolean salir=false;
		boolean aux=false;
		double valor=0;
		double resultado=0;
		String hexadecimal="";
		Scanner entrada= new Scanner(System.in);	
		boolean op_1=false;
		while (!salir){
			int opcion=0;
			try{		
				aux=false;
				System.out.println("Elija una opción"+"\n"+"	1) Sumar 2 números decimales-binarios"+"\n"+
						"	2) Sumar decimales-hexadecimales"+"\n"+"	3) Cambio de base desde sistema numerico"+"\n"+
						"	4) Transformación de números"+"\n"+"	5) Volver");
				opcion=entrada.nextInt();
				switch(opcion){
					case 1: System.out.println("1) Ha seleccionado Sumar 2 números decimales-binarios");
						binario();
						break;
					case 2: System.out.println("2) Ha seleccionado Sumar decimales-hexadecimales");
						hexadecimal();
						break;
					case 3: System.out.println("3) Ha seleccionado cambio de base desde sistema numérico");
						cambio_base();
						break;
					case 4: System.out.println("4) Ha seleccionado transformación de números");
					
					while(!aux){
						op_1=false;
						System.out.println("Seleccione opción:"+"\n"+"	1) Desde número decimal a Binario"+"\n"+"	2) Desde número binario a decimal"+
						"\n"+"	3) Desde número decimal a Hexadecimal"+"\n"+"	4) Desde número Hexadecimal a Decimal"+"\n"+"	5) Volver");
						opcion=entrada.nextInt();
						switch(opcion){
							case 1: System.out.println("Ingrese un número decimal");
								valor=entrada.nextDouble();
								resultado=dec_base(valor,2);
								System.out.println("El número decimal "+valor+" en binario(base 2) es: "+resultado);
								break;
							case 2: System.out.println("Ingrese un número binario");
								valor=entrada.nextDouble();
								resultado=base_dec((int)valor,2);
								System.out.println("El número binario "+(int)valor+" en decimal (base 10) es: "+resultado);
								break;
							case 3: System.out.println("Ingrese un número decimal");
								valor=entrada.nextDouble();
								hexadecimal=dec_hex(valor);
								System.out.println("El número decimal "+valor+" en hexadecimal es: "+hexadecimal);
								break;
							case 4: System.out.println("Ingrese un número hexadecimal");
								hexadecimal=entrada.next();
								valor=hex_dec(hexadecimal);
								System.out.println("El número hexadecimal "+hexadecimal+" en decimal es: "+valor);
								break;
							case 5: aux=true;
									op_1=true;
								break;
							default:System.out.println("Debe seleccionar opción entre 1 y 5");
								break;
						}
						
						while(!op_1){
						System.out.println("¿Que desea realizar ahora?"+"\n"+"	1) Transformar otro valor"+"\n"+"	2) Volver");
						opcion=entrada.nextInt();						
						
							if (opcion==2){
								op_1=true;
							}else{
								if (opcion==1){
									aux=true;
									op_1=true;
								}else{
									System.out.println("Debe seleccionar la opción 1 o 2");
									entrada.next();
								}	
							}											
						}
					}
						break;
				case 5: salir=true;
						break;
				default: System.out.println("Debe seleccionar una opcion entre 1 y 5");
						break;
				}
				
			}catch (InputMismatchException e) {
				System.out.println("Error:Debe ingresar un valor válido");
				entrada.next();			
			}		
		}
		//entrada.close();
	}
}
