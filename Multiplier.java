class Multiplier {
    /*@ 
    specification Multiplier {
    double in1, in2, k1, k2, out, outval;
    double timeStep;
    in1, in2, k1, k2, timeStep -> outval{calcOut};
    outval -> out{showOut};
    }
    @*/
double calcOut(double in1, double in2, double k1, double k2, double timeStep)
{
    double out = Math.pow(in1, k1) * Math.pow(in2, k2);
    return out;
}


double showOut(double out)
{
    return out;
}
}

