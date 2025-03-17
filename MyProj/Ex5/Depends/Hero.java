package Ex5.Depends;

// 英雄类
public class Hero implements Character, Transformable {
    private String name = "英雄";
    private int health;
    private int attack;
    private int defense;
    private State currentState = new IdleState();

    public Hero(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public Character transform() {
        System.out.println("英雄变身为怪物！");
        return new Monster(this.health, this.attack + 10, this.defense - 5, "兽人");
    }

    // 接口方法实现
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public State getCurrentState() { return currentState; }
    public void setCurrentState(State state) { this.currentState = state; }
    
    
    public void displayStatus() {
        System.out.printf("【%s】 生命值：%d 攻击力：%d 防御力：%d%n",
                name, health, attack, defense);
    }
}