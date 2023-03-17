package com.aena.app;

import com.aena.app.view.MostrarPantalla;
import com.aena.app.model.Coste;
import com.aena.app.model.Empleados;
import com.aena.app.model.Material;

import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
            int numeroTrabajadores;
            System.out.println("Bienvenido a la app de anea!!!");

            ArrayList<Empleados> empleados = new ArrayList<>();

            ArrayList<Material> materiales = new ArrayList<>();

            numeroTrabajadores = MostrarPantalla.mPreguntarNumeroTrabajadores();
            MostrarPantalla.crearEmpleados(numeroTrabajadores, empleados);
            MostrarPantalla.crearMateriales(materiales);
            Coste costeEmpleados = new Coste(materiales, empleados);

            costeEmpleados.pAsignaPorcentaje();
            costeEmpleados.pAgregarDineroHijos();
            costeEmpleados.pAgregarDineroTiempo();
            costeEmpleados.pAgregarIrpf();
            costeEmpleados.pAsignarMateriales();

            MostrarPantalla.mostrarMaterialesEmpleado(costeEmpleados.getEmpleados());
            MostrarPantalla.mostrarDineroTotalGatadoEmpresa(costeEmpleados.getEmpleados());
            MostrarPantalla.mostrarSueldoNetoMedio(costeEmpleados.getEmpleados());
            MostrarPantalla.mostrarMediaHijos(costeEmpleados.getEmpleados());
            MostrarPantalla.MostrarNumeorEmpleadosCategorio(costeEmpleados.getEmpleados());
            MostrarPantalla.mostrarEmpleadoMayorSueldo(costeEmpleados.getEmpleados());

        }
  
}
