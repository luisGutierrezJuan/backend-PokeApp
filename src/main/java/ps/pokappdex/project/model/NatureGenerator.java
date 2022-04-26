package ps.pokappdex.project.model;

import java.util.ArrayList;

public class NatureGenerator {
    public static ArrayList<Nature> createNatures() {
        ArrayList<Nature> natures = new ArrayList<>();

        Nature adamant = new Nature("Adamant", "Atk", "Spa");
        Nature bashful = new Nature("Bashful", "Neutral", "Neutral");
        Nature bold = new Nature("Bold", "Def", "Atk");
        Nature brave = new Nature("Brave", "Atk", "Spe");
        Nature calm = new Nature("Calm", "Spd", "Atk");
        Nature careful = new Nature("Careful", "Spd", "Spa");
        Nature docile = new Nature("Docile", "Neutral", "Neutral");
        Nature gentle = new Nature("Gentle", "Spd", "Def");
        Nature hardy = new Nature("Hardy", "Neutral", "Neutral");
        Nature hasty = new Nature("Hasty", "Spe", "Def");
        Nature impish = new Nature("Impish", "Def", "Spa");
        Nature jolly = new Nature("Jolly", "Spe", "Spa");
        Nature lax = new Nature("Lax", "Def", "Spd");
        Nature lonely = new Nature("Lonely", "Atk", "Def");
        Nature mild = new Nature("Mild", "Spa", "Def");
        Nature modest = new Nature("Modest", "Spa", "Atk");
        Nature naive = new Nature("Naive", "Spe", "Spd");
        Nature naughty = new Nature("Naughty", "Atk", "Spd");
        Nature quiet = new Nature("Quiet", "Spa", "Spe");
        Nature quirky = new Nature("Quirky", "Neutral", "Neutral");
        Nature rash = new Nature("Rash", "Spa", "Spd");
        Nature relaxed = new Nature("Relaxed", "Def", "Spe");
        Nature sassy = new Nature("Sassy", "Spd", "Spe");
        Nature serious = new Nature("Serious", "Neutral", "Neutral");
        Nature timid = new Nature("Timid", "Spe", "Atk");

        if (!natures.contains(adamant)) natures.add(adamant);
        if (!natures.contains(bashful)) natures.add(bashful);
        if (!natures.contains(bold)) natures.add(bold);
        if (!natures.contains(brave)) natures.add(brave);
        if (!natures.contains(calm)) natures.add(calm);
        if (!natures.contains(careful)) natures.add(careful);
        if (!natures.contains(docile)) natures.add(docile);
        if (!natures.contains(gentle)) natures.add(gentle);
        if (!natures.contains(hardy)) natures.add(hardy);
        if (!natures.contains(hasty)) natures.add(hasty);
        if (!natures.contains(impish)) natures.add(impish);
        if (!natures.contains(jolly)) natures.add(jolly);
        if (!natures.contains(lax)) natures.add(lax);
        if (!natures.contains(lonely)) natures.add(lonely);
        if (!natures.contains(mild)) natures.add(mild);
        if (!natures.contains(modest)) natures.add(modest);
        if (!natures.contains(naive)) natures.add(naive);
        if (!natures.contains(naughty)) natures.add(naughty);
        if (!natures.contains(quiet)) natures.add(quiet);
        if (!natures.contains(quirky)) natures.add(quirky);
        if (!natures.contains(rash)) natures.add(rash);
        if (!natures.contains(relaxed)) natures.add(relaxed);
        if (!natures.contains(sassy)) natures.add(sassy);
        if (!natures.contains(serious)) natures.add(serious);
        if (!natures.contains(timid)) natures.add(timid);

        return natures;
    }
}
