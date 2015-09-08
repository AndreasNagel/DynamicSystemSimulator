class Clock {
    /*@ 
    specification Clock {
    double init, initStateType, curStateType, nextStateType, outval, timeStep;
    double empty, pin, nextState, isin, curState, stepCounter;
    double in, out;
    initStateType = 1.0;
    init = 0;
    in = 1;

    alias (double) initstate = (initStateType, init, init, init);
    alias (double) state = (curStateType,curState, pin, stepCounter);
    alias (double) nextstate = (nextStateType, nextState, isin, stepCounter);

    state, state.length, in, timeStep -> nextstate {calcNext};
    curState -> out {outRes};
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


	public double[] calcNext(double[] state, int stateSize, double in, double dt) {
		double[] nextstate = new double[stateSize];
		double type = state[0];
		double curstate = state[1];
		double oldstate = state[2];
		double oldin = state[3];
		
		double step = in / dt;

		if (type == 0.0) {
			nextstate[0] = 1.0;
			nextstate[1] = oldstate + 0.5 * ( oldin + step );
			nextstate[2] = Double.NaN;
			nextstate[3] = Double.NaN;
		} else {
			nextstate[0] = 0.0;
			nextstate[1] = curstate + step;
			nextstate[2] = curstate;
			nextstate[3] = step;
		}
 		return nextstate;
	}

}
