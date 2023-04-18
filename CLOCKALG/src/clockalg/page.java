package clockalg;

public class page {
    private int Number = -1;
    private int modBit = 0;
    private int refBit = 0;

    public page(int num) {
        Number = num;
    }

    public int getNum() {
        return Number;
    }

    public int getMod() {
        return modBit;
    }

    public int getRef() {
        return refBit;
    }

    public void setMod() {
        if (modBit == 1) {
            modBit = 0;
        } else {
            modBit = 1;
        }
    }

    public void setRef() {
        if (refBit == 0) {
            refBit = 1;
        } else {
            refBit = 0;
        }
    }
}
