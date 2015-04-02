class Integrator {
	/*@ 
	specification Integrator {
		// in on sisendpordist tulev muutuja
		// out on väljundpordi muutuja
		// state muutuja antakse sisse simulation enginest
		// init tuleb sise init fieldist integratorist
		// nextstate saadetakse tagasi simulation enginesse
		double init, pin, curState, nextState, empty, isin;
		double in, out, timeStep;
		-> empty {emptyEval};
		alias (double) initstate = (init, empty);
		alias (double) state = (curState, pin);
		//nextstate on massiiv nextState suure S-iga on double.
		alias (double) nextstate = (nextState, isin);
		//isin = 1;
		//praegune valem, leiab ristküliku
		// nextstate = state + in*timeStep;
		//uus valem, leiab trapetsi, pole in sisendit tulemas
		//nextval = state + (prevIn + in)/2*timeStep;
		//state, state.length, in, timeStep -> nextstate {calcNext};
		
		state, state.length, in, timeStep -> nextstate {calcNext};
		nextState -> out {outRes};
		//nextIn = in;
	}
	@*/
    double emptyEval()
{
        return Double.NaN;
}

    double outRes(double inRes)
    {
        //System.out.println("Out value is: " + inRes);
        return inRes;
    }


    double[] calcNext(double[] state, int len, double in, double step){
        double[] results = new double[len];
        if(Double.isNaN(state[1]))
        {
            System.out.println("Getting the next with: " + java.util.Arrays.toString(state) );
            results[0] = state[0];
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
