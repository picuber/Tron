package tron.fields;

import tron.Matrix;
import tron.bikes.Bike;

/**
 *
 * @author Leon
 */
public class FixedLinkField extends LinkField {

    private final FixedLinkField link;

    public FixedLinkField(Matrix m, int x, int y, Matrix linkM, int linkX, int linkY) {
        super(m, x, y);
        link = new FixedLinkField(linkM, linkX, linkY, this);
    }

    private FixedLinkField(Matrix m, int x, int y, FixedLinkField link) {
        super(m, x, y);
        this.link = link;
    }

    @Override
    public void collide(Bike b) {
        b.goToLinkEnd(link);
    }

}
