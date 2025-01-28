# MsTransfer
proyecto ejemplo
DEMO PRPYECTO MSTRANSFER LUIS POLEO
METODO DE SEGURIDAD SPRING SEGURITY + JWT
LOG4FJ
APIS EXPUESTAS
CONEXION BD 
TEST UNIT

PARA HACER USO DE LAS API SE DEBE GENERAR UN TOKEN EL CUAL SE CREO UN API PARA SE PUEDA CREAR UN USUARIO Y OTRO  EL CUAL YA CON EL  USUARIO CREADO Y REGISTRADO EN SISTEMA TE  DEVUELVE EL TOKEN PARA CONSUMIR LAS OTRAS API 

POST http://localhost:8080/api/auth/signup
BODY RAW
{
"username": "lpoleos",
"password": "123456789"
}

get token
POST http://localhost:8080/api/auth/signin
{
"username": "lpoleos",
"password": "123456789"
}

create account if client exist database
post http://localhost:8080/api/cuentas
body raw
{
    "tipoCuenta": "AHORRO",
    "saldo": 1000.00,
    "cliente": {
            "id": 1
     }
}

Se subo al proyecto el collection del los consumos

