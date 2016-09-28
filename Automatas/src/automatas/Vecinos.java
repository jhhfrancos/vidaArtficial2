/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jhh
 */
public class Vecinos {

    /**
     * @param args the command line arguments
     */
    
    public int kVercinos = 2;
    public static void main(String[] args) {
        Vecinos automata = new Vecinos();
        int[][] grilla = new int[20][20];
        int iteraciones = 5;
        grilla = automata.inicializar(grilla);
        
        for(int j = 0; j<iteraciones; j++){
            grilla = automata.iteracion(grilla);
            for(int i = 0; i<grilla.length; i++){
                for(int k = 0; k <grilla.length; k++){
                    System.out.print(grilla[i][k]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public int[][] inicializar(int[][] grilla) {
        
        Random rand = new Random();
        int numero;
        for(int i = 0; i < grilla.length; i++){
            for(int j = 0; j < grilla.length; j++){
                numero = (rand.nextInt(3));
                grilla[i][j] = numero;
            }
            
        }
        return grilla;
    }

    public int[][] iteracion(int[][] grilla) {
        int colorActual;
        int numVecinos;
        
        for(int i = 0; i < grilla.length; i++){
            for(int j = 0; j <grilla.length; j++){
                colorActual = grilla[i][j];
                if(colorActual != 0){
                    numVecinos = calcularVecinos(grilla,i,j);
                    if(numVecinos>=kVercinos){
                        goToOther(grilla,i,j);
                    }
                }
            }
        }
        return grilla;
    }

    public int calcularVecinos(int[][] grilla, int i, int j) {
        int colorActual = grilla[i][j];
        int tamGrilla = grilla.length;
        int numVecinos = 0;
        int iSig = (((i + 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int jSig = (((j + 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int iAtr = (((i - 1) % tamGrilla) + tamGrilla) % tamGrilla;
        int jAtr = (((j - 1) % tamGrilla) + tamGrilla) % tamGrilla;
        // derecha
        numVecinos += (grilla[iSig][jSig] == colorActual || grilla[iSig][jSig] == 0)? 0: 1;
        numVecinos += (grilla[i][jSig] == colorActual || grilla[i][jSig] == 0)? 0: 1;
        numVecinos += (grilla[iAtr][jSig] == colorActual || grilla[iAtr][jSig] == 0)? 0: 1;
        numVecinos += (grilla[iSig][j] == colorActual || grilla[iSig][j] == 0)? 0: 1;
        numVecinos += (grilla[iAtr][j] == colorActual || grilla[iAtr][j] == 0)? 0: 1;
        numVecinos += (grilla[iAtr][jAtr] == colorActual || grilla[iAtr][jAtr] == 0)? 0: 1;
        numVecinos += (grilla[i][jAtr] == colorActual || grilla[i][jAtr] == 0)? 0: 1;
        numVecinos += (grilla[iAtr][jAtr] == colorActual || grilla[iAtr][jAtr] == 0)? 0: 1;
        return numVecinos;
    }

    public void goToOther(int[][] grilla, int i, int j) {
        int colorActual = grilla[i][j];
        Random rand = new Random();
        int x;
        int y;
        do{
            x = rand.nextInt(grilla.length);
            y = rand.nextInt(grilla.length);
            if(grilla[x][y]==0){
                grilla[x][y] = colorActual;
                grilla[i][j] = 0;
            }
        }while(grilla[i][j] != 0);
    }
    
    
}
