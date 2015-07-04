<?php
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