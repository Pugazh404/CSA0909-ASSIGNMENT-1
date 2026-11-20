# Task 7 – Override and Specialise Behaviour

Subclasses override ratePerHour() and may override calculateFee() when a category has special rules. Use @Override to let the compiler check the method signature. An overriding method cannot reduce visibility or use an incompatible return type. Use final for immutable registration numbers and constants; avoid final on extension points intended for overriding.

equals() and hashCode() must use the same identity field. If registration number defines identity, equal vehicles with the same registration must return the same hash code. toString() should provide a readable summary without exposing unnecessary private data.

A switch-based implementation is possible but requires updating central branching logic when a new category is introduced. Virtual method dispatch is O(1) in practical terms; the larger difference is maintainability and the number of existing classes changed.
