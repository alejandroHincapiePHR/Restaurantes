Correr el docker compose y asegurarse que la DB si este generando automaticamente la data en el archivo init-db
actualmente configurado para correr en puerto 8081, esto se puede cambiar en el archivo .env, la variable server port

### Documentación de la API

#### **1. Obtener todos los restaurantes**
- **Descripción**: Devuelve una lista de todos los restaurantes disponibles.
- **Método HTTP**: `GET`
- **URL**: `/restaurantes`
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Lista de objetos `Restaurante`
  
```json
[
  {
    "idRestaurante": 1,
    "nombre": "Restaurante A",
    "email": "contacto@restauranteA.com",
    "platos": []
  },
  {
    "idRestaurante": 2,
    "nombre": "Restaurante B",
    "email": "contacto@restauranteB.com",
    "platos": []
  }
]
```

#### **2. Obtener un restaurante por ID**
- **Descripción**: Devuelve un restaurante específico basado en su ID.
- **Método HTTP**: `GET`
- **URL**: `/restaurantes/{id}`
- **Parámetros**: 
  - `id`: El ID del restaurante que se desea consultar.
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Objeto `Restaurante`
  
```json
{
  "idRestaurante": 1,
  "nombre": "Restaurante A",
  "email": "contacto@restauranteA.com",
  "platos": []
}
```

- **Error**:
  - **Código**: `404 Not Found` (si el restaurante no existe)

#### **3. Obtener todos los clientes**
- **Descripción**: Devuelve una lista de todos los clientes.
- **Método HTTP**: `GET`
- **URL**: `/clientes`
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Lista de objetos `Cliente`
  
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juanp@example.com",
    "ubicacion": "Calle Falsa 123"
  },
  {
    "id": 2,
    "nombre": "María López",
    "email": "marial@example.com",
    "ubicacion": "Av. Siempre Viva 456"
  }
]
```

#### **4. Obtener cliente por ID**
- **Descripción**: Devuelve un cliente específico basado en su ID.
- **Método HTTP**: `GET`
- **URL**: `/clientes/{id}`
- **Parámetros**:
  - `id`: El ID del cliente que se desea consultar.
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Objeto `Cliente`
  
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "email": "juanp@example.com",
  "ubicacion": "Calle Falsa 123"
}
```

- **Error**:
  - **Código**: `404 Not Found` (si el cliente no existe)

#### **5. Obtener todos los pedidos de un cliente específico**
- **Descripción**: Devuelve todos los pedidos asociados a un cliente.
- **Método HTTP**: `GET`
- **URL**: `/clientes/{clienteId}/pedidos`
- **Parámetros**:
  - `clienteId`: El ID del cliente.
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Lista de objetos `Pedido`
  
```json
[
  {
    "idPedido": 1,
    "estado": "ENVIADO",
    "platos": []
  },
  {
    "idPedido": 2,
    "estado": "PAGADO",
    "platos": []
  }
]
```

#### **6. Obtener todos los pedidos**
- **Descripción**: Devuelve una lista de todos los pedidos.
- **Método HTTP**: `GET`
- **URL**: `/pedidos`
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Lista de objetos `Pedido`
  
```json
[
  {
    "idPedido": 1,
    "estado": "ENVIADO",
    "platos": []
  },
  {
    "idPedido": 2,
    "estado": "PAGADO",
    "platos": []
  }
]
```

#### **7. Obtener pedido por ID**
- **Descripción**: Devuelve un pedido específico basado en su ID.
- **Método HTTP**: `GET`
- **URL**: `/pedidos/{id}`
- **Parámetros**:
  - `id`: El ID del pedido que se desea consultar.
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Objeto `Pedido`
  
```json
{
  "idPedido": 1,
  "estado": "ENVIADO",
  "platos": []
}
```

- **Error**:
  - **Código**: `404 Not Found` (si el pedido no existe)

#### **8. Crear un nuevo pedido**
- **Descripción**: Crea un nuevo pedido para un cliente.
- **Método HTTP**: `POST`
- **URL**: `/pedidos`
- **Cuerpo de la solicitud**:
  
```json
{
  "cliente": {
    "id": 1
  },
  "estado": "CREADO",
  "platos": [
    {
      "idPlato": 1
    },
    {
      "idPlato": 2
    }
  ]
}
```

- **Respuesta exitosa**: 
  - **Código**: `201 Created`
  - **Cuerpo**: Objeto `Pedido` creado

```json
{
  "idPedido": 3,
  "estado": "CREADO",
  "platos": [
    {
      "idPlato": 1
    },
    {
      "idPlato": 2
    }
  ]
}
```

#### **9. Actualizar el estado de un pedido**
- **Descripción**: Actualiza el estado de un pedido existente.
- **Método HTTP**: `PATCH`
- **URL**: `/pedidos/{id}/estado`
- **Parámetros**:
  - `id`: El ID del pedido.
  - `estado`: El nuevo estado del pedido (CREADO, PAGADO, ACEPTADO, PREPARACION, ENVIADO, RECIBIDO).
- **Respuesta exitosa**: 
  - **Código**: `200 OK`
  - **Cuerpo**: Objeto `Pedido` actualizado
  
```json
{
  "idPedido": 1,
  "estado": "ENVIADO",
  "platos": []
}
```

- **Error**:
  - **Código**: `404 Not Found` (si el pedido no existe)

### Definiciones de objetos

#### **Restaurante**
- `idRestaurante`: Identificador único del restaurante.
- `nombre`: Nombre del restaurante.
- `email`: Correo electrónico de contacto del restaurante.
- `platos`: Lista de platos que ofrece el restaurante.

#### **Plato**
- `idPlato`: Identificador único del plato.
- `nombre`: Nombre del plato.
- `precio`: Precio del plato.

#### **Pedido**
- `idPedido`: Identificador único del pedido.
- `estado`: Estado del pedido (CREADO, PAGADO, ACEPTADO, PREPARACION, ENVIADO, RECIBIDO).
- `platos`: Lista de platos asociados al pedido.
- `cliente`: Cliente que realizó el pedido.

#### **Cliente**
- `id`: Identificador único del cliente.
- `nombre`: Nombre del cliente.
- `email`: Correo electrónico del cliente.
- `ubicacion`: Ubicación del cliente.
- `pedidos`: Lista de pedidos realizados por el cliente.
