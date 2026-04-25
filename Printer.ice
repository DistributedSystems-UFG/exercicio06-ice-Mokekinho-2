module Demo
{
    interface Printer
    {
        string printString(string s);
            
        int add(int a, int b);

        int sub(int a, int b);
    }

    interface Calor
    {

        double calorSensivel(double m, double c, double teta);

        double calorLatente(double m, double L);

    }
}