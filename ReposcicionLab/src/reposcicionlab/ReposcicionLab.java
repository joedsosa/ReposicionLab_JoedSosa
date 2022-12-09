/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reposcicionlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joeds
 */
public class ReposcicionLab {

    /**
     * @param args the command line arguments
     */
    static List<Carro> cars = new ArrayList<Carro>();
    static List<Pieza> piezas = new ArrayList<Pieza>();
    static boolean juegoTerminado = false;
    static boolean suecosGanan = false;
    static boolean moscovitasGanan = false;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner stc = new Scanner(System.in);
        String resp = "";
        do {

            System.out.println("Bienvenido a la Reposicion del Laboratorio: ");
            System.out.println("Hola Memo, Hola Stephanie");
            System.out.println("Sleccione el Ejericio que desea revisar: ");
            System.out.println("1) Ajedrez Nordico");
            System.out.println("2) Sistema de Venta de Carros ");
            int opciones = stc.nextInt();
            switch (opciones) {

                case 1:// llamar metodo
                {
                    System.out.println(" Bienvenido a el Ejercicio 1: AJEDREZ NORDICO ");
                    Ejercicio1();
                    break;
                }

                case 2: // llamar metodo
                {
                    System.out.println("Bienvenido a el Ejercicio 2: HERMANOS RODRIGUEZ");
                    MenuCarros();
                    break;
                }

            }
            System.out.println("Desea continuar S para continuar, cualquier otra tecla para salir!");
            resp = stc.nextLine();
        } while ("s".equalsIgnoreCase(resp) || "S".equalsIgnoreCase(resp));

    }

    public static void Ejercicio1() {
        imprimirMatriz(situacionInicialPiezas());
        int numJugador = 1;
        String controlPiezas = "Moscovitas";
        String controlPiezasChar = "M";
        Random r = new Random();
        int numRandom = r.nextInt(5) + 1;
        if (numRandom % 2 == 0) {
            numJugador = 1;
        } else {
            numJugador = 2;
        }
        do {
            boolean movimiento = false;
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println(" -------------------------------------- ");
                System.out.println("Jugador " + numJugador + " usted controla los " + controlPiezas);
                System.out.println("Ingrese las coordenadas para seleccionar su pieza");
                System.out.print("Coordenada X(columnas 0 - 9):");
                int pos1X = sc.nextInt();
                System.out.print("Coordenada Y (filas 0 - 9):");
                int pos1Y = sc.nextInt();
                System.out.println("Ingrese las coordenadas donde desea mover su pieza");
                System.out.print("Coordenada X (columnas 0 - 9):");
                int pos2X = sc.nextInt();
                System.out.print("Coordenada Y (filas 0 - 9):");
                int pos2Y = sc.nextInt();
                System.out.println(" -------------------------------------- ");
                movimiento = setMovimiento(pos1X, pos1Y, pos2X, pos2Y, controlPiezasChar);
            } while (!movimiento);
            boolean terminado = juegoTerminado();
            imprimirMatriz(piezas);
            if (terminado) {
                juegoTerminado = true;
            }
            if (numJugador == 1) {
                numJugador = 2;
                controlPiezas = "Suecos";
                controlPiezasChar = "S";
            } else if (numJugador == 2) {
                numJugador = 1;
                controlPiezas = "Moscovitas";
                controlPiezasChar = "M";
            }
        } while (!juegoTerminado);
        System.out.println(" ############# JUEGO TERMINADO ############# ");
        if (suecosGanan) {
            System.out.println(" ############# LOS SUECOS GANAN ############# ");
        }

        if (suecosGanan) {
            System.out.println(" ############# LOS MOSCOVITAS GANAN ############# ");
        }

    }

    public static void MenuCarros() {

        int opcion = 0;
        do {
            System.out.println("");
            System.out.println("");
            System.out.print("*** REGISTRO DE CARROSS ***\n");
            System.out.println(" -------------------------------------- ");
            System.out.print("1 - Agregar\n");
            System.out.print("2 - Leer\n");
            System.out.print("3 - Modificar \n");
            System.out.println("4 - Eliminar ");
            System.out.println("5. salir");
            Scanner sc1 = new Scanner(System.in);
            opcion = sc1.nextInt();
            switch (opcion) {
                case 1: {
                    addCarro();
                    break;
                }
                case 2: {
                    leerCarro();
                    break;
                }
                case 3: {
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Que carro desea modificar: ");
                    String param = sc3.nextLine();

                    System.out.println("Que desea editar: ");
                    Carro car = new Carro();
                    System.out.print("Ingrese el VIN del carro ");
                    String VIN = sc3.nextLine();
                    System.out.print("Ingrese la Marca del carro:  ");
                    String Marca = sc3.nextLine();
                    System.out.print("Ingrese el modelo del carro: ");
                    String modelo = sc3.nextLine();
                    System.out.print("Ingrese el color del carro:");
                    String color = sc3.nextLine();
                    System.out.print("Ingrese el año del carro: ");
                    int año = sc3.nextInt();
                    car.setVIN(VIN);
                    car.setModelo(modelo);
                    car.setMarca(Marca);
                    car.setColor(color);
                    car.setAño(0);
                    cars.add(car);
                    ModificarCarro(modelo, car);

                    break;
                }
                case 4: {
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Ingrese el nombre:");
                    String param = sc2.nextLine();
                    removeCarro(param);
                    break;
                }
                case 5: {
                    System.out.println("Bye");
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                }

            }
        } while (opcion != 5);
    }

    public static void addCarro() {
        Scanner sc = new Scanner(System.in);
        Carro car = new Carro();
        System.out.print("Ingrese el VIN del carro ");
        String VIN = sc.nextLine();
        System.out.print("Ingrese la Marca del carro:  ");
        String Marca = sc.nextLine();
        System.out.print("Ingrese el modelo del carro: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese el color del carro:");
        String color = sc.nextLine();
        System.out.print("Ingrese el año del carro: ");
        int año = sc.nextInt();
        car.setVIN(VIN);
        car.setModelo(modelo);
        car.setMarca(Marca);
        car.setColor(color);
        car.setAño(0);
        cars.add(car);

    }

    public static void removeCarro(String param) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getModelo());
            if (param.equals(cars.get(i).getModelo())) {
                cars.remove(i);

            }
        }
    }

    public static void leerCarro() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
            System.out.println("");
        }
    }

    public static void ModificarCarro(String param, Carro carro) {
        for (int i = 0; i < cars.size(); i++) {
            //System.out.println(cars.get(i).getModelo());
            if (param.equals(cars.get(i).getModelo())) {
                cars.get(i).setModelo(carro.getModelo());
                cars.get(i).setColor(carro.getColor());
                cars.get(i).setMarca(carro.getMarca());
                cars.get(i).setVIN(carro.getVIN());
                cars.get(i).setAño(carro.getAño());

            }
        }
    }
    public static boolean juegoTerminado() {
        List<Pieza> moscovitas = new ArrayList<Pieza>();
        boolean juegoTerminado=false;
        int posRey=0;
        int i=0;
        Pieza piezaRey = new Pieza();
        for (Pieza pieza : piezas) {
            // LOCALIZAR LA PIEZA DEL REY
            if(pieza.isRey()){
                piezaRey=pieza;
                posRey=i;
            }
            if("M".equals(pieza.getTipo())){
                moscovitas.add(pieza);
            }
            i++;
        }
        
        // EL REY HA LLEGADO AL BORDE
        // LOS BORDES EN COORDENADAS
        if(piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==1 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==2 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==3 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==4 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==5 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==6 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==7 ||
           piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==8){
           suecosGanan=true;
           juegoTerminado=true;
        }
        
        if(piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==1 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==2 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==3 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==4 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==5 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==6 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==7 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==0){
           suecosGanan=true;
           juegoTerminado=true;
        }
        
        if(piezaRey.getCoordenadaX()==0 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==1 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==2 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==3 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==4 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==5 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==6 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==7 && piezaRey.getCoordenadaY()==8 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==8){
           suecosGanan=true;
           juegoTerminado=true;
        }
        
        if(piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==0 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==1 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==2 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==3 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==4 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==5 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==6 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==7 ||
           piezaRey.getCoordenadaX()==8 && piezaRey.getCoordenadaY()==8){
           suecosGanan=true;
           juegoTerminado=true;
        }
        
        // EL REY ESTA RODEADO DE MOSCOVITAS
        // TRAER SOLO PIEZAS MOSCOVITAS
        if(!suecosGanan){
            int moscovitasRodeando=0;
            for (Pieza moscovita : moscovitas) {
                if(piezaRey.getCoordenadaX()+1==moscovita.getCoordenadaX()){
                    moscovitasRodeando++;
                }
                if(piezaRey.getCoordenadaY()+1==moscovita.getCoordenadaY()){
                    moscovitasRodeando++;
                }
            }
            if(moscovitasRodeando>3){
                moscovitasGanan=true;
            }
        }
        
        
        return juegoTerminado;
    }
    
    public static List<Pieza> situacionInicialPiezas() {
        // Moscovitas
        Pieza pieza = new Pieza();
        pieza.setActivo(true);
        pieza.setCoordenadaX(0);
        pieza.setCoordenadaY(3);
        pieza.setTipo("M");
        piezas.add(pieza);
        
        Pieza pieza2 = new Pieza();
        pieza2.setActivo(true);
        pieza2.setCoordenadaX(0);
        pieza2.setCoordenadaY(4);
        pieza2.setTipo("M");
        piezas.add(pieza2);
        
        Pieza pieza3 = new Pieza();
        pieza3.setActivo(true);
        pieza3.setCoordenadaX(0);
        pieza3.setCoordenadaY(5);
        pieza3.setTipo("M");
        piezas.add(pieza3);
        
        Pieza pieza4 = new Pieza();
        pieza4.setActivo(true);
        pieza4.setCoordenadaX(1);
        pieza4.setCoordenadaY(4);
        pieza4.setTipo("M");
        piezas.add(pieza4);
        
        Pieza pieza5 = new Pieza();
        pieza5.setActivo(true);
        pieza5.setCoordenadaX(3);
        pieza5.setCoordenadaY(0);
        pieza5.setTipo("M");
        piezas.add(pieza5);
        
        Pieza pieza6 = new Pieza();
        pieza6.setActivo(true);
        pieza6.setCoordenadaX(4);
        pieza6.setCoordenadaY(0);
        pieza6.setTipo("M");
        piezas.add(pieza6);
        
        Pieza pieza7 = new Pieza();
        pieza7.setActivo(true);
        pieza7.setCoordenadaX(5);
        pieza7.setCoordenadaY(0);
        pieza7.setTipo("M");
        piezas.add(pieza7);
        
        Pieza pieza8 = new Pieza();
        pieza8.setActivo(true);
        pieza8.setCoordenadaX(4);
        pieza8.setCoordenadaY(1);
        pieza8.setTipo("M");
        piezas.add(pieza8);
        
        Pieza pieza9 = new Pieza();
        pieza9.setActivo(true);
        pieza9.setCoordenadaX(8);
        pieza9.setCoordenadaY(3);
        pieza9.setTipo("M");
        piezas.add(pieza9);
        
        Pieza pieza10 = new Pieza();
        pieza10.setActivo(true);
        pieza10.setCoordenadaX(8);
        pieza10.setCoordenadaY(4);
        pieza10.setTipo("M");
        piezas.add(pieza10);
        
        Pieza pieza11 = new Pieza();
        pieza11.setActivo(true);
        pieza11.setCoordenadaX(8);
        pieza11.setCoordenadaY(5);
        pieza11.setTipo("M");
        piezas.add(pieza11);
        
        Pieza pieza12 = new Pieza();
        pieza12.setActivo(true);
        pieza12.setCoordenadaX(7);
        pieza12.setCoordenadaY(4);
        pieza12.setTipo("M");
        piezas.add(pieza12);
        
        Pieza pieza13 = new Pieza();
        pieza13.setActivo(true);
        pieza13.setCoordenadaX(4);
        pieza13.setCoordenadaY(8);
        pieza13.setTipo("M");
        piezas.add(pieza13);
        
        Pieza pieza14 = new Pieza();
        pieza14.setActivo(true);
        pieza14.setCoordenadaX(3);
        pieza14.setCoordenadaY(8);
        pieza14.setTipo("M");
        piezas.add(pieza14);
        
        Pieza pieza15 = new Pieza();
        pieza15.setActivo(true);
        pieza15.setCoordenadaX(5);
        pieza15.setCoordenadaY(8);
        pieza15.setTipo("M");
        piezas.add(pieza15);
        
        Pieza pieza16 = new Pieza();
        pieza16.setActivo(true);
        pieza16.setCoordenadaX(4);
        pieza16.setCoordenadaY(7);
        pieza16.setTipo("M");
        piezas.add(pieza16);
        
        // REY
        Pieza piezaRey = new Pieza();
        piezaRey.setActivo(true);
        piezaRey.setRey(true);
        piezaRey.setCoordenadaX(4);
        piezaRey.setCoordenadaY(4);
        piezaRey.setTipo("S");
        piezas.add(piezaRey);
        
        // SUECOS
        Pieza pieza17 = new Pieza();
        pieza17.setActivo(true);
        pieza17.setCoordenadaX(4);
        pieza17.setCoordenadaY(5);
        pieza17.setTipo("S");
        piezas.add(pieza17);
        
        Pieza pieza18 = new Pieza();
        pieza18.setActivo(true);
        pieza18.setCoordenadaX(4);
        pieza18.setCoordenadaY(6);
        pieza18.setTipo("S");
        piezas.add(pieza18);
        
        Pieza pieza19 = new Pieza();
        pieza19.setActivo(true);
        pieza19.setCoordenadaX(5);
        pieza19.setCoordenadaY(4);
        pieza19.setTipo("S");
        piezas.add(pieza19);
        
        Pieza pieza20 = new Pieza();
        pieza20.setActivo(true);
        pieza20.setCoordenadaX(6);
        pieza20.setCoordenadaY(4);
        pieza20.setTipo("S");
        piezas.add(pieza20);
        
        Pieza pieza21 = new Pieza();
        pieza21.setActivo(true);
        pieza21.setCoordenadaX(2);
        pieza21.setCoordenadaY(4);
        pieza21.setTipo("S");
        piezas.add(pieza21);
        
        Pieza pieza22 = new Pieza();
        pieza22.setActivo(true);
        pieza22.setCoordenadaX(3);
        pieza22.setCoordenadaY(4);
        pieza22.setTipo("S");
        piezas.add(pieza22);
        
        Pieza pieza23 = new Pieza();
        pieza23.setActivo(true);
        pieza23.setCoordenadaX(4);
        pieza23.setCoordenadaY(2);
        pieza23.setTipo("S");
        piezas.add(pieza23);
        
        Pieza pieza24 = new Pieza();
        pieza24.setActivo(true);
        pieza24.setCoordenadaX(4);
        pieza24.setCoordenadaY(3);
        pieza24.setTipo("S");
        piezas.add(pieza24);
        
        return piezas;
    }

    /*public static void imprimirMatriz(List<Pieza> piezas) {
        char matriz[][] = new char[9][9];
        String tablero="";  
        System.out.println(" 0  1  2  3  4  5  6  7  8");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                Pieza piezaExiste=existePiezaEnCoordenadas(piezas,j,i);
                String piezaString="";
                if(j==8){
                    piezaString+=getFiguraPieza(piezaExiste,true);
                    tablero+=piezaString;
                }else{
                    piezaString+=getFiguraPieza(piezaExiste,false);
                    tablero+=piezaString;
                }
            }
        }
        System.out.println(tablero);
    }*/
    
    public static void imprimirMatriz(List<Pieza> piezas) {
        char matriz[][] = new char[9][9];
        String tablero="";  
        System.out.println(" 0  1  2  3  4  5  6  7  8");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                Pieza piezaExiste=existePiezaEnCoordenadas(piezas,j,i);
                String piezaString="";
                if(j==8){
                    piezaString=getFiguraPieza(piezaExiste,true);
                    tablero+=piezaString;
                }else{
                    piezaString=getFiguraPieza(piezaExiste,false);
                    tablero+=piezaString;
                }
            }
        }
        System.out.println(tablero);
    }
    
    public static Pieza existePiezaEnCoordenadas(List<Pieza> piezas,int posX, int posY) {
        Pieza piezaReturn = new Pieza();
        for (Pieza pieza : piezas) {
            if((pieza.getCoordenadaX()==posX && pieza.getCoordenadaY()==posY) && pieza.isActivo()){
                piezaReturn.setExiste(true);
                piezaReturn.setTipo(pieza.getTipo());
                piezaReturn.setRey(pieza.isRey());
            }
        }
        return piezaReturn;
    }
    
    public static String getFiguraPieza(Pieza piezaAEvaluar, boolean isFinalLine) {
        String piezaString="";
        if(piezaAEvaluar.isExiste()){
            if("M".equals(piezaAEvaluar.getTipo())){
                piezaString="[#]";
            }else{
                piezaString="[+]";
            }
            if(piezaAEvaluar.isRey()){
                piezaString="[R]";
            }
        }
        if(piezaString.length()<1){
             piezaString="[ ]";
        }
        if(isFinalLine){
            piezaString+="\n";
        }
        return piezaString;
    }
    
    public static boolean setMovimiento(int posX1, int posY1,int posX2, int posY2,String tipo) {
        String error="";
        Pieza pienzaEncontrada = new Pieza();
        boolean piezaExiste=false;
        boolean posOcupada=false;
        int posPiezaExiste=0;
        int i=0;
        for (Pieza pieza : piezas) {
            // LA FICHA QUE QUEREMOS MOVER EXISTE
            if((pieza.getCoordenadaX()==posX1 && pieza.getCoordenadaY()==posY1) && pieza.isActivo()){
                piezaExiste=true;
                pienzaEncontrada=pieza;
                posPiezaExiste=i;
            }
            // ESTA OCUPADA ESA POSICION
            if((pieza.getCoordenadaX()==posX2 && pieza.getCoordenadaY()==posY2) && pieza.isActivo()){
                posOcupada=true;
            }
            i++;
        }
        
        // SI LA POSICION NO ESTA OCUPADA PERO ES MOVIMIENTO EN DIAGONAL 
        boolean errorMoveDiagonal=false;
        if(pienzaEncontrada.getCoordenadaX()!=posX2){
            if(pienzaEncontrada.getCoordenadaY()==posY2){
                errorMoveDiagonal=false;
            }else{
                errorMoveDiagonal=true;
                error="Solo es permitido mover en vertical y horizontal";
            }
        }
        
        if(pienzaEncontrada.getCoordenadaY()!=posY2){
            if(pienzaEncontrada.getCoordenadaX()==posX2){
                errorMoveDiagonal=false;
            }else{
                errorMoveDiagonal=true;
                error="Solo es permitido mover en vertical y horizontal";
            }
        }
        boolean moverPieza=false;
        if(piezaExiste){
            if(!posOcupada){
                if(tipo.equals(pienzaEncontrada.getTipo())){
                    moverPieza=true;
                }else{
                    error="La pieza que quiere mover no pertence a sus piezas";
                }
            }else{
                error="La posicion que ha establecido esta ocupada";
            }
        }else{
            error="No existe pieza en la posicion que ha establecido";
        }
        
        if(errorMoveDiagonal){
            moverPieza=false;
        }
        
        if(moverPieza){
            piezas.get(posPiezaExiste).setCoordenadaX(posX2);
            piezas.get(posPiezaExiste).setCoordenadaY(posY2);
        }
        System.out.println(error);
        return moverPieza;
    }
}
