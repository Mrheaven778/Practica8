package com.aena.app.view;

import com.aena.app.controller.Utilitis;
import com.aena.app.model.Empleados;
import com.aena.app.model.Material;

import java.util.ArrayList;
import java.util.Scanner;

public class MostrarPantalla {
    /**
     * Con este metodo crearemos empleado y preguntaremos que cargo anos de
     * antiguadad y hijos tiene
     *
     * @param cuestosEmpleadosSon int
     * @param empleados           ArrayList<Empleados>
     * @return ArrayList<Empleados>
     */
    public static void crearEmpleados(int cuestosEmpleadosSon, ArrayList<Empleados> empleados) {
        Scanner sc = new Scanner(System.in);
        String nombreEmpleado=" ";
        String apellidoEmpleado = " ";
        String direccionEmpleado =" ";
        float sueldoEmpleado = 0;
        int antiquity = 0;
        int hijosEmpleado = 0;
        int vacaciones = 0;
        int edadEmpleado = 0;
        for (int i = 0; i < cuestosEmpleadosSon; i++) {
            System.out.println("Introduca el nombre del empleado: ");
            nombreEmpleado = sc.nextLine();

            System.out.println("Introduca el apellido del empleado del empleado " + nombreEmpleado + ": ");
            apellidoEmpleado = sc.nextLine();

            System.out.println("Introduca la edad del empleado " + nombreEmpleado + ": ");
            edadEmpleado = Utilitis.comprobarNumeros(edadEmpleado);

            System.out.println("Introduca la direccion del empleado " + nombreEmpleado + ": ");
            direccionEmpleado = sc.nextLine();

            System.out.println("Introduca el sueldo anual del empleado " + nombreEmpleado + ": ");
            sueldoEmpleado = Utilitis.comprobarNumerosFloats(sueldoEmpleado);

            empleados.add(new Empleados(nombreEmpleado, apellidoEmpleado, sueldoEmpleado, edadEmpleado, direccionEmpleado));

            // Preguntamos si quiere cambiar el cargo
            if (MostrarPantalla.mPreguntarcargo() == 1) {
                empleados.get(i).pAsignarCargo();
            }

            // Preguntamos si quiere cambiar la antiguedad
            if (MostrarPantalla.mPreguntarAntiguedad() == 1) {
                empleados.get(i).setAntiquity(antiquity = Utilitis.comprobarNumeros(antiquity));
            }

            // Preguntamos si quiere cambiar los hijos
            if (MostrarPantalla.mPreguntarHijos() == 1) {
                empleados.get(i).setHijos(hijosEmpleado = Utilitis.comprobarNumeros(hijosEmpleado));
            }

            // Preguntamos si quiere cambiar las vacaciones
            if (MostrarPantalla.mPreguntarVacaciones() == 1) {
                empleados.get(i).setVacaciones(vacaciones = Utilitis.comprobarNumeros(vacaciones));
            }
        }
    }

    /**
     * Este metodo preguntara si quiere anadir un cargo nuevo al trabajador
     *
     * @return un int para saber si dea cambiarlo o no
     */
    public static int mPreguntarcargo() {
        int elecionUsiario = 0;
        do {
            System.out.println("Desa asignarle un cargo, por defecto es junior:");
            System.out.println("1 para asignar un cargo 2 para dejarlo en junior");
            elecionUsiario = Utilitis.comprobarNumeros(elecionUsiario);
        } while (elecionUsiario != 2 && elecionUsiario != 1);
        return elecionUsiario;
    }

    /**
     * Este metodo pregunta la antiguedad del empleado
     *
     * @return nos de vuelve la elecion del usuario para poder cambiar la antiguedad
     * o no
     */
    public static int mPreguntarAntiguedad() {
        int elecionUsiario = 0;
        do {
            System.out.println("Cuanto tiempo lleva en la empresa, por defecto son 0 años");
            System.out.println("1 para asignar antigüedad 2 para dejarlo en 0 años");
            elecionUsiario = Utilitis.comprobarNumeros(elecionUsiario);
        } while (elecionUsiario != 2 && elecionUsiario != 1);
        return elecionUsiario;
    }

    /**
     * Este metodo pregunta si tiene hijos
     *
     * @return nos de vuelve la elecion del usuario para poder cambiar los hijos
     */
    public static int mPreguntarHijos() {
        int elecionUsiario = 0;
        do {
            System.out.println("Cuanto hijos tiene, por defecto son 0 hijos");
            System.out.println("1 para asignar hijos 2 para dejarlo en 0 hijos");
            elecionUsiario = Utilitis.comprobarNumeros(elecionUsiario);
        } while (elecionUsiario != 2 && elecionUsiario != 1);
        return elecionUsiario;
    }

    /**
     * Este metodo pregunta si tiene vacaciones
     *
     * @return nos de vuelve la elecion del usuario para poder cambiar las vacaciones
     */
    public static int mPreguntarVacaciones() {
        int elecionUsiario = 0;
        do {
            System.out.println("Cuanto semanas de vacaciones tiene, por defecto son 4 semanas");
            System.out.println("1 para asignar semanas de vacaciones 2 para dejarlo en 4 semanas");
            elecionUsiario = Utilitis.comprobarNumeros(elecionUsiario);
        } while (elecionUsiario != 2 && elecionUsiario != 1);
        return elecionUsiario;
    }

    /**
     * Con este metodo pregutaremos cuanto trabajadores tienes
     *
     * @return int con el numero de trabajadores
     */
    public static int mPreguntarNumeroTrabajadores() {
        int numeroTrabajadores = 0;
        System.out.println("Cuantos trabajadores tiene: ");
        numeroTrabajadores = Utilitis.comprobarNumeros(numeroTrabajadores);
        return numeroTrabajadores;
    }

    /**
     * Este metodo mostrara el numero de trabajadorees que tienes y su tipo
     *
     * @param empleados un arry list de epleados
     */
    public static void MostrarNumeorEmpleadosCategorio(ArrayList<Empleados> empleados) {
        int numeroJunior = 0; //Declaro la variable numeroJunior y la inicializo a 0
        int numeroSenior = 0; //Declaro la variable numeroSenior y la inicializo a 0
        int numeroManager = 0; //Declaro la variable numeroManager y la inicializo a 0
        int numeroArquitecto = 0; //Declaro la variable numeroArquitecto y la inicializo a 0
        for (Empleados empleado : empleados) {
            //comprobamos si el empleado es junior
            if (empleado.getCargo().equals("junior")) numeroJunior += 1;

            //comprobamos si el empleado es senior
            if (empleado.getCargo().equals("senior")) numeroSenior += 1;

            //comprobamos si el empleado es manager
            if (empleado.getCargo().equals("manager")) numeroManager += 1;

            //comprobamos si el empleado es arquitecto
            if (empleado.getCargo().equals("arquitecto")) numeroArquitecto += 1;
        }
        System.out.println("--------------------");
        System.out.println("Tines " + empleados.size() + " empleados");
        System.out.println("Este es el numero de junios " + numeroJunior);
        System.out.println("Este es el numero de senior " + numeroSenior);
        System.out.println("Este es el numero de manager " + numeroManager);
        System.out.println("Este es el numero de arquitectos " + numeroArquitecto);
    }

    /**
     * Este parametro mostrara el empleado que mas sueldo bruto combre con su id
     * nombre y el dinero que gana
     *
     * @param empleados un array list de empleados
     */
    public static void mostrarEmpleadoMayorSueldo(ArrayList<Empleados> empleados) {
        // Variable para almacenar el sueldo más alto
        float mayorSueldo = 0;
        // Variable para almacenar el nombre del empleado con el sueldo más alto
        String nombreEmpleado = "";
        // Variable para almacenar el id del empleado con el sueldo más alto
        int idUsuario = 0;
        // Recorremos el array de empleados
        for (Empleados empleado : empleados) {
            // Comprobamos si el sueldo del empleado es mayor que el sueldo más alto
            if (empleado.getSueldo() > mayorSueldo) {
                // Actualizamos el sueldo más alto
                mayorSueldo = empleado.getSueldo();
                // Actualizamos el nombre del empleado con el sueldo más alto
                nombreEmpleado = empleado.getNombre();
                // Actualizamos el id del empleado con el sueldo más alto
                idUsuario = empleado.getIdUsuari();
            }
        }
        // Mostramos los datos del empleado con el sueldo más alto
        System.out.println("------------------------------------");
        System.out.println("El empleado que mas cobra es: " + nombreEmpleado + " con id: " + idUsuario + " con un total de " + mayorSueldo + " euros anuales");
    }

    /**
     * Mostraremos la media de hijos total de la empresa
     *
     * @param empleados array list de empleados
     */
    public static void mostrarMediaHijos(ArrayList<Empleados> empleados) {
        //Creamos una variable para ir sumando todos los hijos
        float numeroTotalHijos = 0;
        //Recorremos el array y vamos sumando los hijos
        for (Empleados empleado : empleados) {
            numeroTotalHijos += empleado.getHijos();
        }
        //Mostramos el resultado
        System.out.println("------------------------------------");
        System.out.println("La media total de hijos es: " + (numeroTotalHijos / empleados.size()));
    }

    /**
     * Mostrara la media de sueldo neto de la empresa
     *
     * @param empleados array list de empleados
     */
    public static void mostrarSueldoNetoMedio(ArrayList<Empleados> empleados) {
        // Declaramos una variable sueldoNetoTotal de tipo float y le asignamos el valor 0.
        float sueldoNetoTotal = 0;
        // Recorremos el ArrayList empleados con un for-each.
        for (Empleados empleado : empleados) {
            // Por cada empleado sumamos su sueldoNeto a la variable sueldoNetoTotal.
            sueldoNetoTotal += empleado.getSueldoNeto();
        }
        // Imprimimos en pantalla el sueldo medio total.
        System.out.println("------------------------------------");
        System.out.println("El sueldo medio total es: " + (sueldoNetoTotal / empleados.size()));
    }

    /**
     * Con este metodo mostraremos el sueldo total de dinero gastado por la empresa
     *
     * @param empleados un array list de empleados
     */
    public static void mostrarDineroTotalGatadoEmpresa(ArrayList<Empleados> empleados) {
        // se declara una variable float para almacenar el dinero total gastado
        float dineroTotalGastado = 0;
        // se recorre la lista de empleados
        for (Empleados empleado : empleados) {
            // se suma el sueldo del empleado mas el dinero de materiales gastado
            dineroTotalGastado += empleado.getSueldo() + empleado.getDineroMateriales();
        }
        // se muestra el dinero total gastado
        System.out.println("------------------------------------");
        System.out.println("El dinero total gasto por la empresa es: " + dineroTotalGastado);
    }

    /**
     * Con este metodo preguntamos cuantos materiales tenemos
     *
     * @param materiales es un array list de materiales
     * @return un array list con los materiales
     */
    public static void crearMateriales(ArrayList<Material> materiales) {
        int cantidadHerramientas = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos portatiles tienes de tipo 1: ");

        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("portatiltipo1"));
        }

        cantidadHerramientas = 0;
        System.out.println("Cuantos portatiles tienes de tipo 2: ");
        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("portatiltipo2"));
        }

        cantidadHerramientas = 0;
        System.out.println("Cuantos portatiles tienes de tipo 3: ");
        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("portatiltipo3"));
        }

        cantidadHerramientas = 0;
        System.out.println("Cuantos telefonos tienes de tipo 1: ");
        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("telefonotipo2"));
        }

        cantidadHerramientas = 0;
        System.out.println("Cuantos telefonos tienes de tipo 2: ");
        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("telefonotipo2"));
        }

        cantidadHerramientas = 0;
        System.out.println("Cuantos coches tienes: ");
        cantidadHerramientas = Utilitis.comprobarNumeros(cantidadHerramientas);
        for (int i = 0; i < cantidadHerramientas; i++) {
            materiales.add(new Material("coche"));
        }

    }


    /**
     * Este metodo mostrara los materiales que tiene cada empleado
     *
     * @param empleados lista de empleados
     */
    public static void mostrarMaterialesEmpleado(ArrayList<Empleados> empleados) {
        //Itero sobre todos los empleados
        for (Empleados empleado : empleados) {
            System.out.println("------------------------------------------------------------------");
            //Imprimo el nombre del empleado y el mensaje
            System.out.println("El empleado " + empleado.getNombre() + " con id: " + empleado.getIdUsuari() + ", con el cargo de: " + empleado.getCargo() + " y con un sueldo neto de " + empleado.getSueldoNeto() + " euros anuales al año" + " tiene como materiales los siguientes: ");
            //Itero sobre todos los materiales del empleado actual
            for (int i = 0; i < empleado.getMaterials().size(); i++) {
                //Imprimo el nombre del material y su id
                System.out.println("- " + empleado.getMaterials().get(i).getNombre() + " con el id: " + empleado.getMaterials().get(i).getIdMaterial());
            }
        }
    }
}
