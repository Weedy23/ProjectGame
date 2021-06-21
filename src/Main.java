import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    protected static final Window win = new Window();
    protected static final LoadSave LOAD_SAVE = new LoadSave();
    protected static final String PATHcharacter = "C:\\Progmeistars\\ProjectGame\\Saves\\Character.txt";
    protected static character Player = new character();
    private static final MakeCharacter MakeCharacter = new MakeCharacter();
    private static final Game Game = new Game();


    public static void main(String[] args) throws IOException, ParseException {
        win.Open();
        Path path = Paths.get(PATHcharacter);
        if (LOAD_SAVE.FileCheck(path)) {
            LOAD_SAVE.LoadCharacter(path);
        } else {
            MakeCharacter.MakeCharacter();
        }
        Game.Game();
    }
}
