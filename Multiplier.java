class Multiplier {
    /*@ 
    specification Multiplier {
    double in1, in1onTime, in2, in2onTime, k1, k1onTime, k2, k2onTime, out, outval;
    double timeStep;

    k1onTime = 1;
    k2onTime = 1;
    //in1onTime = 1;
    //in2onTime = 1;

    in1, in2, k1, k2, timeStep -> outval{calcOut};
    outval -> out{showOut};
    }
    @*/
double calcOut(double in1, double in2, double k1, double k2, double timeStep)
{
    double out = Math.pow(in1, k1) * Math.pow(in2, k2);
    System.out.println("inputs: " + Math.pow(in1, k1) + "; " + in1 + "; " + k1 + "; " + in2 + "; " + k2);
    return out;
}


double showOut(double out)
{
    System.out.println("Out: " + out);
    return out;
}
}

