# DiskSpeedTest - Java

Este programa es una herramienta simple en Java para medir la velocidad de escritura y lectura de un disco duro mediante la creación de archivos temporales y posterior eliminación.

## Requisitos:

- Java Development Kit (JDK) instalado en el sistema.
- Un disco duro con suficiente espacio para crear los archivos temporales.

## Instrucciones de Uso:

1. Clonar o descargar el código fuente del programa en una ubicación local.

2. Abrir una terminal o línea de comandos en el directorio donde se encuentra el archivo DiskSpeedTest.java.

3. Compilar el programa ejecutando el siguiente comando:

   javac DiskSpeedTest.java

4. Después de compilar, ejecutar el programa con el siguiente comando:

   java DiskSpeedTest

5. El programa solicitará unos segundos para realizar las mediciones. Durante este tiempo, mostrará un indicador de progreso ('-') para representar la creación de los archivos temporales.

6. Una vez finalizado el proceso, se mostrarán las velocidades promedio de escritura y lectura del disco duro, expresadas en megabytes por segundo (MB/s), con dos decimales.

7. El programa creará archivos temporales en la misma ubicación donde se encuentre el archivo DiskSpeedTest.java. Estos archivos serán eliminados automáticamente después de completar las mediciones.

## Personalización:

- Puedes ajustar los parámetros numFiles y fileSizeInMB en el código fuente para realizar más o menos mediciones y para cambiar el tamaño de los archivos temporales creados. Recuerda que tamaños más grandes pueden requerir más tiempo para completar las operaciones de escritura y lectura.

## Aviso:

Este programa realiza operaciones de escritura y lectura en el disco duro para medir su velocidad. Asegúrate de tener suficiente espacio libre y ten en cuenta que los archivos temporales se crearán y eliminarán durante el proceso. Utiliza este programa bajo tu propia responsabilidad. No es recomendable usarlo en unidades de almacenamiento con datos importantes.
