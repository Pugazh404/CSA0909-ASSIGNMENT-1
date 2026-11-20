# Task 1 – Understand the Problem and Identify Objects

## Inputs and outputs
Inputs: registration number, vehicle category, user category/pass validity, entry time, exit time, and required charging energy. Outputs: allocated floor and slot, unique ticket number, duration, parking fee, and released-slot status.

## Candidate classes
- **Vehicle:** stores registration number and exposes fee behaviour.
- **TwoWheeler, Car, ElectricCar:** specialise vehicle rates and EV charging capability.
- **ParkingSlot:** stores floor/slot identity and the currently parked vehicle.
- **ParkingFacility:** owns floors and allocates/releases slots.
- **ParkingTicket:** stores ticket ID, vehicle, slot and entry time.
- **ParkingService:** coordinates entry and exit operations.
- **ParkingPass:** represents a valid student/staff monthly pass.
- **PricingRule:** separates pricing policy from vehicle identity.

## Important methods
allocate(), release(), enter(), exit(), calculateFee(), chargingFee(), isValid().

## Business rules
A slot holds at most one vehicle; EV charging requires a charging slot; ticket IDs are unique and never reused; a registration cannot have two active tickets; invalid times and negative energy are rejected; a released slot becomes available; a valid monthly pass waives parking fee.

## Assumptions
Time is measured in minutes; each started hour is billed as a full hour; rates are illustrative and configurable; floors may have different slot counts; charging fee is additional to parking fee.

## Alternative: parallel arrays
Parallel arrays store regNo[], type[] and entryTime[] at matching indexes. Searching by registration is O(n); adding a new attribute requires another array and careful index alignment. A Vehicle object also needs O(n) search without an index, but groups related state and behaviour and makes adding an attribute local to the class. Both representations use O(n) total storage; objects have reference/object overhead but are safer to maintain.
