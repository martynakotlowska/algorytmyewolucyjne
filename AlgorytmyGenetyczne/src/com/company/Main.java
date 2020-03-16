package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OperacjeGenetyczne operacjeGenetyczne=new OperacjeGenetyczne();
        Populacja populacja=operacjeGenetyczne.getPopulacja();
        System.out.println("funkcja fitnes() dla kazdego osobnika populacji");
        int j=1;
        ArrayList<Populacja> wszystkiePopulacje=new ArrayList<>();
        wszystkiePopulacje.add(populacja);
     //   wysPop(populacja,operacjeGenetyczne);
        ArrayList<Osobnik> osobniki =populacja.getOsobniki();
        ArrayList<int[]> newChrom=operacjeGenetyczne.krzyzowanie(osobniki.get(0).getChromosom(),osobniki.get(2).getChromosom(),2);
        ArrayList<int[]> newChrom2=operacjeGenetyczne.krzyzowanie(osobniki.get(1).getChromosom(),osobniki.get(3).getChromosom(),5);
        Populacja populacja2=new Populacja(new Osobnik[]{new Osobnik(newChrom.get(0)),new Osobnik(newChrom.get(1)),new Osobnik(newChrom2.get(0)),new Osobnik(newChrom2.get(1))});
        wszystkiePopulacje.add(populacja2);
        Populacja populacja3=new Populacja();
        for (Osobnik i:osobniki){
            Osobnik newOsobnik= new Osobnik(operacjeGenetyczne.mutacja(i.getChromosom(),5));
            populacja3.osobniki.add(newOsobnik);//////// sprawdz co jest nullem
        }
        wszystkiePopulacje.add(populacja3);
        int z=1;
        for (Populacja i:wszystkiePopulacje)
        {
            System.out.println("Populacja "+z+":");
            wysPop(i,operacjeGenetyczne);
            z++;
        }

    }
    public static void wysPop(Populacja populacja,OperacjeGenetyczne operacjeGenetyczne){
        populacja.getOsobniki().forEach(i->
        {
            System.out.println("Osobnik :");
            int [] chrom=null;
            chrom=i.getChromosom();
            operacjeGenetyczne.wysChrom(chrom);
            System.out.println(operacjeGenetyczne.fitness(chrom)+"\n\n\n");
        });
    }
}
