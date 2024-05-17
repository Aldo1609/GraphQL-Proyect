
# GraphQL API Proyect

![1_rZg1Kae1Xc8pDDbNqYMtyQ](https://github.com/Aldo1609/GraphQL-Proyect/assets/60208224/b0be35d7-2cd5-415a-b0a1-98448ff8fa71)



This is a simple proyect using GraphQL API , this service has 5 operations:

- getAllUsers
- findById
- createUser
- updateUser
- deleteUser










## Requirements

📏 JDK 17

📏 Springboot 3.0






## Querys


```bash
query GetAllUsers {
    getAllUsers {
        id
        usuario
        correo
        contrasena
        rol
    }
}
```
```bash
query FindById {
    findById(id: "1") {
        id
        usuario
        correo
        contrasena
        rol
    }
}
```
```bash
mutation CreateUser {
    createUser(
        usuario: "example"
        correo: "example"
        contrasena: "example"
        rol: "example"
    ) {
        id
        usuario
        correo
        contrasena
        rol
    }
}
```
```bash
mutation UpdateUser {
    updateUser(
        id: "example"
        usuario: "example"
        correo: "example"
        contrasena: "example"
        rol: "example"
    ) {
        id
        usuario
        correo
        contrasena
        rol
    }
}
```
```bash
mutation DeleteUser {
    deleteUser(id: "1") {
        id
        usuario
        correo
        contrasena
        rol
    }
}
```

