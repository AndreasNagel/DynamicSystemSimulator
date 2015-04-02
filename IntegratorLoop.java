class IntegratorLoop {
    /*@ specification IntegratorLoop {
    double init, in, out, timeStep;
    double empty, pin, nextState, isin, curState, stepCounter;
    stepCounter = 0;
    -> empty {emptyEval};
    alias (double) initstate = (init, empty, stepCounter);
    alias (double) state = (curState, pin, stepCounter);
    alias (double) nextstate = (nextState, isin, stepCounter);

    state, state.length, in, timeStep -> nextstate {calcNext};
    curState -> out {outRes};
    }@*/ 

    double emptyEval()
    {
        return Double.NaN;
    }
    double outRes(double outval)
    {
System.out.println("Out: " + outval);
        return outval;
    }

    double[] calcNext(double[] state, int len, double in, double step)
    {
        double[] results = new double[len];
        if(Double.isNaN(state[1]))
        {
            System.out.println("Getting the next with: " + java.util.Arrays.toString(state) );
            results[0] = state[0] + in*step;
            results[1] = in;
        }
        else
        {
            System.out.println("Getting the next with in: " + java.util.Arrays.toString(state) + " " + in );
            results[0] = state[0] + (in + state[1]) / 2*step;
            results[1] = in;    
        }
        return results;
    }

}
