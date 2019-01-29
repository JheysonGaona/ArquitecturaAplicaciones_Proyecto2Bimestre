# Tema
Construye tu propio Socrative:

# Proyecto
- Frontend

HTML en combinación con Vue.js, permite crear de forma interactiva la capa de vista. **Vue.js** es de alguna manera una variante de JavaScript en este archivo se debe implementar todo lo que necesitemos.   
- Backend

Utilizamos como base la creación de un proyecto Maven, en sí su función es la de servidor. En esta parte se implementa la conexión a la Base de Datos, la persistencia con la misma, las consultas y conversiones necesarias para la salida al **Frontend**, estas son necesarias ya que su manejo requiere un JSON o un Objeto según como se dirección de la comunicación; si es del **Frontend** al **Backend** es necesario un JSON, en dirección opuesta se necesita un objeto.

La función principal del **Backend** es interpretar todas las consultas realizadas en el **Frontend** para comunicarlas a la Base de Datos.

# Depencias importantes

```
<!-- Manejo de JSON para las respuesta CONEXION -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.5</version>
</dependency>
<!-- Consultas con la BD -->
<dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.8.0</version>
</dependency>
<!-- ORM -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.0.Final</version>
</dependency>
<!-- Persistencia con la ayuda del ORM -->
<dependency>
    <groupId>org.hibernate.javax.persistence</groupId>
    <artifactId>hibernate-jpa-2.1-api</artifactId>
    <version>1.0.0.Final</version>
</dependency>
<!-- Conexion a BD Maria_DB -->
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>2.3.0</version>
</dependency>
<!-- Manejo de LOG's -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.5</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.5</version>
</dependency>
```
Dichas dependencias son librerías necesarias para la ejecución exitosa del proyecto.

# Explicación de dependencias 
1. **mariadb-java-client**

    Empezaremos con mas significativo e util pero a la vez el simple de usar.

    Ya que su uso no es igual que en proyectos, en sí solo crea un puente pero no la conexión hacia la Base de Datos.

2. **Gson**

    Como ya se explico en el apartado de **PROYECTO** es necesario realizar conversiones sobre los resultado de las consultas.

    A continuación unos ejemplos muy sencillos:
    - JSON a Objeto
    
    var cuestionario = gson.fromJson(message, Quiz.class);
    
    Aqui convertimos el JSON resultante a un objeto de tipo **Quiz**.

3. **Hibernate**

    Es un ORM, que realiza mapeo de objeto-relacional es un modelo de programación que consiste en la transformación de las tablas de una base de datos, en una serie de entidades que simplifiquen las tareas básicas de acceso a los datos para el programador.
    
    El ORM permite respetar las relaciones entre las tablas además del uso correcto de los tipos de datos y la persistencia con la Base de Datos. Dicha persistencia se logra por medio de las reglas del ORM, en este caso Hibernate.
    - Tabla
        
        @Entity
        
        @Table(name="docentes")
    - Campos
    
        @Column(name = "nombre")
    - Relaciones  
        
        @OneToMany
            private List<Quiz> cuestionario;
4. **Spark**

    Este es usado para las consultas a la Base de Datos.
    
    Un ejemplo sencillo creado para este wiki:
    ```JAVA
    public static void consulta2(){
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(Docente.class);
            cr.setFirstResult(0);
            cr.setMaxResults(10);
            List results = cr.list();
            results.stream().forEach(System.err::println);
            session.close();
        }
    ``` 
    Aqui lo que se pide es la lista de los 10 primeros Docentes, la misma que regresa como una lista de objetos tipo Docente
# Anexos
- Modelo de la BD.

![Modelo](https://github.com/JheysonGaona/ArquitecturaAplicaciones_Proyecto2Bimestre/blob/master/SQL_MariaDB/ModeloBD.PNG)

- *En caso de recrear el proyecto brindamos el SQL.*
    
[SQL BD](https://github.com/JheysonGaona/ArquitecturaAplicaciones_Proyecto2Bimestre/blob/master/SQL_MariaDB/socrative.sql)

