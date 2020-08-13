$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Feature/SmokeTesting/SmokeTest.feature");
formatter.feature({
  "line": 1,
  "name": "Smoke Testing",
  "description": "",
  "id": "smoke-testing",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "verify that smoke test is performed successfully",
  "description": "",
  "id": "smoke-testing;verify-that-smoke-test-is-performed-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open Loek and perform smoke testing using mentioned scenarios...",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user goes to dashboard and performs smoke test \u003e Click On Company Profile, Company Public Profile, My Profile, My Public Profile",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "go to building app and perform smoke test \u003e Click On Building, Building Unit, Building Room, Building Element, Building Surface, Building tenant, Building document, Building key, Building invoice, Building disturbance, Building contact",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "go to building unit and perform smoke test \u003e Click On BuildingUnit, Building unit element, Building unit tenant, Building unit document, Building unit key address, Building unit invoice address, Building unit disturbance, Building unit contact",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "go to building complex and perform smoke test \u003e Click On BuildingComplex, Building complex key address, Building complex invoice address, Building complex disturbance, Building complex contact",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "go to ticket app and perform smoke test \u003e Click On TicketApp, Work assignment, Archive, Invoice, Report, Article, External article, Settings, Prices, Surcharges, Cost category, External company, Attachments for external assignments, Interface, User rights",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "go to ticket pending tab and perform smoke test \u003e Click On Ticket Pending, Ticket detail, Work order ticket",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "go to invoice specification and perform smoke test \u003e Click On Invoice Specification, Invoice rounded, Invoice detail",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "go to service portal and perform smoke test \u003e Click On Service, Service portal user detail, Service portal news, Service portal news detail, Service portal maintenance, Service portal maintenance detail, Service portal settings, Service portal user rights",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "go to external service portal and login \u003e Click On external service portal, External Service portal login",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "go to external service portal ticket and perform smoke test \u003e Click On external service portal ticket, External service portal ticket detail",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "perform smoke test on external service portal \u003e Click On external service portal, External Service portal my profile, External Service portal news redirection, External Service portal ticket",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "perform smoke test on external service portal news and logout \u003e Click On external service portal news, External Service portal news detail, logged out from external service portal",
  "keyword": "Then "
});
formatter.match({
  "location": "SmokeTest.Open_the_production_url_and_login_with_the_valid_data()"
});
formatter.result({
  "duration": 24671963076,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.user_goes_to_dashboard_and_performs_smoke_test()"
});
formatter.result({
  "duration": 66519837156,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.go_to_building_app_and_perform_smoke_test()"
});
formatter.result({
  "duration": 91117912406,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.go_to_building_unit_and_perform_smoke_test()"
});
formatter.result({
  "duration": 96460770,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.go_to_building_complex_and_perform_smoke_test()"
});
formatter.result({
  "duration": 26791926167,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.go_to_ticket_app_and_perform_smoke_test()"
});
formatter.result({
  "duration": 8295174113,
  "error_message": "org.openqa.selenium.ElementNotVisibleException: element not visible\n  (Session info: chrome\u003d84.0.4147.105)\n  (Driver info: chromedriver\u003d2.40.565498 (ea082db3280dd6843ebfb08a625e3eb905c4f5ab),platform\u003dWindows NT 10.0.10240 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.5.3\u0027, revision: \u0027a88d25fe6b\u0027, time: \u00272017-08-29T12:42:44.417Z\u0027\nSystem info: host: \u0027DESKTOP-OB90OE0\u0027, ip: \u0027192.168.0.106\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, platformName\u003dXP, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.40.565498 (ea082db3280dd6843ebfb08a625e3eb905c4f5ab), userDataDir\u003dC:\\Users\\Dominic\\AppData\\Local\\Temp\\scoped_dir6008_17946}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, unhandledPromptBehavior\u003d, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d84.0.4147.105, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: caaacd6e5b049a7562526f2a3dac8601\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:646)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:275)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:82)\r\n\tat Stepdefinations.Base.GoToModule(Base.java:94)\r\n\tat Stepdefinations.SmokeTesting.SmokeTest.go_to_ticket_app_and_perform_smoke_test(SmokeTest.java:193)\r\n\tat ✽.Then go to ticket app and perform smoke test \u003e Click On TicketApp, Work assignment, Archive, Invoice, Report, Article, External article, Settings, Prices, Surcharges, Cost category, External company, Attachments for external assignments, Interface, User rights(src/main/java/Feature/SmokeTesting/SmokeTest.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SmokeTest.go_to_ticket_pending_tab_and_perform_smoke_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.go_to_invoice_specification_and_perform_smoke_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.go_to_service_portal_and_perform_smoke_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.go_to_external_service_portal_and_login()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.go_to_external_service_portal_ticket_and_perform_smoke_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.perform_smoke_test_on_external_service_portal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SmokeTest.perform_smoke_test_on_external_service_portal_news_and_logout()"
});
formatter.result({
  "status": "skipped"
});
});