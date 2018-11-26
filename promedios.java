import java.util.Scanner;
public class PromedioCalculadora {

	
	// Subrutina para el ingreso de datos
	
	public static void RegistroDatos(String Cursos[], double Notas[], String Alumnos[], Scanner intro) {
		
		for (int k=0; k<Cursos.length; k++) {
			System.out.print("Ingrese el curso ");
			Cursos[k]= intro.next();
		}
		
		for (int i=0; i<Alumnos.length; i++) {
			System.out.print("Ingrese el nombre del alumno ");
			Alumnos[i]= intro.next();
		}
		
		for (int j=0; j<Notas.length; j++) {
			System.out.print("Ingrese las notas ");
			Notas[j]= intro.nextDouble();
		}
	}
	
	// Subrutinas para calculo de promedios
	
	public static double PromedioN(double Notas[], String Alumnos[]) {
		double promAlumno;
		Suma=0;
		for (int i=0; i<Notas.length; i++) {  
			suma = suma + Notas[i];
			promAlumno= suma / Notas.length;  //promedio de notas por alumno???
		}
		return promAlumno;
	}
	
	public static double PromedioC(double PromedioAlumnos[], String Alumnos[]) { //declarar arreglo de promedio de notas de alumnos
		double promCurso;
	
		for (int j=0; j<PromedioAlumnos.length; j++) {  //crear arreglo con promedios de cada alumno para sacar promedio del curso
		suma = suma + PromedioAlumnos[j];
		promCurso= suma / PromedioAlumno.length;  //promedio de notas por Curso???
		}
		return promCurso;
	}
	
	
	
	//Programa Principal
	
	public static void main(String[] args) {
		Scanner intro = new Scanner(System.in);
		
		String Cursos[]; //Revisar tipo de variable
		double Notas[];
		String Alumnos[];
		int P;
		int N;
		int M;
		double PromedioCurso;
		double PromedioAlumno;
		double SumaDatos;
		
		System.out.print("Ingrese el nivel del curso ");
		P = intro.nextInt();
		
		System.out.print("Ingrese la cantidad de alumnos ");
		N = intro.nextInt();
		
		System.out.print("Ingrese el número de notas ");
		M = intro.nextInt();
		
		Cursos = new String[P];
		Alumnos = new String[N];
		Notas = new double[M];

		RegistroDatos(Cursos, Notas, Alumnos, intro);
		
		
		
	}

}
