package dev.vmillet.brozone.game;

import dev.vmillet.brozone.input.inputactor.Input;
import dev.vmillet.brozone.input.inputactor.NpcInput;
import dev.vmillet.brozone.input.inputactor.PlayerInput;
import dev.vmillet.brozone.managers.GameManager;

public class PlayerCreator {
    public Hero createPLayer(GameManager gameManager){
        // TODO add spawn position
        Hero hero = configureAndCreateHero(gameManager);
        // TODO add hero to the world
        return hero;
    }

    private Hero configureAndCreateHero(GameManager gameManager) {
        Input input = createInput(gameManager);
        // TODO equip items
        return new Hero(input);
    }

    private Input createInput(GameManager gameManager) {
        // TODO add a way to create npc
        if (false) {
            return new NpcInput();
        } else {
            return new PlayerInput(gameManager.getScreenContainer().getGameScreen().getHeroControl());
        }
    }

    // TODO to implement
    private void addAndEquipItems() {}
}
