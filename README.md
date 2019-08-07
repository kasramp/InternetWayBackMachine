InternetWayBackMachine
=======================

# Auto Submit URLs to web.archive.org

The purpose of this application is to allow user to to automatically submit a link to web.archive.org. 
The main benefit of this application is that the user does not require to open a browser and do the submission manually each time.
In addition to that, the application can be configured in Linux Crontab and do the task of submission periodically.
You can get more information about Internet Wayback Machine from 

http://www.web.archive.org

To compile the application :

    $ ant

To run the application :

    $ cd build/deploy
    $ java -jar InternetWaybackMachine.jar MyURL

For PHP source just copy and paste it in your Apache folder and done (More suitable for OpenShift).

For more information contact,
* kasra@madadipouya.com 

License
=======
InternetWayBackMachine is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License version 3
as published by the Free Software Foundation.

InternetWayBackMachine is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.  <http://www.gnu.org/licenses/>

Author(s):

© 2015-2019 Kasra Madadipouya <kasra@madadipouya.com>

