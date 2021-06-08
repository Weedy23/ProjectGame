public class Game extends Main{
    private static final Tower Tower = new Tower();
    private static final World World = new World();
    private static final Window win = new Window();
    private static String Place = "World";
    private Game game = new Game();

    public void Game() {
        win.Print("Hi, " + game.Player.getCharName() + ", now you are in " + Place + "!");

         switch (Place) {
             case "World":
                 WorldProcess();
             case "Tower":
                 TowerProcess();
         }
    }
}
