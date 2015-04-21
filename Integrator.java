class Integrator {
    /*@ specification Integrator {
    double init, inval, outval, timeStep;
    double empty, pin, nextState, isin, curState, stepCounter, inonTime, outonTime;
    stepCounter = 0;
    outonTime = 1;
    -> empty {emptyEval};
    alias (double) in = (inval, inonTime);
    alias (double) out = (outval, outonTime);
    alias (double) initstate = (init, empty, stepCounter);
    alias (double) state = (curState, pin, stepCounter);
    alias (double) nextstate = (nextState, isin, stepCounter);

    state, state.length, inval, timeStep -> nextstate {calcNext};
    curState -> outval {outRes};
    }@*/ 

    double emptyEval()
    {
        return Double.NaN;
    }
    double outRes(double outval)
    {
        //Next line can be uncommented for debugging purposes
        //System.out.println("Out: " + outval);
        return outval;
    }

    double[] calcNext(double[] state, int len, double in, double step)
    {
        double[] results = new double[len];
        if(Double.isNaN(state[1]))
        {
            //Next line can be uncommented for debugging purposes
            //System.out.println("Getting the next with: " + java.util.Arrays.toString(state) );
            results[0] = state[0] + in*step;
            results[1] = in;
        }
        else
        {
            results[0] = state[0] + (in + state[1]) / 2*step;
            results[1] = in;    
        }
        return results;
    }

}
