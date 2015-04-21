class Inverter {
    /*@ 
    specification Inverter {
        double inVal, inonTime, outVal, outonTime, timeStep;
        alias (double) in = (inVal, inonTime);
        alias (double) out = (outVal, outonTime);

        // Time correction is conducted in this block, so the output is on time.
        outonTime = 1;
        in, timeStep -> outVal {getOut};
    }
    @*/

    double getOut(double[] in, double timeStep)
    {
        double out = 0;
        if(in[1] == 0)
        {
            out = -1.0 * (in[0] - timeStep);
        }
        else
        {
            out = -1.0 * in[0];
        }
        return out;
    }

}

