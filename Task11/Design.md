# Task 11 – Implement, Test and Defend

Run ParkingSystemDemo.java. It demonstrates entry, allocation, tickets, fee calculation, pass handling and exit/release. Test cases cover normal entry/exit, full facility, duplicate registration, invalid duration, and monthly-pass waiver.

| Test | Expected behaviour |
|---|---|
| Valid car entry | Ticket and slot allocated |
| Second vehicle | Next free slot allocated |
| Full facility | Entry rejected cleanly |
| Duplicate active registration | Rejected |
| Negative duration | Rejected |
| Valid monthly pass | Parking fee is zero |
| Exit | Slot released and ticket closed |

Active-ticket lookup in an array is O(n). ArrayList is also O(n) for lookup by registration; HashMap<String, ParkingTicket> is average O(1) lookup with O(n) storage. HashMap is preferable for frequent exit lookups, while arrays are simple for fixed small facilities. Run the program and record actual outputs/screenshots before submission.
