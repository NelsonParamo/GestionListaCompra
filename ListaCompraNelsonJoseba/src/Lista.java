
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLASE LISTA
 * @author Joseba Hernando
 * @author Nelson Paramo
 */
public class Lista {

	private File fichero;

	private List<Producto> lista;

	public Lista(String nombre) throws FileNotFoundException {
		fichero = new File(nombre);
		lista = new ArrayList<Producto>();
		abrirFichero();
	}

	private void abrirFichero() throws FileNotFoundException {
		Scanner lectura = null;
		try {
			
			lectura = new Scanner(fichero);
			while (lectura.hasNextLine()) {
				String linea = lectura.nextLine();
				String[] atributos = linea.split(",");

				int id = Integer.parseInt(atributos[0]);
				String nombre = atributos[1];
				int cantidad = Integer.parseInt(atributos[2]);
				String medida = atributos[3];
				double precio = Double.parseDouble(atributos[4]);
				boolean comprado = Boolean.parseBoolean(atributos[5]);
				Producto producto = new Producto(nombre, precio, comprado, cantidad, id, medida);
				lista.add(producto);
				
			}

		} catch (Exception e) {
			System.out.println("Se ha creado el archivo : " + fichero);
		} finally {
			try {
				if (lectura != null)
					lectura.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	public void anadirLista(Producto producto, String fichero) {
		FileWriter fich = null;
		lista.add(producto);
		try {
			fich = new FileWriter(fichero, true);
			fich.write(producto.getIdProducto() + "," + producto.getNombre() + "," + producto.getCantidad() + ","
					+ producto.getMedida() + "," + producto.getPrecio() + "," + producto.getComprado() + "\n");
			fich.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}

	}
	
	public void verLista() {
		double total=0;
		for (Producto producto : lista) {
			System.out.println(producto.getIdProducto() + ".-" + producto.getNombre() + ", " + producto.getCantidad()
					+ producto.getMedida() + ", " + producto.getComprado());
			total=total+(producto.getCantidad()*producto.getPrecio());
		}
		System.out.println("Total: "+total+"€");
	}

	public void borrarProducto(int id, String fichero) {
		Producto productoBorrar = null;
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				productoBorrar = producto;
			}
		}
		if (productoBorrar != null) {
			lista.remove(productoBorrar);
		}
	}

	public void actualizarFichero(String fichero) {
		File f = new File(fichero);
		f.delete();
		if (!lista.isEmpty()) {
			for (Producto producto : lista) {
				FileWriter fich = null;
				try {
					fich = new FileWriter(fichero, true);
					fich.write(producto.getIdProducto() + "," + producto.getNombre() + "," + producto.getCantidad()
							+ "," + producto.getMedida() + "," + producto.getPrecio() + "," + producto.getComprado()
							+ "\n");
					fich.close();
				} catch (Exception ex) {
					System.out.println("Mensaje de la excepcion: " + ex.getMessage());
				}
			}
		} else {
			try {
				FileWriter fich = new FileWriter(fichero, true);
				fich.close();
			} catch (Exception ex) {
				System.out.println("Mensaje de la excepcion: " + ex.getMessage());
			}
		}
	}

	public void modificarProducto(String nombreModificar, String medidaModificar, int cantidadModificar,
			double precioModificar, int id) {
		Producto productoModificar = null;
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				productoModificar = producto;
			}
		}
		if (productoModificar != null) {
			productoModificar.setNombre(nombreModificar);
			productoModificar.setMedida(medidaModificar);
			productoModificar.setCantidad(cantidadModificar);
			productoModificar.setPrecio(precioModificar);
		}
	}

	public void vaciarLista() {
		lista = new ArrayList<Producto>();
	}

	public void marcarComprado(int id) {
		Producto productoMarcado = null;
		for (Producto producto : lista) {
			if (producto.getIdProducto() == id) {
				productoMarcado = producto;
			}
		}
		if (productoMarcado != null) {
			if(productoMarcado.getComprado()==false){
				productoMarcado.setComprado(true);
			}else{
				productoMarcado.setComprado(false);
			}
		}
	}
	public int comprobarIdsRepetidos(int id){
		List<Integer> idsCogidos = new ArrayList<Integer>();
		for (Producto producto : lista) {
			idsCogidos.add(producto.getIdProducto());
		}
		while(idsCogidos.contains(id)){
			id++;
		}
		return id;
	}
}
