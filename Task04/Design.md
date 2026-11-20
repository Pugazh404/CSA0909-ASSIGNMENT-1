# Task 4 – Classes, Objects and Constructors

Use parameterised constructors to create valid Vehicle, ParkingSlot and ParkingTicket objects. Overloaded constructors may provide defaults while delegating with this(...). Use super(...) to initialise superclass state. A copy constructor is not needed for a ticket because copying an active ticket could duplicate its unique ID and create conflicting exit records.

A reference variable is held in a stack frame while objects are allocated on the heap. Constructor chaining reduces repeated validation and initialisation. Static factory methods can make named creation policies explicit; setter-based construction temporarily permits incomplete objects unless carefully controlled. Creating n tickets is O(n) time and O(n) object storage for all approaches; factory/constructor calls do not change asymptotic complexity.
