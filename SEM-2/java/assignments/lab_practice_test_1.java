package assignments;

interface THEORY{
    default String print(double nn, String xx){
        return xx+" has scored "+nn+" CGPA in theory courses";
    }
    double CGPAtheory(double[] score, int[] credits);
}
interface LAB{
    default String print(double nn, String xx){
        return xx+" has scored "+nn+" CGPA in lab courses";
    }
    double CGPAlab(double[] score, int[] credits);
}

class Sem1 implements THEORY,LAB{
    @Override
    public double CGPAlab(double[] score,int[] credits){
        return 1.00;
    }
    public double CGPAtheory(double[] score,int[] credits){
        return 1.00;
    }
}