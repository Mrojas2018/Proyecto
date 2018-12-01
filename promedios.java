import java.util.Scanner;

public class promedios {

	public static void main(String[] args) {
		// Declaración de variables
				int N; int M; int P;
				double acumulador=0; 
				double promedioAlumno=0; 
				double promedioCurso=0;
				boolean salir=false;
				double contador=0;
				String aux;
				int op;
				double ponderacion=0;
				
				// Entrada de datos 
				Scanner sc=new Scanner(System.in);
				
				// Lectura nivel del Curso
				System.out.print("Ingrese cantidad de cursos ");
				P = sc.nextInt();
				
				// Lectura cantidad de Alumnos. Debe ser Positivo
				do {
					System.out.print("Ingrese cantidad de alumnos del curso ");
					N = sc.nextInt();
				}	while (N <= 0);
				
				// Lectura número de Notas. Debe ser Positivo
				do {
					System.out.print("Ingrese el número de Notas ");
					M = sc.nextInt();
					aux=sc.nextLine();
				}	while (M <= 0);
				
				
				// Creación de matriz tridimensional	
				String A[][][] = new String [P][N+1][M+1];
				int i;int j; int k;
				
				// Iteración del nivel del curso. Sólo ocupa 1 posición
				for (i=0; i<P ;i++) {  
					System.out.println("Ingrese Nivel del curso");
					//System.out.println("estoy en i"+i);
					A[i][0][0]=sc.nextLine();
				}
				
				for (i=0; i<P ;i++) {
					System.out.println("Curso "+A[i][0][0]);
					for (j=1; j<=N; j++) {  // Iteración cantidad de Alumnos
						//System.out.println("estoy en i "+i+","+j);
						System.out.print("Ingresar nombre de alumno: ");
						A[i][j][0]=sc.nextLine();

						for (k=1; k<=M; k++) {  // Iteración número de Notas

							//System.out.println("estoy en "+i+","+j+","+k);
							System.out.println("Ingresar Nota: "+(k)+" del alumno "+A[i][j][0]);
							A[i][j][k]=sc.nextLine();
						}
					}
				}				

				while(salir==false){
					System.out.println("¿Que desea hacer...?"+"\n"+"	1)Calcular la media por curso"+"\n"+"	2)Calcular la media por alumno");
					op=sc.nextInt();

					//imprimir datos
					//seleccionar curso
					System.out.println("Seleccione curso:");
					for (i=0; i<P ;i++){
						System.out.println((i+1)+") "+A[i][0][0]);
						
					}
					
					i=(sc.nextInt())-1;

					//si seleciona por alumno, pregunta que alumno desea seleccionar del curso
					if (op==2){

						System.out.println("Seleccione alumno:");
						for (j=1; j<=N; j++) {
							System.out.println(j+") "+A[i][j][0]);
						}
							j=sc.nextInt();
							contador=0;
							acumulador=0;
							System.out.println("¿Dese ponderar las notas?"+"\n"+"	1)Si"+"\n"+"	2)No");
							op=0;
							op=sc.nextInt();
							for (k=1; k<=M; k++){
								if (op==1){
									if (k!=M){
									System.out.println("Ingrese poderación nota N°"+k+" (en porcentaje)");
									ponderacion=sc.nextDouble();
									contador=contador+ponderacion;
									}else{
										//saca última ponderacion para el 100%
										ponderacion=100-contador;
										System.out.println("Ponderacion "+k+" nota es "+ponderacion);					
									}
									//calcula la ponderacion de las notas
									ponderacion=ponderacion*(Double.valueOf(A[i][j][k]));
									acumulador = acumulador+(ponderacion/100);
									System.out.println(acumulador);
									promedioAlumno=acumulador;
								}else{
									if (op==2){
										acumulador = acumulador + Double.valueOf(A[i][j][k]);
										contador=contador+1;
										promedioAlumno=acumulador/contador;
									}
								}
							}
							
							System.out.println("El promedio del alumno "+A[i][j][0]+" es "+promedioAlumno);
							
						}else{
						//si selecciona todo el curso
						if(op==1){
							contador=0;
							acumulador=0;
							for (j=1; j<=N; j++) {
								for (k=1; k<=M; k++){
								acumulador = acumulador + Double.valueOf(A[i][j][k]);
								contador=contador+1;
								}
							}
							promedioCurso=acumulador/contador;
							System.out.println("El promedio del curso:"+A[i][0][0]+" es "+promedioCurso);
						}
					}
				}
	}
}
