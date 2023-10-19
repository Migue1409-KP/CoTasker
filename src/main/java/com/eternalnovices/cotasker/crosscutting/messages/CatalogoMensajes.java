package com.eternalnovices.cotasker.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import com.eternalnovices.cotasker.crosscutting.exception.concrete.CrosscuttingCoTaskerException;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CategoriaMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.CodigoMensaje;
import com.eternalnovices.cotasker.crosscutting.messages.enumerator.TipoMensaje;
import com.eternalnovices.cotasker.crosscutting.util.UtilObjeto;

public class CatalogoMensajes {
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No se recibió el codigo del mensaje que se queria crear. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible obtener un mensaje con un código vacío o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema inesperado tratando de llevar a cabo la opereación deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta, la conexión se encontraba nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000008, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cerrar la conexión SQL. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000012, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción, la transacción ya ha sido inciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de iniciar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000017, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción, la transacción ya ha sido confirmada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de confirmar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción SQL, la conexión esta nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000022, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción, la conexión no se encontraba abierta"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción, la transacción ya ha sido confirmada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción. Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de cancelar la transacción. Se presento una excepcion inesperada. Por favor verifique la traza del error presentado..."));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de conectar con la base de datos. Motor de base de datos que se trata de conectar no usado por la app..."));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de establecer la coneccion con el servidor.Por favor verifique la traza del error presentado...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000301, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del tipo de identificación deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000302, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000303, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de prepar la consulta por id un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000304, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de un tipo identificación en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000305, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000306, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000307, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de insertar un dato en la base de datos..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000308, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insetart el cliente deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000309, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un cliente en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000310, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un cliente en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000311, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del cliente deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000312, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id un cliente en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000313, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id un cliente en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000317, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del cliente deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000318, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en ClienteDAO tratando de consultar clientes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000319, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en ClienteDAO tratando de consultar clientes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000321, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en ClienteDAO tratando de consultar clientes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000322, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en ClienteDAO tratando de consultar clientes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000323, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el cliente deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000324, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un cliente en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000325, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un cliente en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000326, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del cliente deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000327, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id un cliente en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000328, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id un cliente en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
	}
	
	
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		
		if(UtilObjeto.esNulo(codigo)) {
			var  mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var  mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000003);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		if(!MENSAJES.containsKey(codigo)) {
			var  mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000000004);
			var  mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000000002);
			throw CrosscuttingCoTaskerException.crear(mensajeUsuario, mensajeTecnico);			
		}
		
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
