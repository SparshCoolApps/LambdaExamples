package sparshcoolapps.lambdaexamples.common;

public class SimpleFormatter implements PrintFormatter {

    private String decorator;

    public SimpleFormatter(String decorator){
        this.decorator = decorator;
    }

    @Override
    public void prePrint(String message) {
        System.out.println(message);
        // Filler for Pre-Action Heading
        for (int i = 1; i <= message.length()+5; i++)
            System.out.print(decorator);
        System.out.println();
        System.out.println();
    }

    @Override
    public void postPrint() {
        for (int i = 1; i <= 100; i++)
            System.out.print(decorator);
        System.out.println();
        System.out.println();
    }
}

