import ee.ioc.cs.vsle.api.ProgramContext;

class Adder {
    /*@ 
    specification Adder {
        double k1, k1onTime, k2, k2onTime, in1, in1onTime, in2, in2onTime, outVal, outonTime, k1s, k2s;
        double timeStep;

        alias (double) in1m = (in1, in1onTime);
        alias (double) in2m = (in2, in2onTime);
        alias (double) k1m = (k1, k1onTime);
        alias (double) k2m = (k2, k2onTime);
        alias (double) out = (outVal, outonTime);

        // Comment/uncomment the 4 line pairs below when you want to change k1 and k2 values during the simulation execution
        k1 = k1s;
        k2 = k2s;
        k1onTime = 1;
        k2onTime = 1;
        //in1onTime = 1;
        //in2onTime = 1;

        //Sellega saab võib-olla kontrollida kas väljad on täidetud või tuleb sisend skeemilt
        //cocovilaSpecObjectName, in1Val -> k1s{getK1};
        //cocovilaSpecObjectName, in2Val -> k2s{getK2};

        // Time correction is done in this block
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
        outVal = curVal[0] * curVal[2] + curVal[1] * curVal[3];

    return outVal;
    }


    public double getK1( String name, double x ) {
        try {
            return Double.valueOf( (String) ProgramContext.getFieldValue( name, "k1" ) );
        } catch(Exception e) { System.err.println( "Error getting k1" ); }
        return 0;
    }

    public double getK2( String name, double x ) {
        try {
            return Double.valueOf( (String) ProgramContext.getFieldValue( name, "k2" ) );
        } catch(Exception e) { System.err.println( "Error getting k2" ); }
        return 0;
    }
}		






