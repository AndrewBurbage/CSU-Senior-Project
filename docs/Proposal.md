# SENIOR PROJECT PROPOSAL
**Student Name:** Andrew Burbage  
**Degree and Major:** Bachelor of Science in Computer Science  
**Project Advisor:** Professor O’Neill  
**Expected Graduation Date:** December 2027

## Problem Statement
The ability to call 911 is often something we take for granted. For many of us we will only dial it a handful of times in our lifetime. However not all emergencies allow for a call, consider those in a situation where silence is survival or even those where speaking may not be an ability they possess [3]. While the FCC does require all phone carriers to offer texting services to 911 dispatch centers, not all accept and even if they do people may not realize what vital information is needed [2].

While these services are offered and are available in most major cities, they are not available everywhere, in fact only 56% of call centers have this capability [1]. Furthermore, most people are not entirely aware of what information is needed by first responders to help. This means that for many when they need to make that call and cannot they are left stranded and without the vital assistance of emergency services.

There must be an option made available to people that allows for them to reach out to their local emergency services without a phone call or being fortunate enough to live in a city or county that offers texting services because for many this can be life or death.

## Project Description
The project is to create an application that would allow users to answer a series of questions similar to those given by a dispatcher that would then be turned into a text to speech recording to be played over a phone call from the user to local emergency services. This allows for an effective and discrete silent 911 call. When the user opens the app and begins to fill out the prompts given, the responses will be stored and used to form a script that will be turned into an audio recording using text to speech. From there a call will be placed to the local dispatch where the script will be played allowing actual dispatchers to collect the needed information to deploy first responders effectively. This allows the user to be discreet or to make an audible call they are incapable of while also allowing dispatchers to get most of the needed information in one concise interaction.

## Proposed Implementation languages
Java and Kotlin

## Libraries, Packages, Development Kits, etc.
The general library will be needed along with a Text-to-Speech, VoIP protocol template, REST API, and a geolocation library.

## Additional Software/Equipment Needed
A designated server may be needed or a third-party cloud-based service, if possible, for hosting internet functions for the call.

## Alternative Solutions and Rationale

### Alternative 1 : Mobile Application
- **Description**:  
  Make a mobile based application that allows users to answer a set of questions like those given by dispatch to form a script and then use TTS to read it over a phone call to actual dispatch.
- **Pros**:
    - Ease of use
    - Accessibility
- **Cons**:
    - May require cell service

### Alternative 2 : Web Application
- **Description**:  
  Make a web based application that allows users to answer a set of questions like those given by dispatch to form a script and then use TTS to read it over a phone call to actual dispatch.
- **Pros**:
    - Ease of design
    - Reliability with assumed internet connection
    - May work if phone is damaged but a computer or tablet is available
- **Cons**:
    - Require knowledge of webpage if not saved
    - Not as easy to access as an app on one's phone during an emergency situation

### Chosen Solution and Rationale
- **Chosen Solution**:  
  Mobile Application
- **Rationale**:  
  I Chose the mobile application because it will be easier to access during an emergency since you could just open the app rather than go to a browser find or type in the link and then start. Also, mobile development shows more skill than web in my opinion.

## Personal Motivation
The benefit of this project is a chance to work and something that is both front-end and back-end as well as a chance to gain some experience with networking-based concepts like APIs. Beyond that, it is also an interesting concept that shows real-world use and mimics an actual product a company or even government might want.

## Outline of future research efforts
* Interview with a local emergency services/dispatch department (in person or via email correspondence)

## Schedule

### CONSTRUCTION
* Familiarize with Kotlin for building app
* Develop Script for User to fill out
* Build app to function that forms script from user responses
* Familiarize with required protocols, services, APIs, and server functions for making automated calls
* Draft test plan
* Develop necessary server structures allowing for successful call
* Integrate into app
* Project update
* Final test plan
* Repository construction

### DEFENSE
* Test for accuracy
* Test for functionality
* Review with small group to test users
* Refine based on feedback from in house testing as well as user feedback
* Repository completion
* Prepare documentation for presentation
* Finalize documentation and Slides for presentation
* Present

## Works Cited

* **[1]** Yan, H. (2019, November 26). A 911 call with a fake pizza order helped stop a possible attack. but what if you can’t speak to 911? CNN. https://www.cnn.com/2019/11/26/us/what-to-do-if-you-cant-speak-to-911/index.html
* **[2]** FCC. (2020, January 6). Text to 911: What you need to know. Federal Communications Commission. https://www.fcc.gov/consumers/guides/what-you-need-know-about-text-911
* **[3]** accesSOS. (2022). Text to 911. https://text911.info/