/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migracion;

import java.util.Random;

/**
 *
 * @author Jhh
 * 
 * vision agentes 10 +- 6
 * 100 agentes
 * 50 +- 20 comida inicial 50*20%
 * 45 +-                    45*20%
 * 
 * 
 * Ley de pareto, power law y zipf law
 * 
 * ley de potencias: para explicar el sistema oculto, fenomeno subyacente
 * 
 * Estado critico es el unico lugar donde se da la emergencia y estructuras complejas...estar vivo...patrones en el espacio 
 * tiempo
 */
public class WarmingUp {
    private int[][] grid =new int[80][80];
    private int cantidadComidaInicial = 50, desviacion = 20, puntoIniciali, puntoInicialj;

    public WarmingUp() {
        llenarCerosMatriz();
        cargarMatriz();
    }
    public double gaussian(){
        
        double x,y;
        double r;
        do {
            x = 2.0 * Math.random() - 1.0;
            y = 2.0 * Math.random() - 1.0;
            r = x * x + y * y;
        } while (r >= 1.0);

        double z = Math.sqrt( -2.0 * Math.log(r) / r);
        return y * z;
    }
    private void llenarCerosMatriz(){
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid.length; j++)
                grid[i][j] = 0;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    
    public void cargarMatriz(){
        Random randPos = new Random();
        int tamMatriz = grid.length;
        //Crear punto inicial
        int celda = randPos.nextInt();
        int posicionPuntoi = ((celda % (tamMatriz/2)) + (tamMatriz/2)) % (tamMatriz/2) + 1;
        celda = randPos.nextInt();
        int posicionPuntoj = ((celda % (tamMatriz/2)) + (tamMatriz/2)) % (tamMatriz/2) - 1;
        puntoIniciali = posicionPuntoi;
        puntoInicialj = posicionPuntoj;
        while(){
            generarCantidadComida(puntoIniciali, puntoInicialj, punto, celda)
            situarComida(posicionPuntoi,posicionPuntoj,grid,comida);
        }
    }
    private void gridContieneCeros(){
        
    }
    private int generarCantidadComida(int posIniciali, int posinicialj, int posi, int posj){
        
    }
    private int[][] situarComida(int posi, int posj, int[][] grid1, int comida){
        if(!(posi >= grid1.length || posj >= grid1.length || posi < 0 || posj < 0 || grid1[posi][posj] == 0)){
            grid1[posi][posj] = comida;
        }
        return grid1;
    }
    
    public static void main(String[] args) {
        WarmingUp waming = new WarmingUp();
        //System.out.println(grid.length + "");
    }
}
