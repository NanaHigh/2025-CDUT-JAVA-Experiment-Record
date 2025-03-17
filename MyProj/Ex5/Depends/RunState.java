package Ex5.Depends;

public class RunState implements State {
    public void handleAction(Character character) {
        System.out.println(character.getName() + " 正在移动");
    }
}