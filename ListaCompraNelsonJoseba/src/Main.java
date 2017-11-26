import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * CLASE MAIN
 * @author Joseba Hernando
 * @author Nelson Paramo
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		int opcion;
		int opcion2;
		int ids = 0;

		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println("BIENVENIDO A SU SOFTWARE PARA REALIZAR LA LISTA DE LA COMPRA");
			System.out.println("-------------------------------------------------------------");
			System.out.println("	  ESCOGE UNA OPCION");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+   1.-HACER LISTA DE LA COMPRA        +");
			System.out.println("+   2.-BORRAR LISTA CREADA             +");
			System.out.println("+   3.-EJEMPLO LISTA DE LA COMPRA      +");
			System.out.println("+   4.-AYUDA                           +");
			System.out.println("+   5.-SALIR DEL PROGRAMA              +");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			opcion = teclado.nextInt();
			try {
				switch (opcion) {
				case 1: {
					System.out.println("Para mantener la persistencia, este programa almacenara la lista");
					System.out.println("de la compra en un fichero, por lo que el primer paso sera");
					System.out.println("introducir un nombre para el archivo, si este nombre ya existe, ");
					System.out.println("se podra actualizar la lista de la compra.");
					String fichero = "";
					fichero = teclado.next();
					Lista lista = new Lista(fichero);
					do {
						System.out.println("");
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						System.out.println("+  1.-Introducir un producto           +");
						System.out.println("+  2.-Modificar un producto            +");
						System.out.println("+  3.-Borrar un producto               +");
						System.out.println("+  4.-Marcar un producto como comprado +");
						System.out.println("+  5.-Vaciar lista de la compra        +");
						System.out.println("+  6.-Mostrar lista de la compra       +");
						System.out.println("+  7.-Salir                            +");
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						System.out.println("        ESCOGE UNA OPCION        ");
						System.out.println("");
						opcion2 = teclado.nextInt();
						try {
							switch (opcion2) {
							case 1:
								System.out.println("Introduce el nombre del producto:");
								Scanner reader = new Scanner(System.in);
								String nombre = reader.next();
								System.out.println("Introduce la unidad de medida(kg, brick, unidades):");
								Scanner reader2 = new Scanner(System.in);
								String medida = reader2.next();
								System.out.println("Introduce la cantidad:");
								Scanner reader3 = new Scanner(System.in);
								int cantidad = reader3.nextInt();
								System.out.println("Introduce el precio:");
								Scanner reader4 = new Scanner(System.in).useLocale(Locale.US);
								double precio = reader4.nextDouble();
								ids++;
								lista.comprobarIdsRepetidos(ids);
								Producto producto = new Producto(nombre, precio, false, cantidad, ids, medida);
								lista.anadirLista(producto, fichero);
								break;
								
							case 2:
								lista.verLista();
								System.out.println("");
								System.out.println("Introduce el id del producto que quieres modificar:");
								Scanner reader5 = new Scanner(System.in);
								int id = reader5.nextInt();
								System.out.println("Introduce el nombre del producto:");
								Scanner reader6 = new Scanner(System.in);
								String nombreModificar = reader6.next();
								System.out.println("Introduce la unidad de medida(kg, brick, unidades):");
								Scanner reader7 = new Scanner(System.in);
								String medidaModificar = reader7.next();
								System.out.println("Introduce la cantidad:");
								Scanner reader8 = new Scanner(System.in);
								int cantidadModificar = reader8.nextInt();
								System.out.println("Introduce el precio:");
								Scanner reader9 = new Scanner(System.in).useLocale(Locale.US);
								double precioModificar = reader9.nextDouble();
								System.out.println(precioModificar);
								lista.modificarProducto(nombreModificar, medidaModificar, cantidadModificar,
										precioModificar, id);
								lista.actualizarFichero(fichero);
								break;
								
							case 3:
								lista.verLista();
								System.out.println("");
								System.out.println("Introduce el id del producto que quieres borrar:");
								Scanner readerBorrar = new Scanner(System.in);
								int idBorrar = readerBorrar.nextInt();
								lista.borrarProducto(idBorrar, fichero);
								lista.actualizarFichero(fichero);
								break;
								
							case 4:
								lista.verLista();
								System.out.println("");
								System.out.println("Introduce el id del producto que quieres marcar como comprado o no comprado:");
								Scanner readerComprado= new Scanner(System.in);
								int idComprado = readerComprado.nextInt();
								lista.marcarComprado(idComprado);
								lista.actualizarFichero(fichero);
								break;
								
							case 5:
								System.out.println("");
								System.out.println("Estas seguro que deseas vaciar la lista?");
								System.out.println("Introduce el 1 para confirmar.");
								Scanner readerVaciar = new Scanner(System.in);
								int confirmacion = readerVaciar.nextInt();
								if (confirmacion == 1) {
									lista.vaciarLista();
									lista.actualizarFichero(fichero);
								}
								break;
								
							case 6:
								System.out.println("Mostrando la lista de la compra:");
								lista.verLista();
								System.out.println("");
								break;
								
							case 7:
								break;
								
							default:
								System.out.println("OPCION NO VALIDA!! TIENE QUE SER NUMERO COMPRENDIDO ENTRE 1 Y 7 POR FAVOR");
							}
							
						} catch (InputMismatchException e) {
							System.out.println("OPCION NO VALIDA!! INSERTA UN NUMERO POR FAVOR");
							teclado.next();
						}

					} while (opcion2 != 7);
					break;
				}
				case 2: {
					System.out.println("Introduce el nombre del fichero que desea borrar:");
					String nombre = teclado.next();
					File fichero = new File(nombre);
					if (fichero.delete())
						System.out.println("El fichero se ha borrado correctamente.");
					else
						System.out.println("El fichero no se he encuentra, o no puede ser borrado.");
					System.out.println("-------------------------------------------------------------");
					System.out.println("");
					break;
				}
				
				case 3: {
					System.out.println("EJEMPLO DE LISTA DE LA COMPRA CON PRODUCTOS");
					System.out.println("-El primer parametro sera el ID del producto");
					System.out.println("-El segundo parametro sera el NOMBRE del producto");
					System.out.println("-El tercer parametro sera la CANTIDAD (y su unidad de medida) del producto");
					System.out.println("-El cuarto parametro sera si el producto esta COMPRADO (TRUE) O NO (FALSE)");
					System.out.println("");
					System.out.println("         1. -PERAS, 1kg, false");
					System.out.println("         2. -MANZANAS, 5kg, true");
					System.out.println("         3. -LIMONES, 1.5kg, false");
					System.out.println("         4. -NARANJAS, 3kg, false");
					System.out.println("");
					System.out.println("-------------------------------------------------------------");
					break;
				}
				
				case 4: {
					System.out.println("BIENVENIDO AL MANUAL DE LA APLICACION");
					System.out.println("");
					System.out.println("En el menu principal podremos selecionar cinco opciones:");
					System.out.println("");
					System.out.println("-En la opcion 1 (HACER LISTA DE LA COMPRA) lo primero que nos pedira es un fichero de texto donde\n"+
										"se almacenaran nuestros productos. Si el fichero no existe nos creara uno nuevo, y si existe\n" +
										"se actualizara. Dentro de esta opcion tendremos 7 opciones diferente.\n" +
										"         -INTRODUCIR PRODCUTO: Añadimos producto con su nombre, unidad de medida, cantidad y precio.\n"+
										"         -MODIFICAR PRODUCTO : Modificar el nombre, unidad de medida, cantidad, precio de un producto.\n"+
										"         -BORRAR PRODUCTO    : Borraremos un producto que no queremos de nuestra lista.\n"+
										"         -MARCAR COMPRADO    : Marcar un prodcuto como comprado (true) o no comprado (false).\n"+
										"         -VACIAR LISTA       : Vaciaremos la lsita de la compra, previa confirmacion.\n"+
										"         -MOSTRAR LISTA      : Mostraremos la lista actual de la compra.");
					System.out.println("");
					System.out.println("-En la opcion 2 (BORRAR LISTA CREADA) podremos borrar una lista creada previamente");
					System.out.println("");
					System.out.println("-En la opcion 3 (EJEMPLO LISTA COMPRA) nos mostrara los parametros que contiene el fichero de una compra.");
					System.out.println("");
					System.out.println("-En la opcion 4 (AYUDA) nos ayudara a entender cada opcion del programa.");
					System.out.println("");
					System.out.println("-En la opcion 5 (SALIR) saldremos del programa.");
					System.out.println("");
					System.out.println("-------------------------------------------------------------");
					break;
				}
				
				case 5: {
					System.out.println("HASTA PRONTO!!");
					break;
				}
				
				default:
					System.out.println("Introduce un numero entre 1 y 3");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("OPCION NO VALIDA!! INSERTA UN NUMERO POR FAVOR");
				teclado.next();
			}
			
		} while (opcion != 5);

	}
}