Feature: Smoke Testing

Scenario: verify that smoke test is performed successfully
Given Open Loek and perform smoke testing using mentioned scenarios...
When user goes to dashboard and performs smoke test > Click On Company Profile, Company Public Profile, My Profile, My Public Profile
Then go to building app and perform smoke test > Click On Building, Building Unit, Building Room, Building Element, Building Surface, Building tenant, Building document, Building key, Building invoice, Building disturbance, Building contact
Then go to building unit and perform smoke test > Click On BuildingUnit, Building unit element, Building unit tenant, Building unit document, Building unit key address, Building unit invoice address, Building unit disturbance, Building unit contact
Then go to building complex and perform smoke test > Click On BuildingComplex, Building complex key address, Building complex invoice address, Building complex disturbance, Building complex contact
Then go to ticket app and perform smoke test > Click On TicketApp, Work assignment, Archive, Invoice, Report, Article, External article, Settings, Prices, Surcharges, Cost category, External company, Attachments for external assignments, Interface, User rights
Then go to ticket pending tab and perform smoke test > Click On Ticket Pending, Ticket detail, Work order ticket
Then go to invoice specification and perform smoke test > Click On Invoice Specification, Invoice rounded, Invoice detail
Then go to service portal and perform smoke test > Click On Service, Service portal user detail, Service portal news, Service portal news detail, Service portal maintenance, Service portal maintenance detail, Service portal settings, Service portal user rights
Then go to external service portal and login > Click On external service portal, External Service portal login  
Then go to external service portal ticket and perform smoke test > Click On external service portal ticket, External service portal ticket detail
Then perform smoke test on external service portal > Click On external service portal, External Service portal my profile, External Service portal news redirection, External Service portal ticket
Then perform smoke test on external service portal news and logout > Click On external service portal news, External Service portal news detail, logged out from external service portal  