package ps8;
class Driver{
    public static void main(String[] args) {
        Rational obj = new Rational(1,2);
        Rational obj2 = new Rational(2,3);
        System.out.println(obj.add(obj2));
        System.out.println(obj.divide(obj2));
    }
}
class Rational {
    private final int num, denom;
    Rational(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }
    public int getNumerator(){
        return num;
    }
    public int getDenominator(){
        return denom;
    }
    Rational add(Rational n){
        int newNumerator = this.num*n.getDenominator() + n.getNumerator()*this.denom;
        int newDenomenator = this.denom*n.getDenominator();
        return new Rational(newNumerator,newDenomenator);
    }
    Rational divide(Rational n){
        int newNumerator = this.num*n.getDenominator();
        int newDenomenator =  n.getNumerator()*this.denom;
        return new Rational(newNumerator,newDenomenator);
    }
    public String toString(){
        return this.num+"/"+this.denom;
    }
    public String toString(int precision){
        double floatingPoint = (double)this.num/this.denom;
        String format = "%."+precision+"f";
        return String.format(format, floatingPoint);
    }
}