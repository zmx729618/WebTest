package zmx.reference.test;

public class ImplicitGarbageRetrieve {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyDate date = new MyDate();
        date = null;
        ReferenceTest.drainMemory();
    }

}
