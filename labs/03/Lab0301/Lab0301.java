mport java.util.LinkedList;
import java.util.Queue;

public class Lab0301 {
    static LinkedList<Asignatura> materias = new LinkedList<>();  
    static Queue<Registro> regis = new LinkedList<>();  
    static Queue<String> codes = new LinkedList<>(); 

    public static void  main (String[] args) {
        boolean siga = true;
        
        carga_asignaturas(args[0]);
        do {
            siga = registro_estudiante();
            if (!siga) break;
            registro_asignaturas();
            reporte_registro();
        } while (true);
    }

    public static void carga_asignaturas(String archivo) {
        materias = Entrada.loadFile(archivo);
    }

    public static boolean registro_estudiante() {
        String codigo = Entrada.readText("DATOS ESTUDIANTE\n\n Código (-1=FIN): ");
        if (codigo.equals("-1")) return false;
        if (codes.contains(codigo)) {
            System.out.println(" Codigo " + codigo + " ya registrado\n");
            return true;
        }
        String nombre = Entrada.readText(" Nombre: ");
        String correo = Entrada.readText(" Correo: ");   
        int semestre = Entrada.readInt(" Semestre: ");
        System.out.println();

        Estudiante estud = new Estudiante(codigo, nombre, correo, semestre);

        regis.add(new Registro(estud));
        codes.add(codigo);

        return true;
    }

    public static void registro_asignaturas() {
        do {
            int sem = Entrada.readInt("\nVer asignaturas del semestre: ", 1, 10);
            mostrar_asignaturas(sem);
        } while (false);
    }

    public static void mostrar_asignaturas(int sem) {
        for (Asignatura s : materias) {
            if (s.getSemestre() == sem)
                System.out.println(s);
        }
        System.out.println();
    }

    public static void reporte_registro() {

    }
}
