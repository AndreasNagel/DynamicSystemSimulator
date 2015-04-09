# DynamicSystemSimulator
A CoCoViLa Package that facilitates simulation of dynamic processes.

Usage
------

Load the package (Package>Load) DynSysSim.xml.

Open a demo scheme (File>Load Scheme) DSS-demo1.syn.
Run the Simulation (Scheme>Run) -- You'll see what happens when you integrate time.

Load another demo simulation DSS-demo2_predator-prey.syn.
Run the simulation. Try to adjust the simulation parameters (adders' coefficients) so that the population of preys and predators would not extinguish - life is not a simple thing! :)

Package description
--------------------

Every scheme should have one Simulator - a Simulation Engine that possess the simulation properties like simulation time and time step (or a number of simulation steps in a time unit), and acts as a supervisor during the simulation execution. The Simulator must be set as super from the Properties window (make double-click or right-click on the image on the scheme to acces the menu).

You can build schemes that depend on the clock to run them, and also schemes, where the clock is not needed as an input of the function on y-axis. If the clock is not used as an input of the y axis, then the clock must be an input to the x-axis and timestep on the simulator must be set to 1. Alternatively, tick counter can be used as an input to x-axis.

The connections between items on the scheme can be made by binding the ports on the items together. Input ports are usually on the left and output ports on the right or upper side of the item.

The graph object on the scheme requires an input to both of it's input ports before it can draw a graph. The drawing currently has to begin from 0 to positive direction.

You can set the Graph object to display several inputs - the number is unlimited.

To execute a simulation choose Scheme>Run.

Have Fun! :)
