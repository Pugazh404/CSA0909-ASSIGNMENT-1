# Task 12 – Day-4 Design Challenge

## Decision: MODIFY
Use a jagged array for floors with different slot capacities, retain the Vehicle abstraction and add E-Bike and DeliveryVan subclasses. Introduce a Pass interface for one-day and monthly passes, and a PricingRule abstraction so time-window pricing is not scattered through the facility.

Delivery vans pay double the car hourly rate from 9:00 AM through 5:00 PM. E-bikes pay a flat parking fee. A one-day visitor pass is valid for the date on which it is issued. Existing allocation and ticket concepts remain; new pricing and pass rules are isolated.

The included Java demonstration implements the new categories and pass behaviour. Run it and capture actual output. Future vehicle types can be added by extending the vehicle abstraction or supplying a pricing strategy. Trade-off: more classes/interfaces, but fewer edits to existing tested code.
