package Ex5.Depends;

// 怪物类
public class Monster implements Character {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private String type;
    private State currentState = new IdleState();

    public Monster(int health, int attack, int defense, String type) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.type = type;
        this.name = type + "怪物";
    }

    // 接口方法实现
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public State getCurrentState() { return currentState; }
    public void setCurrentState(State state) { this.currentState = state; }
    
    public void displayStatus() {
        System.out.printf("【%s】 类型：%s 生命值：%d 攻击力：%d 防御力：%d%n",
                name, type, health, attack, defense);
    }
}