public class MakeCharacter extends Main {

    public void MakeCharacter() {
        win.Print("Hello, Player");
        win.Print("At first chose your race");
        win.Print("Human - +10 Intelligence, +10 CriticalChance");
        win.Print("Orc   - +10 Strength, +10, Stamina, +50 Hp, +10 Defense, +20 CriticalPower");
        win.Print("Elf   - +50 Stamina, +5 CriticalChance, +10 CriticalPower");

        win.setPanelRace();
        for ( ; win.getResult() == null; ) { }
        String RaceName = win.getResult();
        win.setResult(null);
        win.removePanelRace();

        win.Print("Nice chose");
        win.Print("Now chose your class");
        win.Print("Warrior  - +5 Strength, +10 Stamina, +50 Hp, +10 Defense");
        win.Print("Mage     - +10 Intelligence, +10 CriticalChance");
        win.Print("Assassin - +10 Strength, +50 stamina, +20 CriticalChance, +50 CriticalPower");

        win.setPanelClass();
        for ( ; win.getResult() == null; ) { }
        String ClassName = win.getResult();
        win.setResult(null);
        win.removePanelClass();

        win.Print("Nice chose");
        win.Print(RaceName + ", what is your name?");

        win.setPanelText();
        for ( ; win.getResult() == null; ) { }
        String CharName = win.getResult();
        win.setResult(null);
        win.resetTextField();
        win.removePanelText();

        win.Print("Hi, " + CharName + ", how old are you?");

        win.setPanelText();
        for ( ; win.getResult() == null; ) { }
        int CharAge = Integer.parseInt(win.getResult());
        win.setResult(null);
        win.resetTextField();
        win.removePanelText();

        Player.MakeCharacter(CharName, CharAge, 1, 0, ClassName, RaceName);

        win.Print("Now your character is created!");
        win.Print("Have a nice game!");

        win.resetTextArea();
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
