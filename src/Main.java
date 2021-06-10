import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final MakeCharacter MakeCharacter = new MakeCharacter();
    private static final Game Game = new Game();
    protected static character Player = new character();
    private static final LoadSave LOAD_SAVE = new LoadSave();
    static final String PATHcharacter = "C:\\Progmeistars\\ProjectGame\\Saves\\Character.txt";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(PATHcharacter);
        if (LOAD_SAVE.FileCheck(path)) {
            MakeCharacter.MakeCharacter();
        } else {
            LOAD_SAVE.LoadCharacter(path);
        }
        Game.Game();
    }
}
