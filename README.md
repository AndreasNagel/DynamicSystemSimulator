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

You can set the Graph object to display several inputs - the number is unlimited.

To execute a simulation choose Scheme>Run.

Have Fun! :)

NB! The current implementation uses Euler method for integration that is not usable for 
any real-like application. A better implementation is coming soon.