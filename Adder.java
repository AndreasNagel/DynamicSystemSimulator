import ee.ioc.cs.vsle.api.ProgramContext;

class Adder {
    /*@ 
    specification Adder {
        double k1, k2, in1, in2, k1s, k2s;
        double in1, in2, k1,k2;
        double timeStep;
        double out;

        // Comment/uncomment the 4 line pairs below when you want to change k1 and k2 values during the simulation execution
        k1 = k1s;
        k2 = k2s;
        //in1onTime = 1;
        //in2onTime = 1;

        //Sellega saab võib-olla kontrollida kas väljad on täidetud või tuleb sisend skeemilt
        //cocovilaSpecObjectName, in1Val -> k1s{getK1};
        //cocovilaSpecObjectName, in2Val -> k2s{getK2};

        // Time correction is done in this block
        in1, in2, k1, k2 -> out{calcOut};

    }
    @*/


    double calcOut(double  in1, double in2, double k1, double k2)
    {
        double outVal =0;        
        // Following lines can be used in debugging process
        //System.out.println("Calculating with values" + java.util.Arrays.toString(curVal));
        //System.out.println("Have integ values" + java.util.Arrays.toString(integs));
        
        // Arvuta välja väljund väärtus
        outVal = in1 * k1 + in2 * k2;

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






