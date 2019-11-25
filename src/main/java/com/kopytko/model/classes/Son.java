package com.kopytko.model.classes;

public class Son extends Father implements Mother {
    private String nameSon;
    private String surname;
    private String nameFather;
    private String colorEyes;
    private String character;

    public Son(String nameSon, String nameFather, String surname, String colorEyes, String character) {
        super(nameFather, surname);
        this.nameSon = nameSon;
        this.colorEyes = colorEyes;
        this.character = character;
        this.surname = surname;
        this.nameFather = nameFather;
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
        return "Son{" +
                "nameSon='" + nameSon + '\'' +
                ", surname='" + surname + '\'' +
                ", nameFather='" + nameFather + '\'' +
                ", colorEyes='" + colorEyes + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}
