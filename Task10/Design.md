# Task 10 – Packages and Encapsulation

Suggested packages:
- parking.model – Vehicle, ParkingTicket, ParkingSlot and pass classes
- parking.service – ParkingFacility and ParkingService
- parking.app – main application and demonstrations

Use private fields, public validated constructors/getters, and package-private helpers where access should remain within a package. Use protected only for intended subclass extension. Reject negative durations, blank registration numbers and invalid slot indexes at the boundary.

Wrapper classes and autoboxing are useful in generic collections such as ArrayList<Integer>. Do not compare Integer values using == because it may compare object references; use equals() or primitive values. Public mutable fields force every caller to repeat validation and allow invalid state to enter the system. Validation itself is O(1) per update, but centralising it prevents duplicated checks across many call sites.
