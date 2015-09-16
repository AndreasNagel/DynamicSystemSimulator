class Cosine {
    /*@ 
    specification Cosine {
        double timeStep;
        double in, out;

        // Time correction is conducted in this block, so the output is on time.
        in, timeStep -> out {getOut};
    }
    @*/

    double getOut(double in, double timeStep)
    {
        out = Math.cos(in);
        return out;
    }

}

