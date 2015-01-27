import ee.ioc.cs.vsle.api.ProgramContext;

class Adder {
	/*@ 
	specification Adder {
		double k1, k2, in1, in2, out, k1s, k2s;

		// Comment/uncomment a 2 line pairs below when you want to change k1 and k2 values during the simulation execution
		k1 = k1s;
		k2 = k2s;
		// cocovilaSpecObjectName, in1 -> k1s{getK1};
		// cocovilaSpecObjectName, in2 -> k2s{getK2};

		out = k1s * in1 + k2s * in2;
	}
	@*/

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






