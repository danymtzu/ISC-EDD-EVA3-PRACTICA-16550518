/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_sorting;

import java.util.Scanner;

/**
 *
 * @author 16550518
 */
public class EVA3_1_SORTING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int[] iArreglo= new int [1000000];
        int[] iArreglo2= new int [1000000]; 
        int[] iArreglo3= new int [1000000];
        int[] iArreglo4= new int [1000000];
        //llenar con valores aleatorios
        for (int i = 0; i < iArreglo.length; i++) {
            iArreglo[i]= (int)(Math.random()*100)+1;
        }
        for (int i = 0; i < iArreglo2.length; i++) {
            iArreglo2[i]= (int)(Math.random()*100)+1;
        }
        for (int i = 0; i < iArreglo3.length; i++) {
            iArreglo3[i]= (int)(Math.random()*100)+1;
        }
        for (int i = 0; i < iArreglo3.length; i++) {
            iArreglo4[i]= (int)(Math.random()*100)+1;
        }
        
        int cont=0;
        for (int i = 0; i < 10; i++) {
            cont++;
        System.out.println("ARREGLO DE 1,000,000 ELEMENTOS "+ cont+ "\n");
        
        //SELECTION SORT
        System.out.println("SELECTION SORT ");
        //imprimirArreglo(iArreglo);
        long nIni = System.nanoTime();
        selectionSort(iArreglo);
        long nFin = System.nanoTime();
        //imprimirArreglo(iArreglo);
        System.out.println(nFin-nIni+ " nanoseg");
        
        
        // INSERTION SORT
        System.out.println("INSERTION SORT ");
        //imprimirArreglo(iArreglo2);
        long nIni2 = System.nanoTime();
        insertionSort(iArreglo2);
        long nFin2 = System.nanoTime();
        //imprimirArreglo(iArreglo2);
        System.out.println(nFin2-nIni2 + " nanoseg");
        
        // BUBBLE SORT
        System.out.println("BUBBLE SORT ");
        //imprimirArreglo(iArreglo3);
        long nIni3 = System.nanoTime();
        bubbleSort(iArreglo3);
        long nFin3 = System.nanoTime();
        //imprimirArreglo(iArreglo3);
        System.out.println(nFin3-nIni3+ " nanoseg");
        
        // QUICK SORT
        System.out.println("QUICK SORT ");
        //imprimirArreglo(iArreglo4);
        long nIni4 = System.nanoTime();
        quickSort(iArreglo4, 0, iArreglo4.length-1);
        long nFin4 = System.nanoTime();
        //imprimirArreglo(iArreglo4);
        System.out.println(nFin4-nIni4+ " nanoseg");
        
        }
        
       /* Scanner s = new Scanner(System.in);
        System.out.println("Valor a buscar:");
        int iVal= s.nextInt();
        int iResum=binarySearch(iArreglo, iVal);
        System.out.println(iResum);*/
       
        
    }
    
    public static void imprimirArreglo(int[] iArre){
        for (int i = 0; i < iArre.length; i++) {
            System.out.print("["+ iArre[i] +"]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(int[] iArre){
        for (int i = 0; i < iArre.length-1; i++) {
            int iMin= i;
            for (int j = i+1; j < iArre.length; j++) {
                if(iArre[j]< iArre[iMin])
                    iMin=j;
                    
                    int iTemp = iArre[i];
                    iArre[i] = iArre[iMin];
                    iArre[iMin] = iTemp;
            }
        }
    }
     
    
    /*public static void selectionSort(int[] iArre){
         
        int iComp = 0;
        int iSwap=0;
        for (int i = 0; i < iArre.length; i++) {
           
            int iMin=i; //Suponemos que es el mas pequeño
         
            for (int j = i+1; j < iArre.length; j++) {//BUSCAR EL MAS PEQUEÑO
                
                if(iArre[j]<iArre[iMin]){
                    iMin= j;//GUARDAR LA POSICION EN J
                   
                }
                iComp++;
                
            }//TERMINAMOS DE USCAR E INTERCAMBIAMOS
            int iTemp=iArre[iMin];
            iArre[iMin]= iArre[i];
            iArre[i]= iTemp;
            iSwap++;
        }
        
        System.out.println("Comparaciones:" +iComp);
        System.out.println("Intercambios:" +iSwap);
        
    }*/
    
    public static void insertionSort(int[] iArre){
        
        
        for (int i = 0; i < iArre.length; i++) {
            
            int iTemp= iArre[i];
            int j=i;
            while((j>0)&& (iTemp < iArre[j-1])){
                iArre[j]=iArre[j-1];
                j--;
                
            }
                iArre[j]=iTemp;
        }
        
    }
        
    
    public static void bubbleSort(int iArre[]){
        
        boolean bSorted= false;
        int iLast= iArre.length-1;
        
        for (int i = 0; (i < iLast)&& !bSorted; i++) {
            bSorted=true;
            for (int j = iLast; j > i; j--) {
                if(iArre[j-1]> iArre[j]){
                    int iTemp = iArre[j];
                    iArre[j] = iArre[j-1];
                    iArre[j-1] = iTemp;
                    bSorted= false;
                }
                    
            }
        }
    }
    
    public static void quickSort(int iArre[],int iIzq, int iDerch){
        
        int iPivote= iArre[iIzq];
        int i=iIzq;
        int j=iDerch;
        int iAux;
        
        while(i<j){
            while(iArre[i]<= iPivote && i<j) i++;
            while(iArre[j]> iPivote) j--;
                if(i<j){
                    iAux= iArre[i];
                    iArre[i]=iArre[j];
                    iArre[j]=iAux;
                }
                
        }
        iArre[iIzq]= iArre[j];
        iArre[j]=iPivote;
        if(iIzq<j-1)
            quickSort(iArre, iIzq, j-1);
        if(j+1< iDerch)
            quickSort(iArre, j+1, iDerch);
    }
    
    public static int binarySearch(int[] arreglo, int iValorBuscado){
            return binSearch(arreglo, iValorBuscado, 0, arreglo.length-1);
        }
        
        private static int binSearch(int[] arreglo, int iValorBuscado, int iLo, int iHi){
            
            int iPos= -1;
            
            int iMid= iLo+((iHi-iLo)/2);
            if(iLo<= iHi){
            if(iValorBuscado==arreglo[iMid]){
                iPos= iMid;//SE ENCONTRO EL VALOR
            }else if(iValorBuscado<arreglo[iMid]){
                iPos=binSearch(arreglo, iValorBuscado, iLo, iMid-1);//BUSCA EN LA MITAD INFERIOR
                
            }else if(iValorBuscado>arreglo[iMid]){
                iPos=binSearch(arreglo, iValorBuscado, iMid+1, iHi);//BUSCA EN LA MITAD SUPERIOR
            }
            
            }
            
            return iPos;
        }
    
    
}
