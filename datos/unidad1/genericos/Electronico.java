package datos.unidad1.genericos;

public class Electronico extends Producto<String>{
	public Electronico(String nombre, double precio, String garantia){
		super(nombre, precio, garantia);
	}

	public void mostrarDetalles(){
		String datos = "Nombre: " + super.nombre + "\nPrecio: " + super.precio + "\nGarantia: " + super.getExtra();
		System.out.println(datos);
	}
}