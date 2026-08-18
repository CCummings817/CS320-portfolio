# CS-320 Software Test, Automation, and QA Portfolio
**Southern New Hampshire University**

## Artifacts
- Contact.java
- ContactService.java
- ContactTest.java
- ContactServiceTest.java
- CS-320 Project Two Summary and Reflections Report

## Reflections

**How can I ensure that my code, program, or software is functional and secure?**
The most reliable way I have found to ensure functionality and security is through disciplined, requirement-driven testing. Writing unit tests that directly trace back to specific requirements forces you to think critically about what the code is actually supposed to do, not just what it happens to do. Throughout this course, I applied that approach using JUnit 5 to validate each service method against its defined constraints. Security comes from the same mindset -- if you are rigorous about what inputs are acceptable and you test the boundaries aggressively, you close a lot of doors before they become problems.

**How do I interpret user needs and incorporate them into a program?**
User needs have to be translated into concrete, testable requirements before they mean anything to a codebase. Coming from a business analysis background, that translation process feels natural to me -- stakeholders rarely hand you a spec sheet, so you have to ask the right questions and document what you hear. In this course, that looked like reading the project requirements carefully, identifying the specific constraints for each field, and making sure every test case reflected something a real user or system would actually need. If a test does not connect back to a user need, it probably should not exist.

**How do I approach designing software?**
I approach software design the same way I approach most complex problems -- start with the requirements, build the structure around them, and test early and often. I would rather catch a design flaw at the unit test stage than after everything is integrated. This course reinforced that mindset, especially the idea that good tests are not written after the code is done -- they inform how the code gets written in the first place. That shift in thinking is one of the most practical things I am taking away from CS-320.
