package zmx.spi.test;

public class PlusOperationImpl implements IOperation {
 

    @Override
    public int operation(int numberA, int numberB) {

        return numberA + numberB;

    }

}
