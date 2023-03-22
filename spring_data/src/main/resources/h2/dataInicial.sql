--usuario
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, PAIS_NACIMIENTO) VALUES ('PEREZ', '1', 'ROBERTO', '093939393', 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, PAIS_NACIMIENTO) VALUES ('SANCHEZ', '2', 'RAUL', '093223333', 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, PAIS_NACIMIENTO) VALUES ('SANCHEZ PAZMINO', '11', 'PATRICIO', '092222', 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, PAIS_NACIMIENTO) VALUES ('SANCHEZ SALAZAR', '111', 'MAURICIO', '0933333', 'EC');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, PAIS_NACIMIENTO) VALUES ('SANCHEZ SALAZAR', '1111', 'HORACIO', '0934555', 'EC');

INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENT_ID) VALUES ('10 de agosto', 'n31', 1);
INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENT_ID) VALUES ('Av. Amazonas', 'n100', 1);
INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENT_ID) VALUES ('Av. Prensa', 'n1', 2);

INSERT INTO CUENTA (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('22222', 'AHORRO', 1, true);
INSERT INTO CUENTA (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('33333', 'CORRIENTE', 1, false);

INSERT INTO TARJETA (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('8734134', 'AHORRO', 1, true);
INSERT INTO TARJETA (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('843113', 'CORRIENTE', 1, false);

INSERT INTO INVERSION (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('871212.', 'AHORRO', 1, true);
INSERT INTO INVERSION (NUMERO, TIPO, CLIENT_ID, ESTADO) VALUES ('23156413', 'CORRIENTE', 1, false);