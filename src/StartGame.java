public class StartGame {
    private static Window win = new Window();
    private static clas Class = new clas();
    private static character Player = new character();
    private static Ability Ability = new Ability();
    private static Stats Stats = new Stats();


    public void MakeCharacter() {
        win.Print("Hello, Player");
        win.Print("At first chose your class");
        win.Print("Warrior");
        win.Print("Mage");
        win.Print("Assassin");
        win.Print("Write the name of class below");

        String ClassName = win.getText();
        Class.MakeClass(ClassName, Player);

        win.Print("Nice chose");
        win.Print("Now, what is your name?");

        String CharName = win.getText();

        win.Print("Hi, " + CharName + ", how old are you?");

        int CharAge = win.getInt();
        Player.MakeCharacter(CharName, CharAge, Ability, Stats, Class);

        win.Print("Now your character is created!");
    }
}
