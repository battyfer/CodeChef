There are N cities in Chefland numbered from 1 to N and every city has a railway station. Some cities have a train and each city has at most one train originating from it. The trains are represented by an array A, where Ai=0 means the i-th city doesn't have any train originating from it, Ai=1 means the train originating from the i-th city is moving right (to a higher numbered city), and Ai=2 means the train originating from the i-th city is moving left (to a lower numbered city).

Each train keeps on going forever in its direction and takes 1 minute to travel from the current station to the next one. There is a special station at city 1 which lets travellers instantaneously teleport to any other station that currently has a train. Teleportation and getting on a train once in the city both take 0 minutes and all trains start at time 0.

There are M travellers at city 1, and the i-th traveller has destination city Bi. They ask Chef to guide them to teleport to a particular station from which they can catch a train to go to their destination in the least time possible. In case it's not possible for a person to reach his destination, print −1.

Note: The input and output of this problem are large, so prefer using fast input/output methods.
