Sistema de Gestión de Empleados - Backend

Este proyecto es un backend para la gestión de empleados, roles y departamentos, desarrollado en Java con Spring Boot y MySQL. Proporciona una API RESTful para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades del sistema.

Características:
- Gestión de empleados, roles y departamentos.
- Persistencia de datos utilizando JPA y MySQL.

Este backend está diseñado para integrarse con un frontend.

Creación de Rol y Listado: Al crear un rol y realizar una solicitud GET para listar los roles, se visualizará de la siguiente manera:

![Captura de pantalla 2024-09-24 200805](https://github.com/user-attachments/assets/f2445514-981e-4078-91d3-706aecb2182e)

Asignación de Usuarios: Una vez que tengamos los roles y departamentos creados, será posible crear usuarios y asignarles un rol y un departamento específicos. Al realizar una solicitud GET en el departamento o en el rol, se mostrarán todos los empleados correspondientes a dicho departamento o rol.

![Captura de pantalla 2024-09-24 200853](https://github.com/user-attachments/assets/8ffd8c1b-6c3b-411c-8040-57ad3c25c67b)


Información Adicional:

-Asegúrate de tener una base de datos creada en MySQL con el nombre gestion_empleados. Si prefieres utilizar un nombre diferente, puedes modificarlo en el archivo de configuración application.properties.

-En caso de que la aplicación no se ejecute correctamente, revisa el archivo pom.xml y verifica las versiones de las dependencias para identificar cualquier posible error.
