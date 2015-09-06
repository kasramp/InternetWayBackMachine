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
public class CallWayBackMachine
{
	public static void main(String[] args)
	{
		try
		{
			if(args.length < 1)
			{
				System.out.println("No URL provided!");
				return;
			}
			else
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
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}