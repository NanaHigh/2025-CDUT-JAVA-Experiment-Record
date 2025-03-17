package Ex5.Depends;

import java.lang.System;

public class AttackState implements State {
    public void handleAction(Character character) {
        System.out.println(character.getName() + " 发动攻击，造成" + character.getAttack() + "点伤害");
    }
}