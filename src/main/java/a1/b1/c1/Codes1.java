package a1.b1.c1;

/**
 * @author XenoAmess
 */
public class Codes1 {

    static class A {

    }

    static class B extends A implements C, D {

    }

    interface C {

    }

    interface D extends C {

    }

    public static void main(String[] args) {
        System.out.println(A[].class.isAssignableFrom(B[].class));
        System.out.println(C[].class.isAssignableFrom(B[].class));
        System.out.println(D[].class.isAssignableFrom(B[].class));
        System.out.println(C[].class.isAssignableFrom(D[].class));
    }
}