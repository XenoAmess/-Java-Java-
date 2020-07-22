package a1.b1.c1;

class A {

}

class B extends A {

}

/**
 * @author XenoAmess
 */
public class Codes0 {
    public static void main(String[] args) {
        System.out.println(A.class);
        System.out.println(A[].class);
        System.out.println(B.class);
        System.out.println(B[].class);
        System.out.println(A[].class.equals(B[].class));
        System.out.println(new A[0] instanceof B[]);
        System.out.println(new B[0] instanceof A[]);
        System.out.println(A[].class.isAssignableFrom(B[].class));
        System.out.println(B[].class.isAssignableFrom(A[].class));
        System.out.println(new A[0].getClass().isAssignableFrom(new B[0].getClass()));
        System.out.println(new B[0].getClass().isAssignableFrom(new A[0].getClass()));
    }
}