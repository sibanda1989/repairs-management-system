# Repairs Management System

An ERP-like service management Spring web application to manage and track mobile POS terminal repairs.
Consists of :
1. Time tracking
2. Faults management
3. Summary dashboard - presents critical metrics at a glance

## Entities Definition

### Terminal
A terminal is an electronic device used at Point-of-Sale to accept cards as a form of payment for goods/services rendered at a Merchant Site.
It is uniquely identified by a PTID (an 8 digit field)

### Model
This is an entity used to distinguish groupings of terminals by functionality for e.g. communication type can be Wi-Fi or LAN or both.
1 model can have multiple terminals.
This is listed as **TerminalModel** for this project not to conflict with Model as known in Java development context.

### Vendor
A vendor is a manufacturer of terminals for e.g. PAX, VeriFone.
1 vendor can have multiple models under their portfolio

### Repair
A repair lists faults and repairs on a particular terminal at a particular time (Date). It should also capture the date when repair is completed.