import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        // 1. Initialize the Ice communicator within a try-with-resources block
        try (Communicator communicator = Util.initialize(args)) {

            // 2. Create a proxy to the remote 'Printer' object
            // Replace '10.0.0.5' with the actual IP of your ICE server
            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h localhost -p 11000"); // mudei pra porta do servidor

            // 3. Downcast the proxy to the Printer interface
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            // 4. Call the remote method
            String response = printer.printString("Hello from Goiania!");
            System.out.println("Server responded: " + response);

            int sum = printer.add(1,2);
            int sub = printer.sub(5,10);

            System.out.println("Soma: " + sum);
            System.out.println("Subtração: " + sub);


            //Novo objeto criado para calor
            ObjectPrx baseCalor = communicator.stringToProxy("MyCalor:default -h localhost -p  11000");
            
            Demo.CalorPrx calor = Demo.CalorPrx.checkedCast(baseCalor);

            if (calor == null) {
                throw new Error("Invalid proxy");
            }

            double calorSensivel = calor.calorSensivel(10, 1, 50);
            double calorLatente = calor.calorLatente(1400, 540);

            System.out.println("Calor Sensível: " + calorSensivel);
            System.out.println("Calor Latente: " + calorLatente);


        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
