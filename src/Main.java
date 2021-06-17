import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PrimitiveIterator;

public class Main {

    private static final MakeCharacter MakeCharacter = new MakeCharacter();
    private static final Game Game = new Game();
    protected static character Player = new character();
    private static final LoadSave LOAD_SAVE = new LoadSave();
    protected static final String PATHcharacter = "C:\\Progmeistars\\ProjectGame\\Saves\\Character.txt";
    //private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {
        Path path = Paths.get(PATHcharacter);
        if (LOAD_SAVE.FileCheck(path)) {
            LOAD_SAVE.LoadCharacter(path);
        } else {
            MakeCharacter.MakeCharacter();
        }
        Game.Game();
    }
}
