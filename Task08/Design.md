# Task 8 – Apply Polymorphism

Compile-time polymorphism is demonstrated by overloaded calculateFee(int) and calculateFee(LocalTime, LocalTime) methods. Runtime polymorphism occurs when Vehicle references point to TwoWheeler, Car or ElectricCar objects; the actual object's overridden rate method is selected at runtime.

Trace: declared type Vehicle → actual object ElectricCar → Vehicle.calculateFee() calls ratePerHour() → ElectricCar's inherited Car rate is used. A Chargeable reference is available only for objects implementing that interface.

The completed FeeDemo.java is included below. The last line is true because equality is defined by registration number, regardless of concrete vehicle subtype. This is correct only if registration numbers are globally unique and vehicle category is not part of identity.
