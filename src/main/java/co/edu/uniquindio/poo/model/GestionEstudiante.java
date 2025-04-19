package co.edu.uniquindio.poo.model;
import java.util.ArrayList;
import java.util.Optional;

public class GestionEstudiante {
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    public GestionEstudiante(String nombre) {
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    public String registrarEstudiante(Estudiante estudiante) {
        String mensaje="";
        Optional<Estudiante> encontrado = buscarEstudiante(estudiante);
        if (encontrado.isPresent()) {
            mensaje="Estudiante ya registrado";
        }else{
            listaEstudiantes.add(estudiante);
            mensaje="Estudiante registrado";
        }
        return mensaje;
    }

    public Optional<Estudiante> buscarEstudiante(Estudiante estudiante) {
        return listaEstudiantes.stream().filter(e->e.getId().equals(estudiante.getId())).findFirst();
    }

    public String eliminarEstudiante(Estudiante estudiante) {
        String mensaje="";
        Optional<Estudiante> encontrado = buscarEstudiante(estudiante);
        if (encontrado.isPresent()) {
            listaEstudiantes.remove(estudiante);
            mensaje="Estudiante eliminado";
        }else{
            mensaje="Estudiante no existe";
        }
        return mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}



