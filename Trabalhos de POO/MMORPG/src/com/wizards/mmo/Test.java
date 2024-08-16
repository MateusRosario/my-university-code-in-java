package com.wizards.mmo;


import com.wizards.mmo.people.Character;
import com.wizards.mmo.exception.InvalidParameterException;

public class Test{

    public static void main(String[] args) throws InvalidParameterException {
        Test testando = new Test();
        testando.Game();
    }
    public void Game() throws InvalidParameterException {
        Character Elfo001 = new Character("Killer_Potter", 20, 74.45, "Elfo Negro", "Mago");
        Character Barbaro001 = new Character("PlayerMonstro", 40, 100.30, "Barabaro", "Guerreiro");
        System.out.println("O Elfo e o Barbaro se olham e planejam seus ataques...\n...\n...");
        System.out.println("O Elfo usa uma magia sombria, que atinge o bararo...\nAtaque critico...\nO Elfo perde 20 de Mana.\n O Barbaro perde 40 de Vida.");
        Elfo001.diminuirStatus(0, 30);
        Barbaro001.diminuirStatus(40, 0);
        System.out.println("Mas o Barbaro retorna ao calor da batalha rapidamente, e usa seu combo de skills...\n");
        System.out.println("Este provaca uma rajada de ataques com seu escudo e espada...\n O HP do Elfo diminui até sua morte.");
        Elfo001.diminuirStatus(80, 20);
        System.out.println("O Elfo tentou usar sua mana para conjurar um escudo, mas não funcionou...\n\n...");
        System.out.println("O barbaro então ganha 2000 de experiencia por vencer o PVP.");
        Barbaro001.addExp(1000);
        System.out.println("O barbaro esta no Level " + Barbaro001.getLevel() + "...\n\n");
        System.out.println("O Elfo "+ Elfo001.getName() +" é revivido na cidade.");
        Elfo001.revive();
        System.out.println("Fim de Jogo.");
    }
}
