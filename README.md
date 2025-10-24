# TP6 - Colecciones y Sistema de Stock

## Alumno: Marcelo Gomez Armoa.
## Comisión: 8

## Descripción General
Este trabajo práctico implementa tres sistemas diferentes utilizando colecciones dinámicas (ArrayList) y conceptos avanzados de programación orientada a objetos en Java.

## Estructura del Proyecto
```
TP6_Java/
├── src/
│   ├── ejercicio1/     # Sistema de Stock
│   ├── ejercicio2/     # Sistema de Biblioteca
│   └── ejercicio3/     # Sistema Universitario
└── README.md
```

## Ejercicio 1: Sistema de Stock

### Clases Implementadas
- **`CategoriaProducto`** (enum): Define las categorías de productos con descripciones
- **`Producto`**: Representa un producto con id, nombre, precio, cantidad y categoría
- **`Inventario`**: Gestiona una colección de productos con operaciones CRUD
- **`MainEjercicio1`**: Clase principal que demuestra todas las funcionalidades

### Características Principales
- ✅ Uso de enumeraciones (enum) con métodos
- ✅ ArrayList para almacenamiento dinámico
- ✅ Operaciones de búsqueda y filtrado
- ✅ Gestión de stock y reportes
- ✅ 10 tareas implementadas según el enunciado

### Ejecución
```bash
javac -d . src/ejercicio1/*.java
java ejercicio1.MainEjercicio1
```

## Ejercicio 2: Sistema de Biblioteca

### Clases Implementadas
- **`Autor`**: Representa un autor con id, nombre y nacionalidad
- **`Libro`**: Representa un libro con ISBN, título, año y autor
- **`Biblioteca`**: Gestiona una colección de libros (relación de composición 1 a N)
- **`MainEjercicio2`**: Clase principal que demuestra las funcionalidades

### Características Principales
- ✅ Relación de composición 1 a N (Biblioteca → Libros)
- ✅ Si se elimina la biblioteca, se eliminan los libros
- ✅ Búsqueda por ISBN y filtrado por año
- ✅ Gestión de autores únicos
- ✅ 9 tareas implementadas según el enunciado

### Ejecución
```bash
javac -d . src/ejercicio2/*.java
java ejercicio2.MainEjercicio2
```

## Ejercicio 3: Sistema Universitario (Relación Bidireccional)

### Clases Implementadas
- **`Profesor`**: Profesor con lista de cursos que dicta
- **`Curso`**: Curso con referencia a su profesor responsable
- **`Universidad`**: Administra profesores y cursos
- **`MainEjercicio3`**: Clase principal que demuestra la bidireccionalidad

### Características Principales
- ✅ **Relación bidireccional** Profesor ⟷ Curso
- ✅ Sincronización automática al cambiar asignaciones
- ✅ Invariantes de asociación mantenidos
- ✅ Navegación desde ambos extremos de la relación
- ✅ 8 tareas implementadas según el enunciado

### Ejecución
```bash
javac -d . src/ejercicio3/*.java
java ejercicio3.MainEjercicio3
```

## Conceptos Implementados

### 1. Colecciones Dinámicas
- **ArrayList**: Estructura principal para almacenar elementos
- **List**: Interface para flexibilidad en el diseño
- **Operaciones**: add, remove, contains, size, isEmpty

### 2. Enumeraciones (enum)
- **Valores predefinidos**: Categorías de productos
- **Métodos en enum**: Descripción de categorías
- **Constructor personalizado**: Para asociar descripciones

### 3. Relaciones Entre Clases

#### Composición (1 a N)
- **Biblioteca → Libros**: Relación fuerte
- Si se elimina el contenedor, se eliminan los contenidos

#### Bidireccionalidad (1 a N)
- **Profesor ⟷ Curso**: Navegación en ambas direcciones
- **Sincronización**: Cambios se reflejan en ambos lados
- **Invariantes**: Coherencia de referencias mantenida

### 4. Encapsulamiento
- **Atributos privados**: Acceso controlado
- **Métodos públicos**: Interface bien definida
- **Validaciones**: Verificación de datos de entrada

### 5. Búsqueda y Filtrado
- **Por ID/Código**: Búsqueda exacta
- **Por categoría/año**: Filtrado por criterios
- **Por rango de precios**: Filtrado numérico

## Demostraciones Incluidas

### Ejercicio 1
1. Creación y gestión de productos
2. Listado completo del inventario
3. Búsqueda por ID
4. Filtrado por categoría
5. Eliminación de productos
6. Actualización de stock
7. Reportes de stock total
8. Producto con mayor stock
9. Filtrado por rango de precios
10. Visualización de categorías

### Ejercicio 2
1. Creación de biblioteca
2. Registro de autores
3. Adición de libros
4. Listado completo
5. Búsqueda por ISBN
6. Filtrado por año de publicación
7. Eliminación de libros
8. Conteo total de libros
9. Listado de autores únicos

### Ejercicio 3
1. Creación de profesores y cursos
2. Registro en universidad
3. Asignación profesor-curso
4. Listados bidireccionales
5. **Cambio de profesor** (sincronización automática)
6. **Eliminación de curso** (actualización en profesor)
7. **Eliminación de profesor** (cursos quedan sin profesor)
8. Reporte estadístico

## Compilación y Ejecución General

### Compilar todo el proyecto
```bash
# Desde la carpeta raíz del proyecto
javac -d . src/ejercicio1/*.java
javac -d . src/ejercicio2/*.java
javac -d . src/ejercicio3/*.java
```

### Ejecutar cada ejercicio
```bash
java ejercicio1.MainEjercicio1
java ejercicio2.MainEjercicio2
java ejercicio3.MainEjercicio3
```


## Conclusiones Técnicas

✅ **Colecciones dinámicas**: ArrayList permite gestión flexible de elementos
✅ **Enumeraciones**: Proporcionan type-safety y legibilidad
✅ **Composición**: Modela relaciones de pertenencia fuerte
✅ **Bidireccionalidad**: Permite navegación natural entre objetos relacionados
✅ **Encapsulamiento**: Protege la integridad de los datos
✅ **Modularidad**: Código reutilizable y mantenible


