/**
 * CLASE PRODUCTO
 * @author Joseba Hernando
 * @author Nelson Paramo
 *
 */
public class Producto {
	/**
	 * Nombre del producto
	 */
	private String nombre;
	
	/**
	 * Precio del producto
	 */
	private double precio;
	
	/**
	 * Cantidad del producto
	 */
	private int cantidad;
	
	/**
	 * Id del producto
	 */
	private int idProducto;
	
	private String medida;
	
	private boolean comprado;
	/**
	 * Constructor vacio del producto
	 */
	public Producto(int ids) {
		this.idProducto = ids;
	}
	
	/**
	 * Constructor del producto
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */
	public Producto(String nombre, double precio,boolean comprado, int cantidad,int ids,String medida) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.medida = medida;
		this.idProducto = ids;
		this.comprado=comprado;
	}
	
	/**
	 * Clase para modificar el nombre del producto
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setMedida(String medida) {
		this.medida = medida;
	}
	
	public String getMedida() {
		return medida;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	public boolean getComprado() {
		return comprado;
	}

}
