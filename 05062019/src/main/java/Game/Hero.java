package Game;

import java.util.Random;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    // метод для удара
    abstract void hit(Hero hero);

    // метод для лечения
    abstract void healing(Hero hero);

    // метод для нанесения урона
    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }
}

class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}

class Assasin extends Hero {
    // критический урон
    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}

class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
    }
}


class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        //Random randomHealing = new Random();
        boolean isEnable = true;

        Hero[] team1 = new Hero[]{new Warrior(250, "Тигрил", 50, 0)
                , new Assasin(150, "Акали", 70, 0)
                , new Doctor(120, "Жанна", 0, 60)};


        Hero[] team2 = new Hero[]{new Warrior(290, "Минотавр", 60, 0)
                , new Assasin(160, "Джинкс", 90, 0)
                , new Doctor(110, "Зои", 0, 80)};


        while (isEnable){
            for (int i = 0; i < team1.length; i++) {
                if (randomStep.nextInt(2) == 0) {
                    // если доктор то только хилим
                    if (team1[i] instanceof Doctor) {
                        team1[i].healing(needHeal(team1));
                    } else {
                        // удар по противнику
                        team1[i].hit(team2[i]);
                        if (checkWin(team1, team2)) {
                            System.out.println("-----------------");
                            System.out.println("Победила первая команда!");
                            isEnable = false;
                            break;
                        }
                    }
                } else {
                    if (team2[i] instanceof Doctor) {
                        team2[i].healing(needHeal(team2));
                    } else {
                        team2[i].hit(team1[i]);
                        if (checkWin(team1, team2)) {
                            System.out.println("-----------------");
                            System.out.println("Победила вторая команда!");
                            isEnable = false;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }

    public static boolean checkWin(Hero[] team1, Hero[] team2){
        int healthTeam1 = 0;
        int healthTeam2 = 0;

        for (Hero t1: team1) {
            healthTeam1 += t1.getHealth();
        }

        for (Hero t2: team2) {
            healthTeam2 += t2.getHealth();
        }

        if(healthTeam1 <= 0 || healthTeam2 <= 0){
            return true;
        } else {
            return false;
        }
    }

    public static Hero needHeal(Hero[] team){
        int minHealth = maxHeroHealth(team);
        Hero hero = null;

        for (Hero t1: team) {
            if(!(t1 instanceof Doctor) && minHealth > t1.getHealth()){
                minHealth = t1.getHealth();
                hero = t1;
            }
        }
        return hero;
    }

    public static int maxHeroHealth(Hero[] team){
        int maxHealth = 0;

        for (Hero t1: team) {
            if(maxHealth < t1.getHealth()){
                maxHealth = t1.getHealth();
            }
        }
        return maxHealth;
    }
}
