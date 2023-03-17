package com.aena.app.controller;

import java.util.Scanner;

public class Utilitis {
    /**
     * Este  metodo comrpobara que se introducio una letra
     *
     * @param numeroComparar
     * @return int numero mayor que 0
     */
    public static int comprobarNumeros(int numeroComparar) {
        byte repetir = 0;
        Scanner sc = new Scanner(System.in);
        do {
            if (sc.hasNextInt()) {
                numeroComparar = sc.nextInt();
                if (numeroComparar > 0) {
                    repetir = 1;
                } else {
                    System.err.println("[ERROR]Introduca numeros enteros y no ponga 0 ni numeros negaticos, perdon por las molestias");
                    sc.next();
                    repetir = 0;
                }
            } else {
                System.err.println("[ERROR]Introduca numeros enteros y no ponga 0 ni numeros negaticos, perdon por las molestias");
                sc.next();
                repetir = 0;
            }
        } while (repetir == 0);
        return numeroComparar;
    }

    public static float comprobarNumerosFloats(float numeroComparar) {
        byte repetir = 0;
        Scanner sc = new Scanner(System.in);
        do {
            if (sc.hasNextFloat()) {
                numeroComparar = sc.nextFloat();
                if (numeroComparar > 0) {
                    repetir = 1;
                } else {
                    System.err.println("[ERROR]Introduca numeros y no ponga 0 ni numeros negaticos, perdon por las molestias");
                    sc.next();
                    repetir = 0;
                }
            } else {
                System.err.println("[ERROR]Introduca numeros y no ponga 0 ni numeros negaticos, perdon por las molestias");
                sc.next();
                repetir = 0;
            }
        } while (repetir == 0);
        return numeroComparar;
    }

    /**
     * Miramos si el cargo que ponga el usuario exite
     *
     * @param cargoComparar
     * @return boolean true si exite el cargo falso si no exite
     */
    public static boolean comprbarCategoria(String cargoComparar) {
        switch (cargoComparar) {
            case "junior":
                return true;
            case "senior":
                return true;
            case "manager":
                return true;
            case "arquitecto":
                return true;
            default:
                return false;
        }

    }
}
