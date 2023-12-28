package dev.vmillet.brozone.game;

import dev.vmillet.brozone.managers.GameManager;

/**
 * Each entity that should be rendered and computed must implement this interface and
 * be added to the object manager
 */
public interface GameObject {
    void update(GameManager gameManager);
}
