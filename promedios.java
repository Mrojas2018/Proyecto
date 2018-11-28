import java.util.Scanner;
public class matriz_tri {

	public static void main(String[] args) {


// Declaración de variables
		int N; int M; int P; int sumadatos;
		double acumulador; int sumanotas;
		double promedioAlumno; double promedioCurso;
		double sumapromAlumnos;
		
// Creación de matriz tridimensional	
		double A[][][] = new double [P][N][M];
		
// Entrada de datos 
	// Lectura nivel del Curso
		System.out.print("Ingrese el nivel del curso ");
		P = sc.next();
		
	// Lectura cantidad de Alumnos. Debe ser Positivo
		do { 
			System.out.print("Ingrese cantidad de alumnos del curso ");
			N = sc.nextInt();
		}	While (N <= 0);
		
	// Lectura número de Notas. Debe ser Positivo
		do {
			System.out.print("Ingrese el número de Notas ");
			M = sc.nextInt();
		}	While (M <= 0);
		
	// LLenado de Datos en Matriz
		
		for (int i=0; i<1 ;i++) {  // Iteración del nivel del curso. Sólo ocupa 1 posición
			sumanotas = 0;
		
			for (int j=0; j<N.length; j++) {  // Iteración cantidad de Alumnos
				acumulador = 0;
				
				for (int k=0; k<M.length; k++) {  // Iteración número de Notas
					acumulador = acumulador + A[i][j][k];
					
					
				sumanotas = sumanotas + (acumulador/k);
				promedioAlumno = (sumanotas/k.length);
				sumadatos = i.length + j.length + k.length;
				promedioCurso = (sumapromAlumnos/j.length);
				
	 // Falta imprimir resultados	
	}

}
