/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.gomez.sistema.universitario.Controller;

import com.milton.gomez.sistema.universitario.Model.*;
import com.milton.gomez.sistema.universitario.Transferible.TransferibleCarrera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author milton
 */
public class ControllerCarrera {
    
    //Inicialización del controlador.
    private static ControladorUniversitario cu = ControladorUniversitario.getInstance();
    
    public static List<Carrera> listarTodasLasCarreras(){
        return cu.obtenerCarreras();
    }
    
    public static void crearCarrera(TransferibleCarrera t){
        cu.crearCarrera(t.getNombre(), 
                t.getCodigoCarrera(), 
                t.getCantMateriasOptativasParaAprobar(), 
                t.getPlanDeEstudio(), 
                t.getCuatrimestres(), 
                null);
    }

    public static Carrera obtenerCarreraPorId(Integer id){
        return cu.obtenerCarrera(id);
    }
    
    public static List<Cuatrimestre> listarTodosLosCuatrimestres(Integer carreraId){
        HashMap<Integer, Cuatrimestre> cuatrimestres = cu.obtenerCarrera(carreraId).getCuatrimestres();
        ArrayList<Cuatrimestre> listaCuatrimestre = new ArrayList<>();
        cuatrimestres.forEach((k,v) -> listaCuatrimestre.add(v));

        return listaCuatrimestre;
    }
    
    public static Cuatrimestre listarCuatrimestre(Integer carreraId, Integer cuatrimestreId){
        return cu.obtenerCarrera(carreraId).getCuatrimestres().get(cuatrimestreId);
    }
    
    public static List<Materia> listarMateriasDeLaCarrera(Integer carreraId){
        return cu.obtenerCarrera(carreraId).obtenerMateriasDeLaCarrera();
    }
    
    public static void eliminarCarrera(Integer carreraID){
        cu.eliminarCarrera(carreraID);
    }
    
    public static DefaultTableModel obtenerCarrera(JTable table, String busqueda){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        try{
            Carrera c = getCarrera(busqueda);
            model.addRow(new Object[]{
            c.getCarreraID(),
            c.getCodigoCarrera(),
            c.getNombre(),
            c.getCantMateriasOptativasParaAprobar(),
            c.getCuatrimestres().size(),
            c.getPlanDeEstudio()
        });
        }
        catch(NullPointerException e){
            System.out.println("No se encuentra la carrera");
        }
        return model;
    }
    private static Carrera getCarrera(String busqueda){
        for (Carrera carrera : cu.obtenerCarreras()) {
            if (carrera.getNombre().equals(busqueda)) {
                return carrera;
            }
            else if(carrera.getCodigoCarrera().equals(busqueda)){
                return carrera;
            }
        }
        return null;
    }
    
    public static TransferibleCarrera obtenerDatosCarrera(Integer id){
        TransferibleCarrera transferible = new TransferibleCarrera();
        Carrera carrera = cu.obtenerCarrera(id);
        
        transferible.setNombre(carrera.getNombre());
        transferible.setCodigoCarrera(carrera.getCodigoCarrera());
        transferible.setAlumnos(carrera.getAlumnosList());
        transferible.setCantMateriasOptativasParaAprobar(carrera.getCantMateriasOptativasParaAprobar());
        transferible.setCuatrimestres(carrera.getCuatrimestres());
        transferible.setPlanDeEstudio(carrera.getPlanDeEstudio());
        transferible.setId(carrera.getCarreraID());
        
        return transferible;
    }

    public static boolean sePuedeEgresar(Integer carreraId, Integer alumnoId){
        Carrera carrera = cu.obtenerCarrera(carreraId);
        Alumno alumno = cu.obtenerAlumno(alumnoId);

        return carrera.sePuedeGraduar(alumno);
    }
    
    public static Cuatrimestre crearCuatrimestre(Integer nroCuatrimestre){
        return new Cuatrimestre(nroCuatrimestre);
    }
    
    public static void actualizarCarrera(TransferibleCarrera carrera){
        Carrera carreraActualizada = cu.obtenerCarrera(carrera.getId());
        
        carreraActualizada.setNombre(carrera.getNombre());
        carreraActualizada.setCodigoCarrera(carrera.getCodigoCarrera());
        carreraActualizada.setCantMateriasOptativasParaAprobar(carrera.getCantMateriasOptativasParaAprobar());
        carreraActualizada.setPlanDeEstudio(carrera.getPlanDeEstudio());
        carreraActualizada.setCuatrimestres(carrera.getCuatrimestres());
        
    }
}
