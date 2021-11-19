# language: es
@E2E_Capa
Característica: Aplicativo Viva Air
  El usuario realiza una consulta exitosamente
  @TestCase1
  Esquema del escenario: Reserva exitosa sitio web
    Dado que el usuario tiene toda la informacion que necesita
      | origen | destino | fecha_inicial |fecha_final|
      | <origen> | <destino> | <fecha_inicial> |<fecha_final>|
    Cuando realiza la reserva con los datos
    Entonces el usuario deberia ver los resultados
    Ejemplos:
      | origen | destino | fecha_inicial |fecha_final|
      ##@externaldata@./src/test/resources/co.com.qr.capacitaciones.web/datadriver/reservar/Reserva.xlsx@Datos
	|Medellín|Cartagena|21|21|
