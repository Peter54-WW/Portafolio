package datos.unidad1.genericos;

public abstract class Producto<T>{
	protected String nombre;
	protected Double precio;
	protected T extra;

	protected Producto(String nombre, double precio, T extra){
		this.nombre = nombre;
		this.precio = precio;
		this.extra = extra;
	}

	public String getNombre(){
		return nombre;
	}

	public Double getPrecio(){
		return precio;
	}

	public T getExtra(){
		return extra;
	}

	public abstract void mostrarDetalles();
}