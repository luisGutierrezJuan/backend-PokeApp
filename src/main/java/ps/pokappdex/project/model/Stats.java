package ps.pokappdex.project.model;


/*
 * Leyenda:
 *
 * PS: Puntos de salud
 * ATK: Ataque
 * DEF: Defensa
 * SPA: Ataque Especial
 * SPD: Defensa Especial
 * SPE: Velocidad
 *
 * Cada estadística está representada por un array de 3 elementos cada uno;
 *
 * 1. La estadística base
 * 2. Los IVs del Pokémon en esa estadística
 * 3. Los EVs del Pokémon en esa estadística
 * */

public class Stats {
    private int[] ps = new int[3];
    private int[] atk = new int[3];
    private int[] def = new int[3];
    private int[] spa = new int[3];
    private int[] spd = new int[3];
    private int[] spe = new int[3];

    public Stats(int ps, int atk, int def, int spa, int spd, int spe) {
        this.ps[0] = ps;
        this.atk[0] = atk;
        this.def[0] = def;
        this.spa[0] = spa;
        this.spd[0] = spd;
        this.spe[0] = spe;
    }

    public int[] getPs() {
        return ps;
    }

    public void setPs(int[] ps) {
        this.ps = ps;
    }

    public int[] getAtk() {
        return atk;
    }

    public void setAtk(int[] atk) {
        this.atk = atk;
    }

    public int[] getDef() {
        return def;
    }

    public void setDef(int[] def) {
        this.def = def;
    }

    public int[] getSpa() {
        return spa;
    }

    public void setSpa(int[] spa) {
        this.spa = spa;
    }

    public int[] getSpd() {
        return spd;
    }

    public void setSpd(int[] spd) {
        this.spd = spd;
    }

    public int[] getSpe() {
        return spe;
    }

    public void setSpe(int[] spe) {
        this.spe = spe;
    }
}