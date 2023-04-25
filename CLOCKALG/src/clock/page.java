package clock;

class page {
    private int Number = -1;
    private int modBit = 0;
    private int refBit = 0;

    public page(int num) {
        Number = num;
    }

    public void setData(int num)
    {
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

    public void setMod(int mod) {
        modBit = mod;
    }

    public void setRef(int ref) {
        refBit = ref;
    }
}
