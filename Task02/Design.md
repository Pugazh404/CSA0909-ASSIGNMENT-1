# Task 2 – Choose the Data Representation

| Field | Suggested Java type | Reason |
|---|---|---|
| Floor and slot index | int | Whole-number indexes |
| Registration number | String | Contains letters and digits |
| Entry/exit time | java.time.LocalDateTime | Date and time without manual parsing |
| Duration | long minutes | Avoids fractional-minute errors |
| Fee | double for demo; BigDecimal for finance | BigDecimal avoids binary floating-point currency error |
| Occupancy | Vehicle[][] or jagged Vehicle[][] | Stores object references by floor and slot |

A jagged array is appropriate because each floor can have a different number of slots. A single flat array needs an offset/prefix-sum mapping when floor sizes differ; the simple floor × slotsPerFloor formula only works when all floors have equal capacity. ArrayList<ParkingSlot[]> supports dynamic floor collection but adds collection overhead.

Avoid integer truncation: 61 / 60 equals 1, but 61 minutes must bill 2 started hours. Use (minutes + 59) / 60 with integer arithmetic. For fractional rates, convert carefully and prefer BigDecimal for real currency calculations.

Input may be read using Scanner or command-line arguments; validate before creating domain objects.
