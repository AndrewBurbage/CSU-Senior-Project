# Discreet Dispatch - Testing Plan
**By: Andrew Burbage**

## Introduction
My testing plan includes both code-based testing and user functionality testing. The code testing will ensure the product runs reliably and without errors, while user testing will focus on ease of use, ensuring that real users can interact with it smoothly and intuitively. Code-based testing will encompass accuracy of information recorded from users, proper function of all components, and the ability to perform all functions in a timely manner. [cite_start]Functionality will include ease of use, aesthetic, and ease of understanding what input is needed.

## References
* [Proposal for Senior Project](https://docs.google.com/document/d/1rKtoplzBS2pdkYQUyUR1hrGpfEtH6o5G/edit?usp=sharing&ouid=115637623737985374930&rtpof=true&sd=true)
* [Requirements for Senior Project](https://docs.google.com/document/d/1wsZZ5xln92puQG9-gIoLMuCxf1lIFuCw99huMwinCCo/edit?usp=sharing)
* [GitHub Repository for Project](https://github.com/AndrewBurbage/CSU-Senior-Project)

## Test Items
* Discreet Dispatch Application
* Discreet Dispatch Call Server

## Features To Be Tested
* Discreet Dispatch answer recording
* Discreet Dispatch script forming
* Discreet Dispatch call initiation (User approval and call)
* Discreet Dispatch call performance (successful and clear call)
* Discreet Dispatch aesthetic
* Discreet Dispatch UI
* Discreet Dispatch UX

## Features To Not Be Tested
* **Discreet Dispatch field performance (Real 911 calls):** This is illegal in the sense of calling 911 for non-emergency reasons and if used for emergencies during testing would be unethical and dangerous for testers.
* **Discreet Dispatch performance in poor service areas:** This would require testing out of scope parameters and be difficult to conduct and monitor.

## Approach
The testing will include unit, integration, and user acceptance levels. It will combine functional and usability testing types. [cite_start]Testing will use both manual and automated methods, with a mix of white box testing for code reliability and black box testing for user functionality.

## Item Pass/Fail Criteria
* **Testing of the individual components/functions of the code base:**
    * **Pass:** Expected outputs for given inputs in timely manner
    * **Fail:** Incorrect outputs or slow process time
* **Testing of call performance:**
    * **Pass:** Successful and clear call
    * **Fail:** Unreliable calls and hard to hear or understand calls
* **Testing of App Feel and Intuitiveness:**
    * **Pass:** User Testing finds easy to use an aesthetically pleasing
    * **Fail:** Hard or confusing to use and/or unaesthetically pleasing

## Suspension Criteria and Resumption Requirements
* **Suspension Criteria:** Testing will be suspended if critical defects block core functions, if the build is unstable, or if required test data or environments are unavailable.
* **Resumption Requirements:** Testing will resume once blocking defects are fixed, the environment is stable, and all necessary resources are restored.

## Test Deliverables
* Test Cases
* Defect/Enhancement Logs
* Test Reports

## Test Environment
* Android phone with Android OS 12 or newer

## Test Estimate
Testing is estimated to cost $0.00 USD and require approx. [cite_start]20 Hrs.

## Schedule
* Testing Plan Finalized Dec. 6, 2025
* Testing Started Jan. 15, 2026
* Testing Completed Mar. 25, 2026

## Staffing and Training Needs
Discreet Dispatch will require no training, hence the testing for intuitiveness, and will require no staffing for use.

## Responsibilities
* Lead Developer: Andrew Burbage
* Lead Tester: Andrew Burbage
* Lead Integrator: Andrew Burbage
* Lead Designer: Andrew Burbage
* Documentation: Andrew Burbage
* Project Manager: Andrew Burbage

## Risks
* FCC Violations: FCC guideline documents have been identified.

## Assumptions and Dependencies
### Assumptions
* Testers will have access to all required hardware, software, and accounts.
* The development team will deliver stable builds on schedule.
* Users participating in testing will provide timely feedback.
* All test data and documentation will be available before testing begins.

### Dependencies
* Dependent on the development team to fix bugs before retesting.
* Dependent on external APIs or services being available and functional.
* Dependent on the test environment being properly set up and configured.
* Dependent on user testers being available for usability sessions.

## Approval
**Team (Andrew Burbage):** APPROVED **Date:** Dec. 6, 2025

**Advisor (Professor O’Neill):** APPROVED **Date:** Dec. 6, 2025

---

## Test Cases
| Test Case ID | Test Type | Description | Preconditions | Test Steps | Expected Result |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **TC-U01** | Unit | Verify text input fields record answers accurately | App open on questionnaire screen | 1. Enter text in all fields. 2. Navigate forward/backward between screens. | Text persists exactly as entered; no data loss or crashes. |
| **TC-U02** | Unit | Validate script generation uses correct user inputs | Questionnaire completed | 1. Tap "Generate Script". | Script contains all user data, correct formatting, no missing fields. |
| **TC-U03** | Unit | Validate API request for call initiation | Network connection, API key configured | 1. Tap "Initiate Call". 2. Review logs. | API payload is valid (number, script, auth). 200 OK returned. |
| **TC-U04** | Unit | Validate UI performance and screen load speed | App installed | 1. Launch app. 2. Navigate screens. | Screens load < 1 second; smooth transitions. |
| **TC-I01** | Integration | Test full flow: questionnaire → script → call server | Questionnaire working, server online | 1. Complete questionnaire. 2. Generate script. 3. Initiate call. | Script transmitted successfully; call server logs correct data. |
| **TC-I02** | Integration | Test call audio clarity | Test phone available to receive call | 1. Generate script. 2. Initiate call. 3. Answer recipient phone. | Clear audio; correct wording; no distortion or unexpected pauses. |
| **TC-I03** | Integration | Validate physical device compatibility | Fresh install on Android phone | 1. Install application on phone through wireless debugging. 2. Ensure that the app opens and all pages function as they did in emulator testing. | Application installs successfully and works on a physical device. |
| **TC-A01** | UAT | Evaluate intuitiveness of questionnaire | User test group available | 1. The user completes the questionnaire without help. | The user completes easily; reports clear instructions. |
| **TC-A02** | UAT | Evaluate UI aesthetic and readability | App installed | 1. Present UI to user. 2. Gather rating out of 5. | Majority rating ≥ 4/5; no readability complaints. |
| **TC-A03** | UAT | Confirm users understand call approval flow | User test group available | 1. User attempts to start a call. 2. Read approval dialogue. | User understands the confirmation; no accidental calls. [cite_start]| 

---

## Test Reports
| Module | Date | Case | Input | Expected | Actual | Status | Comments |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Police | Jan 15 | TC-U01 | "John Doe, 123 America street, No other persons injured, The offender is unarmed..." | Text persists exactly as entered; no data loss or crashes. | "John Doe, 123 America street, No other persons injured, The offender is unarmed..." | Passed | No issues observed |
| Fire | Jan 15 | TC-U01 | "John Doe, 123 America street, No other person is injured, The fire is upstairs..." | Text persists exactly as entered; no data loss or crashes. | "John Doe, 123 America street, No other person is injured, The fire is upstairs..." | Passed | No issues observed |
| EMS | Jan 15 | TC-U01 | "John Doe, 123 America street, The victim is experiencing chest pain..." | Text persists exactly as entered; no data loss or crashes. | "John Doe, 123 America street, The victim is experiencing chest pain..." | Passed | No issues observed |
| Police | Jan 21 | TC-U02 | "John Doe, Male, 123 America street, Theft, No other persons injured..." | Script contains all user data, correct formatting, no missing fields. | "John Doe, Male, 123 America street, Theft, No other persons injured..." | Passed | No issues Observed |
| Fire | Jan 21 | TC-U02 | "John Doe, Male, 123 America street, Structure Fire, High, No other person is injured..." | Script contains all user data, correct formatting, no missing fields. | "John Doe, Male, 123 America street, Structure Fire, High, No other person is injured..." | Passed | No issues Observed |
| EMS | Jan 21 | TC-U02 | "John Doe, Elderly, Male, 123 America street, Cardiac Issue, No other person is injured..." | Script contains all user data, correct formatting, no missing fields. | "John Doe, Elderly, Male, 123 America street, Cardiac Issue, No other person is injured..." | Passed | No issues Observed |
| Police | Jan 30 | TC-U03 | Initiate Call pressed | API payload is valid (number, script, auth). 200 OK returned. | Call Received | Passed | No Issues Observed |
| Fire | Jan 30 | TC-U03 | Initiate Call pressed | API payload is valid (number, script, auth). 200 OK returned. | Call Received | Passed | No Issues Observed |
| EMS | Jan 30 | TC-U03 | Initiate Call pressed | API payload is valid (number, script, auth). 200 OK returned. | Call Received | Passed | No Issues Observed |
| App | Feb 02 | TC-U04 | Navigation through each screen | Screens load < 1 second; smooth transitions. | All screens are smooth and fast | Passed | No Issues Observed |
| Police | Feb 11 | TC-I01 | Form filled and call made | Script transmitted successfully; call server logs correct data. | Call successful & logged | Passed | No Issues Observed |
| Fire | Feb 18 | TC-I01 | Form filled and call made | Script transmitted successfully; call server logs correct data. | Call successful & logged | Passed | No Issues Observed |
| EMS | Feb 25 | TC-I01 | Form filled and call made | Script transmitted successfully; call server logs correct data. | Call successful & logged | Passed | No Issues Observed |
| App | Feb 11 | TC-I02 | Form filled and call made | Clear audio; correct wording; no distortion or unexpected pauses. | Audio is clear and easily comprehendible | Passed | No Issues Observed |
| App | Feb 02 | TC-I03 | App installed and assessed | Application installs successfully and works on a physical device. | Application is functional | Passed | No Issues Observed |
| Police | Mar 03 | TC-A01 | Users prompted to fill form | User completes easily; reports clear instructions. | Users were all successful and had no questions. | Passed | Suggestions on new sections but no confusion |
| Fire | Mar 03 | TC-A01 | Users prompted to fill form | User completes easily; reports clear instructions. | Users were all successful and had no questions. | Passed | Suggestions on new sections but no confusion |
| EMS | Mar 03 | TC-A01 | Users prompted to fill form | User completes easily; reports clear instructions. | Users were all successful and had no questions. | Passed | Suggestions on new sections but no confusion |
| Home | Mar 17 | TC-A02 | User group asked to rate page | Majority rating ≥ 4/5; no readability complaints. | 5/5 overall | Passed | No issues Observed |
| Police | Mar 17 | TC-A02 | User group asked to rate page | Majority rating ≥ 4/5; no readability complaints. | 4.8/5 overall | Passed | Suggestions for further questions |
| Fire | Mar 17 | TC-A02 | User group asked to rate page | Majority rating ≥ 4/5; no readability complaints. | 4.8/5 overall | Passed | Suggestions for further questions |
| EMS | Mar 17 | TC-A02 | User group asked to rate page | Majority rating ≥ 4/5; no readability complaints. | 4.8/5 overall | Passed | Suggestions for further questions |
| Call Pg | Mar 17 | TC-A02 | User group asked to rate page | Majority rating ≥ 4/5; no readability complaints. | 5/5 overall | Passed | No issues observed |
| App | Mar 17 | TC-A03 | User assessment of call page | User understands the confirmation; no accidental calls. | Users show ease of use and comprehension of approval flow | Passed | [cite_start]No issues observed | 

---

## Defect/Enhancement Logs
| Item | Date | Engineer | Description | Solution Steps | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **UI Style Enhancement** | Dec 1 - Jan 14 | Andrew Burbage | Transition from XML to Compose and Material3 for current industry standards. | 1. Research Compose style and Materials3. 2. Implements new style page by page. 3. Ensure functionality. | [cite_start]Finished |