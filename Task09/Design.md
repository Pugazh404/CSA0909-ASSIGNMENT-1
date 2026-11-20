# Task 9 – Introduce Abstraction

Vehicle is abstract because a generic vehicle has identity and shared fee calculation but no universal hourly rate. ratePerHour() is abstract. Chargeable is an interface because charging is an optional capability; an electric vehicle can extend a vehicle class and implement Chargeable simultaneously.

Interfaces may provide default methods for shared optional behaviour and static utility methods. If Vehicle became an interface, it could not hold per-object instance state through ordinary fields or provide constructors. If Chargeable became an abstract class, Java's single class inheritance would prevent a class already extending another base class from extending it too. Method dispatch remains effectively constant-time; the main differences concern object state and type flexibility.
