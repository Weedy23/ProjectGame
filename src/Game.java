import java.io.IOException;
import java.nio.file.Paths;

public class Game extends Main {
    private static String time = "Day";

    public void Game() throws IOException {
        LOAD_SAVE.SaveCharacter(Paths.get(PATHcharacter));

        win.Print("Hi, " + Player.getCharName() + " Now is " + time);

        int timeCounter = 0;
        for ( ; ; ) {
            Move();
            timeCounter++;
            LOAD_SAVE.SaveCharacter(Paths.get(PATHcharacter));

            if (timeCounter == 3) {
                timeCounter = 0;
                switch (time) {
                    case "Day":
                        time = "Night";
                        break;
                    case "Night":
                        time = "Day";
                        break;
                }
                win.Print("Time switched to " + time);
                win.Print("");
            }
        }
    }

    public void Move() throws IOException {
        int n = (int) (Math.random() * 10);
        int N = 0;
        switch (time) {
            case "Day":
                N = 5;
                break;
            case "Night":
                N = 3;
                break;
        }
        if (n > N) {
            Loot loot = Loot.generateLootOrNothing(Player.getLevel());
            if (loot != null) {
                win.Print("You are lucky! you got " + loot.getName() + "!");
                win.Print("New loot stats: " + loot.viewLootStat());
                if (Player.getCharLoot() != null) {
                    win.Print("Your loot stats:" + Player.getCharLoot().viewLootStat());
                } else {
                    win.Print("You don't have loot equipped");
                }
                win.Print("Do you want to change your loot& Yes or No!");

                win.setPanelYesNo();
                for ( ; win.getResult() == null; ) { }
                switch (win.getResult()) {
                    case "Yes":
                        if (Player.getCharLoot() == null) {
                            Player.getCharStats().setMaxHp(Player.getCharStats().getMaxHp() + loot.getHp());
                            Player.getCharStats().setHp(Player.getCharStats().getMaxHp() + loot.getHp());
                            Player.getCharStats().setDefense(Player.getCharStats().getDefense() + loot.getDefense());
                        } else {
                            Player.getCharStats().setMaxHp(Player.getCharStats().getMaxHp() - Player.getCharLoot().getHp() + loot.getHp());
                            Player.getCharStats().setHp(Player.getCharStats().getMaxHp() - Player.getCharLoot().getHp() + loot.getHp());
                            Player.getCharStats().setDefense(Player.getCharStats().getDefense() - Player.getCharLoot().getDefense() + loot.getDefense());
                        }
                        Player.setCharLoot(loot);
                        break;
                    case "No":
                        win.Print("Ok");
                        break;
                }
                win.setResult(null);
                win.removePanelYesNo();
                win.resetTextArea();
            } else {
                win.Print("You got nothing");
            }
        } else {
            Enemies enemies = Enemies.generateEnemiesOrNothing(Player.getLevel());
            if (enemies != null) {
                win.Print("You meet " + enemies.getName());
                win.Print("FIGHT!");
                win.setPanelAttack();
                enemies = fight(enemies);
                win.removePanelAttack();
                win.resetTextArea();
            } else {
                win.Print("You are lucky! you don't have to fight");
            }
        }
    }

    public static Enemies fight(Enemies enemies) throws IOException {
        for ( ; Player.getCharStats().getHp() > 0 && enemies.getHp() > 0; ) {
            win.Print("Your hp " + Player.getCharStats().getHp());
            win.Print("Your stamina " + Player.getCharStats().getStamina());
            win.Print("Your Intelligence " + Player.getCharStats().getIntelligence());
            win.Print("enemies hp " + enemies.getHp());
            win.Print("");

            for ( ; win.getResult() == null; ) { }
            switch (win.getResult()) {
                case "BaseAttack":
                    enemies.setHp(enemies.getHp() - MakeAttack(Player.MakeAttack("BaseAttack"), Player.getCharStats().getCriticalChance(), Player.getCharStats().getCriticalPower(), enemies.getDodge(), enemies.getDefense()));
                    break;
                case "StrongAttack":
                    enemies.setHp(enemies.getHp() - MakeAttack(Player.MakeAttack("StrongAttack"), Player.getCharStats().getCriticalChance(), Player.getCharStats().getCriticalPower(), enemies.getDodge(), enemies.getDefense()));
                    break;
                case "BaseAbility":
                    enemies.setHp(enemies.getHp() - MakeAttack(Player.MakeAttack("BaseAbility"), Player.getCharStats().getCriticalChance(), Player.getCharStats().getCriticalPower(), enemies.getDodge(), enemies.getDefense()));
                    break;
                case "SpecialAbility":
                    enemies.setHp(enemies.getHp() - MakeAttack(Player.MakeAttack("SpecialAbility"), Player.getCharStats().getCriticalChance(), Player.getCharStats().getCriticalPower(), enemies.getDodge(), enemies.getDefense()));
                    break;
                case "Heal":
                    Player.getCharStats().setHp(MakeHeal(Player.getCharStats().getHp(), Player.getCharStats().getMaxHp(), Player.MakeAttack("Heal")));
                    break;
            }
            win.resetTextArea();
            win.setResult(null);

            Player.getCharStats().setHp(Player.getCharStats().getHp() - MakeAttack(enemies.getAttack(), 0, 1, 20, Player.getCharStats().getDefense()));

        }

        if (enemies.getHp() <= 0) {
            win.Print("You won");
            Player.setExperience(Player.getExperience() + enemies.getExperience());
            Player.LevelUp();
        } else {
            win.Print("You lose");
            LOAD_SAVE.FileDelete(Paths.get(PATHcharacter));
        }
        win.resetTextArea();
        return null;
    }

    public static int MakeAttack(int AttackDamageAttacker, int CriticalChanceAttacker, int CriticalPowerAttacker, int DodgeChanceDefender, int DefensePowerDefender) {
        int Dodge = (int) (Math.random() * 100) + 1;
        if (Dodge <= DodgeChanceDefender) {
            int Critical = (int) (Math.random() * 100) + 1;
            if (Critical <= CriticalChanceAttacker) {
                return (AttackDamageAttacker - DefensePowerDefender) * CriticalPowerAttacker;
            } else {
                return AttackDamageAttacker - DefensePowerDefender;
            }
        } else {
            return 0;
        }
    }

    public static int MakeHeal(int Hp, int MaxHp, int Heal) {
        if (Hp + Heal <= MaxHp) {
            return Hp + Heal;
        } else {
            return MaxHp;
        }
    }
}
