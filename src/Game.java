import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Game extends Main{
    private static final Tower Tower = new Tower();
    private static final World World = new World();
    private static final Window win = new Window();
    private static final LoadSave LOAD_SAVE = new LoadSave();
    private static String Place = "World";

    public void Game() throws IOException {
        win.Print("Hi, " + Player.getCharName() + ", now you are in " + Place + "!");
        Path path = Paths.get(PATHcharacter);
        LOAD_SAVE.SaveCharacter(path);
        /*
         switch (Place) {
             case "World":
                 WorldProcess();
             case "Tower":
                 TowerProcess();
         }

         */
    }
}
