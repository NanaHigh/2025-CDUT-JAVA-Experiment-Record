package Ex5.Depends;

import java.lang.System;

public class DeadState implements State {
    public void handleAction(Character character) {
        System.out.println(character.getName() + " 已死亡");
    }
}