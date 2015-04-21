class Multiplier {
    /*@ 
    specification Multiplier {
    double in1, in1onTime, in2, in2onTime, k1, k1onTime, k2, k2onTime, outVal, outonTime;
    double timeStep;

    alias (double) in1m = (in1, in1onTime);
    alias (double) in2m = (in2, in2onTime);
    alias (double) k1m = (k1, k1onTime);
    alias (double) k2m = (k2, k2onTime);
    alias (double) out = (outVal, outonTime);

    k1onTime = 1;
    k2onTime = 1;
    //in1onTime = 1;
    //in2onTime = 1;

    // Time correction is conducted in this block
    outonTime = 1;
    in1m, in2m, k1m, k2m, timeStep -> outVal{calcOut};
    }
    @*/


    double calcOut(double [] in1, double[] in2, double[] k1, double[] k2, double timeStep)
    {
        double outVal =0;
        double integs[] = {in1[1], in2[1], k1[1], k2[1]};
        double curVal[] = {in1[0], in2[0], k1[0], k2[0]};
        // Juhul kui sisend tuleb otse kellast tee sellele timecorrection.
        if(in1[1] == 0)
        {
            curVal[0] = in1[0] - timeStep;
        }
        // Juhul kui timecorrection on juba tehtud, kasuta hetkel sisendist tulevat väärtust
        else
        {
            curVal[0] = in1[0];
        }
        if(in2[1] == 0)
        {
            curVal[1] =in2[0] - timeStep;
        }
        else
        {
            curVal[1] = in2[0];
        }
        if(k1[1] == 0)
        {
            curVal[2] = k1[0] - timeStep;
        }
        else
        {
            curVal[2] = k1[0];
        }
        if(k2[1] == 0)
        {
            curVal[3] = k2[0] - timeStep;
        }
        else
        {
            curVal[3] = k2[0];
        }
        
        // Following lines can be used in debugging process
        //System.out.println("Calculating with values" + java.util.Arrays.toString(curVal));
        //System.out.println("Have integ values" + java.util.Arrays.toString(integs));
        
        // Arvuta välja väljund väärtus
        outVal = Math.pow(curVal[0], curVal[2]) * Math.pow(curVal[1], curVal[3]);

    return outVal;
    }

}

