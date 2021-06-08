public class Main {

    private static final MakeCharacter MakeCharacter = new MakeCharacter();
    private static final Game Game = new Game();
    protected static character Player = new character();

    public static void main(String[] args) {
        Player = MakeCharacter.MakeCharacter();
        Game.Game();
    }
}
