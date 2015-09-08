import java.util.Arrays;
class Integrator {
    /*@ specification Integrator {
    double init, initStateType, curStateType, nextStateType, outval, timeStep;
    double empty, pin, nextState, isin, curState, stepCounter, pstate, cState, fstate, prevstate;
    initStateType = 0.0;
    double in, out;
// First value is a control value, controls which kind of calculation is done at the present step
// Second value is the output value of the current or next step (depending on the alias, in state, it is given out, in nextstate it is given to state alias of the next step)
// Third value is the previous output value (in state) or the current output value (in nextstate)
// Fourth value is the previous input value, which is 
    alias (double) initstate = (initStateType, init, init, init, init); //This is passed to the control block which gives it back to state alias
    alias (double) state = (curStateType,curState, fstate, pin, pstate);
    alias (double) nextstate = (nextStateType, nextState, cState, isin, prevstate);

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
        double prevstate = state[4];	
        double step = in / dt;
        double accuracy;
        //System.out.println("State:" + Arrays.toString(state));
	//Evaluates the Runge-Kutta value of integrator (clock stays the same)
        if (type == 0.0) {
            nextstate[0] = 1.0;
            nextstate[1] = curstate + step;
            nextstate[2] = curstate;
            nextstate[3] = step;
	// Evaluates the Runge-Kutta clock (integrator value too, but this isn't done accurately)
        }else if (type == 1.0) {
            nextstate[0] = 0.0;
            nextstate[1] = oldstate + 0.5 * ( oldin + step );
            nextstate[2] = Double.NaN;
            nextstate[3] = Double.NaN;
//            nextstate[4] = nextstate[1];
	// if it's only the first step, then it doesn't calculate the correction (Not enough data available)
        }
         //System.out.println(Arrays.toString(nextstate));
         return nextstate;
    }
}
