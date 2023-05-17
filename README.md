# Hackathon Fundación Esplai - Reto Login &amp; Register (Backend)

![portada](https://github.com/paul-23/Hackathon-Fundacion-Esplai/assets/62121921/2de2092b-cebb-4582-a546-03d9e790a914)

## Mensaje de bienvenida
(solo si estas validado por token)

**GET** ``` localhost:8181/welcome ```

## Usuarios

### Listar todos los usuarios
(solo si estas validado por token)

**GET** ``` localhost:8181/users ```

### Login usuario

**POST** ```localhost:8181/login```

```
{
    "username": "admin",
    "password": "password"
}
```

### Registrar usuario

**POST** ```localhost:8181/register```

```
{
    "username": "admin",
    "password": "password",
    "role": "admin"
}
```

### Listar empleado por id
(solo si estas validado por token)

**GET** ```localhost:8181/users/{id}```

```
localhost:8181/users/2
```

### Actualizar empleado
(solo si estas validado por token)

**PUT** ```localhost:8181/users/{id}```

```
localhost:8181/users/2
```

```
{
    "username": "admin",
    "password": "password",
    "role": "admin"
}
```

### Eliminar empleado
(solo si estas validado por token)

**DELETE** ```localhost:8181/users/{id}```

```
localhost:8181/users/2
```
