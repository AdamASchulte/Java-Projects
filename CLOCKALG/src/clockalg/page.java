package clockalg;

public class page {
    private int Number = -1;
    private int modBit = 0;


    public page(int num, int mod)
    {   
        Number = num;
        modBit = mod;
    }


    public int getNum()
    {
        return Number;
    }

    public int getMod()
    {
        return modBit;
    }
}
