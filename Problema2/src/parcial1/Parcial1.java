/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package parcial1;
import java.io.*;

/**
 *
 * @author kevin.cortes
 */
public class Parcial1 {

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
            archivo = new File ("soldados.in");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            int tam;
            tam = Integer.parseInt(br.readLine());
            for (int i = 0; i < tam; i++) {
                String linea = "";
                linea = br.readLine();
                String cantida[] = linea.split(" ");
                int fila,colum;
                fila = Integer.parseInt(cantida[0]); //guardando Fila
                colum = Integer.parseInt(cantida[1]); //guardando Columnas
                int soldados[][] = new int[fila][colum];
                for (int j = 0; j < fila; j++) {
                    String separar[] = br.readLine().split(" ");
                    for (int k = 0; k < colum; k++) {
                        soldados[j][k] = Integer.parseInt(separar[k]);
                    }
                }
                boolean enc = false,sw;
                System.out.println("Matriz "+(i+1));
                //For de verificar si el Saldado va agarrado de la manido de 
                // algun compañero
                for (int j = 0; j < fila; j++) {
                    for (int k = 0; k < colum; k++) {
                        sw = false;                       
                        //derecha
                        if(soldados[j][k]==1){
                            if(!sw && (k+1) < colum){
                                if(soldados[j][k] == soldados[j][k+1]){
                                   sw = true; 
                                }
                            }
                            //iz
                            if(!sw && (k-1) >= 0){
                                if(soldados[j][k] == soldados[j][k-1]){
                                   sw = true; 
                                }
                            }    
                            //aba
                            if(!sw && (j+1) < fila){
                                if(soldados[j][k] == soldados[j+1][k]){
                                   sw = true; 
                                }
                            }   
                            //arriba
                            if(!sw && (j-1) >= 0){
                                if(soldados[j][k] == soldados[j-1][k]){
                                   sw = true; 
                                }
                            }
                            //arri dere
                            if(!sw && (k+1) < colum && (j-1) >= 0){
                                if(soldados[j][k] == soldados[j-1][k+1]){
                                   sw = true; 
                                }
                            }
                            //arri iz
                            if(!sw && (k-1) >= 0 && (j-1) >= 0){
                                if(soldados[j][k] == soldados[j-1][k-1]){
                                   sw = true; 
                                }
                            }
                            //abajo dere
                            if(!sw && (k+1) < colum && (j+1) < fila){
                                if(soldados[j][k] == soldados[j+1][k+1]){
                                   sw = true; 
                                }
                            }
                            //abajo iz
                            if(!sw && (k-1) >= 0 && (j+1) < fila){
                                if(soldados[j][k] == soldados[j+1][k-1]){
                                   sw = true; 
                                }
                            }
                            if(!sw){
                                enc = true;
                                System.out.println(j+" "+k);
                            }
                        }
                    }
                }
                if(!enc){
                    System.out.println("ninguno"); 
                }  
            }       
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   
}
