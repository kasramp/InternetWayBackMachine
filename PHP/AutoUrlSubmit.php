<?php
		/* 
		 * This file is part of InternetWayBackMachine.
		 * InternetWayBackMachine is free software; you can redistribute it and/or modify
		 * it under the terms of the GNU General Public License version 3
		 * as published by the Free Software Foundation.
		 *
		 * InternetWayBackMachine is distributed in the hope that it will be useful,
		 * but WITHOUT ANY WARRANTY; without even the implied warranty of
		 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
		 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
		 *
		 * Author(s):
		 * © 2015 Kasra Madadipouya <kasra@madadipouya.com>
		 */
		$curl = null;
		try
		{
			$curl = curl_init();
        	curl_setopt($curl,CURLOPT_PUT,1);
			$url = "http://web.archive.org/save/".$argv[1];
			curl_setopt($curl,CURLOPT_URL, $url);
			$result = file_get_contents($url);
			echo "Successfully submit URL [".$argv[1]."] to web.archive.org";
		}
		catch(Exception $ex)
		{
			echo $ex->getMessage();
		}
		finally
		{
			curl_close($curl);
		}
?>