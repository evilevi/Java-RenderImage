package lighting;
import primitives.*;
/**
 * class represents a light source in a shape  of spotlight
 * in order to get the same light intensity, we need to increase the initial intensity of the light source
 * class Spot Light defined by position, direction and light intensity.
 * it's a kind of point light so we choose to extend it from pointLight.
 */

public class SpotLight extends PointLight {
    /**
     *  direction - the direction of the light
     */
    private Vector direction;

    @Override
    public Color getIntensity(Point p) {
        double maxAngle=Math.max(0,direction.dotProduct(getL(p)));
        return super.getIntensity(p).scale(maxAngle);
    }

    @Override
    public Vector getL(Point p) {
        return super.getL(p);
    }

    /**
     * constructor
     *
     * @param color    - the color of the light source
     * @param position - the point which the light is being emitted from
     * @param direction direction of light
     */
    public SpotLight(Color color, Point position, Vector direction) {
        super(color, position);
        direction = direction.normalize();

    }
}