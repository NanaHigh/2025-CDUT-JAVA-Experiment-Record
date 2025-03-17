package Ex5.Depends;

// 具体状态实现
public class IdleState implements State {
    public void handleAction(Character character) {
        System.out.println(character.getName() + " 处于站立状态");
    }
}