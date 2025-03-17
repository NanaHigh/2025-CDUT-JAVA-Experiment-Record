package Ex5;

import Ex5.Depends.*;

public class ex5_1 {
    public static void main(String[] args) {
        // 初始化英雄
        Ex5.Depends.Character currentCharacter = new Hero(100, 20, 15);
        
        testCharacter(currentCharacter);
        
        // 英雄变身
        if (currentCharacter instanceof Transformable) {
            currentCharacter = ((Transformable) currentCharacter).transform();
        }
        testCharacter(currentCharacter);
    }


    /// 测试角色
    private static void testCharacter(Ex5.Depends.Character character) {
        System.out.println("\n=== 当前角色状态 ===");
        character.displayStatus();
        
        System.out.println("\n=== 状态测试 ===");
        character.setCurrentState(new IdleState());
        character.getCurrentState().handleAction(character);
        
        character.setCurrentState(new RunState());
        character.getCurrentState().handleAction(character);
        
        character.setCurrentState(new AttackState());
        character.getCurrentState().handleAction(character);
        
        character.setCurrentState(new DeadState());
        character.getCurrentState().handleAction(character);
    }
}
