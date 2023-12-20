package dev.vmillet.brozone;

import com.badlogic.gdx.Gdx;
import dev.vmillet.brozone.utilsTest.GdxTestRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(GdxTestRunner.class)
class AssetFilesTest {
    private final String assetPath = "../assets/";

    @Test
    void defaultLogo() {
        assertTrue(Gdx.files.internal(assetPath + "badlogic.jpg").exists());
    }
}
