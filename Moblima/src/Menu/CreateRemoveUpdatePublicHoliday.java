package Menu;

import java.io.IOException;

import MOBLIMA.BookingApp;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.PublicHolidayIO;

public class CreateRemoveUpdatePublicHoliday extends MenuPage {

	private static MovieCineplexModel movieCineplexModel;

	static final int ADDHOLIDAY = 1;
	static final int REMOVEHOLIDAY = 2;

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		movieCineplexModel = MovieCineplexModel.getInstance();

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Public Holiday Settings");

		System.out.println("...1) Add new Holiday");
		System.out.println("...2) Remove new Holiday");
		System.out.println("");
		System.out.println("...3) Back");

		int choice = ValidInputManager.GetIntWithinRange(1, 4);

		switch (choice) {
			case ADDHOLIDAY: {
				PublicHolidayIO tempIO = new PublicHolidayIO();
				try {
					String holidayArr[] = tempIO.readPublicHolidays();

					System.out.println("...Please input holiday in this format (dd/mm/yy):");

					String newHoliday = ValidInputManager.GetString();

					String newHolidayArr[] = new String[holidayArr.length + 1];
					for (int i = 0; i < newHolidayArr.length; i++) {
						if (i != holidayArr.length)
							newHolidayArr[i] = holidayArr[i];
						else
							newHolidayArr[i] = newHoliday;
					}

					tempIO.writePublicHoliday(newHolidayArr);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
			case REMOVEHOLIDAY: {
				PublicHolidayIO tempIO = new PublicHolidayIO();
				try {
					String holidayArr[] = tempIO.readPublicHolidays();

					String newHoliday = "";
					String newHolidayArr[] = new String[holidayArr.length - 1];

					boolean tryAgain = true;
					while (tryAgain) {
						System.out.println("...Please input holiday in this format (dd/mm/yy):");

						newHoliday = ValidInputManager.GetString();
						boolean Found = false;
						for (int i = 0; i < holidayArr.length; i++) {
							if (newHoliday.equals(holidayArr[i])) {
								holidayArr[i] = "-";
								Found = true;
								tryAgain = false;
								break;
							}
						}

						if (!Found) {
							System.out.println("Error: holiday not found! Do you want to try again?: (Yes / No)");
							String choices[] = { "Yes", "No" };
							if (ValidInputManager.GetStringInChoices(choices).toLowerCase().equals("no")) {
								tryAgain = false;
								this.endMenu = true;
								return;
							}
						}

						System.out.println("");
					}

					boolean skip = false;
					for (int i = 0; i < holidayArr.length; i++) {
						if (holidayArr[i].equals("-"))
							skip = true;
						else
							newHolidayArr[skip ? i - 1 : i] = holidayArr[i];
					}

					tempIO.writePublicHoliday(newHolidayArr);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
		}

		this.endMenu = true;
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
