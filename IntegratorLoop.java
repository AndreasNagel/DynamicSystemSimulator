class IntegratorLoop {
    /*@ specification IntegratorLoop {
    double init, in, out, timeStep;
    double empty, pin, nextState, isin, curState;
    empty = 0;
    alias (double) initstate = (init, empty);
    alias (double) state = (curState, pin);
    alias (double) nextstate = (nextState, isin);

    state, state.length, in -> nextstate {calcNext};
    curState -> out {outRes};
    }@*/ 

    double outRes(double outval)
    {
        return outval;
    }

    double[] calcNext(double[] state, int len, double in)
    {
        double[] results = new double[len];
        //System.out.println("Getting next");
        results[0] = state[0] + (in + state[1])/2;
        results[1] = state[1];
        return results;
    }

}
