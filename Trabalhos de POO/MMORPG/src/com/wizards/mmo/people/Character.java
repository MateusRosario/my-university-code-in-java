package com.wizards.mmo.people;

import com.wizards.mmo.exception.InvalidParameterException;

public class Character {
    private String Name;
    private int MaxHP;
    private int CurrentHP;
    private int MP;
    private int CurrentMP;
    private int Age;
    private double Weight;
    private int Experience;
    private int Level;
    private String Raça;
    private String Classe;
    private boolean Morto=false;

    public Character(String Name, int Age, double Weight, String Raça, String Classe) throws InvalidParameterException {
        if(Name.length()>64) {
            throw new InvalidParameterException("Nome");
        }

        if(Age<16 || Age>80){
            throw new InvalidParameterException("Idade");
        }

        this.Name = Name;
        this.Age = Age;
        this.Weight = Weight;
        this.Raça = Raça;
        this.Classe = Classe;
        this.CurrentHP=60;
        this.CurrentMP=60;
        this.MaxHP=60;
        this.MP=60;
        this.Experience=0;
        this.Level=1;
    }

    public int getLevel() {
        return this.Level;
    }

    public String getName() {
        return Name;
    }

    public void diminuirStatus(int lostHP, int lostMP){
        if(Morto && lostHP<0){
            lostHP=0;
        }

        this.CurrentHP-=lostHP;
        this.CurrentMP-=lostMP;

        if(CurrentHP<=0){
            CurrentHP = 0;
            Morto = true;
            addExp(-((int) (Experience*0.1)));
        }
        if(CurrentMP<0){
            CurrentMP = 0;
        }
    }

    public void revive(){
        Morto = false;
        CurrentHP = 1;
    }

    public void revive(int x){
        if(x <= MaxHP){
            Morto = false;
            CurrentHP = x;
        }
    }

    public void revive(double x) {
        Morto = false;
        CurrentHP =(int) (MaxHP*x);
    }

    public void addExp(int xp) {
        boolean repetir=true;

        Experience+=xp;

        if(Experience > 190000){
            Experience = 190000;
        }else if(Experience < 0){
            Experience = 0;
        }

        do {
            if (Experience >= (500 * (Math.pow(Level + 1, 2)) - 500 * (Level + 1))) {
                Level++;
                MaxHP += 10;
                MP += 10;
            } else if(Experience< (500 * (Math.pow(Level, 2)) - 500 * Level)){
                    Level--;
                    MaxHP -= 10;
                    if(CurrentHP > MaxHP){
                        CurrentHP = MaxHP;
                    }
                    MP -= 10;
                    if(CurrentMP > MP){
                        CurrentMP = MP;
                    }
            }else{
                repetir = false;
            }
        }while (repetir);
    }
}