package edu.insightr.spellmonger;

import java.util.ArrayList;
import java.util.List;


class Player {
    private String name;

    private int points_de_vie;

    Player(String name_, int pv)
    {
        points_de_vie = pv;
        name = name_;

    }

    void damage(int degats)
    {
        points_de_vie -= degats;
    }

    boolean est_mort() { return points_de_vie <= 0; }
    boolean est_en_vie() { return points_de_vie > 0; }


    int get_pv()
    {
        return points_de_vie;
    }

    String get_name()
    {
        return name;
    }

}