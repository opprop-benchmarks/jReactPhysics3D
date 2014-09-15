package net.smert.jreactphysics3d.collision;

import net.smert.jreactphysics3d.body.CollisionBody;
import net.smert.jreactphysics3d.mathematics.Vector3;

/**
 * This structure represents a pair of bodies during the broad-phase collision detection.
 *
 * @author Jason Sorensen <sorensenj@smert.net>
 */
public class BroadPhasePair {

    // Pointer to the first body
    private final CollisionBody body1;

    // Pointer to the second body
    private final CollisionBody body2;

    // Previous cached separating axis
    private final Vector3 previousSeparatingAxis;

    // Constructor
    public BroadPhasePair(CollisionBody body1, CollisionBody body2) {
        this.body1 = body1;
        this.body2 = body2;
        previousSeparatingAxis = new Vector3(1.0f, 1.0f, 1.0f);
    }

    public CollisionBody getBody1() {
        return body1;
    }

    public CollisionBody getBody2() {
        return body2;
    }

    public Vector3 getPreviousSeparatingAxis() {
        return previousSeparatingAxis;
    }

    // Return the pair of bodies index
    public BodyIndexPair newBodiesIndexPair() {
        return ComputeBodiesIndexPair(body1, body2);
    }

    // Return the pair of bodies index
    public static BodyIndexPair ComputeBodiesIndexPair(CollisionBody body1, CollisionBody body2) {

        // Construct the pair of body index
        BodyIndexPair indexPair = body1.getBodyID() < body2.getBodyID()
                ? new BodyIndexPair(body1.getBodyID(), body2.getBodyID())
                : new BodyIndexPair(body2.getBodyID(), body1.getBodyID());
        assert (indexPair.getFirst() != indexPair.getSecond());
        return indexPair;
    }

}
