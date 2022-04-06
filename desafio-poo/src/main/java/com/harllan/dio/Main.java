package com.harllan.dio;

import java.time.LocalDate;

import com.harllan.dio.poo.Bootcamp;
import com.harllan.dio.poo.Curso;
import com.harllan.dio.poo.Dev;
import com.harllan.dio.poo.Mentoria;

public class Main {
	
	public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(30);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Angular");
        curso2.setDescricao("Descrição curso Angular");
        curso2.setCargaHoraria(20);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());
        
        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("Descrição Bootcamp Java Developer - DIO");
        bootcampJava.getConteudos().add(curso1);
        bootcampJava.getConteudos().add(curso2);
        bootcampJava.getConteudos().add(mentoria);

        Dev devHarllan = new Dev();
        devHarllan.setNome("Harllan Andryê");
        devHarllan.inscreverBootcamp(bootcampJava);
        
        System.out.println(devHarllan.obterTextoConteudosInscritos());
        devHarllan.progredir();
        devHarllan.progredir();
        System.out.println("-");
        System.out.println(devHarllan.obterTextoConteudosInscritos());
        System.out.println(devHarllan.obterTextoConteudosConcluidos());
        System.out.println("XP: " + devHarllan.calcularTotalXp());
    }

}
