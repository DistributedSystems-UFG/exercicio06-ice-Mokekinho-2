import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.Util;

public class Server{

    public static void main(String[] args){
        

        try (Communicator communicator = Util.initialize(args)){

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("SimpleAdapter", "default -p 11000");

            PrinterI printer = new PrinterI();

            adapter.add(printer, Util.stringToIdentity("SimplePrinter"));

            CalorI calor = new CalorI();

            adapter.add(calor, Util.stringToIdentity("MyCalor"));

            adapter.activate();

            communicator.waitForShutdown();
        }
    }
}