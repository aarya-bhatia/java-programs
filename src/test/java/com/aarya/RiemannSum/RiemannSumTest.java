package com.aarya.RiemannSum;

import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class RiemannSumTest {

    private static class test2Function implements Function {
        public float eval(float x) {
            return (float) Math.pow(x,2) + 1;
        }
    }

    private static class test3Function implements Function {
        public float eval(float x) {
            return (float)(Math.sqrt(x) * 2);
        }
    }

    @Test
    public static void test2(){

        Function f = new test2Function();

        int a = -1;
        int b = 2;

        float r3 = RiemannSum.right(f,3,a,b);
        float r6 = RiemannSum.right(f,6,a,b);
        float l3 = RiemannSum.left(f,3,a,b);
        float l6 = RiemannSum.left(f,6,a,b);
        float m3 = RiemannSum.middle(f,3,a,b);
        float m6 = RiemannSum.middle(f,6,a,b);

        assertNotNull(r3);
        assertNotNull(r6);
        assertTrue("riemann sum with six rectangles is more accurate", r6 < r3);
        assertTrue("left riemann sum is less than right riemann sum", l3 < r3);
    }

    @Test
    public static void test3() {
        Function f = new test3Function();
        int a = 0, b = 4;
        RiemannSum.right(f, 4, a, b);
        RiemannSum.left(f, 4, a, b);
        RiemannSum.middle(f, 4, a, b);
        System.out.println("test ran successfully");
    }
}
