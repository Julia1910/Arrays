package com.kopytko.model.classes;

public class Daughter extends Father implements Mother {
    private String nameDaughter;
    private String surname;
    private String nameFather;
    private String colorEyes;
    private String character;

    public Daughter(String nameDaughter, String nameFather, String surname, String colorEyes, String character) {
        super(nameFather, surname);
        this.nameDaughter = nameDaughter;
        this.surname = surname;
        this.nameFather = nameFather;
        this.colorEyes = colorEyes;
        this.character = character;
    }

    @Override
    public String getColorEyes() {
        return colorEyes;
    }

    @Override
    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "Daughter{" +
                "nameDaughter='" + nameDaughter + '\'' +
                ", surname='" + surname + '\'' +
                ", nameFather='" + nameFather + '\'' +
                ", colorEyes='" + colorEyes + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}
