package ps.pokappdex.project.model;

import java.util.HashMap;

public class TypeTable {

    private static HashMap<String, float[]> typeTable = new HashMap<>();
    private String[] typeList;

    public TypeTable() {
        this.createTable();
        this.typeList = new String[]{"Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water"};
    }

    public void createTable(){
        typeTable.put("Bug", new float[]{1, 1, 1, 1, 1, 0.5f, 2, 2, 1, 0.5f, 0.5f, 1, 1, 1, 1, 2, 1, 1});
        typeTable.put("Dark", new float[]{2, 0.5f, 1, 1, 2, 2, 1, 1, 0.5f, 1, 1, 1, 1, 1, 0, 1, 1, 1});
        typeTable.put("Dragon", new float[]{1, 1, 2, 0.5f, 2, 1, 0.5f, 1, 1, 0.5f, 1, 2, 1, 1, 1, 1, 1, 0.5f});
        typeTable.put("Electric", new float[]{1, 1, 1, 0.5f, 1, 1, 1, 0.5f, 1, 1, 2, 1, 1, 1, 1, 1, 0.5f, 1});
        typeTable.put("Fairy", new float[]{0.5f, 0.5f, 0, 1, 1, 0.5f, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1});
        typeTable.put("Fighting", new float[]{0.5f, 0.5f, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 0.5f, 1, 1});
        typeTable.put("Fire", new float[]{0.5f, 1, 1, 1, 0.5f, 1, 0.5f, 1, 1, 0.5f, 2, 0.5f, 1, 1, 1, 2, 0.5f, 2});
        typeTable.put("Flying", new float[]{0.5f, 1, 1, 2, 1, 0.5f, 1, 1, 1, 0.5f, 0, 2, 1, 1, 1, 2, 1, 1});
        typeTable.put("Ghost", new float[]{0.5f, 2, 1, 1, 1, 0, 1, 1, 2, 1, 1, 1, 0, 0.5f, 1, 1, 1, 1});
        typeTable.put("Grass", new float[]{2, 1, 1, 0.5f, 1, 1, 2, 2, 1, 0.5f, 0.5f, 2, 1, 2, 1, 1, 1, 0.5f});
        typeTable.put("Ground", new float[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 2, 1, 0.5f, 1, 0.5f, 1, 2});
        typeTable.put("Ice", new float[]{1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 0.5f, 1, 1, 1, 2, 2, 1});
        typeTable.put("Normal", new float[]{1, 1, 1, 1, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        typeTable.put("Poison", new float[]{0.5f, 1, 1, 1, 0.5f, 0.5f, 1, 1, 1, 0.5f, 2, 1, 1, 0.5f, 2, 1, 1, 1});
        typeTable.put("Psychic", new float[]{2, 2, 1, 1, 1, 0.5f, 1, 1, 2, 1, 1, 1, 1, 1, 0.5f, 1, 1, 1});
        typeTable.put("Rock", new float[]{1, 1, 1, 1, 1, 2, 0.5f, 1, 1, 2, 2, 1, 0.5f, 0.5f, 1, 1, 2, 2});
        typeTable.put("Steel", new float[]{0.5f, 1, 0.5f, 1, 0.5f, 2, 2, 0.5f, 1, 0.5f, 2, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0.5f, 1});
        typeTable.put("Water", new float[]{1, 1, 1, 2, 1, 1, 0.5f, 1, 1, 2, 1, 0.5f, 1, 1, 1, 1, 0.5f, 0.5f});
    }

    public static HashMap<String, float[]> getTypeTable() {
        return typeTable;
    }

    public String[] getTypeList(){
        return typeList;
    }

    public float[] calculateTypes(String type1, String type2) {
        float[] res = new float[18];
        if (type2.equals("-")) {
            res = typeTable.get(type1);
        } else {
            float[] typeData1 = typeTable.get(type1);
            float[] typeData2 = typeTable.get(type2);
            if (typeData1 != null) {
                res = typeData1.clone();
                if (typeData2 != null) {
                    for (int i = 0; i < res.length; i++) {
                        res[i] *= typeData2[i];
                    }
                }
            }
        }
        return res;
    }
}
