package Ex5.Depends;

// 角色接口
public interface Character {
    String getName();
    int getHealth();
    int getAttack();
    int getDefense();
    State getCurrentState();
    void setCurrentState(State state);
    void displayStatus();
}
