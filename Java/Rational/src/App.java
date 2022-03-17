public class App {
    public static void main(String[] args) throws Exception {
        Rational rationalNumberObj = new Rational(5,1);
        rationalNumberObj.printRational();
        System.out.println(rationalNumberObj.toDouble()); 
    }
}



class Rational {
    int numerator;
    int denominator;
    Rational(){
        this.numerator = 0;
        this.denominator = 1;
    }
    Rational(int denominator, int numerator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public void negator(){
        this.numerator = -this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }

    public int getnumerator() {
        return this.numerator;
    }

    public void inverter(){
        if(this.denominator != 0){
            int temp = this.denominator;
            this.denominator = this.numerator;
            this.numerator = temp;     
        }else{
            System.out.println("Can't devide by 0");
        }
    }
    public void printRational() {
        System.out.println(this.numerator + "/" + this.denominator); 
    }

    public double toDouble(){
        double rationalNumber = (double) this.numerator / (double) this.denominator;
        return rationalNumber;
    }
}
