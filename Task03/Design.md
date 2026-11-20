# Task 3 – Control Logic

## Allocate pseudocode
1. For each floor from first to last:
2. For each slot on that floor:
3. If the slot is empty and suitable for the vehicle, store the vehicle and return floor/slot.
4. If no suitable slot is found, return null.

## Fee pseudocode
1. Reject negative duration.
2. If a valid monthly pass applies, return zero parking fee.
3. Compute billable hours = ceiling(minutes / 60) using (minutes + 59) / 60.
4. Multiply billable hours by the vehicle hourly rate.
5. Apply any daily maximum and add EV charging fee when applicable.

The program below completes both TODOs in the supplied ParkingFacility pattern. Allocation and release are O(F × S) and O(1), respectively, where F is floor count and S is maximum slots per floor.
