import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
 * © 2015-2019 Kasra Madadipouya <kasra@madadipouya.com>
 */
public class CallWayBackMachine
{
	public static void main(String[] args)
	{
		try
		{
			if(args.length < 1)
			{
				System.out.println("No URL provided!");
			}
			else if(args.length == 1)
			{
				SubmitUrl su = new SubmitUrl(args[0]);
				if(su.getResult())
				{
					System.out.println("Your page submitted sucessfully!");
				}
				else
				{
					System.out.println("Page submission failed :-( ");
				}
			}
			else if(args.length > 1 && "-i".equals(args[0]))
			{
				processFile(args[1]);
			}
			else
			{
				System.out.println("Invalid arguments passed. \n"
						+ "Usage:\n"
						+ "* java -jar InternetWaybackMachine.jar [URL]\n"
						+ "* java -jar InternetWaybackMachine.jar -i [Path to a file contains URLs]");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private static void processFile(String filePath)
	{
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) 
		{
			SubmitUrl submitUrl = new SubmitUrl();
            reader.lines().forEach(url -> 
			{
				System.out.println(url);
				if(submitUrl.getResult(url))
				{
					System.out.println("Your page submitted sucessfully!");
				}
				else
				{
					System.out.println("Page submission failed :-( ");
				}
			});
        } 
		catch (IOException fileException)
		{
            System.out.println("Failed to open the file. Make sure it exists");
        }
	}
}