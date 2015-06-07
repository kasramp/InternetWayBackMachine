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