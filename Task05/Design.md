# Task 5 – Static Members and Object Life Cycle

A ticket sequence can be static when IDs must be unique across every facility in the application. Occupancy belongs to each facility and should be an instance field. A static method is suitable for formatting or generating globally unique IDs; static blocks should be reserved for one-time class initialisation.

After exit, a ticket becomes eligible for garbage collection only when no reachable object references it. Passing an object to a method passes its reference value; returning an object returns a reference.

If each ParkingFacility has its own instance counter, k facilities store k counters and IDs can collide across gates. A shared static counter stores one counter for all facilities; if uniqueness is required across separate application processes, use a persistent database sequence instead.
