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
				"Se ha presentado un problema tratando de consultar por id un estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000304, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de un estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000305, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000306, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de insertar un tipo de identificación en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000307, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de insertar un dato en la base de datos..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000308, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000309, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000310, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar la prioridad en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000311, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema al consultar la prioridad deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000312, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id una prioridad en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000313, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una prioridaden la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000318, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000319, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000321, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000322, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en PrioridadDAO tratando de consultar prioridad.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000323, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000324, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000325, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar el estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado, el problema se presenta en estado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000326, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del estado de tarea deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000327, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id del estado de tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000328, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id del estado de tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000330, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar el el estado de una tarea por id, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000330, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar el el estado de una tarea por id. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000332, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del estado de tarea "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000333, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar el el estado de una tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000334, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar el el estado de una tarea. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000336, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar la consulta de un  estado de  tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000337, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de ejecutar la consulta de un  estado de  tarea por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000335, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de ejecutar la consulta la información del estado de tarea "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000338, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion colocar los parametros para una consulta  de un  estado de  tarea, el problema se presento en la base de datos . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000339, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion colocar los parametros para una consulta  de un  estado de  tarea. por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000340, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000341, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de crear un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000342, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de crear un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000344, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de modificar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000345, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de modificar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000343, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000346, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un usuario ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000347, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de eliminar  un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000348, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de eliminar un usuario . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000349, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar  un usuario por id ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000350, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar  un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000351, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar  un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000352, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar una consulta de un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000353, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de ejecutar una consulta de un usuario por id . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000354, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar  un usuario  ... "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000355, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000356, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000357, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de ejecutar la consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000358, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando ejecutar la consultar  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000359, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo SQLExepcion tratando de colocar los parametros de la consulta de un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000360, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exepcion tratando de colocar los parametros de la consulta de  un usuario  . por favor verificar traza del error "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000101, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insetar una asignación de un proyecto con un usuario"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000102, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000103, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000104, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000105, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000106, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar la relación entre un usuario y un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000107, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000108, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar un usuarioProyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000109, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar la relación entre un usuario y un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000110, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la relación entre un usuario y un proyecto deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000111, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de usuarioproyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000112, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de usuarioproyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000113, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de un usuarioproyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000114, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de un usuarioproyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000116, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000117, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000118, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000119, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000120, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000121, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar UsuarioProyectoDAO tratando de consultar usuariosproyectos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000122, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insetar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000123, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000124, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000125, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000126, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000127, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000128, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000129, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000130, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000131, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la tarae deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000132, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de una tarae en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000133, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de prepar la consulta por id de una tarae en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000134, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de una tarea en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000135, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una tarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000136, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000137, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000138, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en TareaoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000139, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000140, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000141, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en TareaoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000361, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La fecha de creación es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000362, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de prioridad es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000363, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripción de prioridad no es valida. La longitud maxima son 25 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000364, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de prioridad es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000365, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de prioridad solo puede contener letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000366, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de estado es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000367, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripción de estado no es valida. La longitud maxima son 25 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000368, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de estado es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000369, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripción de estado solo puede contener letras"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000370, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase FechasEntityMapper.No es posible mapear las fechas dominio a partir de una entidad de fechas entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000371, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase FechasEntityMapper.No es posible mapear las fehas entity a partir de una entidad de fechas dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000372, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase PrioridadEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000373, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase PrioridadEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000374, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase EstadoEntityMapper.No es posible mapear un estado dominio a partir de una entidad de un estado entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000375, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase EstadoEntityMapper.No es posible mapear un estado entity a partir de una entidad de un estado dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000376, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de proyecto  es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000377, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre del proyecto  no es valida. La longitud maxima son 30 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000378, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del proyecto solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000379, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre del proyecto  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000380, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion  del proyecto  no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000381, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion del proyecto solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000382, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  del proyecto  es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000201, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar una Lista de Tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000202, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar una tarea"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000203, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar una Listatareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000204, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear una Lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000205, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar una ListaTareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000206, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar una ListaTarea en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000207, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar una lista de tareas"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000208, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000209, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000210, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la lista de tareas deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000211, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000212, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de preparar la consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000213, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000214, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de una lista de tareas en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000215, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000216, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000217, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en ListaTareaDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000218, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000219, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000220, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en ListaTareaDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000221, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de crear un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000222, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de insertar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000223, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de insertar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000224, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000225, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de modificar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000226, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de modificar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000227, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar un proyecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000228, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000229, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de eliminar un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000230, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del proyecto deseada"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000231, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de preparar la consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000232, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de preparar la consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000233, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de procesar los datos de una consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000234, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de procesar los datos de una consulta por id de un proyecto en la base de datos.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000235, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en consultar ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000236, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en consultar ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000237, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema funcion colocarParametrosConsulta en ProyectoDAO tratando de consultar tareas.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000238, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion colocarParametrosConsulta en ProyectoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000239, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en funcion ejecutarConsulta en ProyectoDAO tratando de consultar taraes.Se presento una excepcion de tipo SQLException. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000240, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado en funcion ejecutarConsulta en ProyectoDAO tratando de consultar taraes.Se presento una excepcion de tipo Exception. Por favor verifique la traza del error presentado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000241, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ListaTareasEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000242, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase ListaTareasEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000243, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase TareaEntityMapper.No es posible mapear una prioridad dominio a partir de una entidad de una prioridad entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000244, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toEntity de la clase TareaEntityMapper.No es posible mapear una prioridad entity a partir de una entidad de una prioridad dominio nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000245, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion de la lista de tareas solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000246, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion de la lista de tareas no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000247, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000248, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de la lista de tareas es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000249, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la lista de tareas solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000250, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000251, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre de la lista de tareas no es valida. La longitud maxima son 30 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000252, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion de la tarea solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000253, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud de la descripcion de la tarea no es valida. La longitud maxima son 60 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000254, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La descripcion  de la lista de tareas es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000255, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El identificador de la tarea es un dato obligatorio y no puede ser igual al UUID por defecto"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000256, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la tarea solo puede contener letras, digitos o espacios"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000257, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"El nombre de la tarea es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000000258, TipoMensaje.USUARIO, CategoriaMensaje.ADVERTENCIA,
				"La longitud del nombre de la tarea no es valida. La longitud maxima son 30 caracteres"));
		
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
