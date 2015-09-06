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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitUrl
{
	private String url = "";
	public SubmitUrl()
	{

	}
	public SubmitUrl(String url)
	{
		this.url = url;
	}
	public boolean getResult()
	{
		return doSubmit();
	}
	public boolean getResult(String url)
	{
		this.url = url;
		return doSubmit();
	}
	private boolean doSubmit()
	{
		try
		{
			String webArchiveUrl = "http://web.archive.org/save/";
			if(this.url != null && !this.url.isEmpty())
			{
				webArchiveUrl += this.url;	
			} else 
			{
				System.out.println("No URL provided!");
				throw new Exception();
			}
			URL url = new URL(webArchiveUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200)
			{
				int errorCodeInt = conn.getResponseCode();
				throw new Exception();		
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output = null;
			int cnt = 0;
			while(br.readLine() != null)
			{
				output = br.readLine();
				//System.out.println(output);
				cnt++;
			}
			if(cnt>1)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
}