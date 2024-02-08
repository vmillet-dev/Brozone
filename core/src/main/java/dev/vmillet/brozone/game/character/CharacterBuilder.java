package dev.vmillet.brozone.game.character;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import dev.vmillet.brozone.input.ActorInput;

public class CharacterBuilder {
    private CharacterBuilder() {}

    public static Character build(World world, ActorInput input) {
        final Vector2 pos2 = new Vector2(0, 0);
        final Body body = createBody(world, pos2, 0, 1f);

        return new Character(input, body);
    }

    private static Body createBody(World world, Vector2 position, float angle, float density) {
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.angle = angle * MathUtils.degRad;
        bd.angularDamping = 0;
        bd.linearDamping = 0;
        bd.position.set(position);

        Body body = world.createBody(bd);

        CircleShape circle = new CircleShape();
        circle.setRadius(60f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = density;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f; // Make it bounce a little bit

        body.createFixture(fixtureDef);
        circle.dispose();

        return body;
    }
}
