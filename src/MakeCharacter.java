public class MakeCharacter extends Main {
    private static final Window win = new Window();
    private static final Ability Ability = new Ability();
    private static final Stats Stats = new Stats();


    public void MakeCharacter() {
        win.Print("Hello, Player");
        win.Print("At first chose your race");
        win.Print("Human - +10 Intelligence, +10 CriticalChance");
        win.Print("Orc   - +10 Strength, +10, Stamina, +50 Hp, +10 Defense, +20 CriticalPower");
        win.Print("Elf   - +50 Stamina, +5 CriticalChance, +10 CriticalPower");
        win.Print("Write the name of class below");

        String RaceName = win.getText();

        win.Print("Nice chose");
        win.Print("Now chose your class");
        win.Print("Warrior  - +5 Strength, +10 Stamina, +50 Hp, +10 Defense");
        win.Print("Mage     - +10 Intelligence, +10 CriticalChance");
        win.Print("Assassin - +10 Strength, +50 stamina, +20 CriticalChance, +50 CriticalPower");
        win.Print("Write the name of class below");

        String ClassName = win.getText();

        win.Print("Nice chose");
        win.Print(RaceName + ", what is your name?");

        String CharName = win.getText();

        win.Print("Hi, " + CharName + ", how old are you?");

        int CharAge = win.getInt();
        Player.MakeCharacter(CharName, CharAge, ClassName, RaceName);

        win.Print("Now your character is created!");
        win.Print("Have a nice game!");
    }

    public void SetClassStats(String ClassName) {
        switch (ClassName) {
            case "Warrior":
                Player.setCharStats(5, 0, 10, 50, 10, 0, 0);
                break;
            case "Mage":
                Player.setCharStats(0, 10, 0, 0, 0, 10, 0);
                break;
            case "Assassin":
                Player.setCharStats(10, 0, 50, 0, 0, 20, 50);
                break;
        }
    }

    public void SetRaceStats(String RaceName) {
        switch (RaceName) {
            case "Human":
                Player.setCharStats(0, 10, 0, 0, 0, 10, 0);
                break;
            case "Orc":
                Player.setCharStats(10, 0, 10, 50, 10, 0, 20);
                break;
            case "Elf":
                Player.setCharStats(0, 0, 50, 0, 0, 5, 10);
                break;
        }
    }
}
