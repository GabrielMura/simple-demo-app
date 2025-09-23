# simple-demo-app

### Repo Information

**angular** holds the angular development files\
**project** holds the spring boot application

Basic information on the creation of this application (setting up the environment)
1. Install java 
    - `sudo apt install opnjdk-17-jre-headless`
2. Install tomcat
    - Get tomcat 10 from official website
3. Install maven 
    - `sudo apt install maven`
4. Install IDE or code editor - I prefer VS Code
    - In ubuntu, download the deb from the official microsoft website then: `sudo apt install ./<code>.deb`
5. Generate a new maven spring boot project
    - The easiest and quickest way to get going is to go to: start.spring.io
    - Enter project information, and it will generate the project structure and pom.xml with dependencies provided
    - Note: This is bare-bones - you can further add more directories such as repository, model, config, controller, service, etc. classes for easier project breakdown
6. Install git for local and remote version control
    - `sudo apt install git`
    - Could write a whole section on git/github, in summary:
        - Create key for repo in github (grant write access)
        - Pull repo to local with key
        - Put generated project into repo and commit/ push code as developing
7. Create Firebase Firestore database
    - This is optional, just here as a proof of concept to show database access within that applicaiton
    - This is going to be used on the server side, and will be given admin rights to the project
    - Must limit what the front end can access in the service classes as it bypasses database rules
8. Begin on the Angular front end
    - Download node from official website
    - Extract and create necessary system path variables
9. Transfer angular project to tomcat server
    - `ng build --base-href /SimpleDemoApp/ --deploy-url /SimpleDemoApp/`
    - Take the output index.html, css, and js files and put them in the tomcat static directory
    - Note: There are different ways to deploy an application to production, this one just worked for me as there is less configuration needed
10. Transfer the WAR file to your production server
