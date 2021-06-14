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
import java.util.List;
import java.util.Map;

public class LoadSave extends Main{

    public static void SaveCharacter(Path path) throws IOException {
        JSONObject player = new JSONObject();
        player.put("CharName", Player.getCharName());
        player.put("CharAge", Player.getCharAge());
        player.put("Level", Player.getLevel());
        player.put("Experience", Player.getExperience());
        player.put("ClassName", Player.getClassName());
        player.put("RaceName", Player.getRace());
        player.put("Stats", Player.getCharStats());
        player.put("Ability", Player.getCharAbility());

        FileWriter fileWriter = new FileWriter(String.valueOf(path));
        fileWriter.write(player.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
/*
    public static void LoadCharacter(Path path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(String.valueOf(path));

        Object obj = jsonParser.parse(fileReader);
        JSONArray arrayObj = (JSONArray) obj;
        arrayObj.forEach(player -> );

        Player.LoadCharacter(jsonPlayer.getString("CharName"), jsonPlayer.getInt("CharAge"), jsonPlayer.getInt("Level"), jsonPlayer.getInt("Experience"), jsonPlayer.getString("ClassName"), jsonPlayer.getString("RaceName"));
        JsonObject jsonStats = jsonPlayer.getJsonObject("Stats");
        Player.LoadStats(jsonStats.getInt("Strength"), jsonStats.getInt("Intelligence"),jsonStats.getInt("Stamina"), jsonStats.getInt("Hp"), jsonStats.getInt("Defense"), jsonStats.getInt("CriticalChance"), jsonStats.getInt("CriticalPower"));
        JsonObject jsonAbility = jsonPlayer.getJsonObject("Ability");
        Player.LoadAbility(jsonAbility.getInt("BaseAttack"), jsonAbility.getInt("StrongAttack"), jsonAbility.getInt("Heal"), jsonAbility.getInt("BaseAbility"), jsonAbility.getInt("SpecialAbility"));
    }

 */

    public static boolean FileCheck(Path path) throws IOException {
        return Files.readAllLines(path).isEmpty();
    }
}
