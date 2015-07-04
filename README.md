#InternetWayBackMachine
=======================
Auto Submit URLs to web.archive.org

The purpose of this application is to allow user to define a link and allow them to automatically submit to web.archive.org. 
The main benefit of this application is that the user doesn't require to open a browser and do the submission manually each time.
In addition to that, the appliation can be configured in Linux crontab and do the task of submission preidically.
You can get more information about Internet Wayback Machine from 

http://www.web.archive.org

To compile the application :

$ ant

To run the application :

$ cd build/deploy

$ java -jar InternetWaybackMachine.jar MyURL

For PHP source just copy and paste it in your Apache folder and done (More suitable for OpenShift).

For more information contact,
kasra@madadipouya.com 
kasra_mp@live.com
