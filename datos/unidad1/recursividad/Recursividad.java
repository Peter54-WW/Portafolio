package datos.unidad1.recursividad;
public class Recursividad {
	
	public static void saludo(int total, String nombre) {
	
	if(total <= 0)
		return;
	else{
		System.out.println("Hola " + nombre);
		saludo(total-1, nombre);
	}
	
	}

	/**
	*Funcion que realiza cuenta regresiva de acuerdo a un 
	*valor entero
	*Fecha: 25 de septiembre
	*
	*/

	public static void cuentaRegresiva(int n){
		if(n < 1){
			return;
		}else{
			System.out.println(n + " ");
			cuentaRegresiva(n-1);
		}
	}

	
	public static int sumaRecursivia(int[] data, int longitud){
		if(longitud <= 0){
			return 0;
		} else {
			return data[longitud-1] + sumaRecursivia(data, longitud - 1);
		}
	}
	
	public static void main(String[] args){
		//saludo(100, "Pedro");
		//cuentaRegresiva(100);
		int[] data = {3,4,5,6,7,8};
		System.out.println(sumaRecursivia(data, data.length));
	}

}