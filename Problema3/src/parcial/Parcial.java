/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author kevin.cortes
 */
public class Parcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
             // Apertura del fichero y creacion de BufferedReader para poder
             // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("bodega.in");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            int S,N;
            String datos[] = br.readLine().split(" ");
            S = Integer.parseInt(datos[0]); //Capacidad de la bodega
            N = Integer.parseInt(datos[1]); //Numero de Prodecto en la bodega
            
            int bodega[][] = new int[N][2]; //Matriz principal
            int bodegaAux[][] = new int[N][2]; //Matriz Aux de la Principal
            for (int i = 0; i < N; i++) {
                String linea = "";
                linea = br.readLine();
                String cantida[] = linea.split(" ");
                int a,b;
                a = Integer.parseInt(cantida[0]);
                b = Integer.parseInt(cantida[1]);
                bodega[i][0] = a; //Tamaño
                bodega[i][1] = b; //Ganancia
            }
            int mayor = 0,pos = 0;
            boolean sw = false;
            int x = 1;
            //Guardando la matriz de Bodega en un Aux
            for (int i = 0; i < N; i++) {
                bodegaAux[i][0] = bodega[i][0];
                bodegaAux[i][1] = bodega[i][1];
            }
            while(true){
                //Sumando los datos de la matriz con los valores ini del archivo
                for (int i = 0; i < N; i++) {
                    bodega[i][0] += bodegaAux[i][0];
                    bodega[i][1] += bodegaAux[i][1];                    
                }
                sw = false; //Inicialiamos en false
                for (int i = 0; i < N; i++) {
                    //Verifica si los valores estan igual o menor de lo dado
                    if(bodega[i][1] >= mayor && bodega[i][0] <= S){
                        mayor = bodega[i][1]; //Guardo el valor del mayor
                        pos = i; //Guardo la posicion del mayor
                        sw = true; //Activo sw para aumentar la X
                    }                                       
                }
                if(!sw){
                    for (int i = 0; i < N; i++) {
                        //Disminuimos los valores de la vodega restandole el Aux
                        //Porque si el SW es false no entro al condicinal del for
                        //anterior y se deben restan los valores sumados iniciando
                        //el ciclo
                        bodega[i][0] -= bodegaAux[i][0];
                        bodega[i][1] -= bodegaAux[i][1];                    
                    }
                    break;
                }else{
                    x++; //Aumentando X: Las veces que hemos repetido el ciclo
                         //Cuantas veces se esta registrando el producto 
                }                
            }
            System.out.println(bodega[pos][1]); //Ganancia total
            for (int i = 0; i < N; i++) {                
                if(i == pos){ 
                    System.out.println(x); //Las veces que se registro el prod
                }else{
                    System.out.println("0"); //Los demas cero
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
