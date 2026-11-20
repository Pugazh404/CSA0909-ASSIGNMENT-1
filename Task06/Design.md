# Task 6 – Inheritance Hierarchy

```text
                 Vehicle (abstract)
                 /       |        \
          TwoWheeler    Car    ElectricCar
                                  implements Chargeable
```

This is hierarchical inheritance from Vehicle; ElectricCar extends Car (multilevel chain). Vehicle owns registration identity and common fee behaviour. Subclasses supply rates or capabilities. super(...) invokes parent constructors before subclass initialisation. For ElectricCar creation, execution order is Vehicle constructor → Car constructor → ElectricCar constructor.

Alternative composition: Vehicle has a VehicleType/PricingRule object. Adding a category then means creating/configuring a policy instead of subclassing. Both approaches calculate a fee in O(1); composition makes pricing changes more flexible while adding a policy object/reference per vehicle.
