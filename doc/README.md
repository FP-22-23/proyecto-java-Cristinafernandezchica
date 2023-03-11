# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<2022\>/\<2023\>)
Autor/a: Cristina Fernández Chica   uvus: RFM6490


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
    * **fp.tipos**: Paquete que contiene los tipos del proyecto.
    * **fp.test**: Paquete que contiene las clases de test del proyecto.
    * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
    * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **fatalpoliceshootings.csv**: Añade una descripción genérica del dataset.
* **/doc**: Contiene la documentación del proyecto (readme.md)
    
## Estructura del *dataset*

El dataset original Fatal Police Shootings se puede obtener de la URL http://kaggle.com/brendanhasz/fatal-police-shootings
Orginalmente tiene 17 columnas divididas en dos csv, el principal con 14 columnas y uno secundario que contiene las coordenaas
con 3 columnas. El csv principal contiene datos sobre tiroteos mortales que han tenido lugar en EE.UU. El dataset usado en este
proyecto tiene 14 columnas, 12 se han tomado del dataset original, y dos, la lista de policias y los coste de los recursos 
utilizados, se han generado de forma aleatoria. A continuación se describen las 14 columnas del dataset:


* **id**: de tipo String, representa el número de identificación del tiroteo.
* **name**: de tipo String, representa el nombre de la persona tiroteada.
* **manner_of_date**: de tipo String, representa la forma en que muere cada tiroteado/a.
* **armed**: de tipo Enum, representa el arma que portaba la persona tiroteada.
* **age**: de tipo Integer, representa la edad del/la tiroteado/a.
* **gender**: de tipo Enum, representa el género del/la tiroteado/a.
* **city**: de tipo String, representa la ciudad en la que ha ocurrido el tiroteo.
* **lat**: de tipo Double, representa la latitud de las coordenadas donde ha sucedido el tiroteo.
* **lon**: de tipo Double, representa la longitud de las cooordenadas donde ha sucedido el tiroteo.
* **signs_of_mental_illness**: de tipo Boolean, representa si la persona tiroteadas presentaba o no señales de enfermedad mental.
* **body_camera**: de tipo Boolean, representa si los policias implicados en el tiroteo llevaban cámara corporal o no.
* **police_officers_involved**: de tipo List\<String\>, representa la lista de los policias implicados en el tiroteo.
* **cost_of_resources_used**: de tipo Double, representa el coste de los recursos utilizados en el tiroteo.



## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - TiroteoFatalImpl

Representa un tiroteo fatal. También tenemos implementada su interfaz TiroteoFatal.

**Propiedades**:

- *id*, de tipo *String*, consultable. Contiene el identificador del tiroteo. 
- *nombre*, de tipo *String*, consultable y modificable. Contiene el nombre completo del/la tiroteado/a.
- *fecha*, de tipo *LocalDate*, consultable y modificable. Contiene la fecha en que sucedió el tiroteo.
- *maneraMorir*, de tipo *String*, consultable y modificable. Contiene la manera en que murió el/la tiroteado/a.
- *arma*, de tipo *Arma*, consultabke y modificable. Indica el arma que porataba la persona tiroteada. 
  Puede tomar los valores *gun*, *unarmed*, *vehicle*, *knife*, *undetermined*, *sword*, *hammer*, *screwdriver*, *explosives*, *taser*, *ax*.
- *edad*, de tipo *Integer*, consultable y modificable. Contiene la edad de la persona tiroteada en el momento en que ocurrió el tiroteo.
- *genero*, de tipo *Genero*, consultable. Contiene el género de la persona tiroteada. Puede tomar los valores *F*, *M*.
- *ciudad*, de tipo *String*, consultable. Contiene la ciudad en la que ocurrió el tiroteo.
- *coordenadas*, de tipo *Coordenadas*, consultable. Contiene las coordenadas de la ciudad donde ocurrió.
- *signosEnfermedadMental*, de tipo Boolean, consultable y mosificable. Indica si la persona tiroteada presentaba signos de enfermedad mental.
- *camaraCuerpo*, de tipo Boolean, consultable y modificable. Indica si los policias invoulucrados en el tiroteo portaban cámara corporal.
- *policias*, de tipo *List<String>*, consultable y modificable. Contiene la lista de policias involucrados en el tiroteo.
- *costeRecursos*, de tipo Double, consultable y modificable. Contiene el coste de los recursos utilizados en el tiroteo.
- *menorMayor*, de tipo *MenorMayor*, consultable. Indica si la persona tiroteada era menor o mayor de edad, por lo tanto se obtiene a partir de la edad.
  Puede tomar los valores *Menor*, *Mayor*.
- *añoNacimiento*,de tipo Integer, consultable. Indica el año de nacimiento del/la tiroteado/a, por tanto se obtiene a partir de la fecha del tiroteo y la edad.
  
**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Un constructor a partir de String.

**Restricciones**:
 
- R1: La lista de policias no puede estar vacía.
- R2: El coste de los recursos utilizados no puede ser menor o igual a 0.
- R3: La edad del/la tiroteado/a no puede ser menor o igual a 0.

**Criterio de igualdad**: Todos las propieades básicas.

**Criterio de orden natural**: Por nombre, fecha, edad, ciudad y coste de los recursos.

**Representación como cadena**: Generada automáticamente con todas las propiedades básicas del tipo.

**Otras operaciones**:
 
- *Double getDistancia(TiroteoFatalImpl t)*: Devuelve la distancia entre dos lugares.

#### Tipos auxiliares
- Coordenadas, record. Este agrupa la latitud y la longitud para formar así las coordendas.
- Arma, enumerado. Puede tomar los valores *gun*, *unarmed*, *vehicle*, *knife*, *undetermined*, *sword*, *hammer*, *screwdriver*, *explosives*, *taser*, *ax*.
- Genero, enumerado. Puede tomar los valores *F*, *M*.
- MenorMayor, enumerado. Puede tomar los valores *Menor*, *Mayor*.

### Test - TestTiroteoFatalImpl
Clase de test para probar los métodos de tipo TiroteoFatal.
