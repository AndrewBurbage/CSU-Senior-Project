## Requirements Document

**Student Name:** Andrew Burbage

**Degree and Major:** Bachelor of Science in Computer Science

**Project Advisor:** Professor O’Neill

**Expected Graduation Date:** December of 2027

### 1. Functional
* (TCA-02) The application will be easily identifiable by the user and will be designed to be easy to use and understand, allowing for convenient use and clarification when needed, making prior training unnecessary.
* (TCA-01) The application will go question by question allowing for a swift but not confusing utilization of its services leading to efficient interaction between user and product.
* (TCU-02) The application shall create an accurate script based on the user’s responses to each question of the emergency evaluation.
* (TCA-03) The application will ensure that all details are accurate, and the location is correct before moving forward with the call.
* (TCU-03 & TCI-02) The application will make the call in a timely manner and read the script over the call with clear and comprehendible speech.
* The call should finish when the receiver (emergency service dispatch) hangs up, otherwise it will repeat allowing for missed information to be reheard.
* The application should be designed to allow for ease of updates and additional features as well as expansion based on client-based needs for performance.
* The application should log all calls and scripts formed to allow for ease of investigation both by support teams for troubleshooting as well as for possible legal requests.
* The application should also create a proper channel for reporting errors and issues as to allow for quick identification and rectification.

### 2. Look and Feel

#### I. Appearance



* (TCA-02) The application shall have a professional look representative of industry standards.

#### II. Style



* (TCI-01) The application shall utilize a flow through design that goes question by question.

### 3. Usability

#### I. Ease of Use



* (TCA-01) The application shall be easy to moderate easy as it asks questions that range from yes or no to asking for details while not overwhelming the user.

#### II. Personalization and Internationalization



* The application should allow the user to be known by name.
* The application with permission should know residence.

#### III. Learning



* (TCA-01 & TCA-03) The application should require minimal to no learning.
* Ambiguous questions or areas of detail should have an option for clarification.

#### IV. Understandability and Politeness



* (TCA-01) The application should be easily understood and not difficult to traverse.
* (TCA-01) The application shall prompt the user with politeness considering the possible duress of the user.

#### V. Accessibility



* The application should be accessible to adults only.
* (TCU-03) The application shall be accessible with internet/data connection.

#### VI. Convenience



* (TCA-01)The application should be moderately convenient considering the number of required questions that must be addressed.
* (TCA-03) The application shall be moderately convenient in terms of submission, confirming details before finalizing for call.

### 4. Performance

#### I. Speed and Latency



* (TCU-04) The application will be at an acceptable speed of no longer than 15 sec. from submission to outgoing calls.

#### II. Safety-Critical



* (TCU-03) The application will promptly inform the user if the services are unavailable so as to allow them to use other channels to reach emergency services with little delay.

#### III. Precision or Accuracy



* (TCU-02) The application will remain totally accurate to the details given by the user for the call script.
* The application will be accurate to the closest address for the location used to identify where the client is.

#### IV. Reliability and Availability



* (TCU-03) The application should be reliable within reason, if there is a decent connection and the device used is itself reliable then the application ought to be reliable.

#### V. Robustness or Fault-Tolerance



* (TCU-03) If a service from the application fails, the application will inform the user and prompt them to start again.
* (TCU-01) The application shall store all successful steps until the call is made to avoid total restart if one section fails.

#### VI. Capacity



* The application should currently be able to handle 100 calls at once.

#### VII. Scalability or Extensibility



* The questionnaire function of the application should be designed so that it is easy to update with additional features and questions.
* The call side of the application should be able to be bolstered with ease to fulfill a larger amount of traffic if desired or required.
* If the number of users increases significantly the space to store/log scripts shall be designed to be easily expandable.

#### VIII. Longevity



* The application should be designed to be able to be updated with ease as newer versions of device software and third-party services are released.

### 5. Maintainability and Support

#### I. Technical Clarity



* The application should be designed so that all processes and functions are well documented and easy to interpret and comprehend.

#### II. Reporting



* The application should have the ability to report issues so as to support users and ensure that issues are addressed.

### 6. Security

#### I. Access



* Data from user submissions shall only be accessible with administrative permission.

#### II. Integrity



* All information given will be treated as confidential and not released or sold.

#### III. Privacy



* All information given will be treated as confidential.

#### IV. Audit (what information must be recorded to allow security checks. e.g., logs)



* All scripts and calls placed should be logged both for troubleshooting/analysis as well as for possible subpoenas

#### V. Immunity



* The application should issue a required user agreement that makes clear that the ultimate responsibility to contact emergency services falls on the user and not the application and that alternate channels such as this are useful but not infallible.