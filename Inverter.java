class Inverter {
    /*@ 
    specification Inverter {
        double timeStep;
        double in, out;

        // Time correction is conducted in this block, so the output is on time.
        in, timeStep -> out {getOut};
    }
    @*/

    double getOut(double in, double timeStep)
    {
        out = -1.0 * in;
        return out;
    }

}

