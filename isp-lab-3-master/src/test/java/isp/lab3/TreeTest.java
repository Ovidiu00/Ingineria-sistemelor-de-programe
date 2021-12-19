package isp.lab3;

import isp.lab3.exercise1.Exercise1;
import isp.lab3.exercise1.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testGrow() {
        Tree tree = new Tree();
        tree.grow(4);

        assertEquals("Should be 19 meters tall", 19, tree.height);
    }
    @Test
    public void testToString() {
        Tree tree = new Tree();
        tree.grow(5);

        assertEquals("Should be 20 meters tall", "20 metrii", tree.toString());
    }
}
