import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadSave extends Main{

    public static void SaveCharacter(Path path) throws IOException {
        JSONObject file = new JSONObject();

        JSONObject player = new JSONObject();

        JSONObject charInfo = new JSONObject();
        charInfo.put("CharName", Player.getCharName());
        charInfo.put("CharAge", Player.getCharAge());
        charInfo.put("Level", Player.getLevel());
        charInfo.put("Experience", Player.getExperience());
        charInfo.put("ClassName", Player.getClassName());
        charInfo.put("RaceName", Player.getRace());

        player.put("Info", charInfo);

        JSONObject charStats = new JSONObject();
        charStats.put("Strength", Player.getCharStats().getStrength());
        charStats.put("MaxIntelligence", Player.getCharStats().getMaxIntelligence());
        charStats.put("Intelligence", Player.getCharStats().getIntelligence());
        charStats.put("MaxStamina", Player.getCharStats().getMaxStamina());
        charStats.put("Stamina", Player.getCharStats().getStamina());
        charStats.put("Hp", Player.getCharStats().getHp());
        charStats.put("Defense", Player.getCharStats().getDefense());
        charStats.put("CriticalChance", Player.getCharStats().getCriticalChance());
        charStats.put("CriticalPower", Player.getCharStats().getCriticalPower());

        player.put("Stats", charStats);

        JSONObject charAbility = new JSONObject();
        charAbility.put("BaseAttack", Player.getCharAbility().getBaseAttack());
        charAbility.put("StrongAttack", Player.getCharAbility().getStrongAttack());
        charAbility.put("Heal", Player.getCharAbility().getHeal());
        charAbility.put("BaseAbility", Player.getCharAbility().getBaseAbility());
        charAbility.put("SpecialAbility", Player.getCharAbility().getSpecialAbility());

        player.put("Ability", charAbility);

        file.put("Player", player);

        FileWriter fileWriter = new FileWriter(String.valueOf(path));
        fileWriter.write(file.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void LoadCharacter(Path path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(String.valueOf(path));

        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonFile = (JSONObject) obj;
        JSONObject player = (JSONObject) jsonFile.get("Player");
        JSONObject info = (JSONObject) player.get("Info");
        System.out.println(info.get("CharName"));
    }

    public static boolean FileCheck(Path path) throws IOException {
        return Files.readAllLines(path).isEmpty();
    }
}
