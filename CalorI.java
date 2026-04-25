import com.zeroc.Ice.Current;

public class CalorI implements Demo.Calor{

    @Override
    public double calorSensivel(double m, double c, double teta, Current current){

        return m*c*teta;
    }

    @Override
    public double calorLatente(double m, double L, Current current){

        return m*L;
    }

}