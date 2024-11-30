## Descripción

La API del servicio de atención medica retorna una lista de barrios con la cantidad de personas  registradas como en situación de calle que solicitaron al menos una vianda en las heladeras solidarias de ese barrio. El servicio también devuelve una lista con los nombres de las personas vulnerables encontradas.

## Base URL

La URL base para todas las requests de la API es:

`http://localhost:8080/api/atencion-medica`

## Endpoints

### `GET /localidadesVulnerables`

Devuelve una lista de barrios, y dentro de cada barrio esta contenida la cantidad de vulnerables junto a sus nombres.

### Respuesta

Devuelve un String con formato JSON con los siguientes campos:

- `nombreBarrio`: El nombre del barrio del que se obtuvo la información.
  - `vulnerables`: Los nombres de los vulnerables encontrados para dicho barrio.
  - `cantidad`: La cantidad de los vulnerables encontrados para dicho barrio.

### Ejemplo

Request:

```jsx
GET /localidadesVulnerables
```

Respuesta:

```json
{
  "Almagro": {
    "vulnerables" : ["Mati"],
    "cantidad" : 1
  },
  "Caballito": {
    "vulnerables" : ["Santi", "Liam"]
    "cantidad" : 2
  }
}
```

### **`GET /localidadesVulnerables/{nombreBarrio}`**

Devuelve la cantidad de vulnerables junto a sus nombres, para el barrio indicado en el parámetro de la Query.

### Parámetros

- `nombreBarrio`: El nombre del barrio por el cual se quiere filtrar. Para saber que barrios están disponibles, consultar este link: https://buenosaires.gob.ar/laciudad/barrios

### Respuesta

Devuelve un String con formato JSON con los siguientes campos:

- `nombreBarrio`: El nombre del barrio indicado por parámetro, del que se obtuvo la información.
  - `vulnerables`: Los nombres de los vulnerables encontrados para dicho barrio.
  - `cantidad`: La cantidad de vulnerables encontrados para dicho barrio.

Request:

```jsx
GET /localidadesVulnerables/Caballito
```

Respuesta:

```json
{
  "Caballito": {
    "vulnerables" : ["Santi", "Liam"]
    "cantidad" : 2
  }
}
```
