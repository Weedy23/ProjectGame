public class MakeCharacter extends Main {
    private static final Window win = new Window();
    private static final clas Class = new clas();
    private static final Ability Ability = new Ability();
    private static final Stats Stats = new Stats();
    private static final Race Race = new Race();


    public void MakeCharacter() {
        win.Print("Hello, Player");
        win.Print("At first chose your race");
        win.Print("Human - +10 Intelligence, +10 CriticalChance");
        win.Print("Orc   - +10 Strength, +10, Stamina, +50 Hp, +10 Defense, +20 CriticalPower");
        win.Print("Elf   - +50 Stamina, +5 CriticalChance, +10 CriticalPower");
        win.Print("Write the name of class below");

        String RaceName = win.getText();
        Race.MakeRace(RaceName, Player);

        win.Print("Nice chose");
        win.Print("Now chose your class");
        win.Print("Warrior  - +5 Strength, +10 Stamina, +50 Hp, +10 Defense");
        win.Print("Mage     - +10 Intelligence, +10 CriticalChance");
        win.Print("Assassin - +10 Strength, +50 stamina, +20 CriticalChance, +50 CriticalPower");
        win.Print("Write the name of class below");

        String ClassName = win.getText();
        Class.MakeClass(ClassName, Player);

        win.Print("Nice chose");
        win.Print(RaceName + ", what is your name?");

        String CharName = win.getText();

        win.Print("Hi, " + CharName + ", how old are you?");

        int CharAge = win.getInt();
        Player.MakeCharacter(CharName, CharAge, Ability, Stats, Class);

        win.Print("Now your character is created!");
        win.Print("Have a nice game!");
    }
}
