import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;

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
        charStats.put("MaxStamina", Player.getCharStats().getMaxStamina());
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

        if (Player.getCharLoot() != null) {
            JSONObject charLoot = new JSONObject();
            charLoot.put("Name", Player.getCharLoot().getName());
            charLoot.put("Rarity", Player.getCharLoot().getRarity());
            charLoot.put("Attack", Player.getCharLoot().getAttack());
            charLoot.put("Intelligence", Player.getCharLoot().getIntelligence());
            charLoot.put("Hp", Player.getCharLoot().getHp());
            charLoot.put("Defense", Player.getCharLoot().getDefense());

            player.put("Loot", charLoot);
        }

        file.put("Player", player);

        if (!FileCheck(path)) {
            Files.createFile(path);
        }
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

        Player.MakeCharacter(info.get("CharName").toString(),
                parseInt(info.get("CharAge").toString()),
                parseInt(info.get("Level").toString()),
                parseInt(info.get("Experience").toString()),
                info.get("ClassName").toString(),
                info.get("RaceName").toString());

        JSONObject stats = (JSONObject) player.get("Stats");
        Player.LoadStats(parseInt(stats.get("Strength").toString()),
                parseInt(stats.get("MaxIntelligence").toString()),
                parseInt(stats.get("MaxStamina").toString()),
                parseInt(stats.get("Hp").toString()),
                parseInt(stats.get("Defense").toString()),
                parseInt(stats.get("CriticalChance").toString()),
                parseInt(stats.get("CriticalPower").toString()));

        JSONObject ability = (JSONObject) player.get("Ability");
        Player.LoadAbility(parseInt(ability.get("BaseAttack").toString()),
                parseInt(ability.get("StrongAttack").toString()),
                parseInt(ability.get("Heal").toString()),
                parseInt(ability.get("BaseAbility").toString()),
                parseInt(ability.get("SpecialAbility").toString()));

        if (player.containsKey("Loot")) {
            JSONObject loot = (JSONObject) player.get("Loot");
            Player.setCharLoot(Loot.makeLoot(loot.get("Name").toString(),
                    parseInt(loot.get("Rarity").toString()),
                    parseInt(loot.get("Attack").toString()),
                    parseInt(loot.get("Intelligence").toString()),
                    parseInt(loot.get("Hp").toString()),
                    parseInt(loot.get("Defense").toString())));
        }
    }

    public static boolean FileCheck(Path path) throws IOException {
        return Files.exists(path);
    }

    public static void FileDelete(Path path) throws IOException {
        Files.delete(path);
    }
}
