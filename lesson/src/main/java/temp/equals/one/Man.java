package temp.equals.one;

public class Man {

    private int dnaCode;

    public Man(int dnaCode) {
        this.dnaCode = dnaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return dnaCode == man.dnaCode;
    }
    @Override
    public int hashCode() {
        return hashCode();
    }


}
