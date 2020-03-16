/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.*;

/**
 *
 * @author marty
 */
public class OperacjeGenetyczne {

    private Populacja populacja;
    public OperacjeGenetyczne() {
    Osobnik os1=new Osobnik();
    Osobnik os2=new Osobnik();
    Osobnik os3=new Osobnik();
    Osobnik os4=new Osobnik();
    this.populacja=new Populacja(new Osobnik[]{os1,os2,os3,os4});
    }

    public Populacja getPopulacja() {
        return populacja;
    }

    public int[] mutacja(int[] ch, int miejsce){
        int [] chrom=ch.clone();
        Random generator =new Random();
        if (miejsce>chrom.length-1)
            miejsce =chrom.length-1;
    chrom[miejsce-1] =generator.nextInt(100);
        return  chrom;
    }
    
    public ArrayList<int[]> krzyzowanie(int[] ch1,int[] ch2,int zmiana){
    int[] chrom1=ch1.clone();
    int[] chrom2=ch2.clone();
        int temp=chrom1[zmiana];
     chrom1[zmiana]=chrom2[zmiana];
     chrom2[zmiana]=temp;
     ArrayList<int[]> list= new ArrayList<>();
     list.add(chrom1);
     list.add(chrom2);
    return list;
    }

    public int fitness(int[] chrom){
        int parzyste=0;
        int nieparzyste=0;
        int licznik=1;
        for(int i:chrom){
            if (licznik%2==0)
                    parzyste=parzyste+i;
                else
                    nieparzyste=nieparzyste+i;
                licznik++;
        }
        return parzyste-nieparzyste;
    }

    public void wysChrom(int []chrom){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[ ");
        for (int i:chrom){
            stringBuilder.append(i+" ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString()+"\n");
    }
}