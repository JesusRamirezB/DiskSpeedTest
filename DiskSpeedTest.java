import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class DiskSpeedTest {
    public static void main(String[] args) {
        // La variale numFiles indica la cantidad de archivos temporales que seran creados.
        // Las lecturas son mas precisas con mayor cantidad de archivos.
        int numFiles = 3;
        // La variable FileSizeInMB indica el tamaño en MB de cada archivo temporal.
        // Las lecturas son mas precisas con archivos grandes. 
        int fileSizeInMB = 1024; // 102.4 MB

        try {
            double totalWriteSpeed = 0;
            double totalReadSpeed = 0;

            System.out.println("Calculando la velocidad de escritura:");
            // Crear los archivos y medir la velocidad de escritura
            File[] files = new File[numFiles];
            for (int i = 0; i < numFiles; i++) {
                System.out.print("-");
                File file = new File("testfile_" + i);
                byte[] data = new byte[fileSizeInMB * 1024 * 1024]; // Convertir MB a bytes
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    long startTime = new Date().getTime();
                    fos.write(data);
                    long endTime = new Date().getTime();

                    double elapsedTimeInSeconds = (endTime - startTime) / 1000.0; // Tiempo en segundos
                    double writeSpeedInMBps = fileSizeInMB / elapsedTimeInSeconds;
                    totalWriteSpeed += writeSpeedInMBps;
                }
                files[i] = file;
            }

            System.out.println("\nCalculando la velocidad de lectura:");
            // Leer los archivos y medir la velocidad de lectura
            for (int i = 0; i < numFiles; i++) {
                System.out.print("-");
                byte[] data = new byte[fileSizeInMB * 1024 * 1024];

                try (FileInputStream fis = new FileInputStream(files[i])) {
                    long startTime = new Date().getTime();
                    fis.read(data);
                    long endTime = new Date().getTime();

                    double elapsedTimeInSeconds = (endTime - startTime) / 1000.0; // Tiempo en segundos
                    double readSpeedInMBps = fileSizeInMB / elapsedTimeInSeconds;
                    totalReadSpeed += readSpeedInMBps;
                }
            }

            // Calcular las velocidades promedio de lectura y escritura
            double avgWriteSpeed = totalWriteSpeed / numFiles;
            double avgReadSpeed = totalReadSpeed / numFiles;

            // Mostrar en consola las velocidades
            System.out.println("\nVelocidad de escritura: " + String.format("%.2f", avgWriteSpeed) + " MB/s");
            System.out.println("Velocidad de lectura: " + String.format("%.2f", avgReadSpeed) + " MB/s");

            // Eliminar los archivos temporales después de leer
            for (int i = 0; i < numFiles; i++) {
                files[i].delete();
            }
        } catch (IOException e) {
            System.err.println("Error al realizar la prueba de velocidad: " + e.getMessage());
        }
    }
}
