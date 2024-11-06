/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.ControladorUniversitario;
import com.milton.gomez.sistema.universitario.Model.Materia;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleMateria;

import java.util.List;

/**
 *
 * @author milton
 */
public class ControllerMateria {
    //Inicialización del controlador.
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static Materia obtenerMateria(Integer id){
        return cu.obtenerMateria(id);
    }
    
    public static List<Materia> listarTodasLasMaterias(){
        return cu.obtenerMaterias();
    }
    
    public static List<Materia> listarCorrelativas(Integer materiaId){
        return cu.obtenerMateria(materiaId).getCorrelativas();
    }

    public static void crearMateria(TransferibleMateria transferible){
        cu.crearMateria(
                transferible.getCodigoDeMateria(),
                transferible.getNombre(),
                transferible.getPromocionable(),
                transferible.getCorrelativas()
        );
    }
    
    public static void eliminarMateria(Integer materiaID){
        cu.eliminarMateria(materiaID);
    }
}
