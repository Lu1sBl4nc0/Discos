/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discos;

import java.util.Scanner;

/**
 *
 * @author LuisMiguel_Blanco
 *Version 1.0
 * 
 *
 */
public class Discos {

  // N determina el tamaño del array
  static int N = 100;
  
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      
      
    //Crea el array de discos
    Disco[] arrayAlbums = new Disco[N];

    // Crea todos los discos que van en cada una de
    // las celdas del array
    for(int i = 0; i < N; i++) {
      arrayAlbums[i] = new Disco();
    }

    int opcion;
    String codigoIntroducido;
    String autorIntroducido;
    String tituloIntroducido;
    String generoIntroducido;
    String duracionIntroducidaString;
    int duracionIntroducida;
    int primeraLibre;
    int i=0;
    
do {
      System.out.println("\n\nCOLECCIÓN DE DISCOS");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Nuevo disco");
      System.out.println("3. Modificar");
      System.out.println("4. Borrar");
      System.out.println("5. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = Integer.parseInt(entrada.nextLine());
      
      switch (opcion) {
      case 1:
            listado(i, arrayAlbums, false);
        break;
        
      case 2:
            primeraLibre = Nuevo_disco();
        do {
          primeraLibre++;
        } while (!((arrayAlbums[primeraLibre].codigo.equals("LIBRE"))));
        
        System.out.println("Por favor, introduzca los datos del disco.");  
        
        System.out.print("Código: ");
        codigoIntroducido = entrada.nextLine();
        arrayAlbums[primeraLibre].setCodigo(codigoIntroducido);
        
        System.out.print("Autor: ");
        autorIntroducido = entrada.nextLine();
        arrayAlbums[primeraLibre].setAutor(autorIntroducido);
        
        System.out.print("Título: ");
        tituloIntroducido = entrada.nextLine();
        arrayAlbums[primeraLibre].setTitulo(tituloIntroducido);
        
        System.out.print("Género: ");
        generoIntroducido = entrada.nextLine();
        arrayAlbums[primeraLibre].setGenero(generoIntroducido);
        
        System.out.print("Duración: ");
        duracionIntroducida = Integer.parseInt(entrada.nextLine());
        arrayAlbums[primeraLibre].setDuracion(duracionIntroducida);
        
        break;
        
      case 3:
            codigoIntroducido = Modificar(entrada);
  
        i = -1;
        do {
          i++;
        } while (!((arrayAlbums[i].codigo.equals(codigoIntroducido))));
        
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
  
        System.out.println("Código: " + arrayAlbums[i].getCodigo());
        System.out.print("Nuevo código: ");
        codigoIntroducido = entrada.nextLine();
        if (!codigoIntroducido.equals("")) {
          arrayAlbums[i].setCodigo(codigoIntroducido);
        }
        
        System.out.println("Autor: " + arrayAlbums[i].getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = entrada.nextLine();
        if (!autorIntroducido.equals("")) {
          arrayAlbums[i].setAutor(autorIntroducido);
        }
        
        System.out.println("Título: " + arrayAlbums[i].getTitulo());
        System.out.print("Nuevo título: ");
        tituloIntroducido = entrada.nextLine();
        if (!tituloIntroducido.equals("")) {
          arrayAlbums[i].setTitulo(tituloIntroducido);
        }
        
        System.out.println("Género: " + arrayAlbums[i].getGenero());
        System.out.print("Nuevo género: ");
        generoIntroducido = entrada.nextLine();
        if (!generoIntroducido.equals("")) {
          arrayAlbums[i].setGenero(generoIntroducido);
        }
        
        System.out.println("Duración: " + arrayAlbums[i].getDuracion());
        System.out.print("Duración: ");
        duracionIntroducidaString = entrada.nextLine();
        if (!duracionIntroducidaString.equals("")) {
          arrayAlbums[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
        }
        
        break;
        
      case 4:
            codigoIntroducido = Borrar_Disco(entrada);
  
        i = -1;
        do {
          i++;
        } while (!((arrayAlbums[i].codigo.equals(codigoIntroducido))));
        arrayAlbums[i].setCodigo("LIBRE");
        System.out.println("Album borrado.");
        
        break;
        
      default:
      
      } // switch
    } while (opcion != 5);
  }

    private static String Borrar_Disco(Scanner entrada) {
        String codigoIntroducido;
        System.out.println("\nBORRAR");
        System.out.println("======");
        System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
        codigoIntroducido = entrada.nextLine();
        return codigoIntroducido;
    }
   /**
    * 
    * @param entrada Introduce el disco
    * @return Retorna el codigo Introducido
    */
   
    private static String Modificar(Scanner entrada) {
        String codigoIntroducido;
        System.out.println("\nMODIFICAR");
        System.out.println("===========");
        System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
        codigoIntroducido = entrada.nextLine();
        return codigoIntroducido;
    }

    /**
     * 
     * @return  Codigo del disco
     */
    
    private static int Nuevo_disco() {
        int primeraLibre;
        System.out.println("\nNUEVO DISCO");
        System.out.println("===========");
        // Busca la primera posición libre del array
        primeraLibre = -1;
        return primeraLibre;
    }

    /**
     * @return primera posicion libre
     * @param i
     * @param arrayAlbums
     * @param orden 
     */
    private static void listado(int i, Disco[] arrayAlbums, Boolean orden) {
        System.out.println("\nLISTADO");
        System.out.println("=======");
        for(i = 0; i < N; i++) {
            if (!arrayAlbums[i].codigo.equals("LIBRE")) {
                System.out.println(arrayAlbums[i]);
            }
        }
    }
}
