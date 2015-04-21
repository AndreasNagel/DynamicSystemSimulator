import java.util.Arrays;

import ee.ioc.cs.vsle.api.*;

/*
 * This Process should work with any chosen approximation method (Euler, RK2, RK4)
 */
public class Simulator {

	/*@ specification Simulator {

		int time; // simulation time - amount of time units to be processed (ending time)
		double timeStep; // length of a simulation step in time units (Period of steps, think of oscillation)
		double T; // number of steps in a time unit (frequency of steps)
		int steps; // number of steps to be processed during the simulation (Ending on that step)

		timeStep = 1 / T;
		steps = time / timeStep;
		
		long drawingDelay; // delay in ms before computing next step
		boolean repaintImmediately; // update graphics during the computation
		boolean debug; // print the time value
		void done;
		// This block gathers up all the initstate, state, nextstate and finalstate variables from other objects on the scheme
		alias initstate = (*.initstate);
		alias state      = (*.state);
		alias nextstate  = (*.nextstate);
		alias finalstate = (*.finalstate);
                                    // Gathers up all the Step times from objects on scheme
		alias (double) allTimeStep = (*.timeStep);
		allTimeStep.length, timeStep -> allTimeStep {setDoubles};

		alias (boolean) repaint = (*.repaintImmediately);
		repaint.length, repaintImmediately -> repaint {setBooleans};

		alias allDrawn = (*.drawing_ready);

		alias processEnded = (*.paintAll);
		//needs extra input, next to state 
		[state -> nextstate, allDrawn], initstate, time, steps, 
			repaintImmediately, drawingDelay, debug -> done, processEnded {run};

		-> done;
	}@*/	

	/**
	 * Executes the synthesised subtask in a loop. 
	 * Assumes that the timeSteps are equal through the simulation.
	 */
    public void run( Subtask st, Object initst, int time, int steps,
            boolean repaintImmediately, long delay, boolean debug ) 
    {
System.out.println("Trying to run");
        if ( debug ) {
            System.out.println( "\nTotal simulation time is: " + time + " doing "+steps+" steps.");
        }
        // subtaskile (state -> nextstate, allDrawn), initial valuation done here
        Object[] in = new Object[] { initst };
        for ( int i = 0; i <= steps; i++ ) {
            Object[] out = st.run( in );
            in = out;
            // Wait if the delay before computing next state is set
            if (repaintImmediately && delay > 0) {
                try {
                    Thread.sleep( delay );
                } catch ( Exception e ) {
                    }
            }
        }
    }

	public boolean[] setBooleans( int len, boolean val ) {
		boolean[] tmp = new boolean[len];
		Arrays.fill(tmp, val);
		return tmp;
	}

	public double[] setDoubles( int len, double val ) {
		double[] tmp = new double[len];
		Arrays.fill(tmp, val);
		return tmp;
	}
}

